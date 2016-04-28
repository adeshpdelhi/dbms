package dbms;

import java.time.LocalDate;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Bill {
	SimpleStringProperty mobile;
	SimpleStringProperty month;
	SimpleIntegerProperty amount;
	SimpleIntegerProperty plan_id;
	SimpleBooleanProperty ispaid;

	public Bill(String mobile, String month,int amount,int plan_id,boolean ispaid )
	{
		this.plan_id=new SimpleIntegerProperty(plan_id);
		this.mobile=new SimpleStringProperty(mobile);
		this.month=new SimpleStringProperty(month.toString());
		this.amount=new SimpleIntegerProperty(amount);
		this.ispaid=new SimpleBooleanProperty(ispaid);
	}

	public int getPlan_id()
	{
		return plan_id.get();
	}

	public String getMonth(){
		return month.get();
	}
	public int getAmount(){
		return amount.get();
	}
	public boolean getIspaid(){
		return ispaid.get();
	}
	public String getMobile()
	{
		return mobile.get();
	}

}
