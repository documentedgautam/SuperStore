package Code_Mart;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main_SuperStore extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Main_Page.fxml"));
        primaryStage.setTitle("Code Mart");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 700 , 530));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
