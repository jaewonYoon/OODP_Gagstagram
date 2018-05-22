import java.util.Observable;

public class EventSubscriber2 implements java.util.Observer {
	private Observable observable;
	private String title;
	private String news;
	
	public EventSubscriber2(Observable observable) {
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
		System.out.println("\n====EventSubscriber====\n");
		System.out.println(title + "\n" + news + "\n");
	}
}