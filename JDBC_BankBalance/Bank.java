import java.sql.*;
import java.io.*;
class Bank{
    public static void main(String[] args) {
        String Driver="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/bankbalance";
        String username="root";
        String password="sql834";
	try{
          InputStreamReader i=new InputStreamReader(System.in);
	  BufferedReader b=new BufferedReader(i);
	  System.out.println("Enter UserId : ");
	  String userid=b.readLine();
	  System.out.println("Enter Password : ");
	  String pwd=b.readLine();
        Class.forName(Driver);
    	Connection con=DriverManager.getConnection(url,username,password);
    	Statement stmt=con.createStatement();
String qry="select balance from balance where userid='"+userid+"'and password='"+pwd+"'";
    	ResultSet res=stmt.executeQuery(qry);
	if(res.next()){
		System.out.print(res.getDouble(1));
	}else{
		System.out.println("Invalid Credentials");
}
	    con.close();
    
	}
	catch(Exception e){
	System.out.println(e); 
	}
}
}