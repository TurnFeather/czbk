package cn.itcast.jdbc.lob;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import cn.itcast.util.JdbcUtil;

//大文本的存取
/*
 use day15;
 create table t1(
 	id int primary key,
 	content longtext
 );
 */
public class ClobDemo 
{
	@Test
	public void testAdd()
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement("insert into t1(id,content) values(?,?)");
			stmt.setInt(1, 1);
			//大数据要使用流的形式
			File file = new File("D:/jpm.txt");
			Reader reader = new FileReader(file);
			stmt.setCharacterStream(2, reader, (int)file.length());	//不能使用long的参数，因为mysql根本支持不到那么大的数据，就没有实现
			int i = stmt.executeUpdate();
			if (i > 0)
			{
				System.out.println("插入成功");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.release(null, stmt, conn);
		}
	}
	@Test
	public void testRead()
	{
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			st = conn.prepareStatement("select * from t1 where id=1");
			rs = st.executeQuery();
			if (rs.next())
			{
				Reader r = rs.getCharacterStream(2);
				Writer w = new FileWriter("E:/haha.txt");
				char cbuf[] = new char[1024];
				int len = 0;
				while ((len = r.read(cbuf)) != -1)
				{
					w.write(cbuf, 0, len);
				}
				r.close();
				w.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.release(rs, st, conn);
		}
	}
}
