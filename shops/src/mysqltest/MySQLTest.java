package mysqltest;
import java.sql.*;

import java.util.ArrayList;



public class MySQLTest{

    private Connection connection;

    // コンストラクタで Connection 初期化
    public MySQLTest() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    	connection = DriverManager.getConnection(
    			"jdbc:mysql://localhost:3306/shop?characterEncoding=UTF-8&serverTimezone=JST","shop","shop");
        
    }
    public void insert(String name,String pass) throws SQLException {
        String sql = "INSERT INTO shop.test values ('"+name+"', '"+pass+"')";

        connection.createStatement().executeUpdate(sql);
    }
    public ArrayList select() throws SQLException {
    	ArrayList list = new ArrayList();
        String sql = "SELECT * FROM shop.test";

        ResultSet resultSet = connection.createStatement().executeQuery(sql);

        while (resultSet.next()) {
           Bean b = new Bean();
           

           b.setName(resultSet.getString(1));
            b.setPass(resultSet.getString(2));
           
            list.add(b);
        }
        

        return list;
    }
    public void close() throws SQLException{
    	connection.close();
    }

  }

