/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.beinlich.markus.pizzaservice.test.pages;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.graphene.page.Location;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Markus
 */
@Location("customer.xhtml")
public class CustomerPage extends AbstractPage {

//    @FindBy(xpath = "//tbody/tr[1]/td[4]")
    @FindBy(id = "j_idt34:j_idt35:0:quantity_input")
    private WebElement quantityInput0;

    public void assertOnPage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(CustomerPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertTitle("customerHeader");
    }

    public void doInput() {
        quantityInput0.sendKeys("1");
        quantityInput0.click();
    }
    
    public void doOrder() {
        WebElement orderButton = getButtonByLabel("customerButtonNext");
        Graphene.guardHttp(orderButton).click();
    }
}
