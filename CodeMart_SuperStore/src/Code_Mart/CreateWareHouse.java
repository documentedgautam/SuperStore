package Code_Mart;

import com.sun.org.apache.bcel.internal.classfile.Code;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.InputMismatchException;

public class CreateWareHouse {
    @FXML
    private TextField w_name;

    @FXML
    private TextField w_id;

    @FXML
    private TextField w_pswd;

    @FXML
    private Text in_id;

    @FXML
    public void w_create(ActionEvent event)throws IOException{
        String wh_name=w_name.getText();
        try {
            Integer wh_id = Integer.parseInt(w_id.getText());
            String wh_pswd = w_pswd.getText();
            SuperUser SU=SuperUser.getInstance();
            int n=SU.Ware_Ad_list.size();
            SU.Create_Warehouse(wh_id, wh_pswd, wh_name);
            if(n==SU.Ware_Ad_list.size()){
                throw new CodeMartCustomException("Admin already exists");
            }
            Alert alert1=new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setHeaderText(null);
            alert1.setContentText("WareHouse created Successfully!!");
            alert1.showAndWait();
            ((Node)event.getSource()).getScene().getWindow().hide();
        }
        catch (InputMismatchException e){
            in_id.setText("Invalid ID");
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
