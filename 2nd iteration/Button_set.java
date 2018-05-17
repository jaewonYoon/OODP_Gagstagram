
public class Button_set implements Aggregate{
	private But[] But;
	private int last=0;
	
	public Button_set(int maxsize) {
		this.But=new But[maxsize];
		
	}
	public But getButtonAt(int index) {
		return But[index];
	}
	public void appendButton(But Butto) {
		this.But[last]=Butto;
		last++;
	}
	public int getLength() {
		return last;
	}
	public Iterator iterator() {
			return new Button_setIterator(this);
	}

}
