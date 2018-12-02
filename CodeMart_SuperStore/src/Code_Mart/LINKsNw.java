package Code_Mart;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LINKsNw {

    @FXML
    private TextField w_name;

    @FXML
    private TextField s_name;

    @FXML
    public void link(ActionEvent event)throws IOException{
        SuperUser SU=SuperUser.getInstance();
        String W_name=w_name.getText();
        String S_name=s_name.getText();
        SU.Link_SnW(W_name, S_name, 1);
        Alert alert1=new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setHeaderText(null);
        alert1.setContentText("Linked Successfully!!");
        alert1.showAndWait();
        ((Node)event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    public void delink(ActionEvent event)throws IOException{
        SuperUser SU=SuperUser.getInstance();
        String W_name=w_name.getText();
        String S_name=s_name.getText();
        SU.Link_SnW(W_name, S_name, -1);
        Alert alert1=new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setHeaderText(null);
        alert1.setContentText("Delink Successfully!!");
        alert1.showAndWait();
        ((Node)event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    public void cancel(ActionEvent event)throws IOException {
        ((Node)event.getSource()).getScene().getWindow().hide();
    }
}
