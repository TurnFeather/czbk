import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class Test
{
	public static void main(String []args) throws FileNotFoundException, IOException
	{
		Properties props = System.getProperties();
		System.out.println(props.size());
		Set<Entry<Object,Object>> set = props.entrySet();
		Iterator<Entry<Object, Object>> iterator = set.iterator();
		while (iterator.hasNext()){
			Entry<Object, Object> entry = iterator.next();
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
		
		props.store(new FileOutputStream("D:\\abc.txt"), "content");
	}
}