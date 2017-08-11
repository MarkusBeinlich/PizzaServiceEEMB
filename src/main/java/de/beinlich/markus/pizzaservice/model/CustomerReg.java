/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.beinlich.markus.pizzaservice.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author schulung
 */
@NamedQueries({
    @NamedQuery(name = CustomerReg.findByEmail, query = "SELECT c FROM CustomerReg c WHERE c.email = :email")
})
@Entity
public class CustomerReg implements Serializable{
    public static final String findByEmail = "CustomerReg.findByEmail";
    private static final long serialVersionUID = 6041779523439137448L;
    
    @Id
    private String email;
    private String password;
    private String rolename;

    public CustomerReg() {
    }

    
    
    public CustomerReg(String email, String password) {
        this.email = email;
        this.password = password;
    }

    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
    
    
}
