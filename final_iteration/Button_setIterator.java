

public class Button_setIterator implements Iterator{
	private Button_set bs;
	private int index;
	public Button_setIterator(Button_set bs) {
		this.bs=bs;
		this.index=0;
	}
	public boolean hasNext() {
		if(index<bs.getLength()) {
			return true;
		}
		else {
			return false;
		}
	}
	public Object next() {
		But But	=bs.getButtonAt(index);
		index++;
		return But;
	}
}
