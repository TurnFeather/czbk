package cn.itcast.el.functions;

public class MyFunctions {
	public static boolean contains(String strs[],String str)
	{
		boolean results = false;
		if (strs!=null && strs.length>0)
		{
			for (String s : strs)
			{
				if (s.equals(str))
				{
					results = true;
					break;
				}
			}
		}
		return results;
	}
}
