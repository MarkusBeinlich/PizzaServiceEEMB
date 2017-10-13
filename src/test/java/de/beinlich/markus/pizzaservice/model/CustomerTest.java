package de.beinlich.markus.pizzaservice.model;

import java.util.Collections;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 *
 * @author Markus
 */
public class CustomerTest {

    public CustomerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getCustomerId method, of class Customer.
     */
    @Test
    public void testGetCustomerId() {
        System.out.println("getCustomerId");
        Customer instance = new Customer();
        Integer expResult = null;
        Integer result = instance.getCustomerId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCustomerId method, of class Customer.
     */
    @Test
    public void testSetCustomerId() {
        System.out.println("setCustomerId");
        Integer customerId = null;
        Customer instance = new Customer();
        instance.setCustomerId(customerId);
        assertThat(instance.getCustomerId(), is(customerId));
    }

    /**
     * Test of getFirstName method, of class Customer.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        Customer instance = new Customer();
        String expResult = "";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFirstName method, of class Customer.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "Markus";
        Customer instance = new Customer();

        instance.setFirstName(firstName);

        assertThat(instance.getFirstName(), is(firstName));
    }

    /**
     * Test of getLastName method, of class Customer.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        Customer instance = new Customer();
        String expResult = "";
        String result = instance.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLastName method, of class Customer.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "Beinlich";
        Customer instance = new Customer();

        instance.setLastName(lastName);
        assertThat(instance.getLastName(), is(lastName));
    }

    /**
     * Test of getEmail method, of class Customer.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Customer instance = new Customer();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);

    }

    /**
     * Test of setEmail method, of class Customer.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "mb@gmx";
        Customer instance = new Customer();
        instance.setEmail(email);

        assertThat(instance.getEmail(), is(email));
    }

    /**
     * Test of getPhone method, of class Customer.
     */
    @Test
    public void testGetPhone() {
        System.out.println("getPhone");
        Customer instance = new Customer();
        String expResult = "";
        String result = instance.getPhone();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPhone method, of class Customer.
     */
    @Test
    public void testSetPhone() {
        System.out.println("setPhone");
        String phone = "";
        Customer instance = new Customer();
        instance.setPhone(phone);
        
        assertThat(instance.getPhone(), is(phone));
    }

    /**
     * Test of getStreet method, of class Customer.
     */
    @Test
    public void testGetStreet() {
        System.out.println("getStreet");
        Customer instance = new Customer();
        String expResult = "";
        String result = instance.getStreet();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStreet method, of class Customer.
     */
    @Test
    public void testSetStreet() {
        System.out.println("setStreet");
        String street = "";
        Customer instance = new Customer();
        instance.setStreet(street);
        
        assertThat(instance.getStreet(), is(street));
    }

    /**
     * Test of getTown method, of class Customer.
     */
    @Test
    public void testGetTown() {
        System.out.println("getTown");
        Customer instance = new Customer();
        String expResult = "";
        String result = instance.getTown();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTown method, of class Customer.
     */
    @Test
    public void testSetTown() {
        System.out.println("setTown");
        String town = "";
        Customer instance = new Customer();
        instance.setTown(town);
        
        assertThat(instance.getTown(), is(town));
    }

    /**
     * Test of getPostcode method, of class Customer.
     */
    @Test
    public void testGetPostcode() {
        System.out.println("getPostcode");
        Customer instance = new Customer();
        String expResult = "";
        String result = instance.getPostcode();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPostcode method, of class Customer.
     */
    @Test
    public void testSetPostcode() {
        System.out.println("setPostcode");
        String postcode = "";
        Customer instance = new Customer();
        instance.setPostcode(postcode);
        assertThat(instance.getPostcode(), is(postcode));
    }

    /**
     * Test of getLastUpdate method, of class Customer.
     */
    @Test
    public void testGetLastUpdate() {
        System.out.println("getLastUpdate");
        Customer instance = new Customer();
        Long expResult = null;
        Long result = instance.getLastUpdate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLastUpdate method, of class Customer.
     */
    @Test
    public void testSetLastUpdate() {
        System.out.println("setLastUpdate");
        Long lastUpdate = System.currentTimeMillis();
        Customer instance = new Customer();
        instance.setLastUpdate(lastUpdate);
        assertThat(instance.getLastUpdate(), is(lastUpdate));
    }

    /**
     * Test of getOrderHeaders method, of class Customer.
     */
    @Test
    public void testGetOrderHeaders() {
        System.out.println("getOrderHeaders");
        Customer instance = new Customer();
        List<OrderHeader> expResult = Collections.emptyList();
        List<OrderHeader> result = instance.getOrderHeaders();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOrderHeaders method, of class Customer.
     */
    @Test
    public void testSetOrderHeaders() {
        System.out.println("setOrderHeaders");
        List<OrderHeader> orderHeaders = null;
        Customer instance = new Customer();
        instance.setOrderHeaders(orderHeaders);
        assertThat(instance.getOrderHeaders(), is(Collections.EMPTY_LIST));
    }

    /**
     * Test of addOrderHeader method, of class Customer.
     */
    @Test
    public void testAddOrderHeader() {
        System.out.println("addOrderHeader");
        OrderHeader orderHeader = mock(OrderHeader.class);
        Customer instance = new Customer();
        instance.addOrderHeader(orderHeader);
        
        assertThat(instance.getOrderHeaders().get(0), is(orderHeader));
    }

}
