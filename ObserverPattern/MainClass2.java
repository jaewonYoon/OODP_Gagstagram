import java.util.Observer;
public class MainClass2 {
	public static void main(String[] args) {
		NewsMachine2 newsmachine2 = new NewsMachine2();
		
		Observer es = new EventSubscriber2(newsmachine2);
		Observer as = new AnnualSubscriber2(newsmachine2);
	
		newsmachine2.setNewsInfo("news1", "news2"); 
		newsmachine2.setNewsInfo("news3", "news4");
		
		newsmachine2.deleteObserver(as);
		newsmachine2.setNewsInfo("delete check", "news");
	}
}
