package Code_Mart;

public class Store_prod {
    private String S_name;

    public String getS_name() {
        return S_name;
    }

    public void setS_name(String s_name) {
        S_name = s_name;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    private int Quantity;

    public Store_prod(String S_name, int Quantity){
        this.S_name=S_name;
        this.Quantity=Quantity;
    }
}
