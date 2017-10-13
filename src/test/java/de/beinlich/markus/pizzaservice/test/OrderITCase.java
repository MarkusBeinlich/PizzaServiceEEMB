/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.beinlich.markus.pizzaservice.test;

import de.beinlich.markus.pizzaservice.controller.SigninController;
import de.beinlich.markus.pizzaservice.test.pages.ConfirmationPage;
import de.beinlich.markus.pizzaservice.test.pages.MenuPage;
import de.beinlich.markus.pizzaservice.test.pages.CustomerPage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.InitialPage;
import org.jboss.arquillian.graphene.page.Page;
import org.jboss.arquillian.junit.Arquillian;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Markus
 */
@RunWith(Arquillian.class)
public class OrderITCase extends AbstractItCase {

    @Drone
    private WebDriver browser;
    @Page
    private CustomerPage customerPage;
    @Page
    private ConfirmationPage confirmationPage;

    @Test
    public void testAddOrderWithLogin(@InitialPage MenuPage menuPage) {
        System.out.println("testAddOrderMB");
        menuPage.assertOnPage();
        menuPage.getLoginForm().login("markus.beinlich@gmx.de", "secure");
        menuPage.clearPage();
        menuPage.doInput();
        menuPage.doOrder();

        confirmationPage.assertOnPage();
        confirmationPage.doConfirmation();
        
        assertThat(confirmationPage.getOrderAmount(), is("€ 8,50"));
        
        confirmationPage.assertFacesMessage("confirmationEnjoyYourMeal");
        confirmationPage.closeMessageBar();
        confirmationPage.doNewOrder();
    }

    @Test
    public void testAddOrderWithoutLogin(@InitialPage MenuPage menuPage) {

        System.out.println("testAddOrderWithoutLogin");
        menuPage.clearPage();
        menuPage.assertOnPage();
        menuPage.doInput(1,2);
        menuPage.doOrder();

        customerPage.assertOnPage();
        customerPage.doInput();
        customerPage.doCustomerEntered();
        confirmationPage.assertOnPage();
        confirmationPage.doConfirmation();
        
        assertThat(confirmationPage.getOrderAmount(), is("€ 17,50"));

        confirmationPage.assertConfirmationMessage();
        confirmationPage.closeMessageBar();
        confirmationPage.doNewOrder();

    }
    
        @Test
    public void testOrderAmountToHigh(@InitialPage MenuPage menuPage) {
        
        menuPage.clearPage();
        menuPage.assertOnPage();
        menuPage.doInput(10,9, 10);
        
        assertThat(menuPage.getMessages(), containsString("Maximum is"));
        menuPage.doInput(0,0, 0);

    }
}
