import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//��ѯ���еļ�¼����ӡ������̨��
public class JDBCDemo1 {

	public static void main(String[] args) throws SQLException {
		//1��������������ע������
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		//2����ȡ�����ݿ������
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","root");
		//3���õ�����SQL���Ķ��󣬲����͸����ݿ�
		 Statement st = connection.createStatement();
		//4������в�ѯ������õ���װ�˲�ѯ����Ķ���
		 ResultSet rs = st.executeQuery("select id,name,chinese,english,math from student");
		//5���������
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
