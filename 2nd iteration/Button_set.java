
public class Button_set implements Aggregate{
	private But[] Buttons;
	private int last=0;
	public Button_set(int maxsize) {
		this.Buttons=new But[maxsize];
		
	}
	public But getButtonAt(int index) {
		return Buttons[index];
	}
	public void ab(But p) {
		this.Buttons[last]=p;
		last++;
	}
	public int getLength() {
		return last;
	}
	public Iterator iterator() {
			return new Button_setIterator(this);
	}

}
