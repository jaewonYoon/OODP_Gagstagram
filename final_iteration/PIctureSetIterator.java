

public class PIctureSetIterator implements Iterator{
	private PIctureSet pictureSet;
	private int index;
	public PIctureSetIterator(PIctureSet pictureSet){
		this.pictureSet = pictureSet;
		this.index = 0; 
	}
	public boolean hasNext() {
		if(index<pictureSet.getLength()) {
			return true;
		}else {
			return false; 
		}
	}
	public Object next() {
		Picture picture = pictureSet.getPicture(index);
		index++;
		return picture; 
	}
}
/** 
 *  written by jaewon 
 */
