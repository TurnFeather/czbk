import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//查询所有的记录，打印刀控制台上
public class JDBCDemo1 {

	public static void main(String[] args) throws SQLException {
		//1、加载驱动程序并注册驱动
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		//2、获取与数据库的连接
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","root");
		//3、得到代表SQL语句的对象，并发送给数据库
		 Statement st = connection.createStatement();
		//4、如果有查询结果，得到封装了查询结果的对象
		 ResultSet rs = st.executeQuery("select id,name,chinese,english,math from student");
		//5、遍历结果
		 while (rs.next())
		 {
			 System.out.println("*******************************************************");
			 System.out.println(rs.getObject("id"));
			 System.out.println(rs.getObject("name"));
			 System.out.println(rs.getObject("chinese"));
			 System.out.println(rs.getObject("english"));
			 System.out.println(rs.getObject("math"));
		 }
		 rs.close();
		 st.close();
		 connection.close();
	}

}
