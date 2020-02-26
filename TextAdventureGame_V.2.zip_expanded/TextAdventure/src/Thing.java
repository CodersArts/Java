
public class Thing {
	private String name;
	private String desc;
	
	public Thing() {
	
	}
	public Thing(String name, String desc) {
		this.name = name;
		this.desc = desc;
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
	public String look() {
		return  getDesc();
	}
	@Override
	public String toString() {
		return "Thing name=" + name + ", desc=" + desc ;
	}
   
    
	
}
