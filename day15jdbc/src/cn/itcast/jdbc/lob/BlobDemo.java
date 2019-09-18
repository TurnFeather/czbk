package cn.itcast.jdbc.lob;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import cn.itcast.util.JdbcUtil;

//大二进制数据的存取
/*
 	create table t2(
 		id int primary key,
 		content longblob
 	);
 */
public class BlobDemo {
	@Test
	public void test1()
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement("insert into t2(id,content) values(?,?)");
			stmt.setInt(1, 1);
			InputStream in = new FileInputStream("D:/壁纸1.jpg");
			stmt.setBinaryStream(2, in, in.available());
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
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement("select * from t2 where id=1");
			rs = stmt.executeQuery();
			InputStream in = null;
			OutputStream out = new FileOutputStream("E:/aaa.jpg");
			if (rs.next())
			{
				in = rs.getBinaryStream(2);
				int len = -1;
				byte[] b = new byte[1024];
				while ((len = in.read(b)) != -1)
				{
					out.write(b, 0, len);
				}
				in.close();
				out.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.release(rs, stmt, conn);
		}
	}
}
