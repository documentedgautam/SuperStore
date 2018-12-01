package Code_Mart;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SU_Opt {

    @FXML
    public void create_warehouse(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("create_warehouse.fxml"));
        primaryStage.setTitle("Code Mart");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 406, 295));
        primaryStage.show();
    }

    @FXML
    public void create_store(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("create_store.fxml"));
        primaryStage.setTitle("Code Mart");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 406, 295));
        primaryStage.show();
    }

    @FXML
    public void linkSnW(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("LinkSnW.fxml"));
        primaryStage.setTitle("Code Mart");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 406, 295));
        primaryStage.show();
    }

    @FXML
    public void see_data(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Reg_WareNStore.fxml"));
        Scene su_login_scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(su_login_scene);
        window.show();
    }

    @FXML
    public void signout(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Main_Page.fxml"));
        Scene su_login_scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(su_login_scene);
        window.show();
    }
}