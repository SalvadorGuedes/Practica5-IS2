package practica.pkg5.is2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MailListReaderDDBB {
    public static ArrayList<String> read () throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
        ArrayList <String> mailList = new ArrayList<>();
        
        Class.forName("org.sqlite.JDBC");
        Connection c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Salvador\\Documents\\0-Salvador\\ULPGC\\TERCERO\\Netbeans\\Practica 4 IS2\\KATADB");

        Statement stmt = c.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM MAILS");

        while(rs.next()){
            mailList.add(rs.getString("MAIL"));
        }


        rs.close();
        stmt.close();
        c.close();
        return mailList;
    }
}
