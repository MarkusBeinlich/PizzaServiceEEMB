/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.beinlich.markus.pizzaservice.test.pages;

import java.util.logging.Level;
import java.util.logging.Logger;
import static junit.framework.Assert.assertEquals;
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
    @FindBy(id = "j_idt34:inFirstName")
    private WebElement firstName;
    @FindBy(id = "j_idt34:inLastName")
    private WebElement lastName;
    @FindBy(id = "j_idt34:inEmail")
    private WebElement email;
    @FindBy(id = "j_idt34:inPhone")
    private WebElement phone;
    @FindBy(id = "j_idt34:inStreet")
    private WebElement street;
    @FindBy(id = "j_idt34:inTown")
    private WebElement town;
    @FindBy(id = "j_idt34:inPostcode")
    private WebElement postcode;

    public void assertOnPage() {

        assertTitle("customerHeader");
        System.out.println("CustomerPage assertOnPage End");
    }

    public void doInputFirstName() {
        firstName.sendKeys("Markus");
    }

    public void doInput() {
        firstName.sendKeys("Markus");
        lastName.sendKeys("Beinlich");
        email.sendKeys("markus@beinlich");
        phone.sendKeys("089-12345");
        street.sendKeys("Dorfstr. 11");
        town.sendKeys("München");
        postcode.sendKeys("80123");
    }

    public void assertMissingLastname() {
        WebElement missingLastname = getElementById("j_idt34:j_idt38");
        assertEquals("Nachname ist ein Pflichtfeld.", missingLastname.getText());
    }

    public void doCustomerEntered() {
        WebElement nextButton = getButtonByLabel("customerButtonNext");
        Graphene.guardHttp(nextButton).click();
    }
}
