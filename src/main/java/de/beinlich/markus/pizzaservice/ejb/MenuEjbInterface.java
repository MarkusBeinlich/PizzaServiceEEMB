/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.beinlich.markus.pizzaservice.ejb;

import de.beinlich.markus.pizzaservice.model.Menu;

/**
 *
 * @author Markus Beinlich
 */
public interface MenuEjbInterface {
      public Menu getMenu(Menu menu);
      public void addMenu(Menu menu);
      public Menu updateMenu(Menu menu);
}
