package dbms;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class User {

	SimpleIntegerProperty id;
	SimpleStringProperty name;
	SimpleIntegerProperty age;
	SimpleStringProperty gender;
	SimpleStringProperty city;
	SimpleStringProperty mobile;

	public User(int id,String name,int age, String gender, String city, String mobile)
	{
		this.id=new SimpleIntegerProperty(id);
		this.age=new SimpleIntegerProperty(age);
		this.name=new SimpleStringProperty(name);
		this.gender=new SimpleStringProperty(gender);
		this.city=new SimpleStringProperty(city);
		this.mobile=new SimpleStringProperty(mobile);
	}

	public int getId()
	{
		return id.get();
	}

	public int getAge()
	{
		return age.get();
	}
	public String getName()
	{
		return name.get();
	}
	public String getGender()
	{
		return gender.get();
	}
	public String getMobile()
	{
		return mobile.get();
	}
	public String getCity()
	{
		return city.get();
	}

	
}
