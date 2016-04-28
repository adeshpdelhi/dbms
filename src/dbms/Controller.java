
package dbms;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller implements Initializable{
	@FXML
    private ToggleGroup plans_type;

    @FXML
    private TextField users_age_from;

    @FXML
    private TextField misc_usage_mobile;

    @FXML
    private TextField users_age_to;

    @FXML
    private RadioButton plans_type_prepaid;

    @FXML
    private CheckBox plans_calls_3;

    @FXML
    private Button changeplan_submit;

    @FXML
    private CheckBox plans_calls_4;

    @FXML
    private TextField moduser_name;

    @FXML
    private TextField misc_retrieve_mobile;
    
    @FXML
    private TextField misc_recharge_amount;


    @FXML
    private RadioButton moduser_type_postpaid;

    @FXML
    private CheckBox plans_calls_1;

    @FXML
    private CheckBox plans_calls_2;

    @FXML
    private TextField users_city;

    @FXML
    private DatePicker misc_retrieve_month;

    @FXML
    private ToggleGroup moduser_gender;

    @FXML
    private TextField queries_4_messages;

    @FXML
    private TextField queries_1_k;

    @FXML
    private CheckBox queries_3_gt;

    @FXML
    private RadioButton moduser_gender_male;

    @FXML
    private CheckBox plans_msg_3;

    @FXML
    private CheckBox plans_msg_4;

    @FXML
    private TextField moduser_age;

    @FXML
    private Button moduser_delete;

    @FXML
    private CheckBox plans_msg_1;

    @FXML
    private CheckBox plans_msg_2;

    @FXML
    private TextField queries_4_calls;

    @FXML
    private RadioButton moduser_type_prepaid;

    @FXML
    private TextField moduser_plan_id;

    @FXML
    private TextField moduser_city;

    @FXML
    private TextField changeplan_plan_id;


    @FXML
    private CheckBox misc_change_chage_to_postpaid;

    @FXML
    private RadioButton moduser_gender_female;

    @FXML
    private TextField plans_plan_id;

    @FXML
    private TextField queries_3_lt_value;

    @FXML
    private TextField misc_recharge_mobile;

    @FXML
    private Button misc_change_submit;

    @FXML
    private TextField misc_pay_mobile;

    @FXML
    private TextField queries_3_eq_value;

    @FXML
    private RadioButton plans_type_postpaid;

    @FXML
    private CheckBox queries_3_eq;

    @FXML
    private ToggleGroup moduser_type;

    @FXML
    private TextField queries_4_k;

    @FXML
    private TextField queries_4_m;

    @FXML
    private Button queries_submit;


    @FXML
    private Button misc_pay_submit;


    @FXML
    private TextField queries_4_data;

    @FXML
    private TextField misc_change_mobile;

    @FXML
    private Button misc_usage_submit;

    @FXML
    private Button misc_recharge_submit;

    @FXML
    private CheckBox queries_4;

    @FXML
    private CheckBox plans_data_1;

    @FXML
    private CheckBox queries_3;

    @FXML
    private CheckBox queries_3_lt;

    @FXML
    private CheckBox plans_data_2;

    @FXML
    private CheckBox queries_2;

    @FXML
    private CheckBox plans_data_3;

    @FXML
    private CheckBox queries_1;

    @FXML
    private CheckBox plans_data_4;

    @FXML
    private TextField changeplan_mobile;

    @FXML
    private Button plans_submit;

    @FXML
    private CheckBox queries_5;


    @FXML
    private Tab insertuser_name;

    @FXML
    private TextField plans_price_from;

    @FXML
    private Button moduser_submit;


    @FXML
    private TextField moduser_mobile;

    @FXML
    private TextField users_mobile;

    @FXML
    private TextField plans_price_to;

    @FXML
    private Button users_submit;

    @FXML
    private TextField queries_3_gt_value;

    @FXML
    private CheckBox misc_change_chage_to_prepaid;

    @FXML
    private Button misc_retrieve_bills;
    @FXML	private TableView table;
    @FXML	private TableColumn c1;
    @FXML	private TableColumn c2;
   @FXML	private TableColumn c3;
   @FXML	private TableColumn c4;
   @FXML	private TableColumn c5;
   @FXML	private TableColumn c6;
    ObservableList<Plan> plandata=FXCollections.observableArrayList();
    ObservableList<User> userdata=FXCollections.observableArrayList();
    ObservableList <Preaccount> preaccdata=FXCollections.observableArrayList();
    ObservableList <Postaccount> postaccdata=FXCollections.observableArrayList();
    ObservableList <Bill> billdata=FXCollections.observableArrayList();
    public String appendand (String w,String s){
    	if(w.length()==0)
    		return s;
    	w=w+" AND "+s;
    	return w;
    }
    public String appendor (String w,String s){
    	if(w.length()==0)
    		return s;
    	w=w+" OR "+s;
    	return w;
    }
    public void submitplan(ActionEvent e){
    	String wclause="";
    	if(plans_plan_id.getText().length()!=0){
    		wclause=appendand(wclause,"plan_id="+plans_plan_id.getText());
    	}
    	if(plans_price_from.getText().length()!=0 && plans_price_to.getText().length()!=0){
    		try{
    			int from=Integer.parseInt(plans_price_from.getText());
    			int to=Integer.parseInt(plans_price_to.getText());
    			wclause=appendand(wclause,"price BETWEEN "+from+" AND "+to);
    		}
    		catch(Exception ex){ex.printStackTrace();}
    	}
    	if(plans_type.getSelectedToggle() != null){
    		String type=((RadioButton)plans_type.getSelectedToggle()).getText();
    		type=type.toLowerCase();
    		wclause=appendand(wclause,"type='"+type+"'");
    	}
    	if(plans_calls_1.isSelected() || plans_calls_2.isSelected() || plans_calls_3.isSelected() || plans_calls_4.isSelected()){
	    	String pclause="";
    		if(plans_calls_1.isSelected()){
	    		pclause=appendor(pclause," pcalls<100");
	    	}
	    	if(plans_calls_2.isSelected()){
	    		pclause=appendor(pclause," pcalls BETWEEN 100 AND 500");
	    	}
	    	if(plans_calls_3.isSelected()){
	    		pclause=appendor(pclause," pcalls BETWEEN 500 AND 1000");
	    	}
	    	if(plans_calls_4.isSelected()){
	    		pclause=appendor(pclause," pcalls >1000 ");
	    	}
	    	if(pclause.length()!=0)
	    		pclause="("+pclause+")";
	    	wclause=appendand(wclause,pclause);
    	}
    	
    	if(plans_msg_1.isSelected() || plans_msg_2.isSelected() || plans_msg_3.isSelected() || plans_msg_4.isSelected()){
	    	String pclause="";
    		if(plans_msg_1.isSelected()){
	    		pclause=appendor(pclause," pmsgs<100");
	    	}
	    	if(plans_msg_2.isSelected()){
	    		pclause=appendor(pclause," pmsgs BETWEEN 100 AND 500");
	    	}
	    	if(plans_msg_3.isSelected()){
	    		pclause=appendor(pclause," pmsgs BETWEEN 500 AND 1000");
	    	}
	    	if(plans_msg_4.isSelected()){
	    		pclause=appendor(pclause," pmsgs >1000 ");
	    	}
	    	if(pclause.length()!=0)
	    		pclause="("+pclause+")";
	    	wclause=appendand(wclause,pclause);
    	}
    	
    	if(plans_data_1.isSelected() || plans_data_2.isSelected() || plans_data_3.isSelected() || plans_data_4.isSelected()){
	    	String pclause="";
    		if(plans_data_1.isSelected()){
	    		pclause=appendor(pclause," pdata<100");
	    	}
	    	if(plans_data_2.isSelected()){
	    		pclause=appendor(pclause," pdata BETWEEN 100 AND 500");
	    	}
	    	if(plans_data_3.isSelected()){
	    		pclause=appendor(pclause," pdata BETWEEN 500 AND 1000");
	    	}
	    	if(plans_data_4.isSelected()){
	    		pclause=appendor(pclause," pdata >1000 ");
	    	}
	    	if(pclause.length()!=0)
	    		pclause="("+pclause+")";
	    	wclause=appendand(wclause,pclause);
    	}
    	
    	
    	
    	if(wclause.length()==0)
    		return;
    	plandata.clear();
    	c1.setCellValueFactory(new PropertyValueFactory<>("plan_id"));
    	c2.setCellValueFactory(new PropertyValueFactory<>("pcalls"));
    	c3.setCellValueFactory(new PropertyValueFactory<>("pmsgs"));
    	c4.setCellValueFactory(new PropertyValueFactory<>("pdata"));
    	c5.setCellValueFactory(new PropertyValueFactory<>("type"));
    	c6.setCellValueFactory(new PropertyValueFactory<>("price"));
    	c1.setText("plan_id");c2.setText("pcalls");c3.setText("pmsgs");c4.setText("pdata");c5.setText("type");c6.setText("price");
    	ResultSet rs = null;
         Connection connection = null;
         Statement statement = null; 

         String query = "SELECT * FROM plan_details WHERE " + wclause;
         System.out.println(query);
         try {           
             connection = JDBCConnect.getConnection();
             statement = connection.createStatement();
             rs = statement.executeQuery(query);
             //System.out.println("Total results found "+rs.getFetchSize());
             while(rs.next()){
            	Plan p=new Plan(rs.getInt("plan_id"),rs.getInt("pcalls"),rs.getInt("pmsgs"), rs.getInt("pdata"),rs.getString("type"),rs.getInt("price"));
             	System.out.println(". "+rs.getString("plan_id"));
             	plandata.add(p);
             }
         } catch (SQLException ex) {
             ex.printStackTrace();
         } finally {
             if (connection != null) {
                 try {
                     connection.close();
                 } catch (SQLException ex) {
                     ex.printStackTrace();
                 }
             }
         }
         table.setItems(plandata);
    }
    public void justexecute(String query){
    	System.out.println("justexecute: "+query);
    	Connection connection = null;
        Statement statement = null; 
        try {           
            connection = JDBCConnect.getConnection();
            statement = connection.createStatement();
            statement.execute(query);
            }
         catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    public int getidbyname(String name){

    	ResultSet rs = null;
        Connection connection = null;
        Statement statement = null; 
        int id = -1;
        String query = "SELECT id FROM user_details WHERE name='"+name+"'";
        System.out.println(query);
        try {           
            connection = JDBCConnect.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            //System.out.println("Total results found "+rs.getFetchSize());
            if(rs.next()){
	           	id=rs.getInt("id");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return id;
    }
    public int getidbymobile(String mobile){
    	ResultSet rs = null;
        Connection connection = null;
        Statement statement = null; 
        int id=-1;
        String query = "SELECT id FROM user_details natural join user WHERE mobile="+mobile;
        System.out.println(query);
        try {           
            connection = JDBCConnect.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            //System.out.println("Total results found "+rs.getFetchSize());
            if(rs.next()){
	           	id=rs.getInt("id");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return id;
    }
    
    public String gettypebymobile(String mobile){
    	ResultSet rs = null;
        Connection connection = null;
        Statement statement = null; 
        String type=null;
        String query = "select distinct \"prepaid\" from user natural join prepaid_account where exists(select \"prepaid\" from prepaid_account where mobile="+mobile+") union select distinct \"postpaid\" from user natural join postpaid_account where exists(select \"postpaid\" from postpaid_account where mobile="+mobile+")";
        System.out.println(query);
        try {           
            connection = JDBCConnect.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            //System.out.println("Total results found "+rs.getFetchSize());
            if(rs.next()){
            	try{
	           	type=rs.getString("prepaid");
            	}
            	catch(Exception e){
            		type="postpaid";
            	}
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return type;
    }

    public void delete_user_submit(ActionEvent ev){
    	if(moduser_mobile.getText().length()==0)
    		return;
    	int id=getidbymobile(moduser_mobile.getText());
    	String query="DELETE FROM user_details where id="+id;
    	justexecute(query);
    	query="DELETE FROM user where mobile="+moduser_mobile.getText();
    	justexecute(query);
    	if(gettypebymobile(moduser_mobile.getText()).equals("prepaid"))
    		query="DELETE FROM prepaid_account where mobile="+moduser_mobile.getText();
    	else
    		query="DELETE FROM postpaid_account where mobile="+moduser_mobile.getText();
    	justexecute(query);
    }
    public int[] getplanbyplan_id(int plan_id){
    	ResultSet rs = null;
        Connection connection = null;
        Statement statement = null; 
        int details[] = new int[5];
        String query = "SELECT * FROM plan_details WHERE plan_id="+plan_id;
        System.out.println(query);
        try {           
            connection = JDBCConnect.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            //System.out.println("Total results found "+rs.getFetchSize());
            if(rs.next()){
	           	details[0]=rs.getInt("plan_id");
	           	details[1]=rs.getInt("pcalls");
	           	details[2]=rs.getInt("pmsgs");
	           	details[3]=rs.getInt("pdata");
	           	details[4]=rs.getInt("price");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return details;
    }
    
    public void insert_user_submit(ActionEvent ae){
    	if(moduser_name.getText().length()==0 || moduser_mobile.getText().length()==0 || moduser_age.getText().length()==0 ||    	moduser_city.getText().length()==0 || moduser_plan_id.getText().length()==0 || moduser_gender.getSelectedToggle()==null ||moduser_type.getSelectedToggle()==null)
    	{
    		System.out.println("Aborted"); return;
    	}
    	String values="'"+moduser_name.getText()+"',"+moduser_age.getText()+",'"+((RadioButton)moduser_gender.getSelectedToggle()).getText().charAt(0)+"','"+moduser_city.getText()+"'";
    	String query="INSERT INTO user_details(name,age,gender,city) values ("+values+")";
    	justexecute(query);
    	int pdetails[]=getplanbyplan_id(Integer.parseInt(moduser_plan_id.getText()));
    	if(((RadioButton)moduser_type.getSelectedToggle()).getText().equals("Prepaid")){
    		values=moduser_mobile.getText()+",0,"+pdetails[0]+","+pdetails[1]+","+pdetails[2]+","+pdetails[3];
        	query="INSERT INTO prepaid_account values ("+values+")";
    	}
    	if(((RadioButton)moduser_type.getSelectedToggle()).getText().equals("Postpaid")){
    		values=moduser_mobile.getText()+","+pdetails[0]+","+pdetails[1]+","+pdetails[2]+","+pdetails[3];
        	query="INSERT INTO postpaid_account values ("+values+")";
    	}
    	justexecute(query);
    	int id=getidbyname(moduser_name.getText());
    	if(id==-1)
    	{
    		System.out.println("Error finding id"); return;
    	}
    	query="INSERT INTO user values ("+id+","+moduser_mobile.getText()+")"; 
    	justexecute(query);
    }
    
    public void misc_usage_submit(ActionEvent ae){
    	//System.out.println("here");
    	if(misc_usage_mobile.getText().length()==0)
    		{
    		System.out.println("abort");
    		return;
    		}
    	String mobile=misc_usage_mobile.getText();
    	if(gettypebymobile(mobile).equals("prepaid")){
	    	preaccdata.clear();
	    	c1.setCellValueFactory(new PropertyValueFactory<>("mobile"));
	    	c2.setCellValueFactory(new PropertyValueFactory<>("balance"));
	    	c3.setCellValueFactory(new PropertyValueFactory<>("plan_id"));
	    	c4.setCellValueFactory(new PropertyValueFactory<>("calls"));
	    	c5.setCellValueFactory(new PropertyValueFactory<>("msgs"));
	    	c6.setCellValueFactory(new PropertyValueFactory<>("data"));
	    	c1.setText("mobile");c2.setText("balance");c3.setText("plan_id");c4.setText("calls");c5.setText("msgs");c6.setText("data");
	    	ResultSet rs = null;
	         Connection connection = null;
	         Statement statement = null; 
	
	         String query = "SELECT * FROM prepaid_account WHERE mobile="+mobile ;
	         System.out.println(query);
	         try {           
	             connection = JDBCConnect.getConnection();
	             statement = connection.createStatement();
	             rs = statement.executeQuery(query);
	             //System.out.println("Total results found "+rs.getFetchSize());
	             while(rs.next()){
	            	Preaccount a=new Preaccount(rs.getString("mobile"),rs.getInt("balance"),rs.getInt("plan_id"),rs.getInt("calls"),rs.getInt("msgs"),rs.getInt("data"));
	            	preaccdata.add(a);
	             }
	         } catch (SQLException ex) {
	             ex.printStackTrace();
	         } finally {
	             if (connection != null) {
	                 try {
	                     connection.close();
	                 } catch (SQLException ex) {
	                     ex.printStackTrace();
	                 }
	             }
	         }
	         table.setItems(preaccdata);
    	}
    	else{
    		postaccdata.clear();
	    	c1.setCellValueFactory(new PropertyValueFactory<>("mobile"));
	    	c2.setCellValueFactory(new PropertyValueFactory<>("plan_id"));
	    	c3.setCellValueFactory(new PropertyValueFactory<>("calls"));
	    	c4.setCellValueFactory(new PropertyValueFactory<>("msgs"));
	    	c5.setCellValueFactory(new PropertyValueFactory<>("data"));


	    	c1.setText("mobile");c2.setText("plan_id");c3.setText("calls");c4.setText("msgs");c5.setText("data");
	    	ResultSet rs = null;
	         Connection connection = null;
	         Statement statement = null; 
	
	         String query = "SELECT * FROM postpaid_account WHERE mobile="+mobile ;
	         System.out.println(query);
	         try {           
	             connection = JDBCConnect.getConnection();
	             statement = connection.createStatement();
	             rs = statement.executeQuery(query);
	             //System.out.println("Total results found "+rs.getFetchSize());
	             while(rs.next()){
	            	Postaccount a=new Postaccount(rs.getString("mobile"),rs.getInt("plan_id"),rs.getInt("calls"),rs.getInt("msgs"),rs.getInt("data"));
	            	postaccdata.add(a);
	             }
	         } catch (SQLException ex) {
	             ex.printStackTrace();
	         } finally {
	             if (connection != null) {
	                 try {
	                     connection.close();
	                 } catch (SQLException ex) {
	                     ex.printStackTrace();
	                 }
	             }
	         }
	         table.setItems(postaccdata);
    	}
    }
    public void submituser(ActionEvent e){
    	String wclause="";
    	if(users_mobile.getText().length()!=0){
    		try{
    			Long m=Long.parseLong(users_mobile.getText());
    			wclause=appendand(wclause,"mobile="+m);
    		}
    		catch(Exception ex){ex.printStackTrace();}
    	}
    	if(users_age_from.getText().length()!=0 && users_age_to.getText().length()!=0){
    		try{
    			int from=Integer.parseInt(users_age_from.getText());
    			int to=Integer.parseInt(users_age_to.getText());
    			wclause=appendand(wclause,"age BETWEEN "+from+" AND "+to);
    		}
    		catch(Exception ex){ex.printStackTrace();}
    	}
    	if(users_city.getText().length()!=0){
    		wclause=appendand(wclause,"city='"+users_city.getText()+"'");
    	}

    	if(wclause.length()==0)
    		return;
    	userdata.clear();
    	c1.setCellValueFactory(new PropertyValueFactory<>("id"));
    	c2.setCellValueFactory(new PropertyValueFactory<>("name"));
    	c3.setCellValueFactory(new PropertyValueFactory<>("age"));
    	c4.setCellValueFactory(new PropertyValueFactory<>("gender"));
    	c5.setCellValueFactory(new PropertyValueFactory<>("city"));
    	c6.setCellValueFactory(new PropertyValueFactory<>("mobile"));
    	c1.setText("id");c2.setText("name");c3.setText("age");c4.setText("gender");c5.setText("city");c6.setText("mobile");
    	
    	
    	ResultSet rs = null;
        Connection connection = null;
        Statement statement = null; 

        String query = "SELECT id,name,age,gender,city,mobile FROM user_details natural join user natural join prepaid_account WHERE " + wclause+" UNION "
        		+ "SELECT id,name,age,gender,city,mobile FROM user_details natural join user natural join postpaid_account WHERE " + wclause;
        System.out.println(query);
        try {           
            connection = JDBCConnect.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            //System.out.println("Total results found "+rs.getFetchSize());
            while(rs.next()){
            	User u =new User(rs.getInt("id"),rs.getString("name"),rs.getInt("age"), rs.getString("gender"),rs.getString("city"),rs.getString("mobile"));;
            	System.out.println(". "+rs.getString("id"));
            	userdata.add(u);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        table.setItems(userdata);
    }
	public void misc_pay_submit(ActionEvent ev){
		if(misc_pay_mobile.getText().length()==0)
			return;
		String mobile=misc_pay_mobile.getText();
		String query="UPDATE bills SET ispaid=true where mobile="+mobile;
		justexecute(query);
	}
	public void misc_retrieve_submit(ActionEvent ae){
		if(misc_retrieve_mobile.getText().length()==0)
			return;
		String mobile=misc_retrieve_mobile.getText();
		
		billdata.clear();
    	c1.setCellValueFactory(new PropertyValueFactory<>("mobile"));
    	c2.setCellValueFactory(new PropertyValueFactory<>("month"));
    	c3.setCellValueFactory(new PropertyValueFactory<>("amount"));
    	c4.setCellValueFactory(new PropertyValueFactory<>("planid"));
    	c5.setCellValueFactory(new PropertyValueFactory<>("ispaid"));
    	c1.setText("mobile");c2.setText("month");c3.setText("amount");c4.setText("planid");c5.setText("ispaid");
		
		ResultSet rs = null;
        Connection connection = null;
        Statement statement = null; 
        String query = "SELECT * FROM bills WHERE mobile="+mobile;
        System.out.println(query);
        try {           
            connection = JDBCConnect.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            //System.out.println("Total results found "+rs.getFetchSize());
            while(rs.next()){
	           	Bill b=new Bill(rs.getString("mobile"),rs.getString("month"),rs.getInt("amount"),rs.getInt("plan_id"),rs.getBoolean("ispaid"));
	           	billdata.add(b);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
		table.setItems(billdata);
	}
	public void misc_recharge_submit(ActionEvent ae){
		if (misc_recharge_mobile.getText().length()==0 || misc_recharge_amount.getText().length()==0)
			return;
		String mobile=misc_recharge_mobile.getText();
		String amount=misc_recharge_amount.getText();
		String query="UPDATE prepaid_account SET balance=balance+"+amount+" where mobile="+mobile;
		justexecute(query);
	}
	public void misc_change_submit(ActionEvent ae){
		if(misc_change_mobile.getText().length()==0)
			return;
		String mobile=misc_change_mobile.getText();
		String oldtype=gettypebymobile(mobile);
		String newtype;
		if(oldtype.equals("prepaid")) newtype="postpaid";
		else newtype="prepaid";
		String query="DELETE FROM "+oldtype+"_account where mobile="+mobile;
		justexecute(query);
		if(newtype.equals("prepaid")){
			query="INSERT INTO prepaid_account values("+mobile+",0,1,0,0,0)";
		}
		if(newtype.equals("postpaid")){
			query="INSERT INTO postpaid_account values("+mobile+",13,50,50,50)";
		}
		justexecute(query);
	}
    
	public void changeplan_submit(ActionEvent ae){
		if (changeplan_mobile.getText().length()==0 && changeplan_plan_id.getText().length()==0)
			return;
		String mobile=changeplan_mobile.getText();
		String plan_id=changeplan_plan_id.getText();
		String type=gettypebymobile(mobile);
		String query=null;
		int pd[]=getplanbyplan_id(Integer.parseInt(plan_id));
		if(type.equals("prepaid"))
			query="UPDATE prepaid_account SET plan_id="+plan_id+" , calls="+pd[1]+" , msgs="+pd[2]+" , data="+pd[3]+" WHERE mobile="+mobile;
		if(type.equals("postpaid"))
			query="UPDATE postpaid_account SET plan_id="+plan_id+" , calls="+pd[1]+" , msgs="+pd[2]+" , data="+pd[3]+" WHERE mobile="+mobile;
		justexecute(query);
	}
	public void query1(){
		if(queries_1_k.getText().length()==0)
			return;
		int k=Integer.parseInt(queries_1_k.getText());
		String date = null;
		if(k>5) return;
		if(k==5)	date="2015-11-01";
		if(k==4)	date="2015-12-01";
		if(k==3)	date="2016-01-01";
		if(k==2)	date="2016-02-01";
		if(k==1)	date="2016-03-01";
		String query="select id,mobile,name,age,gender,city from bills natural join user natural join user_details where month>='"+date+"' and city='Pune' and ispaid=false group by mobile having count(*)="+k;
		userdata.clear();
    	c1.setCellValueFactory(new PropertyValueFactory<>("id"));
    	c2.setCellValueFactory(new PropertyValueFactory<>("name"));
    	c3.setCellValueFactory(new PropertyValueFactory<>("age"));
    	c4.setCellValueFactory(new PropertyValueFactory<>("gender"));
    	c5.setCellValueFactory(new PropertyValueFactory<>("city"));
    	c6.setCellValueFactory(new PropertyValueFactory<>("mobile"));
    	c1.setText("id");c2.setText("name");c3.setText("age");c4.setText("gender");c5.setText("city");c6.setText("mobile");
    	
    	
    	ResultSet rs = null;
        Connection connection = null;
        Statement statement = null; 

         System.out.println(query);
        try {           
            connection = JDBCConnect.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            //System.out.println("Total results found "+rs.getFetchSize());
            while(rs.next()){
            	User u =new User(rs.getInt("id"),rs.getString("name"),rs.getInt("age"), rs.getString("gender"),rs.getString("city"),rs.getString("mobile"));;
            	System.out.println(". "+rs.getString("id"));
            	userdata.add(u);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        table.setItems(userdata);
	}

	public void query3(){
		if(!((queries_3_lt_value.getText().length()!=0&&queries_3_lt.isSelected())|| (queries_3_eq_value.getText().length()!=0&&queries_3_eq.isSelected()) || (queries_3_gt_value.getText().length()!=0&&queries_3_gt.isSelected())))
			return;
		String pclause="";
		if((queries_3_lt_value.getText().length()!=0&&queries_3_lt.isSelected())){
    		pclause=appendor(pclause," amount< "+queries_3_lt_value.getText()+" ");
    	}
    	if(queries_3_eq_value.getText().length()!=0&&queries_3_eq.isSelected()){
    		pclause=appendor(pclause," amount= "+queries_3_eq_value.getText()+" ");
    	}
    	if(queries_3_gt_value.getText().length()!=0&&queries_3_gt.isSelected()){
    		pclause=appendor(pclause," amount> "+queries_3_gt_value.getText()+" ");
    	}
    	if(pclause.length()!=0)
    		pclause="("+pclause+")";
    	String query="select d.id,s.mobile,d.name,d.age,d.gender,d.city from bills as s natural join user natural join user_details as d where "+pclause+" group by mobile having count(*)= (select count(*) from bills where mobile=s.mobile)";
		userdata.clear();
    	c1.setCellValueFactory(new PropertyValueFactory<>("id"));
    	c2.setCellValueFactory(new PropertyValueFactory<>("name"));
    	c3.setCellValueFactory(new PropertyValueFactory<>("age"));
    	c4.setCellValueFactory(new PropertyValueFactory<>("gender"));
    	c5.setCellValueFactory(new PropertyValueFactory<>("city"));
    	c6.setCellValueFactory(new PropertyValueFactory<>("mobile"));
    	c1.setText("id");c2.setText("name");c3.setText("age");c4.setText("gender");c5.setText("city");c6.setText("mobile");
    	
    	
    	ResultSet rs = null;
        Connection connection = null;
        Statement statement = null; 

         System.out.println(query);
        try {           
            connection = JDBCConnect.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            //System.out.println("Total results found "+rs.getFetchSize());
            while(rs.next()){
            	User u =new User(rs.getInt("d.id"),rs.getString("d.name"),rs.getInt("d.age"), rs.getString("d.gender"),rs.getString("d.city"),rs.getString("s.mobile"));;
            	System.out.println(". "+rs.getString("id"));
            	userdata.add(u);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        table.setItems(userdata);
	}
	public void query4(){
		if(queries_4_m.getText().length()==0 || queries_4_k.getText().length()==0)
			return;
		String m=queries_4_m.getText(); String k=queries_4_k.getText();
		plandata.clear();
    	c1.setCellValueFactory(new PropertyValueFactory<>("plan_id"));
    	c2.setCellValueFactory(new PropertyValueFactory<>("pcalls"));
    	c3.setCellValueFactory(new PropertyValueFactory<>("pmsgs"));
    	c4.setCellValueFactory(new PropertyValueFactory<>("pdata"));
    	c5.setCellValueFactory(new PropertyValueFactory<>("type"));
    	c6.setCellValueFactory(new PropertyValueFactory<>("price"));
    	c1.setText("plan_id");c2.setText("pcalls");c3.setText("pmsgs");c4.setText("pdata");c5.setText("type");c6.setText("price");
    	ResultSet rs = null;
         Connection connection = null;
         Statement statement = null; 

         String query = "create or replace view temp2 (plan_id,mobile) as select plan_id,mobile from bills union select plan_id,mobile from postpaid_account union select plan_id,mobile from prepaid_account";
         justexecute(query);
         query="select t.plan_id,pcalls,pmsgs,pdata,p.price, p.type from temp2 as t natural join user natural join user_details as u natural join plan_details as p where u.gender='F' group by plan_id having count(distinct mobile)>="+k+" and count(distinct city)>="+m;
         System.out.println(query);
         
         try {           
             connection = JDBCConnect.getConnection();
             statement = connection.createStatement();
             rs = statement.executeQuery(query);
             //System.out.println("Total results found "+rs.getFetchSize());
             while(rs.next()){
            	Plan p=new Plan(rs.getInt("t.plan_id"),rs.getInt("pcalls"),rs.getInt("pmsgs"), rs.getInt("pdata"),rs.getString("p.type"),rs.getInt("p.price"));
             	System.out.println(". "+rs.getString("t.plan_id"));
             	plandata.add(p);
             }
         } catch (SQLException ex) {
             ex.printStackTrace();
         } finally {
             if (connection != null) {
                 try {
                     connection.close();
                 } catch (SQLException ex) {
                     ex.printStackTrace();
                 }
             }
         }
         table.setItems(plandata);
         query="drop view temp2;";
         justexecute(query);
	}
	public void query5(){
		if(queries_4_calls.getText().length()==0 || queries_4_messages.getText().length()==0 || queries_4_data.getText().length()==0)
			return;
		Float calls=Float.parseFloat(queries_4_calls.getText())/100,msgs=Float.parseFloat(queries_4_messages.getText())/100,data=Float.parseFloat(queries_4_data.getText())/100;
		userdata.clear();
    	c1.setCellValueFactory(new PropertyValueFactory<>("id"));
    	c2.setCellValueFactory(new PropertyValueFactory<>("name"));
    	c3.setCellValueFactory(new PropertyValueFactory<>("age"));
    	c4.setCellValueFactory(new PropertyValueFactory<>("gender"));
    	c5.setCellValueFactory(new PropertyValueFactory<>("city"));
    	c6.setCellValueFactory(new PropertyValueFactory<>("mobile"));
    	c1.setText("id");c2.setText("name");c3.setText("age");c4.setText("gender");c5.setText("city");c6.setText("mobile");
    	
    	
    	ResultSet rs = null;
        Connection connection = null;
        Statement statement = null; 

        String query = "select u.id,s.mobile,u.name,u.age,u.gender,u.city  from prepaid_account as s natural join "
        		+ " plan_details as d natural join user natural join user_details as u where "
        		+ " pmsgs-s.msgs>="+msgs+" * (pmsgs) and pcalls-s.calls>="+calls+" * (pcalls) and pdata-s.data>="+data+" * (pdata) "
        		+ " union select u.id,s.mobile,u.name,u.age,u.gender,u.city from postpaid_account as s natural join "
        		+ " plan_details as d natural join user natural join user_details as u where "
        		+ " pmsgs-s.msgs>="+msgs+" * (pmsgs) and pcalls-s.calls>="+calls+" * (pcalls) and pdata-s.data>="+data+" * (pdata) ";
        System.out.println(query);
        try {           
            connection = JDBCConnect.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            //System.out.println("Total results found "+rs.getFetchSize());
            while(rs.next()){
            	User u =new User(rs.getInt("id"),rs.getString("name"),rs.getInt("age"), rs.getString("gender"),rs.getString("city"),rs.getString("mobile"));
            	System.out.println(". "+rs.getString("id"));
            	userdata.add(u);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        table.setItems(userdata);
	}
	
	public void queries_submit(ActionEvent ae){
		if(queries_1.isSelected()){
			query1();
			return;
		}
		if(queries_3.isSelected()){
			query3();
			return;
		}
		if(queries_4.isSelected()){
			query4();
			return;
		}
		if(queries_5.isSelected()){
			query5();
			return;
		}
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}

