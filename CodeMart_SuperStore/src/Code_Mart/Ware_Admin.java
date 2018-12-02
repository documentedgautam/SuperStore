import java.util.ArrayList;

public class Ware_Admin extends User{
    protected WareHouse W_house;

    public Ware_Admin(){

    }

    public Ware_Admin(int ID, String PSWD, String Name, ArrayList<Ware_Admin> Ware_Ad_list){
        this.ID=ID;
        this.PSWD=PSWD;
        this.W_house=new WareHouse(Name, Ware_Ad_list);
    }

	public static void serialize() throws IOException
	{
		//SuperUser s1 = new SuperUser(123,"hi");
		ObjectOutputStream	out	= null;
		try
		{
			out = new ObjectOutputStream( new FileOutputStream("Ware_Ad_Serialization.txt"));
			out.writeObject(this.W_house);
		}
		finally
		{
			out.close();
		}	
	}

	public static void deserialize(WareHouse w1) throws IOException,ClassNotFoundException
	{
		ObjectInputStream in = null;
		try
		{
			in = new ObjectInputStream(new FileInputStream("out.txt"));
			w1 = (WareHouse) in.readObject();
		}
		finally
		{
			in.close();
		}
	}    
}
