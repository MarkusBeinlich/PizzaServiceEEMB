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
    @FindBy(xpath = "//input[contains(@id,'inFirstName')]")
    private WebElement firstName;
    @FindBy(xpath = "//input[contains(@id,'inLastName')]")
    private WebElement lastName;
    @FindBy(xpath = "//input[contains(@id,'inEmail')]")
    private WebElement email;
    @FindBy(xpath = "//input[contains(@id,'inPhone')]")
    private WebElement phone;
    @FindBy(xpath = "//input[contains(@id,'inStreet')]")
    private WebElement street;
    @FindBy(xpath = "//input[contains(@id,'inTown')]")
    private WebElement town;
    @FindBy(xpath = "//input[contains(@id,'inPostcode')]")
    private WebElement postcode;
    @FindBy(xpath = "//div[contains(@id,'messageLastName')]")
    private WebElement messageLastName;

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
        System.out.println("assertMissingLastname");
        assertEquals("Nachname ist ein Pflichtfeld.", messageLastName.getText());
    }

    public void doCustomerEntered() {
        System.out.println("doCustomerEntered");
        WebElement nextButton = getButtonByLabel("customerButtonNext");
        Graphene.guardHttp(nextButton).click();
    }
}
