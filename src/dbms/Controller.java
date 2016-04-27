
package dbms;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class Controller implements Initializable{
    @FXML
    private TextField queries_1_x;
    @FXML
    private ToggleGroup plans_type;
    @FXML
    private TextField users_age_from;
    @FXML
    private TextField users_age_to;
    @FXML
    private RadioButton insertuser_gender_male;
    @FXML
    private RadioButton insertuser_type_prepaid;
    @FXML
    private RadioButton plans_type_prepaid;
    @FXML
    private CheckBox plans_calls_3;
    @FXML
    private Button changeplan_submit;
    @FXML
    private CheckBox plans_msg_2;
    @FXML
    private CheckBox plans_msg_3;
    @FXML
    private CheckBox plans_msg_4;
    @FXML
    private CheckBox plans_data_2;
    @FXML
    private CheckBox plans_data_3;
    @FXML
    private CheckBox plans_data_4;
    @FXML
    private Button insert_user_submit;
    @FXML
    private ToggleGroup insertuser_type;
    @FXML
    private CheckBox plans_calls_1;
    @FXML
    private CheckBox plans_calls_2;
    @FXML
    private CheckBox plans_calls_4;
    @FXML
    private TextField users_city;
    @FXML
    private TextField queries_4_messages;
    @FXML
    private TextField queries_1_k;
    @FXML
    private CheckBox queries_3_gt;
    @FXML
    private CheckBox plans_msg_1;
    @FXML
    private TextField queries_4_calls;
    @FXML
    private TextArea insertuser_address;
    @FXML
    private TextField changeplan_planid;
    @FXML
    private ToggleGroup insertuser_type1;
    @FXML
    private TextField plans_planid;
    @FXML
    private TextField queries_3_lt_value;
    @FXML
    private TextField queries_3_eq_value;
    @FXML
    private RadioButton insertuser_type_postpaid;
    @FXML
    private RadioButton insertuser_plan_planid;
    @FXML
    private RadioButton plans_type_postpaid;
    @FXML
    private TextField queries_2_k;
    @FXML
    private CheckBox queries_3_eq;
    @FXML
    private TextField queries_4_k;
    @FXML
    private TextField insertuser_city;
    @FXML
    private TextField queries_4_m;
    @FXML
    private TextField insertuser_plan_planid_value;
    @FXML
    private Button queries_submit;
    @FXML
    private ToggleGroup insertuser_gender;
    @FXML
    private TextField queries_4_data;
    @FXML
    private TextField insertuser_age;
    @FXML
    private CheckBox queries_4;
    @FXML
    private CheckBox plans_data_1;
    @FXML
    private CheckBox queries_3;
    @FXML
    private CheckBox queries_3_lt;
    @FXML
    private CheckBox queries_2;
    @FXML
    private CheckBox queries_1;
    @FXML
    private TextField changeplan_mobile;
    @FXML
    private Button plans_submit;
    @FXML
    private CheckBox queries_5;
    @FXML
    private TextField plans_price_from;
    @FXML
    private RadioButton insertuser_plan_basicplan;
    @FXML
    private RadioButton insertuser_gender_female;
    @FXML
    private TextField users_mobile;
    @FXML
    private TextField plans_price_to;
    @FXML
    private TextField insertuser_mobile;
    @FXML
    private Button users_submit;
    @FXML
    private TextField queries_3_gt_value;
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
             while(rs.next())
             	System.out.println(". "+rs.getString("pid"));
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
    	
    	ResultSet rs = null;
        Connection connection = null;
        Statement statement = null; 

        String query = "SELECT id,mobile FROM user_details natural join user natural join prepaid_account WHERE " + wclause+" UNION "
        		+ "SELECT id,mobile FROM user_details natural join user natural join postpaid_account WHERE " + wclause;
        System.out.println(query);
        try {           
            connection = JDBCConnect.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            //System.out.println("Total results found "+rs.getFetchSize());
            while(rs.next())
            	System.out.println(". "+rs.getString("id"));
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
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}

