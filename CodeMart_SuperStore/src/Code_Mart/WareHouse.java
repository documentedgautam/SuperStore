package Code_Mart;

import java.util.ArrayList;

public class WareHouse {
    String Name;
    protected ArrayList<Store> Store_list = new ArrayList<Store>();
    
    public WareHouse(String Name){
        this.Name=Name;
    }
}
