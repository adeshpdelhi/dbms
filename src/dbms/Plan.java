package dbms;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Plan {

	SimpleIntegerProperty plan_id;
	SimpleIntegerProperty pcalls;
	SimpleIntegerProperty pmsgs;
	SimpleIntegerProperty pdata;
	SimpleIntegerProperty price;
	SimpleStringProperty type;

	public Plan(int plan_id, int pcalls,int pmsgs,int pdata, String type, int price )
	{
		this.plan_id=new SimpleIntegerProperty(plan_id);
		this.pcalls=new SimpleIntegerProperty(pcalls);
		this.pmsgs=new SimpleIntegerProperty(pmsgs);
		this.pdata=new SimpleIntegerProperty(pdata);
		this.price=new SimpleIntegerProperty(price);
		this.type=new SimpleStringProperty(type);
	}

	public int getPlan_id()
	{
		return plan_id.get();
	}

	public int getPcalls()
	{
		return pcalls.get();
	}

	public int getPmsgs()
	{
		return pmsgs.get();
	}
	
	public int getPdata()
	{
		return pdata.get();
	}
	public int getPrice()
	{
		return price.get();
	}
	public String getType()
	{
		return type.get();
	}

	
}
