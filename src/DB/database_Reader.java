package DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class database_Reader {
	
	ResultSet result = null;
	Statement queryCaller = null;
	Connection con = null;
	StringBuffer buff = null;
	private int logID;
	private int AccNum;
	
	
	
	
	
	public int getAccNum() {
		return AccNum;
	}

	public void setAccNum(int accNum) {
		AccNum = accNum;
	}

	public database_Reader() {
		
		MysqlDataSource ds = new MysqlDataSource();
		ds.setServerName("localhost");
		ds.setPort(3306);
		ds.setDatabaseName("madrassen");
		
		
		try {
			con = ds.getConnection("bank", "bank");
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
		
		
//		returntransactions();
		
		
		if(result != null){
			try{
				//System.out.println("\nBye Bye!");
				result.close();
			} catch (SQLException e){
				System.out.println("Warning: Could not close \"result\" ");
				
			}
		}
	
	}
	
	
	
	public void getUserAccount(String UserName){
		
		
		try {
			
			result = queryCaller.executeQuery("SELECT userID FROM user WHERE UserName = '" + UserName + "'");
			logID = result.getInt("userID");
			result.beforeFirst();
			result = queryCaller.executeQuery("SELECT AccountNumber FROM account WHERE userID = " + logID );
			AccNum = result.getInt("AccountNumber");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public Boolean login(String username, String password){
		String userN = username;
		String passW = password;
		
		boolean LoginValue = false;
		
		
		try {
			result = queryCaller.executeQuery("SELECT userID, UserName, PassWord FROM user ");
			result.beforeFirst();
			buff = new StringBuffer();			
					
			while(result.next()){	
				
				
				
				if(userN.equals(result.getString("userName")) && passW.equals(result.getString("passWord"))){
					
					getUserAccount(result.getString("userName"));
					LoginValue = true;
					
					
				
					
					
					
					
					
					
				}
				
				
			}
		
		} catch (SQLException e) {			
			//System.out.println("Welcome to my catch block \n" + e.getMessage());
			
		}
		
		return LoginValue;	
	}

public String returntransactions(){
		
		String xxx = null;
		String stuff = null;
		
		try {
			
			
//			result = queryCaller.executeQuery("SELECT TransactionsID, Amount, Date, TransactionText FROM transactions WHERE TransactionsID =  ");
			result = queryCaller.executeQuery("SELECT TransactionsID, Amount, Date, TransactionText FROM transactions WHERE AccountNumber = (SELECT AccountNumber FROM account WHERE userID = '3')");
			
			ResultSetMetaData resultInfo = result.getMetaData();
			int nCols = resultInfo.getColumnCount();
			result.beforeFirst();
			buff = new StringBuffer();
			while(result.next()){
				
				int id = result.getInt("TransactionsID");
				int cash = result.getInt("Amount");
				String datum = result.getString("Date");
				String distict = result.getString("TransactionText");
				
				//Display textPane
				
				xxx = id + " " + "\t" + cash + " " + "\t" + datum + "\t " + "\t" + distict + "\n";
				buff.append(xxx);
	
			}
			System.out.println(stuff);
			stuff = buff.toString();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println("SQL query failed! ");
		}
		
		return stuff;
	}

	
public void AddUser(String User, String Pass) { 
	Statement stmt = null;
			try {
				stmt = con.createStatement();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.getMessage();
			}
					
			try {
				stmt.executeUpdate("INSERT INTO user (UserName, PassWord) VALUES ('" + User + "','" + Pass + "')");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		
	}
	
public void SaveUsers(int Accnum, String AccName) { 
	Statement stmt = null;
			try {
				stmt = con.createStatement();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.getMessage();
			}
					
			try {
				stmt.executeUpdate("INSERT INTO savedrecivers (SavedAccountNumber, SavedAccountName) VALUES ('" + Accnum + "','" + AccName + "')");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		
	}

public void transaction(int recieversAccount, int amount, String transactionsText){
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	Date d = new Date();
	
	try (Statement stmt = con.createStatement()){
		
		con.setAutoCommit(false);
		
		stmt.executeUpdate("UPDATE account SET balance = balance - " + amount + " WHERE accountNumber = " + getAccNum());
		stmt.executeUpdate("UPDATE account SET balance = balance + " + amount + " WHERE accountNumber = " + recieversAccount);
		
		stmt .executeUpdate("INSERT INTO transactions (AccountNumber,Amount, Date, TransactionText) VALUES " + 
		"(" + AccNum + "," + "-" + amount + ",'" + dateFormat.format(d) + "'," + "'" + transactionsText + "'" + ")");
		
		stmt.executeUpdate("INSERT INTO transactions (AccountNumber,Amount, Date, TransactionText) VALUES " + 
		"(" + recieversAccount + "," + amount + ",'" + dateFormat.format(d) + "'," + "'" + transactionsText + "'"+ ")");	
	
		con.commit();
		
	} catch (SQLException e) {	
		
		try {
			con.rollback();
		} catch (SQLException e2) {
			System.err.println("WARNING! Failed to rollback money transfer! " + e2.getMessage());
		}
		System.err.println("Transaction failed" + e.getMessage());
	}
	try {
		con.setAutoCommit(true);
	} catch (SQLException e) {
		System.err.println("Failed to turn on autocommit. " + e.getMessage());
	}
}
}
