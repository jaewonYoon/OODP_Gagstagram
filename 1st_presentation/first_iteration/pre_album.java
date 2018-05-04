package first_iteration;
	
import java.util.LinkedHashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class pre_album extends Application{
	@Override
	public void start(Stage stage) {
		try {
			Image image1 = new Image("file:image/image1.jpeg");
			Image image2 = new Image("file:image/image2.jpeg");
			Image image3 = new Image("file:image/image3.jpeg");
			Image image4 = new Image("file:image/image4.jpeg");
			Image image5 = new Image("file:image/image5.jpeg");

			
			ImageView iv = new ImageView();
			iv.setFitWidth(600);
			iv.setPreserveRatio(true);
			
			Label label1 = new Label("1");
			Label label2 = new Label("2");
			Label label3 = new Label("3");
			Label label4 = new Label("4");
			Label label5 = new Label("5");

			GridPane grid = new GridPane();
			grid.addRow(0, label1, label2, label3, label4, label5);;
			grid.setAlignment(Pos.BOTTOM_CENTER);
			
			Map<Label,Image> map = new LinkedHashMap<Label,Image>();
			map.put(label1, image1);
			map.put(label2, image2);
			map.put(label3, image3);
			map.put(label4, image4);
			map.put(label5, image5);
			
			for(Label label : map.keySet()) {
				label.setStyle("-fx-border-color: black; -fx-font-size:20;");
				label.setOnMouseEntered(e->{
					iv.setImage(map.get(label));
				});
				label.setOnMouseExited(e->{
					iv.setImage(null);
				});
			}	
			 
			pane.getChildren().addAll(iv,grid);
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	StackPane pane = new StackPane();
	Scene scene = new Scene(pane, 800, 500); 
	public static void main(String[] args) {
		launch(args);
	}
}
