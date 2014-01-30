package arrayStuff;

public class ID {
	
	private static String num;
	private static String id;
	private static String traf;
	
	String[][] nameID;
	
	public ID(){
		
	}
	
	public ID(String number, String ID, String transfer){
		num = number;
		id = ID;
		traf = transfer;
		//nameID = new String[num][id];
	}
	
	public static void testData(){
		System.out.println(num + " " + id + " " + traf);
	}

}
