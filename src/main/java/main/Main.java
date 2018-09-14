/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import facade.Facade;
import javax.persistence.Persistence;

/**
 *
 * @author Andreas Heick Laptop
 */
public class Main
{

    public static void main(String[] args)
    {
        Facade facade = new Facade(Persistence.createEntityManagerFactory("pu"));


        System.out.println("---");

        System.out.println("---");

        System.out.println("---");

        System.out.println("---");

        System.out.println("---");

        System.out.println("---");

        System.out.println("---");

        System.out.println("---");

        System.out.println("---");
    }

}
