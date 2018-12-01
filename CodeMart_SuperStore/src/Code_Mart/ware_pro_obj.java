package Code_Mart;

public class ware_pro_obj {
    private String NAME;
    private int no_of_prod;
    public ware_pro_obj(String Name, int no_of_prod){
        this.NAME=Name;
        this.no_of_prod = no_of_prod;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public int getNo_of_prod() {
        return no_of_prod;
    }

    public void setNo_of_prod(int no_of_prod) {
        this.no_of_prod = no_of_prod;
    }
}
