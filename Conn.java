
/* JDBC Conectivity

1- Register the driver
2- create connection
3- create statement
4-
5-

*/

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;
  public Conn(){

  
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
     c = DriverManager.getConnection("jdbc:mysql:///bankManagementSystem", "root", "oracle");
     s= c.createStatement();

    } catch (Exception e){
        System.out.println(e);
    }
}
}