package cn.itcast.base.generic;

public class GenericUtil 
{
	public static <T> void m1(T[] t,int i,int j)
	{
		T temp;
		temp = t[i];
		t[i] = t[j];
		t[j] = temp;
	}
	//0 1 2 
	public static <T> void reverse(T[] t)
	{
		//by myself
		/*
		int len = t.length;
		T temp;
		for (int i=0;i<len/2;i++)
		{
			temp = t[i];
			t[i] = t[len - i - 1];
			t[len - i - 1] = temp;
		}*/
		
		int startIndex = 0;
		int endIndex = t.length - 1;
		while(startIndex < endIndex)
		{
			T temp = t[startIndex];
			t[startIndex] = t[endIndex];
			t[endIndex] = temp;
			startIndex++;
			endIndex--;
		}
	}
}
