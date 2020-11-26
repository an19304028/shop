package mysqltest;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.math.BigDecimal;


class Test{
	
	public static void main(String[] args){
	
		selectTest();
	}
	
	public static void selectTest(){
		try{
			//Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracleに接続する
			/*Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
				"gogo","nono");
			*/
			
			/*Connection cn = DriverManager.getConnection(
			"jdbc:mysql://localhost/orcl?useSSL=false",
			"info","pro");
			*/
			
			Connection cn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/world?characterEncoding=UTF-8&serverTimezone=JST",
			"info","pro");
			
			
			
			System.out.println("接続完了");
			
			//select文
			String sql=" SELECT * FROM city where ID <= 5000;";

			//Statementインターフェイスを実装するクラスをインスタンス化する
			Statement st=cn.createStatement();

			//select文を実行し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			ResultSet rs=st.executeQuery(sql);

			//カーソルを一行だけスクロールし、データをフェッチする
			System.out.println("Name"+"\t"+"CountryCode"+"\t"+"District"+"\t"+"Population");
			int count = 0;
			while(rs.next()){
				String name=rs.getString (2);	//1列目のデータを取得
				String cc=rs.getString(3);	//2列目のデータを取得
				String district =rs.getString(4);	//3列目のデータを取得
				String population = rs.getString(5);
				count++;

				System.out.println(name+"\t"+cc+"\t"+district+"\t"+population);
			}
			System.out.println(count+"行選択されました");
			
			//Oracleから切断する
			cn.close();

			System.out.println("切断完了");
		/*}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("クラスがないみたい。");
		*/}catch(SQLException e){
			e.printStackTrace();
			System.out.println("SQL関連の例外みたい。");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
