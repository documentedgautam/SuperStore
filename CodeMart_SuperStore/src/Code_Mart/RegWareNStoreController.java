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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RegWareNStoreController implements Initializable{
    public ArrayList<Ware_Admin> Ware_Ad_list;
    public ArrayList<Store_Admin> Store_Ad_list;
    @FXML
    private Label label;

    @FXML
    private TextField no_w_house;

    @FXML
    private TextField no_store;

    @FXML
    private TableView<ware_pro_obj> RegWareNStore_Tabel1;

    @FXML
    private TableView<store_pro_obj> RegWareNStore_Tabel2;

    @FXML
    private TableColumn<ware_pro_obj, String> w_nameColumn;

    @FXML
    private TableColumn<ware_pro_obj, Integer> n_prod1;

    @FXML
    private TableColumn<store_pro_obj, String> s_name;

    @FXML
    private TableColumn<store_pro_obj, Integer> n_prod2;

    @FXML
    public void go_back(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SU_opt.fxml"));
        Scene su_login_scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(su_login_scene);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        SuperUser SU=SuperUser.getInstance();
        Ware_Ad_list=SU.giveWAlist();
        Store_Ad_list=SU.giveSAlist();
        try {
            no_w_house.setText(Integer.toString(Ware_Ad_list.size()));
        }
        catch(NullPointerException e){
            no_w_house.setText(Integer.toString(0));
        }
        try {
            no_store.setText(Integer.toString(Store_Ad_list.size()));
        }
        catch (NullPointerException e){
            no_store.setText(Integer.toString(0));
        }
        s_name.setCellValueFactory(new PropertyValueFactory<store_pro_obj, String>("NAME"));
        n_prod2.setCellValueFactory(new PropertyValueFactory<store_pro_obj, Integer>("no_of_prod"));
        RegWareNStore_Tabel2.setItems(getObj2());
        w_nameColumn.setCellValueFactory(new PropertyValueFactory<ware_pro_obj, String>("NAME"));
        n_prod1.setCellValueFactory(new PropertyValueFactory<ware_pro_obj, Integer>("no_of_prod"));
        RegWareNStore_Tabel1.setItems(getObj1());
    }

    public ObservableList<ware_pro_obj> getObj1(){
        ObservableList<ware_pro_obj> obj=FXCollections.observableArrayList();
        try {
            for (int i = 0; i < Ware_Ad_list.size(); i++) {
                obj.add(new ware_pro_obj(Ware_Ad_list.get(i).W_house.getNAME(), Ware_Ad_list.get(i).W_house.Product_list.size()));
            }
        }
        catch (NullPointerException e){

        }
        return obj;
    }

    public ObservableList<store_pro_obj> getObj2(){
        ObservableList<store_pro_obj> obj1=FXCollections.observableArrayList();
        try {
            for (int i = 0; i < Store_Ad_list.size(); i++) {
                obj1.add(new store_pro_obj(Store_Ad_list.get(i).store.getNAME(), Store_Ad_list.get(i).store.getProduct_list().size()));
            }
        }
        catch (NullPointerException e){

        }
        return obj1;
    }

}
