package furnitureapp;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.io.Serializable;
import java.text.DecimalFormat;

/**
 *
 * @author 44750
 */
public class Table extends Furniture implements Serializable {

    private String[] baseTypes = {"Wooden", "Chrome"};
    private String baseChoice;
    private int diameter;
    private double basePrice;

    Table() {
        this.baseChoice = "Wooden";
        this.diameter = 50;
        this.basePrice = 45.00;
        image = new ImageIcon();
    }

    public Table(int base, int diameter, int IDNumber, int chooseWood, int quantity, int baseTypes) {
        super(IDNumber, chooseWood, quantity);
       this.diameter = diameter;
        this.basePrice = 45.00;
        image = new ImageIcon();
        baseChoice = this.baseTypes[baseTypes];

    }

    public void setBaseTypes(String[] baseTypes) {
        this.baseTypes = baseTypes;

    }

    public void setBaseChoice(String baseChoice) {
        this.baseChoice = baseChoice;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;

    }

    public String[] getBaseTypes() {
        return baseTypes;
    }

    public String getBaseChoice() {
        return baseChoice;
    }

    public int getDiameter() {
        return diameter;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getCharge(){
        itemPrice = quantity*((diameter*diameter* unitPrice) + basePrice);
        return itemPrice;
    }

    public  String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String table = "<html>TABLE" + "<br>" + "Wood : " + woodChoice +"<br>"+ "Base Choice :"  + baseChoice + "<br>" + "basePrice : " + basePrice + "<br>" + "Diameter : " +diameter+"<br>" +
                "Quantity : " + quantity + "<br>" + "The Price is : " + decimalFormat.format(getCharge());
        return table;
    }

    public  String string() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String table = "TABLE" + "\n" +"Item ID : "+getIDNumber()+"\n"+ "Wood: " + woodChoice +"\n"+ "Base Choice :"  + baseChoice + "\n" +  "Diameter: " +diameter+"\n" +
                "The Price is: " + decimalFormat.format(getCharge());
        return table;
    }
}
