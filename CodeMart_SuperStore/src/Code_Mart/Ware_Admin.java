package Code_Mart;

public class Ware_Admin extends User{
    protected WareHouse W_house;

    public Ware_Admin(){

    }

    public Ware_Admin(int ID, String PSWD, String Name){
        this.ID=ID;
        this.PSWD=PSWD;
        this.W_house=new WareHouse(Name);
    }
}
