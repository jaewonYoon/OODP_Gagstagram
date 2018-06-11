
public interface Element {
	public abstract String getName();
	public abstract String getPath();
	public abstract void accept(Visitor v);
	public abstract void update_path(); 
	public String toString();
}
