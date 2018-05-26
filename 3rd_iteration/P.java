// 사진 폴더에 있는 파일 전부 읽어오는 클라스
import java.io.File;


public class P {
	public P() {
		final String path=".\\..\\";
		File directory = new File(path);
		File[] files = directory.listFiles();
		for(int i = 0 ; i < files.length ; i++){
			File file = files[i]; 
			if(file.isFile()){
				System.out.println(file.getAbsolutePath());
				
			}
		}
	}
	public static void main(String[] argv) {
		P p=new P();
	}
}
