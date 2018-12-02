import java.io.Serializable;

/** Represents an Product.
* @author Dheeraj
* @author https://github.com/documentedgautam/SuperStore
* @version 1.0
*/
public class Product implements Serializable
{
    protected String P_NAME;
    protected int P_ID;
    protected String PATH;
    protected int d;
    protected int h;
    protected int k;
    protected int Quantity;
    protected int Price;

/** Creates a Product with default values.
*/
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

/** Creates a Product with Specific name.
* @param name A String representing Product's name
*/
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

/** Creates a Product with some specifications.
* @param p_name A String representing Product's name
* @param p_id An Integer representing Product's id
* @param path A String representing Product's path in Database
* @param _d An Integer representing Product's cost includes fixed cost per quarter
* @param _h An Integer representing Product's carrying cost per unit per quarter
* @param _k An Integer representing Product's demand of in units per quarter
*/
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
