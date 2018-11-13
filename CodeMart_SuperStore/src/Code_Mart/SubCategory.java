package Code_Mart;

import java.io.Serializable;
import java.util.ArrayList;

class SubCategory extends Category implements Serializable
{
    protected ArrayList<SubCategory> Sub_list;
    protected ArrayList<Product> Pro_list;
    protected String S_name;
}

