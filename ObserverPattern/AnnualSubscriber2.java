import java.util.Observable;

public class AnnualSubscriber2 implements java.util.Observer {
	private Observable observable;
	private String title;
	private String news;
	
	public AnnualSubscriber2(Observable observable) {
		this.observable = observable;
		this.observable.addObserver(this);
	}
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof NewsMachine2) {
			NewsMachine2 newsmachine2 = (NewsMachine2) o;
			this.title = newsmachine2.getTitle();
			this.news = newsmachine2.getNews();
		}
		display(); 
	}
	
	public void display() {
		System.out.println("오늘의 뉴스\n====================\n");
	}
}
