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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Markus
 */
@Location("menu.xhtml")
public class MenuPage extends AbstractPage {

//    @FindBy(xpath = "//tbody/tr[1]/td[4]")
    @FindBy(id = "j_idt34:j_idt35:0:quantity_input")
    private WebElement quantityInput0;

    public void assertOnPage() {
        assertTitle("menu");
    }

    public void doInput() {
        quantityInput0.sendKeys("1");
        quantityInput0.sendKeys(Keys.TAB);
    }
    
    public void doOrder() {
        WebElement orderButton = getElementById("j_idt34:orderButton");
        System.out.println("orderButton2: " + orderButton.getText());
//        orderButton.submit();
        Graphene.guardHttp(orderButton).click();
//        Graphene.guardAjax(orderButton).click();
        System.out.println("after orderButton2");
    }
}
