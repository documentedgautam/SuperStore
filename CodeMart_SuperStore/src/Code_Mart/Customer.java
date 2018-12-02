import java.io.Serializable;
import java.util.ArrayList;
class Customer extends User
{
	protected  ArrayList<Product> Cart_list;
	protected  int fund;
	protected Store Cust_Store;

	public Customer(int _id,String pswd,Store _store)
	{
		this.ID = _id;
		this.PSWD = pswd;
		fund = 0;
		Cart_list = null;
		Cust_Store = _store; 
	}

	protected void Add_Fund(int _fund)
	{
		fund = _fund;
	}

	protected ArrayList<Product> Search(Product prod)
	{

	}

	protected void CheckOut()			// we can replace CheckOut method with payment
	{
		this.Payment();
	}

	protected boolean Check_Availability(Product prod) throws CustomException
	{
		try
		{
			int flag=0;
			for(int i=0;i<Cust_Store.Prod_list.size();i++)			
			{
				if(Cust_Store.Prod_list.get(i).P_NAME.equals(prod.P_NAME))
				{
					if(Cust_Store.Prod_list.get(i).P_ID==prod.ID)
					{
						if(Cust_Store.Prod_list.get(i).Quantity>=prod.Quantity)
						{
							return true;
						}
						else
						{
							flag=1;
							break;
						}								// invalid name or id of product
					}
				}
			}
			if(flag==1)
			{
				return false;
			}
			else
			{
				throw new CustomException("Invalid name or id of product");
			}

			return false;
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
	}

	protected void Add_to_Cart(Product prod) throws CustomException
	{
		try
		{
			int flag=0;
			for(int i=0;i<Cust_Store.Prod_list.size();i++)
			{
				if((Cust_Store.Prod_list.get(i).P_NAME.equals(prod.P_NAME)) &&(Cust_Store.Prod_list.get(i).P_ID==prod.P_ID))
				{
					Cart_list.add(prod);
					flag=1;
					break;
				}
			}	
			if(flag==0)
			{
				throw new CustomException("Product does not exist");
			}
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}			
	}

	protected void Sort()
	{

	}

	protected void Payment() throws CustomException
	{
		try
		{
			int flag=0;								// for fund ---> it will decrease only when 
												// customer's fund will decrease,
			for(int i=0;i<Cart_list.size();i++)	// Store products quantity will decrease
			{									// check EOQ
				int num = this.fund;
				for(int j=0;j<Cust_Store.Prod_list.size();j++)
				{
					if((Cust_Store.Prod_list.get(j).P_NAME.equals(Cart_list.get(i).P_NAME))&&(Cust_Store.Prod_list.get(j).P_ID==Cart_list.get(i).P_ID))
					{
						num = num - (Cart_list.get(i).Quantity)*(Cust_Store.Prod_list.get(j).Price);	
						if(num<=0)
						{
							flag=1;
							break;
						}					
						else
						{
							int quan = Cust_Store.Prod_list.get(j).Quantity;
							quan = quan - Cart_list.get(i).Quantity;
							if(quan<=0)
							{
								quan = Math.sqrt((2*(Cust_Store.Prod_list.get(j).d)*(Cust_Store.Prod_list.get(j).k))/Cust_Store.Prod_list.get(j).h);
								Product p = Cust_Store.Send_message(Cart_list.get(i).P_NAME,Cart_list.get(i).P_ID,quan,"djgdh");
								Cust_Store.Prod_list.get(j).Quantity += p.Quantity;  
							}
							else
							{
								Cust_Store.Prod_list.get(j).Quantity = Cust_Store.Prod_list.get(j).Quantity - Cart_list.get(i).Quantity;		
							}	
							this.fund = this.fund - (Cart_list.get(i).Quantity)*(Cust_Store.Prod_list.get(j).Price);
							break;				
						}							
					}			
				}
			}
		
			if(flag==1)
			{
				throw new CustomException("Out of funds");
			}
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}								
	}

	protected void Change_Store(Store st)
	{
		this.Cust_Store = st;
	}

	public static void serialize() throws IOException
	{
		//SuperUser s1 = new SuperUser(123,"hi");
		ObjectOutputStream	out1 = null;
		ObjectOutputStream	out2 = null;
		try
		{
			out1 = new ObjectOutputStream( new FileOutputStream("Customer_Serialization.txt"));
			out1.writeObject(this.Cart_list);
			out2 = new ObjectOutputStream( new FileOutputStream("Customer_Serialization.txt"));
			out2.writeObject(this.Cust_Store);			

		}
		finally
		{
			out.close();
		}	
	}

	public static void deserialize(ArrayList<Product>p,Store s1) throws IOException,ClassNotFoundException
	{
		ObjectInputStream in1 = null;
		ObjectInputStream in2 = null;
		try
		{
			in1 = new ObjectInputStream(new FileInputStream("Customer_serialization.txt"));
			p = (ArrayList<Product>) in1.readObject();
			in2 = new ObjectInputStream(new FileInputStream("Customer_serialization.txt"));
			s1 = (Store) in2.readObject();			
		}
		finally
		{
			in1.close();
			in2.close();
		}
	}	
}
