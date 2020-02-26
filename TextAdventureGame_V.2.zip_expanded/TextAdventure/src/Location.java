import java.util.HashMap;
import java.util.Map;

//general location (battlefield, outer space, etc.)
public class Location {
	private String type;
	private HashMap<String ,Location> roomDir;
	

	public Location() {
		roomDir = new HashMap<String,Location>();
	}
	
	public String getType() {
		return type;
		
	}

	public void setType(String type) {
		this.type = type;
	}
	public void addDirection(String dir,Location location){
		roomDir.put(dir, location);  
	  }

	public HashMap<String, Location> getRoomDir() {
		return roomDir;
	}

	public void setRoomDir(HashMap<String, Location> roomDir) {
		this.roomDir = roomDir;
	}

	@Override
	public String toString() {
		return "Location [type=" + type + ", roomDir=" + roomDir + "]";
	}

	
	
	
	
	
}
