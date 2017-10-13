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
import org.openqa.selenium.By;
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
    @FindBy(xpath = "//input[contains(@id,'1:quantity_input')]")
    private WebElement quantityInput1;
    @FindBy(xpath = "//input[contains(@id,'2:quantity_input')]")
    private WebElement quantityInput2;
    @FindBy(xpath = "//button[contains(@id,'orderButton')]")
    private WebElement orderButton;
    @FindBy(xpath = "//div[contains(@id,'messages')]")
    private WebElement messages;

    public void assertOnPage() {
        assertTitle("menu");
    }

    public void doInput() {
        doInput(1);
    }

    public void doInput(int... intArray) {
        System.out.println("doInput:" + quantityInput0.getText());
        quantityInput0.sendKeys(Integer.toString(intArray[0]));
        quantityInput0.sendKeys(Keys.TAB);
        if (intArray.length > 1) {
            quantityInput1.sendKeys(Integer.toString(intArray[1]));
            quantityInput1.sendKeys(Keys.TAB);
        }
        if (intArray.length > 2) {
            quantityInput2.sendKeys(Integer.toString(intArray[2]));
            quantityInput2.sendKeys(Keys.TAB);
        }
    }
    
    public void clearPage() {
        quantityInput0.clear();
        quantityInput1.clear();
        quantityInput2.clear();
    }
    
    public String getMessages() {
        Graphene.waitGui().until(ExpectedConditions.visibilityOf(messages));
        return messages.getText();
    }

    public void doOrder() {
//        try {
//            //        WebElement orderButton = getButtonByLabel("menuOrder");
//            Thread.sleep(3000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(MenuPage.class.getName()).log(Level.SEVERE, null, ex);
//        }
        System.out.println("orderButton4: " + orderButton.getText());
//        orderButton.submit();
        Graphene.waitGui().until(ExpectedConditions.elementToBeClickable(orderButton)).click();
//        waitAjax().until(ExpectedConditions.elementToBeClickable(orderButton));
//        Graphene.guardHttp(orderButton).click();
//        Graphene.waitForHttp(orderButton).click();
//        orderButton.sendKeys(Keys.ENTER);
//        Graphene.guardAjax(orderButton).click();
        System.out.println("after orderButton2");
    }
}
