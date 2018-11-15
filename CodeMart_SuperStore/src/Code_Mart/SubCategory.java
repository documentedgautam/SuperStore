import java.io.Serializable;
import java.util.ArrayList;
class SubCategory implements Serializable
{
	protected ArrayList<SubCategory> Sub_list;
	protected ArrayList<Product> Pro_list;
	protected String S_name;

	public SubCategory(String name)
	{
		S_name = name;
		Sub_list = new ArrayList<SubCategory>();
		Pro_list = new ArrayList<Product>();
	}
}