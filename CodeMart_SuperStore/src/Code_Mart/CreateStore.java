package Code_Mart;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.InputMismatchException;

public class CreateStore {
    @FXML
    private TextField s_name;

    @FXML
    private TextField s_id;

    @FXML
    private TextField s_pswd;

    @FXML
    private Text n_id;

    @FXML
    public void s_create(ActionEvent event)throws IOException{
        String S_name=s_name.getText();
        try {
            Integer S_id = Integer.parseInt(s_id.getText());
            String S_pswd = s_pswd.getText();
            SuperUser SU=SuperUser.getInstance();
            int n=SU.Store_Ad_list.size();
            SU.Create_Store(S_id, S_pswd, S_name);
            if(n==SU.Store_Ad_list.size()){
                throw new CodeMartCustomException("Admin already exists");
            }
            Alert alert1=new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setHeaderText(null);
            alert1.setContentText("Store created successfully!! ");
            alert1.showAndWait();
            ((Node)event.getSource()).getScene().getWindow().hide();
        }
        catch (InputMismatchException e){
            n_id.setText("Invalid ID");
        }
        catch(CodeMartCustomException e){
            e.getMessage();
        }
    }

    @FXML
    public void cancel(ActionEvent event)throws IOException{
        ((Node)event.getSource()).getScene().getWindow().hide();
    }
}
