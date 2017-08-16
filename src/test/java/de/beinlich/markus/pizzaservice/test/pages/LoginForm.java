/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.beinlich.markus.pizzaservice.test.pages;

import static org.jboss.arquillian.graphene.Graphene.guardHttp;
import org.jboss.arquillian.graphene.fragment.Root;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Markus
 */
public class LoginForm {

    @Root
    private WebElement form;

    @FindBy(xpath = "//input[contains(@id,'username')]")
    private WebElement userName;

     @FindBy(xpath = "//input[contains(@id,'password')]")
    private WebElement password;

     @FindBy(xpath = "//div[contains(@id,'username')]")
    private WebElement loginButton;
    
    public void login(String userName, String password) {
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        guardHttp(loginButton).click();
    }
}
