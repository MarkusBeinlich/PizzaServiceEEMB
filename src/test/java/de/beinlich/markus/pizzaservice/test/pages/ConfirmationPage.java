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
import static org.jboss.arquillian.graphene.Graphene.waitAjax;
import static org.jboss.arquillian.graphene.Graphene.waitGui;
import org.jboss.arquillian.graphene.page.Location;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 *
 * @author Markus
 */
@Location("confirmation.xhtml")
public class ConfirmationPage extends AbstractPage {

    @FindBy(xpath = "//tfoot[contains(@id,'order_foot')]")
    private WebElement orderAmount;

    public void assertOnPage() {

        assertTitle("confirmationCustomer");
        System.out.println("ConfirmationPage assertOnPage End");
    }

    public void doConfirmation() {
        System.out.println("doConfirmation for orderAmount:" + orderAmount.getText());
        WebElement nextButton = getButtonByLabel("confirmationSubmitOrder");
//        Graphene.guardAjax(nextButton).click();
        waitAjax().until(ExpectedConditions.elementToBeClickable(nextButton));
        Graphene.guardHttp(nextButton).click();

    }

    public void doNewOrder() {
        System.out.println("doNewOrder");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(ConfirmationPage.class.getName()).log(Level.SEVERE, null, ex);
//        }
        WebElement newOrderButton = getButtonByLabel("confirmationNewOrder");
//        Graphene.guardAjax(nextButton).click();
        waitGui().until(ExpectedConditions.elementToBeClickable(newOrderButton));
        Graphene.guardHttp(newOrderButton).click();
    }

    public void assertConfirmationMessage() {
        assertFacesMessage("confirmationThankYou");
    }
    
    public String getOrderAmount() {
        return orderAmount.getText();
    }
}
