
public class Background_Factory extends AbstractFactory {
	public Background getBackground(String Type) {
	      if(Type == null){
	         return null;
	      }
	      if(Type.equalsIgnoreCase("pic1")){
	         return new pic1();
	      }else if(Type.equalsIgnoreCase("pic2")){
	         return new pic2();
	      }else if(Type.equalsIgnoreCase("pic3")){
	         return new pic3();
	      }
	      return null;
	   }
}
