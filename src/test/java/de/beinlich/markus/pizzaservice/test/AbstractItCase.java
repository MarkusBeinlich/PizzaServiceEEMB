/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.beinlich.markus.pizzaservice.test;

import java.io.File;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;


/**
 *
 * @author Markus Beinlich
 */
public abstract class AbstractItCase {
    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        WebArchive webArchive;
        System.out.println("createDeploymentMB2");
        webArchive =  ShrinkWrap.create(ZipImporter.class, "test.war").importFrom(new File("target/PizzaServiceEEMB-1.0-SNAPSHOT.war")).as(WebArchive.class);
        return webArchive;
    }
    
}
