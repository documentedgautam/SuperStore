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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GU_Opt implements Initializable {
    private static Customer Cust=new Customer();
    private static Store store;
    public ArrayList<Store_Admin> Store_Ad_list;

    @FXML
    private TextField S_name;

    @FXML
    private Text txt;

    @FXML
    private TableView<Cust_Store> Store_name;

    @FXML
    private TableColumn<Cust_Store, String> Store_col;

    @FXML
    private TextField fund;

    @FXML
    private TextField c_fund;

    @FXML
    public void Add_Fund(ActionEvent event)throws IOException{
        Cust.Add_Fund(Integer.parseInt(fund.getText()));
        Parent root = FXMLLoader.load(getClass().getResource("GU_opt.fxml"));
        Scene su_login_scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(su_login_scene);
        window.show();
    }

    @FXML
    public void sign_out(ActionEvent event)throws IOException {
        Cust.fund=0;
        Cust.Cust_Store=null;
        Cust.Cart_list=null;
        Parent root = FXMLLoader.load(getClass().getResource("Main_Page.fxml"));
        Scene su_login_scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(su_login_scene);
        window.show();
    }

    @FXML
    public void enter(ActionEvent event)throws IOException{
        //txt.setText("");
        boolean flag=true;
        String St_name=S_name.getText();
        for(int i=0;i<Store_Ad_list.size();i++){
            if(Store_Ad_list.get(i).store.getNAME().equals(St_name)){
                Cust.Cust_Store=Store_Ad_list.get(i).store;
                flag=false;
                Parent root = FXMLLoader.load(getClass().getResource("Checkout.fxml"));
                Scene su_login_scene = new Scene(root);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(su_login_scene);
                window.show();
            }
        }
        if(flag){
            txt.setText("Store Doesn't exist");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        c_fund.setText(Integer.toString(Cust.fund));
        SuperUser SU=SuperUser.getInstance();
        Store_Ad_list=SU.giveSAlist();
        Store_col.setCellValueFactory(new PropertyValueFactory<Cust_Store, String>("NAME"));
        Store_name.setItems(getObj1());
    }

    public ObservableList<Cust_Store> getObj1(){
        ObservableList<Cust_Store> obj= FXCollections.observableArrayList();
        try {
            for (int i = 0; i < Store_Ad_list.size(); i++) {
                System.out.println(Store_Ad_list.size());
                obj.add(new Cust_Store(Store_Ad_list.get(i).store.getNAME()));
            }
        }
        catch (NullPointerException e){

        }
        return obj;
    }

    public static Customer getInstance(){
        return Cust;
    }
}
