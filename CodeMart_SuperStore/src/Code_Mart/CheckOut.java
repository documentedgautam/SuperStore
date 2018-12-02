package Code_Mart;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CheckOut {

    @FXML
    public void Sign_Out(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Main_Page.fxml"));
        Scene su_login_scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(su_login_scene);
        window.show();
    }

    @FXML
    public void go_back(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GU_opt.fxml"));
        Scene su_login_scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(su_login_scene);
        window.show();
    }
}
