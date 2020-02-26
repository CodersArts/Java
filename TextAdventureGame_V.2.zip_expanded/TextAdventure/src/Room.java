import java.util.ArrayList;

public class Room extends Location {
	
	private String name;
	private String desc;
	private ArrayList<Thing> contents;
	private int numberOfThings;
	public Room() {
		contents = new ArrayList<>();
		setType("Room");
	}
	
	public Room(String name, String desc) {
		this.name = name;
		this.desc = desc;
		contents = new ArrayList<>();
		setType("Room");
	}

	public ArrayList<Thing>  getContents() {
		return contents;
	}
	
	public void addObject(Thing item){
		contents.add(item);
	}
	public void dropObject(Thing item){
		contents.remove(item);
	}
	

	public void setContents(ArrayList<Thing> contents) {
		this.contents = contents;
	}

	public int getNumberOfThings() {
		numberOfThings = contents.size();
		return numberOfThings;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String setLocationType() {
		return "Room";
		
	}
	
	public void viewRoomContent() {
		System.out.println("Room Contents");
		System.out.println();
		if(contents.size()==0)
			System.out.println("No Item in Room");
		else {
		for(int i = 0 ; i < contents.size(); i++)
			System.out.println(i + "  " + contents.get(i));
		}
		System.out.println();
	}

	@Override
	public String toString() {
		return "Room [name=" + name + ", desc=" + desc + ", contents=" + contents
				+ ", numberOfThings=" + getNumberOfThings() + "]";
	}

	public Thing getRoomItem(int takeThing) {
		Thing t = contents.get(takeThing);
		dropObject(t);
		return t;
		
	}
}
