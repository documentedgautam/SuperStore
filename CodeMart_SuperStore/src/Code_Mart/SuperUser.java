package Code_Mart;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class SuperUser extends User{
    protected ArrayList<Ware_Admin> Ware_Ad_list;
    protected ArrayList<Store_Admin> Store_Ad_list;
    private static SuperUser SU=null;

    public static SuperUser getInstance(){
        if (SU==null){
            SU=new SuperUser();
        }
        return SU;

    }

    public SuperUser() {
        this.ID=2021;
        this.PSWD="CM@001";
        Ware_Ad_list = new ArrayList<Ware_Admin>();
        Store_Ad_list = new ArrayList<Store_Admin>();
    }

    public ArrayList<Ware_Admin> giveWAlist(){
        return SU.Ware_Ad_list;
    }

    public ArrayList<Store_Admin> giveSAlist(){
        return SU.Store_Ad_list;
    }

    protected void Create_Warehouse(int id, String PSWD, String Name){
        Ware_Admin ware_admin=new Ware_Admin(id, PSWD, Name, Ware_Ad_list);
        boolean flag=true;
        for(int i=0;i<Ware_Ad_list.size();i++){
            if(Ware_Ad_list.get(i).ID==id){
                flag=false;
            }
        }
        if(flag) {
            Ware_Ad_list.add(ware_admin);
        }
        //sort_w_house(Ware_Ad_list,0,Ware_Ad_list.size());
    }

    protected void Create_Store(int id, String PSWD, String Name){
        Store_Admin S_Admin=new Store_Admin(id, PSWD, Name);
        Store_Ad_list.add(S_Admin);
        //sort_store(Store_Ad_list,0, Store_Ad_list.size());
    }

    protected void Link_SnW(String W_name, String S_name, int l){
        if(l==1) {
            for (int i = 0; i < Ware_Ad_list.size(); i++) {
                if (Ware_Ad_list.get(i).W_house.getNAME().equals(W_name)) {
                    for (int j = 0; j < Store_Ad_list.size(); j++) {
                        if (Store_Ad_list.get(j).store.getNAME().equals(S_name)) {
                            Ware_Ad_list.get(i).W_house.Store_Ad_list.add(Store_Ad_list.get(j));
                            break;
                        }
                    }
                    break;
                }
            }
        }
        else if(l==-1){
            for (int i = 0; i < Ware_Ad_list.size(); i++) {
                if (Ware_Ad_list.get(i).W_house.getNAME().equals(W_name)) {
                    for (int j=0;j<Ware_Ad_list.get(i).W_house.Store_Ad_list.size();j++){
                        if(Ware_Ad_list.get(i).W_house.Store_Ad_list.get(j).store.getNAME().equals(S_name)){
                            Ware_Ad_list.get(i).W_house.Store_Ad_list.remove(j);
                            break;
                        }
                    }
                    break;
                }
            }
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
