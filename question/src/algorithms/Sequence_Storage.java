package algorithms;

import java.util.Arrays;

public class Sequence_Storage {
/*
	public static void main(String[] args) 
	{
	
		String a = new String("大家好");
		System.out.println(a);
		change(a);
		System.out.println(a);
		final int b = 10;
	
		//System.out.println(sum(100));
		
		String a = "abcd";
		String b = "abcd";
		System.out.println(a == b);
		
		String c = new String("abcd");
		String d = new String("abcd");
		System.out.println(c == d);
	
		String str = "abcedfghijk";
		int i = str.length();
		for(i=i-1;i>=0;i--)
			System.out.println(str.charAt(i));
	
		int value[] = {10,20,30,40};
		for ( int var : value)
		{
			System.out.println(var);
		}
	
		String str = "Hello My name is yurongcheng";
		char array[] = str.toCharArray();
		char array2[] = new char[20];
		array2 = Arrays.copyOfRange(array, 5, 5+10);
		for (char c : array2)
			System.out.println(c);
	
		int t[] = {23,12,4,5,44,65,23,54,32,67};
		for (int i=9;i>=0;i--)
			for(int j=0;j<i;j++)
			{
				if(t[j] > t[j+1])
				{
					int temp = t[j+1];
					t[j+1] = t[j];
					t[j] = temp;
				}
			}
		for(int var : t){
			System.out.println(var);
		}
		
	}
*/
	public static int aMethod(int i)throws Exception
    {
        try{
            return i / 10;
        }
        catch (Exception ex)
        {
            throw new Exception("exception in a Method");
        } finally{
            System.out.printf("finally");
        }
    }
 
    public static void main(String [] args)
    {
        try
        {
            aMethod(0);
        }
        catch (Exception ex)
        {
            System.out.printf("exception in main");
        }
        System.out.printf("finished");
    }
	public static void change(String str)
	{
		str = "我改变了吗?";
	}
	
	public static int BF_Index(char[]s,char []t,int pos)
	{
		int i = pos,j = 1;
		int area = s[0] - t[0] + 1;
		while(i <= area && j <= t[0])	//第一次改进
		{
			if (s[i] == t[j])
			{
				++i;				//继续比较后面的字符
				++j;
			}
			else
			{
				i = i - j + 2;		//指针后1格重新开始匹配
				j = 1;
			}
		}
		if (j > t[0])				//t中对应的字符比较完了。
			return i - t[0];
		else
			return 0;
	}
	
	public static int sum(int n)
	{
		return n == 0 ? 0 : n + sum(n-1);
	}
}
