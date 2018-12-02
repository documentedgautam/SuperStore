package Code_Mart;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class WA_login {
    @FXML
    TextField suser_id;

    @FXML
    PasswordField password;

    @FXML
    public void isvalid(ActionEvent event)throws IOException{
        SuperUser SU=SuperUser.getInstance();
        String userid=suser_id.getText();
        String paswd=password.getText();
        if (userid.isEmpty()||paswd.isEmpty()){
            Alert alert1=new Alert(Alert.AlertType.ERROR);
            alert1.setHeaderText(null);
            alert1.setContentText("Enter user id and password");
            alert1.showAndWait();
        }
        else{
            boolean flag=true;
            for(int i=0;i<SU.giveWAlist().size();i++){
                if(SU.giveWAlist().get(i).ID==Integer.parseInt(userid)){
                    if(SU.giveWAlist().get(i).PSWD.equals(paswd)){
                        flag=false;
                        Alert alert1=new Alert(Alert.AlertType.INFORMATION);
                        alert1.setHeaderText(null);
                        alert1.setContentText("Login Successful");
                        alert1.showAndWait();
                        Parent root = FXMLLoader.load(getClass().getResource("S_opt.fxml"));
                        Scene su_login_scene = new Scene(root);
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                        window.setScene(su_login_scene);
                        window.show();
                    }
                }
            }
            if(flag){
                Alert alert1=new Alert(Alert.AlertType.ERROR);
                alert1.setHeaderText(null);
                alert1.setContentText("Wrong user id or password");
                suser_id.setText("");
                password.setText("");
                alert1.showAndWait();
            }
        }
    }

    @FXML
    public void goback(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Main_Page.fxml"));
        Scene su_login_scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(su_login_scene);
        window.show();
    }
}
