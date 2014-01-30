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

	public String returntransactions(){
		
		String xxx = null;
		String stuff = null;
		
		try {
			
			result = queryCaller.executeQuery("SELECT ID, Name, CountryCode, District, Population FROM City");
			
			ResultSetMetaData resultInfo = result.getMetaData();
			int nCols = resultInfo.getColumnCount();
			result.beforeFirst();
			buff = new StringBuffer();
			while(result.next()){
				
				int id = result.getInt("ID");
				String name = result.getString("Name");
				String code = result.getString("CountryCode");
				String distict = result.getString("District");
				int pop = result.getInt("Population");
				
				//display
				
//				System.out.println("ID: " + id);
//				System.out.println("Name: " + name);
//				System.out.println("CountryCode: " + code);
//				System.out.println("District: " + distict);
//				System.out.println("Population: " + pop);
				
				//Display textPane
				
				xxx = "ID: " + id + " " + "\tName: " + name + " " + "\nCountryCode: " + code + " " + "\nDistrict: " + distict + " " + "\nPopulation: " + pop +"\n";
				//buff.append(xxx);
	
			}
			
			//stuff = buff.toString();
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
		ds.setDatabaseName("world");
		
		
		try {
			con = ds.getConnection("root", "fiskcarre1");
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
