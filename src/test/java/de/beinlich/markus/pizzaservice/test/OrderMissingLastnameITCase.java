/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.beinlich.markus.pizzaservice.test;

import de.beinlich.markus.pizzaservice.test.pages.ConfirmationPage;
import de.beinlich.markus.pizzaservice.test.pages.MenuPage;
import de.beinlich.markus.pizzaservice.test.pages.CustomerPage;
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
public class OrderMissingLastnameITCase extends AbstractItCase{
    @Drone
    private WebDriver browser;
    @Page
    private CustomerPage customerPage;
    @Page
    private ConfirmationPage confirmationPage;

    @Test
    public void testAddOrderMissingLastname(@InitialPage MenuPage menuPage){
        System.out.println("testAddOrderMissingLastname");
        menuPage.assertOnPage();
        menuPage.doInput();
        menuPage.doOrder();
        customerPage.assertOnPage();
        customerPage.doInputFirstName();
        customerPage.doCustomerEntered();
        customerPage.assertMissingLastname();
    }
    
}
