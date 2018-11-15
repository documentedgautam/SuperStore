import java.io.Serializable;
import java.util.ArrayList;
class SuperUser extends User implements Serializable
{
	protected ArrayList<Ware_Admin> Ware_Ad_list;
	protected ArrayList<Store_Admin> Store_Ad_list;

	public SuperUser(int _id,String _pswd)
	{
		id = _id;
		pswd = _pswd;
		Ware_Ad_list = new ArrayList<Ware_Admin>();
		Store_Ad_list = new ArrayList<Store_Admin>();
	}

	protected void Create_Warehouse(int id,String pswd,String name)
	{
		WareHouse p = new WareHouse(name);
		Ware_Admin w = new Ware_Admin(p,id,pswd);
		Ware_Ad_list.add(w);

	}

	protected void Create_Store(int id,String pswd,String name)
	{
		Store p = new Store(name);
		Store_Admin w = new Store_Admin(p,id,pswd);		
		Store_Ad_list.add(w);				
	}

	protected void Link_SnW(Ware_Admin ware_admin,Store_Admin a_store)
	{
		ware_admin.W_house.Store_Ad_list.add(a_store);
	}



	private void See_Data()
	{

	}

}