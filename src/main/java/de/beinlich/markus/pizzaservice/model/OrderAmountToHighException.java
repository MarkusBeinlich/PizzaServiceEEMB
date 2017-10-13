/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.beinlich.markus.pizzaservice.model;


/**
 *
 * @author Markus
 */
public class OrderAmountToHighException extends Exception {
    public OrderAmountToHighException(String message){
       super(message);
    }
}
