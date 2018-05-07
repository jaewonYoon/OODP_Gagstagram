import java.io.Serializable;

public class Serial implements Serializable {
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



/* 객체 전송을 위해서 serialization이 되어야함.
객체를 바이트 단위로 분해.   marshalling
분해된 데이터를 순서에 따라 전송
전송 받은 데이터를 원래대로 복구 unmarshalling




마샬링으로 바이트로 분해된 객체는 스트림을 통해서 나갈 수 있는 준비가 되었다. 

앞에서 언급한대로 객체를 마샬링하기 위해서는 Serializable 인터페이스를 구현한 클래스로 만들어진 객체에 한해서만 마샬링이 진행될 수 있다.


*/