import java.io.Serializable;
import java.util.ArrayList;
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

	public Product(Sting p_name,int p_id,String path,int _d,int _h,int _k,int _Quantity,int _price)
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