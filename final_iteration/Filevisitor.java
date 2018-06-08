import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class Filevisitor implements Visitor {
	private String filetype;
	private ArrayList jpgfiles = new ArrayList();
	public Filevisitor(String filetype) {
		this.filetype =filetype;
	}
	public java.util.Iterator getfiles() {
		return jpgfiles.iterator();
	}
	
	@Override
	public void visit(visitorFile file) {
		// TODO Auto-generated method stub
		file.update_path();
		File f =new File(file.getPath());
		File[] allFiles = f.listFiles();
		for(File afile :allFiles) {
		if(file.getName().endsWith(filetype)) {
			jpgfiles.add(afile);
		}
	  }
	}
}
