package Code_Mart;

import java.util.ArrayList;

public class Ware_Admin extends User{
    protected WareHouse W_house;

    public Ware_Admin(){

    }

    public Ware_Admin(int ID, String PSWD, String Name, ArrayList<Ware_Admin> Ware_Ad_list){
        this.ID=ID;
        this.PSWD=PSWD;
        this.W_house=new WareHouse(Name, Ware_Ad_list);
    }
}
