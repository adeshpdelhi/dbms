package dbms;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Preaccount {
	SimpleIntegerProperty plan_id;
	SimpleIntegerProperty calls;
	SimpleIntegerProperty msgs;
	SimpleIntegerProperty data;
	SimpleIntegerProperty balance;
	SimpleStringProperty mobile;
	
	public Preaccount(String mobile,int balance,int plan_id, int calls,int msgs,int data )
	{
		this.plan_id=new SimpleIntegerProperty(plan_id);
		this.calls=new SimpleIntegerProperty(calls);
		this.msgs=new SimpleIntegerProperty(msgs);
		this.data=new SimpleIntegerProperty(data);
		this.balance=new SimpleIntegerProperty(balance);
		this.mobile=new SimpleStringProperty(mobile);
	}

	public int getPlan_id()
	{
		return plan_id.get();
	}

	public int getCalls()
	{
		return calls.get();
	}

	public int getMsgs()
	{
		return msgs.get();
	}
	
	public int getData()
	{
		return data.get();
	}
	public int getBalance()
	{
		return balance.get();
	}
	public String getMobile()
	{
		return mobile.get();
	}

}
