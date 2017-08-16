/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.beinlich.markus.pizzaservice.test.pages;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.jboss.arquillian.graphene.Graphene;
import static org.jboss.arquillian.graphene.Graphene.waitAjax;
import org.jboss.arquillian.graphene.page.Location;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 *
 * @author Markus
 */
@Location("menu.xhtml")
public class MenuPage extends AbstractPage {

//    @FindBy(xpath = "//tbody/tr[1]/td[4]")
    @FindBy(xpath = "//input[contains(@id,'0:quantity_input')]")
    private WebElement quantityInput0;
    @FindBy(xpath = "//button[contains(@id,'orderButton')]")
    private WebElement orderButton;

    public void assertOnPage() {
        assertTitle("menu");
    }

    public void doInput() {
        System.out.println("doInput:" + quantityInput0.getText());
        quantityInput0.sendKeys("1");
        quantityInput0.sendKeys(Keys.TAB);
    }

    public void doOrder() {
//        WebElement orderButton = getButtonByLabel("menuOrder");
//        WebElement orderButton = getElementById("j_idt35:orderButton");
        System.out.println("orderButton4: " + orderButton.getText());
//        orderButton.submit();
        waitAjax().until(ExpectedConditions.elementToBeClickable(orderButton));
        Graphene.guardHttp(orderButton).click();
//        Graphene.waitForHttp(orderButton).click();
//        orderButton.sendKeys(Keys.ENTER);
//        Graphene.guardAjax(orderButton).click();
        System.out.println("after orderButton2");
    }
}
