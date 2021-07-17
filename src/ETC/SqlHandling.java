package ETC;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class SqlHandling {

    public SqlHandling() {}


    public static void main(String[] args) {
        getconnection();
    }

    public static void readData()
    {

        try {
            Connection c=getconnection();
            Statement statement=c.createStatement();
            statement.executeUpdate("TRUNCATE  usernameAndPassword");
            statement.executeUpdate("DELETE FROM usernameAndPassword");



        }
        catch (Exception e)
        {
            System.out.println(e);
        }


        try {
            Scanner scanner=new Scanner(new File("password.txt"));
            while(scanner.hasNextLine())
            {
                String username="";
                String password="";
                username= scanner.nextLine();
                password= scanner.nextLine();
                if((username.length()==0)||(password.length()==0))
                    continue;
                else
                {

                    post(username,password);

                }



            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    public static Connection getconnection()
    {
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/farmfrenzy";
        String username="meiEEsam";
        String password="jicdqrzjicdqrz.2002";
        try {
            Class.forName(driver);
            Connection conn= DriverManager.getConnection(url,username,password);

            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



        return null;
    }
    public static void createTable()
    {

        try {
            Connection con = getconnection();
            PreparedStatement create =con.prepareStatement("CREATE TABLE IF NOT EXISTS usernameAndPassword(id int NOT NULL AUTO_INCREMENT,username varchar(45),password varchar(45),PRIMARY KEY(id))");
            create.executeUpdate();


        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        finally {
            System.out.println("successful");
        }





    }
    public static void post(String username,String password)
    {



        try {
            Connection con = getconnection();
            PreparedStatement posted = con.prepareStatement("INSERT INTO usernameAndpassword (username,password) VALUES ('" + username + "','" + password + "')");
            posted.executeUpdate();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }


    }

    public  static void delete(){









    }




}
