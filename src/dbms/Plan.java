package dbms;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Plan {

	SimpleIntegerProperty pid;
	SimpleIntegerProperty calls;
	SimpleIntegerProperty msgs;
	SimpleIntegerProperty data;
	SimpleIntegerProperty price;
	SimpleStringProperty type;

	public Plan(int pid, int calls,int msgs,int data, String type, int price )
	{
		this.pid=new SimpleIntegerProperty(pid);
		this.calls=new SimpleIntegerProperty(calls);
		this.msgs=new SimpleIntegerProperty(msgs);
		this.data=new SimpleIntegerProperty(data);
		this.price=new SimpleIntegerProperty(price);
		this.type=new SimpleStringProperty(type);
	}

	public int getPid()
	{
		return pid.get();
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
	public int getPrice()
	{
		return price.get();
	}
	public String getType()
	{
		return type.get();
	}

	
}
