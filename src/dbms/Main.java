package dbms;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		try {
		
			Parent root = FXMLLoader.load(getClass().getResource("Filter.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Filter");
            primaryStage.show();
        } catch (Exception ex) {
        	ex.printStackTrace();

        }
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
