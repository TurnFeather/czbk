import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

//查询所有的记录，打印刀控制台上
public class JDBCDemo2 {

	public static void main(String[] args) throws Exception {
		//1、加载驱动程序并注册驱动
		Class.forName("com.mysql.jdbc.Driver");		//加载字节码到内存中去，这样，也就会调用类中的静态代码块，驱动也就自然而然加载了。
		//2、获取与数据库的连接
		//方式一
		//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","root");
		//方式二
		//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root");
		//方式三
		Properties p = new Properties();
		p.setProperty("user", "root");
		p.setProperty("password", "root");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",p);
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
