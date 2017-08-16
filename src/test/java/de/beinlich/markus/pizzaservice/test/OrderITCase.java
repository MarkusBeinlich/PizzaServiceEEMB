/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.beinlich.markus.pizzaservice.test;

import de.beinlich.markus.pizzaservice.test.pages.ConfirmationPage;
import de.beinlich.markus.pizzaservice.test.pages.MenuPage;
import de.beinlich.markus.pizzaservice.test.pages.CustomerPage;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.InitialPage;
import org.jboss.arquillian.graphene.page.Page;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Markus
 */
@RunWith(Arquillian.class)
public class OrderITCase extends AbstractItCase{
    @Drone
    private WebDriver browser;
    @Page
    private CustomerPage customerPage;
    @Page
    private ConfirmationPage confirmationPage;
    
    @Test
    public void testAddOrder(@InitialPage MenuPage menuPage){
        System.out.println("testAddOrderMB");
        menuPage.assertOnPage();
        menuPage.getLoginForm().login("markus.beinlich@gmx.de", "secure");
        menuPage.doInput();
        menuPage.doOrder();
//        customerPage.assertOnPage();
//        customerPage.doInput();
//        customerPage.doCustomerEntered();
        confirmationPage.assertOnPage();
        confirmationPage.doConfirmation();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(OrderITCase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
