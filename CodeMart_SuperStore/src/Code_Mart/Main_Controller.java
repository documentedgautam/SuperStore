package Code_Mart;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;

public class Main_Controller {

    @FXML
    Button su_login;

    @FXML
    public void SU_login_page(ActionEvent event)throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("SU_pswd.fxml"));
        Scene su_login_scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(su_login_scene);
        window.show();
    }

    @FXML
    public void WA_login_page(ActionEvent event)throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("WA_pswd.fxml"));
        Scene su_login_scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(su_login_scene);
        window.show();
    }

    @FXML
    public void SA_login_page(ActionEvent event)throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("SA_pswd.fxml"));
        Scene su_login_scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(su_login_scene);
        window.show();
    }

    @FXML
    public void exit(ActionEvent event){
        System.exit(0);
    }
}
