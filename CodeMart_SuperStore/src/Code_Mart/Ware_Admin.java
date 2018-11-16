import java.io.Serializable;
import java.util.ArrayList;
class Ware_Admin implements Serializable
{
	protected WareHouse W_house;

	public Ware_Admin(WareHouse house_ware,int _id,String _str)
	{
		W_house = house_ware;
		this.id = _id;
		this.pswd = _str;
	}
}