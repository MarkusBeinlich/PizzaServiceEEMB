/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.beinlich.markus.pizzaservice.ejb;

import de.beinlich.markus.pizzaservice.model.OrderHeader;

/**
 *
 * @author Markus Beinlich
 */
public interface OrderEjbInterface {

    public void saveOrder(OrderHeader order);
}
