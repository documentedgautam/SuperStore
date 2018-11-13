package Code_Mart;
import java.util.ArrayList;

public class Store {
    private final String NAME;
    private ArrayList<Category> Cat_list;
    private ArrayList<Product> Prod_list;
    private WareHouse Parent;

    public Store(String NAME){
        this.NAME=NAME;
    }

    protected String getNAME(){
        return this.NAME;
    }
}
