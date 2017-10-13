/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.beinlich.markus.pizzaservice.test.pages;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.containsString;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.Graphene;
import static org.jboss.arquillian.graphene.Graphene.guardNoRequest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 *
 * @author Markus
 */
public abstract class AbstractPage {

    @Drone
    WebDriver browser;

    @FindBy(xpath = "//h2")
    private WebElement title;

    @FindBy(xpath = "//div[contains(@id,'loginDialog')]")
    private LoginForm loginForm;

    @FindBy(xpath = "//a[contains(@title,'login')]")
    private WebElement loginLink;

//    @FindBy(xpath = "//div[contains(@class,'ui-dialog-content')]")
//    private WebElement facesMessage;
    @FindBy(xpath = "//a[contains(@class,'ui-dialog-titlebar-close')]")
//    @FindBy(xpath = "//span[contains(@class,'ui-icon')]")
    private WebElement facesMessageClose;

    private String getString(String key) {
        return ResourceBundle.getBundle("messages", Locale.GERMANY).getString(key);
    }

    protected void assertTitle(String key) {
        assertEquals(getString(key), title.getText());
    }

    protected WebElement getButtonByLabel(String label) {
        return browser.findElement(By.xpath("//button/span[text()='" + getString(label) + "']"));
    }

    protected WebElement getElementById(String id) {
        return browser.findElement(By.id(id));
    }

    public LoginForm getLoginForm() {   // we can either manipulate with the login form or just expose it
        guardNoRequest(loginLink).click();
        return loginForm;
    }

    public void assertFacesMessage(String key) {
//        try {
//            //          @FindBy(xpath = "//div[contains(@class,'ui-dialog-content')]")
//            Thread.sleep(1000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(AbstractPage.class.getName()).log(Level.SEVERE, null, ex);
//        }
        WebElement facesMessage = browser.findElement(By.id("primefacesmessagedlg"));
//        waitAjax().until(ExpectedConditions.visibilityOf(facesMessage));
        System.out.println("key:" + getString(key) + "-Text:" + facesMessage.getText() + "-");
        Assert.assertThat(facesMessage.getText(), containsString(getString(key)));
    }

    public void closeMessageBar() {
//        waitAjax().until(ExpectedConditions.visibilityOf(facesMessageClose));
//        Graphene.guardHttp(facesMessageClose).click();
        WebElement facesMessage = browser.findElement(By.id("primefacesmessagedlg"));
        Actions builder = new Actions(browser);
        builder.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        Graphene.waitGui().until(ExpectedConditions.invisibilityOfElementLocated(By.id("primefacesmessagedlg")));
//        facesMessage.sendKeys(Keys.TAB);
//        facesMessage.click();
    }

}
