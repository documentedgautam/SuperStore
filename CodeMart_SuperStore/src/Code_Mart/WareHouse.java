import java.io.Serializable;
import java.util.ArrayList;
class WareHouse implements Serializable
{
	private final String NAME;
	private final ArrayList<Category>Cat_list;		// database
	private final ArrayList<Store_Admin>Store_Ad_list;	// linked stores to that warehouse
	private final ArrayList<Product>Product_list;	// not using in update function  and can use in give ack 
	private final ArrayList<Ware_Admin>Ware_Ad_list;	// helps in tracing the warehouses

	public WareHouse(String name)
	{
		this.NAME = name;
		Cat_list = new ArrayList<Cateory>();
		Store_list = new ArrayList<Store_Admin>();
		Product_list = new ArrayList<Product>();
		Ware_Ad_list = new ArrayList<Ware_Admin>();
	}

	public void Add(String path,Product prod) throws CustomException
	{
		boolean flag0=false;
		try
		{
			if(Search(prod.P_NAME).P_NAME!=null)
		 	{
				flag0=true;
				throw new CustomException("Product already exists in Warehouse");
			}
		}
		catch(CustomException e)
		{
			if(flag0)
			{
				throw new CustomException("Product already exists in Warehouse");
			}
				String[] cat = path.split(" > ");
				int k=0;
				boolean flag=true,flag1=true;
			if(cat.length<2)
			{
				throw new CustomException("Invalid Input");
			}
			else if(cat.length==2)
			{
				for(int i=0;i<Cat_list.size();i++)
				{
					if(Cat_list.get(i).C_name.equals(cat[k]))
					{
						flag=false;
						k++;
						for(int j=0;j<Cat_list.get(i).Sub_list.size();j++)
						{
							if(Cat_list.get(i).Sub_list.get(j).S_name.equals(cat[k]))
							{
								flag1=false;
								String path_of_product=Cat_list.get(i).C_name+" > "+Cat_list.get(i).Sub_list.get(j).S_name+" > "+prod.P_NAME;
								//Product p = new Product(product,path,Price,Quantity);
								prod.PATH = path_of_product;
								Cat_list.get(i).Sub_list.get(j).Pro_list.add(prod);
								Product_list.add(prod);
								return;
							}
						}
						if(flag1)
						{
							Cat_list.get(i).Sub_list.add(new SubCategory(cat[k]));
							int l=Cat_list.get(i).Sub_list.size()-1;
							String path_of_product=Cat_list.get(i).C_name+" > "+C_name.get(i).Sub_list.get(l).S_name+" > "+prod.P_NAME;
							//Product p = new Product(product,path,Price,Quantity);
							prod.PATH = path_of_product;
							Cat_list.get(i).Sub_list.get(l).Pro_list.add(prod);
							Product_list.add(prod);
							return;
						}
					}
				}
				if(flag)
				{
					Cat_list.add(new Category(cat[k]));
					k++;
					Cat_list.get(Cat_list.size()-1).Sub_list.add(new SubCategory(cat[k]));
					int l=Cat_list.get(Cat_list.size()-1).Sub_list.size();
					String path=Cat_list.get(Cat_list.size()-1).C_name+" > "+Cat_list.get(Cat_list.size()-1).Sub_list.get(l-1).S_name+" > "+prod.P_NAME;
					//Product p = new Product(product,path,Price,Quantity);
					prod.PATH = path_of_product;
					Cat_list.get(Cat_list.size()-1).Sub_list.get(l-1).Pro_list.add(prod);
					Product_list.add(prod);
					return;
				}
			}
			else if(cat.length==3)
			{
				for(int i=0;i<Cat_list.size();i++)
				{
					if(Cat_list.get(i).C_name.equals(cat[k]))
					{
						flag=false;
						k++;
						for(int j=0;j<Cat_list.get(i).Sub_list.size();j++)
						{
							if(Cat_list.get(i).Sub_list.get(j).S_name.equals(cat[k]))
							{
								flag1=false;
								boolean flag2=true;
								k++;
								for(int m=0;m<Cat_list.get(i).Sub_list.get(j).Sub_list.size();m++)
								{
									if(Cat_list.get(i).Sub_list.get(j).Sub_list.get(m).S_name.equals(cat[k]))
									{
										flag2=false;
										String path_of_product=Cat_list.get(i).C_name+" > "+Cat_list.get(i).Sub_list.get(j).S_name+" > "+Cat_list.get(i).Sub_list.get(j).Sub_list.get(m).S_name+" > "+prod.P_NAME;
										//Product p = new Product(product,path,Price,Quantity);
										prod.PATH = path_of_product;
										Cat_list.get(i).Sub_list.get(j).Sub_list.get(m).Pro_list.add(prod);
										Product_list.add(prod);
										return;
									}
								}
								if(flag2)
								{
									Cat_list.get(i).Sub_list.get(j).add(new SubCategory(cat[k]));
									int m=Cat_list.get(i).Sub_list.get(j).Sub_list.size()-1;
									String path_of_product=Cat_list.get(i).C_name+" > "+Cat_list.get(i).Sub_list.get(j).S_name+" > "+Cat_list.get(i).Sub_list.get(j).Sub_list.get(m).S_name+" > "+prod.P_NAME;
									//Product p = new Product(product,path,Price,Quantity);
									prod.PATH = path_of_product;
									Cat_list.get(i).Sub_list.get(j).Sub_list.get(m).Pro_list.add(prod);
									Product_list.add(prod);
									return;
								}
							}
						}
						if(flag1)
						{
							Cat_list.get(i).Sub_list.add(new SubCategory(cat[k]));
							int l=Cat_list.get(i).Sub_list.size()-1;
							k++;
							Cat_list.get(i).Sub_list.get(l).Sub_list.add(new SubCategory(cat[k]));
							int m=Cat_list.get(i).Sub_list.get(l).Sub_list.size()-1;
							String path_of_product=Cat_list.get(i).C_name+" > "+Cat_list.get(i).Sub_list.get(l).S_name+" > "+Cat_list.get(i).Sub_list.get(l).Sub_list.get(m).S_name+" > "+prod.P_NAME;
							//Product p = new Product(product,path,Price,Quantity);
							prod.PATH = path_of_product;
							Cat_list.get(i).Sub_list.get(l).Sub_list.get(m).Pro_list.add(prod);
							Product_list.add(prod);
							return;
						}
					}
				}
				if(flag)
				{
					Cat_list.add(new Category(cat[k]));
					k++;
					Cat_list.get(Cat_list.size()-1).Sub_list.add(new SubCategory(cat[k]));
					int l=Cat_list.get(Cat_list.size()-1).Sub_list.size();
					k++;
					Cat_list.get(Cat_list.size()-1).Sub_list.get(l-1).Sub_list.add(new SubCategory(cat[k]));
					int m=Cat_list.get(Cat_list.size()-1).sub.get(l-1).Sub_list.size();
					String path_of_product=Cat_list.get(Cat_list.size()-1).C_name+" > "+Cat_list.get(Cat_list.size()-1).Sub_list.get(l-1).S_name+" > "+Cat_list.get(Cat_list.size()-1).Sub_list.get(l-1).Sub_list.get(m-1).S_name+" > "+prod.P_NAME;
					//Product p = new Product(product,path,Price,Quantity);
					prod.PATH = path_of_product;
					Cat_list.get(Cat_list.size()-1).Sub_list.get(l-1).Pro_list.add(prod);
					Product_list.add(prod);
					return;
				}
			}
		}
	}

	public void Delete(Product prod) throws CustomException
	{
		//String[] cat=prod.path.split(" > ");
		//String Produc = cat[cat.length-1];
		boolean flag=true;
		for(int i=0;i<Cat_list.size();i++)
		{
			if(Cat_list.get(i).C_name.equals(prod.P_NAME))
			{
				Cat_list.remove(i);
				//System.out.println("Category Deleted");
				flag=false;
				break;
			}
			for(int j=0;j<Cat_list.get(i).Sub_list.size();j++)
			{
				if(Cat_list.get(i).Sub_list.get(j).S_name.equals(prod.P_NAME))
				{
					Cat_list.get(i).Sub_list.remove(j);
					//System.out.println("Subcategory Deleted");
					flag=false;
					break;
				}
				for(int k=0;k<Cat_list.get(i).Sub_list.get(j).Sub_list.size();k++)
				{
					if(Cat_list.get(i).Sub_list.get(j).Sub_list.get(k).S_name.equals(prod.P_NAME))
					{
						Cat_list.get(i).Sub_list.get(j).Sub_list.remove(k);
						//System.out.println("Subcategory Deleted");
						flag=false;
						break;
					}
					for(int l=0;l<Cat_list.get(i).Sub_list.get(j).Sub_list.get(k).Pro_list.size();l++)
					{
						if(Cat_list.get(i).Sub_list.get(j).Sub_list.get(k).Pro_list.get(l).name.equals(prod.P_NAME))
						{
							Cat_list.get(i).Sub_list.get(j).Sub_list.get(k).Pro_list.remove(l);
							Product_list.remove(prod);
							//System.out.println("Product Deleted");
							flag=false;
							break;
						}
					}
				}
				for(int k=0;k<Cat_list.get(i).Sub_list.get(j).Pro_list.size();k++)
				{
					if(Cat_list.get(i).Sub_list.get(j).Pro_list.get(k).P_NAME.equals(prod.P_NAME))
					{
						Cat_list.get(i).Sub_list.get(j).Pro_list.remove(k);
						Product_list.remove(prod);
						//System.out.println("Product Deleted");
						flag=false;
						break;
					}
				}
			}
		}
		if(flag)
		{
			throw new CustomException("Invalid Path");
		}
	}

	public void Update(Prod prod) throws CustomException  // giving a product
	{													 //  which has only updated price and quantity
		Product pro=Search(prod.P_NAME);					 //   temporary product
		if(pro.name==null)
		{
			throw new CustomException("Product not found in Amacon");
		}
		pro.Price(prod.Price);
		pro.Quantity(prod.Quantity);
	}

	public Product Search(String product) throws CustomException
	{
		for(int i=0;i<Cat_list.size();i++)
		{
			for(int j=0;j<Cat_list.get(i).Sub_list.size();j++)
			{
				for(int k=0;k<Cat_list.get(i).Sub_list.get(j).Sub_list.size();k++)
				{
					for(int l=0;l<Cat_list.get(i).Sub_list.get(j).Sub_list.get(k).Pro_list.size();l++)
					{
						if(Cat_list.get(i).Sub_list.get(j).Sub_list.get(k).Pro_list.get(l).P_NAME.equals(product))
						{
							return Cat_list.get(i).Sub_list.get(j).Sub_list.get(k).Pro_list.get(l);
						}
					}
				}
				for(int k=0;k<Cat_list.get(i).Sub_list.get(j).Pro_list.size();k++)
				{
					if(Cat_list.get(i).Sub_list.get(j).Pro_list.get(k).P_NAME.equals(product))
					{
						return Cat_list.get(i).Sub_list.get(j).Pro_list.get(k);
					}
				}
			}
		}
		throw new CustomException("Product Not Found");
	}		

	public void Check_Data()
	{

	}	

	public Product give_ack(String name,int id,int quantity,String date)
	{
		boolean flag = false;
		int flag1 = 0; // for forward message
		try
		{
			for(int i=0;i<Product_list.size();i++)
			{
				if(Product_list.get(i).P_NAME.equals(name))
				{
					if((Product_list.get(i).P_ID==id)&&(Product_list.get(i).Quantity>=quantity))
					{
						Product_list.get(i).Quantity = Product_list.get(i).Quantity - quantity;
						// check Quantity for that product and if Quantity=0; ---> alert message
						return new Product("",0,"",0,0,0,quantity,0);
					}
					else
					{
						if(Product_list.get(i).P_ID!=id)
						{
							flag = true;
							throw new CustomException("Invalid product id");
						}
						else
						{
							flag1=1;
						}
					}
				}
			}


		}
		catch(CustomException e)
		{
			if(flag)
			{
				throw new CustomException("Invalid product id");
			}
			else if(flag1==1)
			{
				return Forward_message(name,id,quantity,date);
			}
		}

	}

	public Product Forward_message(String name,int id,int quantity,String date)
	{
		for(int i=0;i<Ware_Ad_list.size();i++)
		{
			for(int j=0;j<Ware_Ad_list.get(i).W_house.Product_list.size();j++)
			{
				if(Ware_Ad_list.get(i).W_house.Product_list.get(j).P_NAME.equals(name))
				{
					if((Ware_Ad_list.get(i).W_house.Product_list.get(j).P_ID==id) && (Ware_Ad_list.get(i).W_house.Product_list.get(j).Quantity>quantity))
					{
						return new Product("",0,"",0,0,0,quantity,0);		//Ware_Ad_list.get(i).W_house.Product_list.get(j);
					}
				}
			}
		}
	}		
}