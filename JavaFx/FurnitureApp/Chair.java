package furnitureapp;

import javax.swing.*;
import java.io.Serializable;
import java.text.DecimalFormat;

public class Chair extends Furniture implements Serializable
{

    private boolean armrests;
    private int NumberOfUnits = 1625;

    Chair() {
        super();
        this.armrests = false;
        this.NumberOfUnits = 2;
        image = new ImageIcon();

    }

    Chair(boolean armrests, int IDNumber, int typeOfWood, int quantity) {
        super(IDNumber, typeOfWood, quantity);
        this.armrests = armrests;
        image = new ImageIcon();
        setArmrests(armrests);

    }

    public boolean getArmrests() {
        return armrests;
    }

    public int getNumberOfUnits() {
        return NumberOfUnits;
    }

    public void setArmrests(boolean armrests) {
        this.armrests = armrests;
        if (armrests)
        {
            NumberOfUnits = 1875;

        }
        else
        {
            NumberOfUnits = 1625;
        }
    }

    public void setNumberOfUnits(int NumberOfUnits) {
        this.NumberOfUnits = NumberOfUnits;
    }

    @Override
    public double getCharge() {

        itemPrice = (NumberOfUnits * unitPrice) * quantity;
        return itemPrice;

    }

    @Override
    public String toString() {
        String hasArmrests;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        if (armrests == true)
        {
            hasArmrests = "Yes";
        }
        else
        {
            hasArmrests = "No";
        }
        String chair = "<html>CHAIR" + "<br>" + "Wood : " + woodChoice + "<br>" + "Armrests : " + hasArmrests + "<br>"+
                "Number of Units per chair : " + NumberOfUnits + "<br>" + "Quantity :" + quantity + "<br>"+ "The price is : " + decimalFormat.format(getCharge());
        return chair;
    }

    public String string() {
        String hasArmrests;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        if (armrests == true)
        {
            hasArmrests = "Yes";
        }
        else
        {
            hasArmrests = "No";
        }
        String chair = "CHAIR" + "\n" +"Item ID : "+getIDNumber()+"\n"+ "Wood: " + woodChoice + "\n" + "Armrests: " + hasArmrests + "\n"+
                "The price is: " + decimalFormat.format(getCharge());
        return chair;

    }

}
