
import java.io.Serializable;

class Serial implements Serializable {
	private static final long serialVersionUID = 1L;
	private String writer;
	private String title;
	private String writing;
	private String file;
	public Serial(String w,String t, String wt,String f) {
	writer=w;
	title=t;
	writing =wt;
	file=f;
	}
	public String getWriter() {
		return writer;
	}
	public String getTitle() {
		return title;
	}
	public String getWriting() {
		return writing;
	}
	public String getFile() {
		return file;
	}
}


