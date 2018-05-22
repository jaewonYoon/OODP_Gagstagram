import java.util.ArrayList;
import java.util.Observable;


@SuppressWarnings({ "deprecation", "unused" })
public class NewsMachine2 extends Observable {
	
	private String title;
	private String news;
	
	// 갱신할 새로운 데이터 여부의 플래그 값을 변경하고(setChanged())
	// 옵저버들에게 새로운 데이터를 전달한다. (notifyObservers())
	public void setNewsInfoChanged() {
		this.setChanged();
		this.notifyObservers();
	}
	
	public void setNewsInfo(String title, String news) {
		this.title = title;
		this.news = news;
		setNewsInfoChanged();
	}
	public String getTitle() {
		return title;
	}
	public String getNews() {
		return news;
	}
}
