package Code_Mart;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.io.IOException;

public class S_Opt {
    @FXML
    private TextField C_name;

    @FXML
    private TextField c_name;

    @FXML
    private TextField S_name;

    @FXML
    private TextField s_name;

    @FXML
    private TextField P_name;

    @FXML
    private TextField p_name;

    @FXML
    private TextField s1_name;

    @FXML
    private TextField quantity;

    @FXML
    public void add_Category(ActionEvent event)throws IOException{
        String Category_Name=C_name.getText();
    }
}
