class Store implements Serializable, Add_Del_Upd
{
	private final String NAME;
	private ArrayList<Category> Cat_list;
	private ArrayList<Product> Prod_list;
	private Warehouse parent;

	public void Add(String path,Product prod)
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
								String path_of_product=Cat_list.get(i).C_name+" > "+Cat_list.get(i).Sub_list.get(j).S_name+" > "+prod.name;
								//Product p = new Product(product,path,Price,Quantity);
								prod.PATH = path_of_product;
								Cat_list.get(i).Sub_list.get(j).Pro_list.add(prod);
								Prod_list.add(prod);
								return;
							}
						}
						if(flag1)
						{
							Cat_list.get(i).Sub_list.add(new SubCategory(cat[k]));
							int l=Cat_list.get(i).Sub_list.size()-1;
							String path_of_product=Cat_list.get(i).C_name+" > "+C_name.get(i).Sub_list.get(l).S_name+" > "+prod.name;
							//Product p = new Product(product,path,Price,Quantity);
							prod.PATH = path_of_product;
							Cat_list.get(i).Sub_list.get(l).Pro_list.add(prod);
							Prod_list.add(prod);
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
					String path_of_product=Cat_list.get(Cat_list.size()-1).C_name+" > "+Cat_list.get(Cat_list.size()-1).Sub_list.get(l-1).S_name+" > "+prod.name;
					//Product p = new Product(product,path,Price,Quantity);
					prod.PATH = path_of_product;
					Cat_list.get(Cat_list.size()-1).Sub_list.get(l-1).Pro_list.add(prod);
					Prod_list.add(prod);
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
										String path_of_product=Cat_list.get(i).C_name+" > "+Cat_list.get(i).Sub_list.get(j).S_name+" > "+Cat_list.get(i).Sub_list.get(j).Sub_list.get(m).S_name+" > "+prod.name;
										//Product p = new Product(product,path,Price,Quantity);
										prod.PATH = path_of_product;
										Cat_list.get(i).Sub_list.get(j).Sub_list.get(m).Pro_list.add(prod);
										Prod_list.add(prod);
										return;
									}
								}
								if(flag2)
								{
									Cat_list.get(i).Sub_list.get(j).add(new SubCategory(cat[k]));
									int m=Cat_list.get(i).Sub_list.get(j).Sub_list.size()-1;
									String path_of_product=Cat_list.get(i).C_name+" > "+Cat_list.get(i).Sub_list.get(j).S_name+" > "+Cat_list.get(i).Sub_list.get(j).Sub_list.get(m).S_name+" > "+prod.name;
									//Product p = new Product(product,path,Price,Quantity);
									prod.PATH = path_of_product;
									Cat_list.get(i).Sub_list.get(j).Sub_list.get(m).Pro_list.add(prod);
									Prod_list.add(prod);
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
							String path_of_product=Cat_list.get(i).C_name+" > "+Cat_list.get(i).Sub_list.get(l).S_name+" > "+Cat_list.get(i).Sub_list.get(l).Sub_list.get(m).S_name+" > "+prod.name;
							//Product p = new Product(product,path,Price,Quantity);
							prod.PATH = path_of_product;
							Cat_list.get(i).Sub_list.get(l).Sub_list.get(m).Pro_list.add(prod);
							Prod_list.add(prod);
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
					String path_of_product=Cat_list.get(Cat_list.size()-1).C_name+" > "+Cat_list.get(Cat_list.size()-1).Sub_list.get(l-1).S_name+" > "+Cat_list.get(Cat_list.size()-1).Sub_list.get(l-1).Sub_list.get(m-1).S_name+" > "+prod.name;
					//Product p = new Product(product,path,Price,Quantity);
					prod.PATH = path_of_product;
					Cat_list.get(Cat_list.size()-1).Sub_list.get(l-1).Pro_list.add(prod);
					Prod_list.add(prod);
					return;
				}
			}
		}
	}

	public void Delete(Product prod) throws CustomException
	{
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
							Prod_list.remove(prod);
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
						Prod_list.remove(prod);
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

	public void Update(Product prod) throws CustomException // giving a product  
	{														// which has only updated price and quantity
		int flag = 0;										// temporary product
		int flag1 = 0;
		int flag2 = 0;
		int flag3 = 0;
		int flag4 = 0;
		int flag5 = 0;
		int flag6 = 0;
		int flag7 = 0;
		int flag8 = 0;
		int flag9 = 0;
		for(int i=0;i<Prod_list.size();i++)
		{
			if(i.name.equals(prod.name))
			{
				String product_path = i.path;
				flag = 1;
				break;
			}
		}
		if(flag==1)
		{
			String[]cat = product_path.split(" > ");
			if(cat.length==3)
			{
				for(int i=0;i<Cat_list.size();i++)
				{
					if(flag4==1 || flag6==1)
					{
						break;
					}
					else if(Cat_list.get(i).C_name.equals(cat[0]))
					{
						flag1 = 1;  // category has been found
						for(int j=0;j<Cat_list.get(i).Sub_list.size();j++)
						{
							if(flag3==1 || flag5==1)
							{
								flag4=1; 
								break;
							}
							else if(Cat_list.get(i).Sub_list.get(j).S_name.equals(cat[1]))
							{
								flag2=1;  // sub category has been found
								for(int k=0;k<Cat_list.get(i).Sub_list.get(j).Pro_list.size();k++)
								{
									if(Cat_list.get(i).Sub_list.get(j).Pro_list.get(k).name.equals(cat[2]))
									{
										Product pr = Cat_list.get(i).Sub_list.get(j).Pro_list.get(k);
										pr.Price = prod.Price;
										pr.Quantity = prod.Quantity;
										flag3 = 1; // product is found
										//flag5 =1;
										break;
									}
								}
								if(flag3==0)
								{
									throw new CustomException("Product does not exist");
									flag5=1; // product not found but subcategory is found
									break;
								}
							}
						}
						if(flag2==0)   // if sub category is not found
						{
							throw new CustomException("Product does not exist");
							flag6=1; 
							break;
						}
					}			
				}
				if(flag1 ==0)
				{
					throw new CustomException("Product does not exist");
				}

			}
			else if(cat.length==4)
			{
				for(int i=0;i<Cat_list.size();i++)
				{
					if(flag8==1 || flag9==1)
					{
						break;
					}
					else if(Cat_list.get(i).C_name.equals(cat[0]))
					{
						flag1 = 1;  // category has been found
						for(int j=0;j<Cat_list.get(i).Sub_list.size();j++)
						{
							if(flag6==1 || flag7==1)
							{
								flag8=1; 
								break;
							}
							else if(Cat_list.get(i).Sub_list.get(j).S_name.equals(cat[1]))
							{
								flag2=1;  // sub category has been found
								for(int k=0;k<Cat_list.get(i).Sub_list.get(j).Sub_list.size();k++)
								{
									if(flag4==1 || flag5==1)
									{
										flag6 = 1;
										break;
									}
									else if(Cat_list.get(i).Sub_list.get(j).Sub_list.get(k).S_name.equals(cat[2]))
									{
										flag3=1; // sub sub category has been found
										for(int l=0;l<Cat_list.get(i).Sub_list.get(j).Sub_list.get(k).Pro_list.size();l++)
										{
											if(Cat_list.get(i).Sub_list.get(j).Sub_list.get(k).Pro_list.get(l).name.equals(cat[3))
											{
												Product pr = Cat_list.get(i).Sub_list.get(j).Sub_list.get(k).Pro_list.get(l);
												pr.Price = prod.Price;
												pr.Quantity = prod.Quantity;
												flag4 = 1; // product is found
												//flag5 =1;
												break;
											}
										}
										if(flag4==0) // product not found
										{
											throw new CustomException("Product does not exist");
											flag5=1; // product not found but sub subcategory is found
											break;
										}										
									}
								}
								if(flag3==0) // sub sub category is not found 
								{
									flag7=1;
									throw new CustomException("Product does not exist");
									break;
								}

							}
						}
						if(flag2==0)   // if sub category is not found
						{
							throw new CustomException("Product does not exist");
							flag9=1; 
							break;
						}
					}			
				}
				if(flag1 ==0)
				{
					throw new CustomException("Product does not exist");
				}
			}
		}
		else
		{
			throw new CustomException("Product does not exist");
		}
	}

	protected void Check_Data()
	{

	}

	protected void Send_message(Product prod)
	{

	}
	
}