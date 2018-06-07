import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;



public class Filechooser {
	private static Filechooser Instance = new Filechooser(); 
	public static String path_saved; 
	public Filechooser(){
		
		JFileChooser jFileChooser = new JFileChooser();
		jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		int result = jFileChooser.showOpenDialog(new JFrame());
	
	
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = jFileChooser.getSelectedFile();
		    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
		    path_saved = selectedFile.getAbsolutePath();
		}
	}
	
	public static Filechooser getinstance() {
		if(Instance==null) {
			Instance = new Filechooser(); 
		}
		return Instance; 
	}
}
