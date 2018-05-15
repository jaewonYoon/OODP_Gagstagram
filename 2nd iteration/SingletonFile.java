package first_iteration;

public class SingletonFile {
	private static SingletonFile singletonfile;
	private Filechooser filechooser = new Filechooser();
	
	private SingletonFile(){}
	
	public static SingletonFile getInstance(){
		singletonfile = new SingletonFile();
		return singletonfile;
	}
	public void setFile(Filechooser filechooser) {
		this.filechooser = filechooser; 
	}
	public Filechooser getFilechooser() {
		return filechooser;
	}
	
}
