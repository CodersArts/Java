package furnitureapp;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.io.Serializable;

/**
 *
 * @author 44750
 */
public  abstract class Furniture implements Serializable {


    private int IDNumber;
    private String[] typeOfWood = {"Walnut","Oak"};
    protected String woodChoice;
    protected double itemPrice;
    protected double unitPrice;
    protected int quantity;
    protected ImageIcon image;





    Furniture()
    {

        this.IDNumber=999;
        this.quantity = 1;
        this.woodChoice = "Walunt";
        this.unitPrice = 0.03;

    }

    public Furniture (int IDNumber, int chooseWood, int quantity)
    {
        this.IDNumber = IDNumber;
        this.woodChoice = typeOfWood[chooseWood];
        this.quantity=  quantity;

        if( woodChoice.equals(typeOfWood[0])){
            unitPrice = 0.03;
        }
        else{
            unitPrice = 0.04;
        }
    }

    public int getIDNumber() {
        return IDNumber;
    }

    public String getTypeOfWood() {
        return woodChoice;
    }


    public double getItemPrice() {
        return itemPrice;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setIDNumber(int IDNumber) {
        this.IDNumber = IDNumber;
    }

    public void setTypeOfWood(String wood)
    {
        this.woodChoice = wood;

        if(woodChoice == "Walnut")
        {
            unitPrice = 0.03;
        }
        else if (woodChoice == "Oak")
        {
            unitPrice = 0.04;
        }
    }



    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }



    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }
    @Override
    public abstract String toString();
    public abstract double getCharge();
    public abstract String string();
}

