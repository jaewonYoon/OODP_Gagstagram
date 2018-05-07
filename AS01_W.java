import java.io.Serializable;

public class AS01_W implements Serializable {
	private String writer;
	private String title;
	private String writing;
	private String file;
	public AS01_W(String w,String t, String wt,String f) {
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
