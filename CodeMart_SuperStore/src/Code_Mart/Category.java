class Category implements Serializable
{
	protected ArrayList<SubCategory> Sub_list;
	protected String C_name; 

	public Category(String name)
	{
		C_name = name;
		Sub_list = new ArrayList<SubCategory>();
	}
}