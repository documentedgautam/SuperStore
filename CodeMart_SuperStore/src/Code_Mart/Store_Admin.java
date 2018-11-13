package Code_Mart;

public class Store_Admin extends User{
    protected Store store;

    public Store_Admin(){

    }

    public Store_Admin(int ID, String PSWD, String Name){
        this.ID=ID;
        this.PSWD=PSWD;
        this.store=new Store(Name);
    }
}
