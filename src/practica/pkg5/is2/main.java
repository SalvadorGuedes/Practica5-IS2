package practica.pkg5.is2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class main {

  public static void main( String args[] ) throws ClassNotFoundException, SQLException{
      Class.forName("org.sqlite.JDBC");
      Connection c = DriverManager.getConnection("jdbc:sqlite:KATADB");
      
      Statement stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery("Select * FROM PEOPLE");
      
      while(rs.next()){
          System.out.println("ID= "+ rs.getInt("ID"));
          System.out.println("NAME= "+ rs.getString("NAME"));
      }
      
      stmt = c.createStatement();
      String sql = "CREATE TABLE COMPANY " +
                   "(ID INT PRIMARY KEY     NOT NULL," +
                   " NAME           TEXT    NOT NULL, "; 
      
      rs.close();
      stmt.close();
      c.close();
  }
}
