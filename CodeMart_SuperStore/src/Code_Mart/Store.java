package Code_Mart;
import java.util.ArrayList;

public class Store {
//    private final String NAME;
//    private ArrayList<Category> Cat_list;
//    private ArrayList<Product> Product_list;
//    private WareHouse Parent;
//
//    public Store(String NAME){
//        this.NAME=NAME;
//    }
//
    protected String getNAME(){
        return this.NAME;
    }
//
//    public ArrayList<Category> getCat_list() {
//        return Cat_list;
//    }
//
//    public void setCat_list(ArrayList<Category> cat_list) {
//        Cat_list = cat_list;
//    }
//
//    public ArrayList<Product> getProduct_list() {
//        return Product_list;
//    }
//
//    public void setProduct_list(ArrayList<Product> product_list) {
//        Product_list = product_list;
//    }
//
//    public WareHouse getParent() {
//        return Parent;
//    }
//
//    public void setParent(WareHouse parent) {
//        Parent = parent;
//    }
    private final String NAME;
    protected ArrayList<Category> Cat_list;
    protected ArrayList<Product> Prod_list;
    protected WareHouse parent;

    public Store(String name)
    {
        this.NAME = name;
        Cat_list = new ArrayList<Category>();
        //Store_list = new ArrayList<Store_Admin>();
        Prod_list = new ArrayList<Product>();
        //Ware_Ad_list = new ArrayList<Ware_Admin>();
        parent = null;
    }

    public ArrayList<Product> getProduct_list(){
        return this.Prod_list;
    }

    public void Add(String path,Product prod)
    {
        try
        {
            boolean flag0=false;
            try
            {
                if(Search(prod.P_NAME).P_NAME!=null)
                {
                    flag0=true;
                    throw new CodeMartCustomException("Product already exists in Warehouse");
                }
            }
            catch(CodeMartCustomException e)
            {
                if(flag0)
                {
                    throw new CodeMartCustomException("Product already exists in Warehouse");
                }
                String[] cat = path.split(" > ");
                int k=0;
                boolean flag=true,flag1=true;
                if(cat.length<2)
                {
                    throw new CodeMartCustomException("Invalid Input");
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
                                    Prod_list.add(prod);
                                    return;
                                }
                            }
                            if(flag1)
                            {
                                Cat_list.get(i).Sub_list.add(new SubCategory(cat[k]));
                                int l=Cat_list.get(i).Sub_list.size()-1;
                                String path_of_product=Cat_list.get(i).C_name+" > "+Cat_list.get(i).Sub_list.get(l).S_name+" > "+prod.P_NAME;
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
                        String path_of_product=Cat_list.get(Cat_list.size()-1).C_name+" > "+Cat_list.get(Cat_list.size()-1).Sub_list.get(l-1).S_name+" > "+prod.P_NAME;
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
                                            String path_of_product=Cat_list.get(i).C_name+" > "+Cat_list.get(i).Sub_list.get(j).S_name+" > "+Cat_list.get(i).Sub_list.get(j).Sub_list.get(m).S_name+" > "+prod.P_NAME;
                                            //Product p = new Product(product,path,Price,Quantity);
                                            prod.PATH = path_of_product;
                                            Cat_list.get(i).Sub_list.get(j).Sub_list.get(m).Pro_list.add(prod);
                                            Prod_list.add(prod);
                                            return;
                                        }
                                    }
                                    if(flag2)
                                    {
                                        Cat_list.get(i).Sub_list.get(j).Sub_list.add(new SubCategory(cat[k]));
                                        int m=Cat_list.get(i).Sub_list.get(j).Sub_list.size()-1;
                                        String path_of_product=Cat_list.get(i).C_name+" > "+Cat_list.get(i).Sub_list.get(j).S_name+" > "+Cat_list.get(i).Sub_list.get(j).Sub_list.get(m).S_name+" > "+prod.P_NAME;
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
                                String path_of_product=Cat_list.get(i).C_name+" > "+Cat_list.get(i).Sub_list.get(l).S_name+" > "+Cat_list.get(i).Sub_list.get(l).Sub_list.get(m).S_name+" > "+prod.P_NAME;
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
                        int m=Cat_list.get(Cat_list.size()-1).Sub_list.get(l-1).Sub_list.size();
                        String path_of_product=Cat_list.get(Cat_list.size()-1).C_name+" > "+Cat_list.get(Cat_list.size()-1).Sub_list.get(l-1).S_name+" > "+Cat_list.get(Cat_list.size()-1).Sub_list.get(l-1).Sub_list.get(m-1).S_name+" > "+prod.P_NAME;
                        //Product p = new Product(product,path,Price,Quantity);
                        prod.PATH = path_of_product;
                        Cat_list.get(Cat_list.size()-1).Sub_list.get(l-1).Pro_list.add(prod);
                        Prod_list.add(prod);
                        return;
                    }
                }
            }
        }
        catch(CodeMartCustomException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public Product Search(String product) throws CodeMartCustomException
    {
        try
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
            throw new CodeMartCustomException("Product Not Found");
        }
        catch(CodeMartCustomException e)
        {
            System.out.println(e.getMessage());
        }
        finally{
            return new Product("",0,"",0,0,0,0,0);
        }
    }

    public void Delete(Product prod) throws CodeMartCustomException
    {
        try
        {
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
                            if(Cat_list.get(i).Sub_list.get(j).Sub_list.get(k).Pro_list.get(l).P_NAME.equals(prod.P_NAME))
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
                        if(Cat_list.get(i).Sub_list.get(j).Pro_list.get(k).P_NAME.equals(prod.P_NAME))
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
                throw new CodeMartCustomException("Invalid Path");
            }
        }
        catch(CodeMartCustomException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void Update(Product prod) throws CodeMartCustomException  // giving a product
    {	try
    {									 //  which has only updated price and quantity
        Product pro=Search(prod.P_NAME);					 //   temporary product
        if(pro.P_NAME==null)
        {
            throw new CodeMartCustomException("Product not found in Amacon");
        }
        pro.Price = prod.Price;
        pro.Quantity = prod.Quantity;
    }
    catch(CodeMartCustomException e)
    {
        System.out.println(e.getMessage());
    }
    }

    protected void Check_Data()
    {

    }

    protected Product Send_message(String name,int id,int quantity,String date)
    {
        return parent.give_ack(name,id,quantity,date);
    }
}
