class WareHouse implements SerialiZable
{
	private final String NAME;
	private final ArrayList<Category>Cat_list;
	private final ArrayList<Store_Admin>Store_list;
	private final ArrayList<Product>Product_list;
	private final ArrayList<Ware_Admin>Ware_Ad_list;

	public void Add(String categories,Product prod) throws CustomException
	{
		boolean flag0=false;
		try
		{
			if(Search(prod.name).name!=null)
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
				String[] cat = categories.split(" > ");
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
								String path=Cat_list.get(i).C_name+" > "+Cat_list.get(i).Sub_list.get(j).S_name+" > "+prod.name;
								//Product p = new Product(product,path,Price,Quantity);
								prod.PATH = path;
								Cat_list.get(i).Sub_list.get(j).Pro_list.add(prod);
								return;
							}
						}
						if(flag1)
						{
							Cat_list.get(i).Sub_list.add(new SubCategory(cat[k]));
							int l=Cat_list.get(i).Sub_list.size()-1;
							String path=Cat_list.get(i).C_name+" > "+C_name.get(i).Sub_list.get(l).S_name+" > "+prod.name;
							//Product p = new Product(product,path,Price,Quantity);
							prod.PATH = path;
							Cat_list.get(i).Sub_list.get(l).Pro_list.add(prod);
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
					String path=Cat_list.get(Cat_list.size()-1).C_name+" > "+Cat_list.get(Cat_list.size()-1).Sub_list.get(l-1).S_name+" > "+prod.name;
					//Product p = new Product(product,path,Price,Quantity);
					prod.PATH = path;
					Cat_list.get(Cat_list.size()-1).Sub_list.get(l-1).Pro_list.add(prod);
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
										String path=Cat_list.get(i).C_name+" > "+Cat_list.get(i).Sub_list.get(j).S_name+" > "+Cat_list.get(i).Sub_list.get(j).Sub_list.get(m).S_name+" > "+prod.name;
										//Product p = new Product(product,path,Price,Quantity);
										prod.PATH = path;
										Cat_list.get(i).Sub_list.get(j).Sub_list.get(m).Pro_list.add(prod);
										return;
									}
								}
								if(flag2)
								{
									Cat_list.get(i).Sub_list.get(j).add(new SubCategory(cat[k]));
									int m=Cat_list.get(i).Sub_list.get(j).Sub_list.size()-1;
									String path=Cat_list.get(i).C_name+" > "+Cat_list.get(i).Sub_list.get(j).S_name+" > "+Cat_list.get(i).Sub_list.get(j).Sub_list.get(m).S_name+" > "+prod.name;
									//Product p = new Product(product,path,Price,Quantity);
									prod.PATH = path;
									Cat_list.get(i).Sub_list.get(j).Sub_list.get(m).Pro_list.add(prod);
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
							String path=Cat_list.get(i).C_name+" > "+Cat_list.get(i).Sub_list.get(l).S_name+" > "+Cat_list.get(i).Sub_list.get(l).Sub_list.get(m).S_name+" > "+prod.name;
							//Product p = new Product(product,path,Price,Quantity);
							prod.PATH = path;
							Cat_list.get(i).Sub_list.get(l).Sub_list.get(m).Pro_list.add(prod);
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
					String path=Cat_list.get(Cat_list.size()-1).C_name+" > "+Cat_list.get(Cat_list.size()-1).Sub_list.get(l-1).S_name+" > "+Cat_list.get(Cat_list.size()-1).Sub_list.get(l-1).Sub_list.get(m-1).S_name+" > "+prod.name;
					//Product p = new Product(product,path,Price,Quantity);
					prod.PATH = path;
					Cat_list.get(Cat_list.size()-1).Sub_list.get(l-1).Pro_list.add(prod);
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
			if(Cat_list.get(i).C_name.equals(prod.name))
			{
				Cat_list.remove(i);
				//System.out.println("Category Deleted");
				flag=false;
				break;
			}
			for(int j=0;j<Cat_list.get(i).Sub_list.size();j++)
			{
				if(Cat_list.get(i).Sub_list.get(j).S_name.equals(prod.name))
				{
					Cat_list.get(i).Sub_list.remove(j);
					//System.out.println("Subcategory Deleted");
					flag=false;
					break;
				}
				for(int k=0;k<Cat_list.get(i).Sub_list.get(j).Sub_list.size();k++)
				{
					if(Cat_list.get(i).Sub_list.get(j).Sub_list.get(k).S_name.equals(prod.name))
					{
						Cat_list.get(i).Sub_list.get(j).Sub_list.remove(k);
						//System.out.println("Subcategory Deleted");
						flag=false;
						break;
					}
					for(int l=0;l<Cat_list.get(i).Sub_list.get(j).Sub_list.get(k).Pro_list.size();l++)
					{
						if(Cat_list.get(i).Sub_list.get(j).Sub_list.get(k).Pro_list.get(l).name.equals(prod.name))
						{
							Cat_list.get(i).Sub_list.get(j).Sub_list.get(k).Pro_list.remove(l);
							//System.out.println("Product Deleted");
							flag=false;
							break;
						}
					}
				}
				for(int k=0;k<Cat_list.get(i).Sub_list.get(j).Pro_list.size();k++)
				{
					if(Cat_list.get(i).Sub_list.get(j).Pro_list.get(k).name.equals(prod.name))
					{
						Cat_list.get(i).Sub_list.get(j).Pro_list.remove(k);
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

	public void Update(String product, int price, int quantity) throws CustomException
	{
		Product pro=Search(product);
		if(pro.name==null)
		{
			throw new CustomException("Product not found in Amacon");
		}
		pro.Price(price);
		pro.Quantity(quantity);
	}

	public Product Search(String product)
	{
		for(int i=0;i<Cat_list.size();i++)
		{
			for(int j=0;j<Cat_list.get(i).Sub_list.size();j++)
			{
				for(int k=0;k<Cat_list.get(i).Sub_list.get(j).Sub_list.size();k++)
				{
					for(int l=0;l<Cat_list.get(i).Sub_list.get(j).Sub_list.get(k).Pro_list.size();l++)
					{
						if(Cat_list.get(i).Sub_list.get(j).Sub_list.get(k).Pro_list.get(l).name.equals(product))
						{
							return Cat_list.get(i).Sub_list.get(j).Sub_list.get(k).Pro_list.get(l);
						}
					}
				}
				for(int k=0;k<Cat_list.get(i).Sub_list.get(j).Pro_list.size();k++)
				{
					if(Cat_list.get(i).Sub_list.get(j).Pro_list.get(k).name.equals(product))
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

	}

	public Product Forward_message(String name,int id,int quantity,String date)
	{

	}		
}