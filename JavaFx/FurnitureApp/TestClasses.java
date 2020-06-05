/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package furnitureapp;

/**
 *
 * @author 44750
 */
public class TestClasses 
{
    public static void main(String[] args){
        Chair chair1 = new Chair();
        Chair chair2 = new Chair(true, 001, 1 , 1);
        Chair chair3 = new Chair (false, 002, 0, 2);
        
        
        Table table1 = new Table();
        Table table2  = new Table();
        Table table3 = new Table();
        
        Desk desk1 = new Desk();
        Desk desk2 = new Desk(201, 0, 1, 3, 80, 80);
        Desk desk3 = new Desk(202, 1, 3, 4, 60, 60);
        
        
        
        System.out.println(chair1.toString());
        System.out.printf("The price is £%.2\n\n", chair1.getCharge());
        System.out.println(chair2.toString());
        System.out.printf("The price is £%.2f\n\n", chair2.getCharge());
        System.out.println(chair3.toString());
        System.out.printf("The price is £%.2f\n\n", chair3.getCharge());
        
        
        
        System.out.println(table1.toString());
       System.out.printf("The price is £%.2\n\n", table1.getCharge());
        System.out.println(table2.toString());
        System.out.printf("The price is £%.2\n\n", table2.getCharge());
        System.out.println(table3.toString());
        System.out.printf("The price is £%.2\n\n", table3.getCharge());
        
        System.out.println(desk1.toString());
        System.out.printf("The price is £%.2\n\n", desk1.getCharge());
        System.out.println(desk2.toString());
        System.out.printf("The price is £%.2\n\n", desk2.getCharge());
        System.out.println(desk3.toString());
        System.out.printf("The price is £%.2\n\n", desk3.getCharge());
        
        
        
        
        
    }
    
}
