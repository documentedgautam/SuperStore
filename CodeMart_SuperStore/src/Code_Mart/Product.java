package Code_Mart;

import java.io.Serializable;

class Product implements Serializable
{
    protected String P_NAME;
    protected int P_ID;
    protected String PATH;
    protected int d;
    protected int h;
    protected int k;
    protected int Quantity;
    protected int Price;

    public Product(){
        P_NAME = null;
        P_ID = 0;
        PATH = null;
        d = 0;
        h = 0;
        k = 0;
        Quantity = 0;
        Price = 0;
    }

    public Product(String Name){
        P_NAME = Name;
        P_ID = 0;
        PATH = null;
        d = 0;
        h = 0;
        k = 0;
        Quantity = 0;
        Price = 0;
    }

    public Product(String Name, int Quantity){
        P_NAME = Name;
        P_ID = 0;
        PATH = null;
        d = 0;
        h = 0;
        k = 0;
        this.Quantity = Quantity;
        Price = 0;
    }

    public Product(String p_name,int p_id,String path,int _d,int _h,int _k,int _Quantity,int _price)
    {
        P_NAME = p_name;
        P_ID = p_id;
        PATH = path;
        d = _d;
        h = _h;
        k = _k;
        Quantity = _Quantity;
        Price = _price;

    }
}
