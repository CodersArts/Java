import java.util.ArrayList;

public class Adventurer {
	private Room location;
	private Room moveFrom;
	private ArrayList<Thing> inventory;
	private int  numberOfObjects;
	
	public Adventurer() {
		location = null;
		moveFrom = null;
		inventory = new ArrayList<Thing>();
		numberOfObjects = 0;
	}
	public Adventurer(Room location, Room moveFrom,int numberOfObjects) {
		super();
		this.location = location;
		this.moveFrom = moveFrom;
		this.inventory = new ArrayList<Thing>();
		this.numberOfObjects = numberOfObjects;
	}
	public void take(Thing item){
		inventory.add(item);
	}
	public void drop(Thing item){
		inventory.remove(item);
	}
	public Room getLocation() {
		return location;
	}
	public void setLocation(Room location) {
		this.location = location;
	}
	public Room getMoveFrom() {
		return moveFrom;
	}
	public void setMoveFrom(Room moveFrom) {
		this.moveFrom = moveFrom;
	}
	public ArrayList<Thing> getInventory() {
		return inventory;
	}
	public void setInventory(ArrayList<Thing> inventory) {
		this.inventory = inventory;
	}
	public int getNumberOfObjects() {
		return numberOfObjects;
	}
	public void setNumberOfObjects(int numberOfObjects) {
		this.numberOfObjects = numberOfObjects;
	}
	
	public void viewAdventurerInventory() {
		System.out.println("Adventurer Inventory");
		System.out.println();
		if(inventory.size()==0)
			System.out.println("No Item in Inventory");
		else {
		for(int i = 0 ; i < inventory.size(); i++)
			System.out.println(i + "  " + inventory.get(i));
		}
		System.out.println();
	}
	
	public Thing getInventoryItem(int takeThing) {
		Thing t = inventory.get(takeThing);
		drop(t);
		return t;
	}
	
	@Override
	public String toString() {
		return "Adventurer [location=" + location + ", moveFrom=" + moveFrom + ", inventory=" + inventory
				+ ", numberOfObjects=" + numberOfObjects + "]";
	}
  
	
	
}
