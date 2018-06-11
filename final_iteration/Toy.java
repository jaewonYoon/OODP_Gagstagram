
public class Toy {
	public static void main(String[] args) {
		AbstractFactory Background_Factory = FactoryProducer.getFactory("Back");
		Background shape1 = Background_Factory.getBackground("pic2");
		shape1.Back();
	}
}
