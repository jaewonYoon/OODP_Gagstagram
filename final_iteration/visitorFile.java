
public class visitorFile  extends Element {
	private String name;
	private String path;
	public visitorFile(String name, String path) {
		this.name = name;
		this.path = path;
	}
	public String getName() {
		return name;
	}
	public String getPath() {
		return path;
	}
	public void accept(Visitor v) {
		v.visit(this);
	}
	public void update_path() {
		if(Filechooser.path_saved!=null) 
        	path = Filechooser.path_saved; 
	}
}
