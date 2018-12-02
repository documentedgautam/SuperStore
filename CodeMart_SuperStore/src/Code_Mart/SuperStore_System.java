//package comlowewriterpayroll;
import java.io.*;
import java.util.*;


/** Represents an SuperStore System.
* @author Dheeraj
* @author https://github.com/documentedgautam/SuperStore
* @version 1.0
*/

public class SuperStore_System
{

/** Creates an Empty SuperStore System.
*/
	public SuperStore_System()
	{

	}

/** Gets a SuperUser.
* @param id The SuperUser's id
* @param pswd The SuperUser's password
* @return A SuperUser having specific id and password 
*/

    public SuperUser Create_SuperUser(int id,String pswd)
    {
        return new SuperUser(id,pswd);
    }

/** Serializes a SuperUser into SuperStore_serialization.txt.
* @param s1 A SuperUser that needs to be serialized	
*/

	public static void serialize(SuperUser s1) throws IOException
	{
		//SuperUser s1 = new SuperUser(123,"hi");
		ObjectOutputStream	out	= null;
		try
		{
			out = new ObjectOutputStream( new FileOutputStream("SuperStore_serialization.txt"));
			out.writeObject(s1);
		}
		finally
		{
			out.close();
		}	
	}

/** Deserializes a SuperUser from SuperStore_serialization.txt.
* @param s1 A SuperUser that needs to be deserialized	
*/
	public static void deserialize(SuperUser s1) throws IOException,ClassNotFoundException
	{
		ObjectInputStream in = null;
		try
		{
			in = new ObjectInputStream(new FileInputStream("SuperStore_serialization.txt"));
			s1 = (SuperUser) in.readObject();
		}
		finally
		{
			in.close();
		}
	}	    

    public static void main(String[]args) throws IOException, ClassNotFoundException,CodeMartCustomException
    {
    	SuperStore_System  obj = new SuperStore_System();
    	SuperUser su = obj.Create_SuperUser(53421,"lol");
  /*  	serialize(su);
    	deserialize();
    	System.out.println(su.ID);
	*/
    	su.Create_Warehouse(123, "hi", "ram");
    	su.Create_Store(234,"hello", "ramesh");
    	su.Link_SnW("ram","ramesh");
    	Ware_Admin wa1 = su.Ware_Ad_list.get(0);
    	Store_Admin sa1 = su.Store_Ad_list.get(0);

    	wa1.W_house.Add("electronics > smartphone", new Product("Oneplus",01,"",1,2,3,10,100));
    	wa1.W_house.Add("electronics > smartphone", new Product("Motorola",02,"",1,2,3,10,200));
    	wa1.W_house.Add("electronics > smartphone", new Product("Mi",03,"",1,2,3,10,300));

    	sa1.store.Add("electronics > smartphone", new Product("Oneplus",01,"",1,2,3,1,100));
    	sa1.store.Add("electronics > smartphone", new Product("Motorola",02,"",1,2,3,1,200));

    	Customer cs = new Customer(01,"himesh",sa1.store);
    	cs.Add_Fund(1000);
    	cs.Add_to_Cart(new Product("Oneplus",01,"",0,0,0,1,0));
    	cs.CheckOut();



    }
}
