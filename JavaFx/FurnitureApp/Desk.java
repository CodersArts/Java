package furnitureapp;

import javax.swing.*;
import java.io.Serializable;
import java.text.DecimalFormat;

/**
 *
 * @author 44750
 */
public class Desk  extends Furniture implements Serializable {
    private int NumberOfDrawers;
    private int height = 80;
    private int width;
    private int depth;

    Desk(){
        super();
        this.width=80;
        this.depth = 80;
        this.NumberOfDrawers = 2;
        image = new ImageIcon();
    }
    Desk(int IDNumber, int chooseWood, int quantity, int drawers, int w, int d){
        super(IDNumber, chooseWood, quantity);
        this.NumberOfDrawers = drawers;
        this.width= w;
        this.depth = d;
        image = new ImageIcon ();

    }

    public int getNumberOfDrawers() {
        return NumberOfDrawers;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getDepth() {
        return depth;
    }

    public void setNumberOfDrawers(int noOfDrawers) {
        this.NumberOfDrawers = noOfDrawers;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
    @Override
    public double getCharge(){
        itemPrice= quantity*(((height + width + depth) *12) + (depth * width) * unitPrice) + (NumberOfDrawers * 8.5);
        return itemPrice;
    }
    @Override
    public String toString(){
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String desk = "<html>DESK " + "<br>" + "Wood : " + woodChoice + "<br>" + "Number of Drawers : "  + NumberOfDrawers + "<br>" +
                "Width : " + width+ "<br>" + "Depth : " + depth + "<br>" + "Height : 80" + "<br>" + "Quantity : " + quantity +"<br>" + "The Price is : " + decimalFormat.format(getCharge());
        return desk;
    }

    public String string(){
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String desk = "DESK " + "\n" +"Item ID : "+getIDNumber()+"\n"+"Wood: " + woodChoice + "\n" + "Number of Drawers: "  + NumberOfDrawers + "\n" +
                "Width" + width+ "\n" + "Depth:" + depth + "\n" + "The Price is: " + decimalFormat.format(getCharge());
        return desk;
    }



}
