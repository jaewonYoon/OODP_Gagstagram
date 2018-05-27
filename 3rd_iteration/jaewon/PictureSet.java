public class PictureSet implements Aggregate{
	private int last = 0;
	private Picture[] pictures;
	public PictureSet(int maxsize) {
		this.pictures = new Picture[maxsize];

	}
	public Picture getPicture(int index) {
		return pictures[index];
	}
	public int getLength() {
		return last; 
	}
	public void addPicture(Picture picture) {
		this.pictures[last] = picture; 
		last++;
	}
	public Iterator iterator() {
		return new PictureSetIterator(this); 
	}
}
/**
**/