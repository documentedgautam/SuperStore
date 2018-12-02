import java.util.ArrayList;

/** Represents an SuperUser.
* @author Dheeraj
* @author https://github.com/documentedgautam/SuperStore
* @version 1.0
*/

public class SuperUser extends User{
    protected ArrayList<Ware_Admin> Ware_Ad_list;
    protected ArrayList<Store_Admin> Store_Ad_list;

    public SuperUser(int ID, String PSWD){
        this.ID=ID;
        this.PSWD=PSWD;
        Ware_Ad_list = new ArrayList<Ware_Admin>();
        Store_Ad_list = new ArrayList<Store_Admin>();
    }

/** Creates an Empty SuperUser.
*/
    public SuperUser() {

    }


    public ArrayList<Ware_Admin> giveWAlist(){
        return Ware_Ad_list;
    }

    public ArrayList<Store_Admin> giveSAlist(){
        return Store_Ad_list;
    }

    protected void Create_Warehouse(int id, String PSWD, String Name){
        Ware_Admin ware_admin=new Ware_Admin(id, PSWD, Name, Ware_Ad_list);
        Ware_Ad_list.add(ware_admin);
        //sort_w_house(Ware_Ad_list,0,Ware_Ad_list.size());
    }

    protected void Create_Store(int id, String PSWD, String Name){
        Store_Admin S_Admin=new Store_Admin(id, PSWD, Name);
        Store_Ad_list.add(S_Admin);
        //sort_store(Store_Ad_list,0, Store_Ad_list.size());
    }

    protected void Link_SnW(String W_name, String S_name){
        for (int i=0; i<Ware_Ad_list.size();i++) {
            if(Ware_Ad_list.get(i).W_house.getNAME().equals(W_name)){//&&Ware_Ad_list.get(i).W_house.getNAME().equals(W_name)){
                for (int j=0;j<Store_Ad_list.size();j++){
                    if(Store_Ad_list.get(j).store.getNAME().equals(S_name)){
                        Ware_Ad_list.get(i).W_house.Store_Ad_list.add(Store_Ad_list.get(j));
                        Store_Ad_list.get(j).parent = Ware_Ad_list.get(i);
                        break;
                    }
                }
                break;
            }
        }
    }

    public static void serialize() throws IOException
    {
        //SuperUser s1 = new SuperUser(123,"hi");
        ObjectOutputStream  out1 = null;
        ObjectOutputStream  out2 = null;
        try
        {
            out1 = new ObjectOutputStream( new FileOutputStream("WA_N_SA_list_serialization.txt"));
            out1.writeObject(this.Ware_Ad_list);
            out2 = new ObjectOutputStream( new FileOutputStream("WA_N_SA_list_serialization.txt"));
            out2.writeObject(this.Store_Ad_list);
        }
        finally
        {
            out1.close();
            out2.close();
        }   
    }

    public static void deserialize(ArrayList<Ware_Admin>w1,ArrayList<Store_Admin>s1) throws IOException,ClassNotFoundException
    {
        ObjectInputStream in1 = null;
        ObjectInputStream in2 = null;
        try
        {
            in1 = new ObjectInputStream(new FileInputStream("WA_N_SA_list_serialization.txt"));
            w1 = (ArrayList<Ware_Admin>) in1.readObject();
            in2 = new ObjectInputStream(new FileInputStream("WA_N_SA_list_serialization.txt"));
            s1 = (ArrayList<Store_Admin>) in2.readObject();
        }
        finally
        {
            in1.close();
            in2.close();
        }
    }    

    private void see_data(){
        
    }

    /*public int binarySearch(int arr[], int l, int r, int x)
    {
        if (r>=l)
        {
            int mid = l + (r - l)/2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] > x)
                return binarySearch(arr, l, mid-1, x);
            return binarySearch(arr, mid+1, r, x);
        }
        return -1;
    }
    public static void sort_w_house(ArrayList<Ware_Admin> arr, int low, int high)
    {
        int N = high - low;
        if (N <= 1)
            return;
        int mid = low + N/2;
        sort_w_house(arr, low, mid);
        sort_w_house(arr, mid, high);
        ArrayList<Ware_Admin> temp = new ArrayList<Ware_Admin>();
        Ware_Admin a=new Ware_Admin();
        for(int i=0;i<N;i++) {
            temp.add(a);
        }
        int i = low, j = mid;
        for (int k = 0; k < N; k++)
        {
            if (i == mid) {
                temp.set(k, arr.get(j++));
            }
            else if (j == high) {
                temp.set(k, arr.get(i++));
            }
            else if (arr.get(j).W_house.Name.compareTo(arr.get(i).W_house.Name)<0) {
                temp.set(k, arr.get(j++));
            }
            else {
                temp.set(k, arr.get(i++));
            }
        }
        for (int k = 0; k < N; k++) {
            arr.set(low+k, temp.get(k));
        }
    }
    public static void sort_store(ArrayList<Store_Admin> arr, int low, int high)
    {
        int N = high - low;
        if (N <= 1)
            return;
        int mid = low + N/2;
        sort_store(arr, low, mid);
        sort_store(arr, mid, high);
        ArrayList<Store_Admin> temp = new ArrayList<Store_Admin>();
        Ware_Admin a=new Ware_Admin();
        for(int i=0;i<N;i++) {
            temp.add(a);
        }
        int i = low, j = mid;
        for (int k = 0; k < N; k++)
        {
            if (i == mid) {
                temp.set(k, arr.get(j++));
            }
            else if (j == high) {
                temp.set(k, arr.get(i++));
            }
            else if (arr.get(j).store.Name.compareTo(arr.get(i).store.Name)<0) {
                temp.set(k, arr.get(j++));
            }
            else {
                temp.set(k, arr.get(i++));
            }
        }
        for (int k = 0; k < N; k++) {
            arr.set(low+k, temp.get(k));
        }
    }*/
}
