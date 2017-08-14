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
@Location("confirmation.xhtml")
public class ConfirmationPage extends AbstractPage {


    public void assertOnPage() {

        assertTitle("confirmationCustomer");
        System.out.println("ConfirmationPage assertOnPage End");
    }

    public void doConfirmation() {
        System.out.println("doConfirmation");
        WebElement nextButton = getButtonByLabel("confirmationSubmitOrder");
        Graphene.guardAjax(nextButton).click();
    }
}
