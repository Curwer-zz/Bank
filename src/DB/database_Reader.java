package DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class database_Reader {
	
	ResultSet result = null;
	Statement queryCaller = null;
	Connection con = null;
	StringBuffer buff = null;
	
	public Boolean login(String username, String password){
		String userN = username;
		String passW = password;
		boolean LoginValue = false;
		String GetUsern = null;
		String GetPassW = null;
		
		
		try {
			result = queryCaller.executeQuery("SELECT userName, passWord FROM user");
			ResultSetMetaData resultInfo = result.getMetaData();
			int nCols = resultInfo.getColumnCount();
			result.beforeFirst();
			buff = new StringBuffer();
					
			while(result.next()){	
				if(userN.equals(result.getString("passWord")) && passW.equals(result.getString("passWord"))){
					LoginValue = true;
				}
				
			}
			
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		return LoginValue;
		
		
	}

	public String returntransactions(){
		
		String xxx = null;
		String stuff = null;
		
		try {
			
			result = queryCaller.executeQuery("SELECT transactionsID, amount, date, TransactionText, AccID FROM transactions");
			
			ResultSetMetaData resultInfo = result.getMetaData();
			int nCols = resultInfo.getColumnCount();
			result.beforeFirst();
			buff = new StringBuffer();
			while(result.next()){
				
				int id = result.getInt("transactionsID");
				int cash = result.getInt("amount");
				String datum = result.getString("date");
				String distict = result.getString("TransactionText");
				int accID = result.getInt("AccID");
				
				//Display textPane
				
				xxx = "ID: " + id + " " + "\nAmount: " + cash + " " + "\nDate: " + datum + " " + "\nAccountID: " + accID + "\nTransactionText: " + distict + "\n";
				buff.append(xxx);
	
			}
			
			stuff = buff.toString();
//			
//			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL query failed! ");
		}
		
		return stuff;
	}
	
	public database_Reader() {
		
		MysqlDataSource ds = new MysqlDataSource();
		ds.setServerName("localhost");
		ds.setPort(3306);
		ds.setDatabaseName("mydb");
		
		
		try {
			con = ds.getConnection("", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Error: Couldn´t connect.. " + e.getMessage());
			return;
		}
		
		//System.out.println("Connection successfull!!!");
		
		
		try {
			queryCaller = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Error! Could not create statment. ");
			try{
				con.close();
			} catch (SQLException e1){
				System.err.println("Warning");
			}
			return;
		}
		
		//System.out.println("Create statment successful! ");
		
		
		returntransactions();
		
		
		if(result != null){
			try{
				//System.out.println("\nBye Bye!");
				result.close();
			} catch (SQLException e){
				System.out.println("Warning: Could not close \"result\" ");
				
			}
		}
	
	}
}
