package dbms;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

    public static void getUserDetails(int userId)  {      
        ResultSet rs = null;
        Connection connection = null;
        Statement statement = null; 

        String query = "SELECT * FROM user_details WHERE id=" + userId;
        try {           
            connection = JDBCConnect.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            if(rs.next())
            	System.out.println(rs.getString("name") +" record properly retrieved");
            else
            	System.out.println("No record found");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

	public static void main(String[] args) {
		launch(args);
		//getUserDetails(5);
		
	}
}