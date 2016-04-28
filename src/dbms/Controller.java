
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
import javafx.scene.control.TextArea;
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


    private TextField moduser_planid;

    @FXML
    private TextField moduser_city;

    @FXML
    private TextField changeplan_planid;


    @FXML
    private CheckBox misc_change_chage_to_postpaid;

    @FXML
    private RadioButton moduser_gender_female;

    @FXML
    private TextField plans_planid;

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
    	if(plans_planid.getText().length()!=0){
    		wclause=appendand(wclause,"pid="+plans_planid.getText());
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
	    		pclause=appendor(pclause," calls<100");
	    	}
	    	if(plans_calls_2.isSelected()){
	    		pclause=appendor(pclause," calls BETWEEN 100 AND 500");
	    	}
	    	if(plans_calls_3.isSelected()){
	    		pclause=appendor(pclause," calls BETWEEN 500 AND 1000");
	    	}
	    	if(plans_calls_4.isSelected()){
	    		pclause=appendor(pclause," calls >1000 ");
	    	}
	    	if(pclause.length()!=0)
	    		pclause="("+pclause+")";
	    	wclause=appendand(wclause,pclause);
    	}
    	
    	if(plans_msg_1.isSelected() || plans_msg_2.isSelected() || plans_msg_3.isSelected() || plans_msg_4.isSelected()){
	    	String pclause="";
    		if(plans_msg_1.isSelected()){
	    		pclause=appendor(pclause," msgs<100");
	    	}
	    	if(plans_msg_2.isSelected()){
	    		pclause=appendor(pclause," msgs BETWEEN 100 AND 500");
	    	}
	    	if(plans_msg_3.isSelected()){
	    		pclause=appendor(pclause," msgs BETWEEN 500 AND 1000");
	    	}
	    	if(plans_msg_4.isSelected()){
	    		pclause=appendor(pclause," msgs >1000 ");
	    	}
	    	if(pclause.length()!=0)
	    		pclause="("+pclause+")";
	    	wclause=appendand(wclause,pclause);
    	}
    	
    	if(plans_data_1.isSelected() || plans_data_2.isSelected() || plans_data_3.isSelected() || plans_data_4.isSelected()){
	    	String pclause="";
    		if(plans_data_1.isSelected()){
	    		pclause=appendor(pclause," data<100");
	    	}
	    	if(plans_data_2.isSelected()){
	    		pclause=appendor(pclause," data BETWEEN 100 AND 500");
	    	}
	    	if(plans_data_3.isSelected()){
	    		pclause=appendor(pclause," data BETWEEN 500 AND 1000");
	    	}
	    	if(plans_data_4.isSelected()){
	    		pclause=appendor(pclause," data >1000 ");
	    	}
	    	if(pclause.length()!=0)
	    		pclause="("+pclause+")";
	    	wclause=appendand(wclause,pclause);
    	}
    	
    	
    	
    	if(wclause.length()==0)
    		return;
    	plandata.clear();
    	c1.setCellValueFactory(new PropertyValueFactory<>("pid"));
    	c2.setCellValueFactory(new PropertyValueFactory<>("calls"));
    	c3.setCellValueFactory(new PropertyValueFactory<>("msgs"));
    	c4.setCellValueFactory(new PropertyValueFactory<>("data"));
    	c5.setCellValueFactory(new PropertyValueFactory<>("type"));
    	c6.setCellValueFactory(new PropertyValueFactory<>("price"));
    	c1.setText("pid");c2.setText("calls");c3.setText("msgs");c4.setText("data");c5.setText("type");c6.setText("price");
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
            	Plan p=new Plan(rs.getInt("pid"),rs.getInt("calls"),rs.getInt("msgs"), rs.getInt("data"),rs.getString("type"),rs.getInt("price"));
             	System.out.println(". "+rs.getString("pid"));
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
        String query = "SELECT id FROM user_details WHERE name="+name;
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
    public void insert_user_submit(ActionEvent ae){
    	if(moduser_name.getText().length()==0 || moduser_mobile.getText().length()==0 || moduser_age.getText().length()==0 ||    	moduser_city.getText().length()==0 || moduser_planid.getText().length()==0 || moduser_gender.getSelectedToggle()==null ||moduser_type.getSelectedToggle()==null)
    	{
    		System.out.println("Aborted"); return;
    	}
    	String values=moduser_name.getText()+","+moduser_age.getText()+","+((RadioButton)moduser_gender.getSelectedToggle()).getText().charAt(0)+","+moduser_city.getText();
    	String query="INSERT INTO user_details values ("+values+")";
    	justexecute(query);
    	int id=getidbyname(moduser_name.getText());
    	query="INSERT INTO user values ("+id+","+moduser_mobile.getText()+")";
    	justexecute(query);
    	if(((RadioButton)moduser_type.getSelectedToggle()).getText().equals("Prepaid")){
    		values="";
    	}
    	if(((RadioButton)moduser_type.getSelectedToggle()).getText().equals("Postpaid")){
        	values="";
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
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}

