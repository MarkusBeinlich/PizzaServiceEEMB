package de.beinlich.markus.pizzaservice.model;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;

import java.math.BigDecimal;
import java.text.NumberFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
@NamedQuery(name = OrderHeader.findAll, query = "SELECT oh FROM OrderHeader oh ")
public class OrderHeader implements Serializable {

    private static final long serialVersionUID = 4994150745256346814L;

    private static final BigDecimal MAX_ORDER_AMOUNT = new BigDecimal(100);

    public static final String findAll = "OrderHeader.findAll";

    @Version
    private Long lastUpdate;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private Customer customer;

    @OneToMany(mappedBy = "orderHeader", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private List<OrderEntry> orderEntries;

    private LocalDateTime orderDate;
    private String sessionId;
    private String ipAddress;

    public OrderHeader() {
        orderEntries = new ArrayList<>();
    }

    public Collection<OrderEntry> getOrderEntriesAsCollection() {
        return orderEntries;
    }

    public ByteArrayOutputStream createPdf() {
        Document document = new Document();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PdfPTable table1;
        PdfPTable table;
        NumberFormat nfInteger;
        nfInteger = NumberFormat.getIntegerInstance();
        NumberFormat nfCurr;
        nfCurr = NumberFormat.getCurrencyInstance();

        try {

            // document = new Document();
            //bos = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, bos);

            document.open();

            document.add(new Paragraph("Bestellung"));
            table = new PdfPTable(4);
            table.setSpacingBefore(10);
            table.setSpacingAfter(10);
            table.addCell("Name ");
            table.addCell("Beschreibung");
            table.addCell("Menge");
            table.addCell("Betrag");
            for (OrderEntry orderEntry : orderEntries) {
                table.addCell(orderEntry.getName());
                table.addCell(orderEntry.getDescription());
                table.addCell(nfInteger.format(orderEntry.getQuantity()));
                table.addCell(nfCurr.format(orderEntry.getAmount()));
            }
            table.addCell("");
            table.addCell("");
            table.addCell("");
            table.addCell(nfCurr.format(this.getAmount()));

            document.add(table);

            document.add(new Paragraph("Adresse"));

            table = new PdfPTable(2);
            table.setSpacingBefore(10);
            table.setSpacingAfter(10);
            table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
            table.addCell("Nachname");
            table.addCell(this.customer.getLastName());
            table.addCell("Vorname");
            table.addCell(this.customer.getFirstName());
            table.addCell("Email");
            table.addCell(this.customer.getEmail());

            document.add(table);

            document.close();

            //for ( PrintService s : PrintServiceLookup.lookupPrintServices( null, null ) )System.out.println( s.getName() );
        } catch (DocumentException ex) {
            Logger.getLogger(OrderHeader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bos;
    }

    public void store() {
//        DaoOrder daoOrder = new DaoOrder();
//        DaoOrderEntry daoOrderEntry = new DaoOrderEntry();
//        this.orderId = daoOrder.store(this);
//        for (Map.Entry<MenuItem, OrderEntry> orderEntry : orderEntries.entrySet()) {
//            daoOrderEntry.store(orderEntry.getValue(), orderId);
//        }
    }

    public void addOrderEntries(List<MenuItem> menuItems) throws OrderAmountToHighException {
        String message = "";
        for (MenuItem menuItem : menuItems) {
            try {
                addOrderEntry(menuItem);
                message = "";
            } catch (OrderAmountToHighException ex) {
                message = ex.getMessage();
            }
        }
        if (!message.equals("")) {
            throw new OrderAmountToHighException(message);
        }
    }

    public void addOrderEntry(MenuItem menuItem) throws OrderAmountToHighException {
        BigDecimal orderAmount;
        OrderEntry newOrderEntry;
        boolean entryNotFound = true;

        for (int i = orderEntries.size() - 1; i >= 0; i--) {
            if (orderEntries.get(i).getName().equals(menuItem.getName())) {
                entryNotFound = false;
                if (menuItem.getQuantity() != 0) {
                    orderEntries.get(i).setQuantity(menuItem.getQuantity());
                } else {
                    orderEntries.remove(i);
                }
            }
        }
        if (entryNotFound && menuItem.getQuantity() != 0) {
            newOrderEntry = new OrderEntry(menuItem);
            newOrderEntry.setOrderHeader(this);
            orderEntries.add(newOrderEntry);
        }
        orderAmount = getAmount();
        if (orderAmount.compareTo(MAX_ORDER_AMOUNT) >= 0) {
            throw new OrderAmountToHighException("Maximum is: " + MAX_ORDER_AMOUNT.toPlainString());
        }

    }
    
    public boolean isValid() {
        return !orderEntries.isEmpty() && getAmount().compareTo(MAX_ORDER_AMOUNT)< 0;
    }

    public void removeOrderEntry(OrderEntry orderEntry) {
        orderEntries.remove(orderEntry);
    }

    public BigDecimal getAmount() {
        BigDecimal amount;
        amount = BigDecimal.ZERO;
        for (OrderEntry orderEntry : orderEntries) {
            amount = amount.add(orderEntry.getAmount());
        }
        return amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        if (customer.getOrderHeaders().contains(this) == false) {
            customer.addOrderHeader(this);
        }
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public List<OrderEntry> getOrderEntries() {
        return orderEntries;
    }

    public void setOrderEntries(List<OrderEntry> orderEntries) {
        this.orderEntries = orderEntries;
    }

}
