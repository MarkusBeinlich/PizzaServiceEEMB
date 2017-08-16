/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.beinlich.markus.pizzaservice.test.pages;

import java.util.Locale;
import java.util.ResourceBundle;
import static junit.framework.Assert.assertEquals;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.Graphene;
import static org.jboss.arquillian.graphene.Graphene.guardAjax;
import static org.jboss.arquillian.graphene.Graphene.guardHttp;
import static org.jboss.arquillian.graphene.Graphene.guardNoRequest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Markus
 */
public abstract class AbstractPage {

    @Drone
    private WebDriver browser;

    @FindBy(xpath = "//h2")
    private WebElement title;

    @FindBy(xpath = "//div[contains(@id,'loginDialog')]")
    private LoginForm loginForm;

    @FindBy(xpath = "//a[contains(@title,'login')]")
    private WebElement loginLink;

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

}
