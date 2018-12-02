public class Store_Admin extends User{
    protected Store store;

    public Store_Admin(Store st){
        store = st;
    }

    public Store_Admin(int ID, String PSWD, String Name)
    {
        this.ID=ID;
        this.PSWD=PSWD;
        this.store=new Store(Name);

    }
	public static void serialize() throws IOException
	{
		//SuperUser s1 = new SuperUser(123,"hi");
		ObjectOutputStream	out	= null;
		try
		{
			out = new ObjectOutputStream( new FileOutputStream("Store_Ad_Serialization.txt"));
			out.writeObject(this.store);
		}
		finally
		{
			out.close();
		}	
	}

	public static void deserialize(Store s1) throws IOException,ClassNotFoundException
	{
		ObjectInputStream in = null;
		try
		{
			in = new ObjectInputStream(new FileInputStream("Store_Ad_serialization.txt"));
			s1 = (Store) in.readObject();
		}
		finally
		{
			in.close();
		}
	}    
}
