import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

//��ѯ���еļ�¼����ӡ������̨��
public class JDBCDemo2 {

	public static void main(String[] args) throws Exception {
		//1��������������ע������
		Class.forName("com.mysql.jdbc.Driver");		//�����ֽ��뵽�ڴ���ȥ��������Ҳ�ͻ�������еľ�̬����飬����Ҳ����Ȼ��Ȼ�����ˡ�
		//2����ȡ�����ݿ������
		//��ʽһ
		//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","root");
		//��ʽ��
		//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root");
		//��ʽ��
		Properties p = new Properties();
		p.setProperty("user", "root");
		p.setProperty("password", "root");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",p);
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
