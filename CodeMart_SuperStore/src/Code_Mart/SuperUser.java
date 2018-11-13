class SuperUser extends User implements SerialiZable
{
	protected ArrayList<Ware_Admin> Ware_Ad_list;

	public SuperUser(int _id,String _pswd)
	{
		id = _id;
		pswd = _pswd;
	}

	protected void Create_Warehouse(int id,String pswd,String name)
	{

	}

	protected void Create_Store(int id,String pswd,String name)
	{

	}

	protected void Link_SnW(Ware_Admin ware_admin,Store_Admin a_store)
	{

	}

	private void See_Data()
	{

	}

}