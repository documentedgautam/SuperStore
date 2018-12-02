package Code_Mart;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CheckOut implements Initializable {

    @FXML
    private TextField P_name;

    @FXML
    private TextField p_name;

    @FXML
    private TextField Q_prod;

    @FXML
    private TextField q_prod;

    @FXML
    private Text txt;

    @FXML
    private TableView<Store_prod> p_names;

    @FXML
    private TableColumn<Store_prod, String> p1_name;

    @FXML
    private TableColumn<Store_prod, Integer> quantity;

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

    @FXML
    public void check_availability(ActionEvent event)throws IOException {
        String name=P_name.getText();
        int Quantity = Integer.parseInt(Q_prod.getText());
        try{
            Customer Cust=GU_Opt.getInstance();
            Cust.Check_Availability(new Product(name, Quantity));
            txt.setText("Product available");
        }
        catch (CodeMartCustomException e){
            txt.setText("Product not available");
        }
        Parent root = FXMLLoader.load(getClass().getResource("Checkout.fxml"));
        Scene su_login_scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(su_login_scene);
        window.show();
    }

    @FXML
    public void add_to_cart(ActionEvent event)throws IOException{
        String name=p_name.getText();
        int Quantity = Integer.parseInt(q_prod.getText());
        Customer Cust=GU_Opt.getInstance();
        Cust.Cart_list.add(new Product(name, Quantity));

    }

    @FXML
    public void check_out(ActionEvent event)throws IOException{
        Customer Cust=GU_Opt.getInstance();
        Cust.CheckOut();
        Alert alert1=new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setHeaderText(null);
        alert1.setContentText("Thank You for shopping with us !!");
        alert1.showAndWait();
        Parent root = FXMLLoader.load(getClass().getResource("Main_Page.fxml"));
        Scene su_login_scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(su_login_scene);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        p1_name.setCellValueFactory(new PropertyValueFactory<Store_prod, String>("NAME"));
        quantity.setCellValueFactory(new PropertyValueFactory<Store_prod, Integer>("quantity"));
        p_names.setItems(getObj1());
    }

    public ObservableList<Store_prod> getObj1(){
        Customer Cust=GU_Opt.getInstance();
        ObservableList<Store_prod> obj= FXCollections.observableArrayList();
        try {
            for (int i = 0; i < Cust.Cust_Store.Prod_list.size(); i++){
                obj.add(new Store_prod(Cust.Cust_Store.Prod_list.get(i).P_NAME, Cust.Cust_Store.Prod_list.get(i).Quantity));
            }
        }
        catch (NullPointerException e){

        }
        return obj;
    }
}
