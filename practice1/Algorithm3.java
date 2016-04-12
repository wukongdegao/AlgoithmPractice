package practice1;

import java.util.*;

/*
 * 3. Implement Quicksort and Randomized Quicksort. 
 * 
 * @author 袁点 13130110031
 */

public class Algorithm3 
{

	public static void main(String[] args) 
	{
		Scanner in=new Scanner(System.in);
		System.out.println("please input your Integer:");
		String get=in.nextLine();
		
		//将输入数字作为字符数组存储
		String[] str=get.split("\\D");
		int[] S=new int[str.length];
		
		//将字符串转化为数字储存
		for(int i=0;i<S.length;i++)
			S[i]=Integer.parseInt(str[i]);
		
		//拷贝一个新的数组作为随机快排使用
		int[] copiedS=Arrays.copyOf(S, S.length);
		
		//快排结果
		quickSort(S, 0, S.length-1);
		System.out.println("quickSort result:");
		for(int a:S)
			System.out.print(a+" ");
		
		//随机化快排结果
		Random_quickSort(copiedS, 0, copiedS.length-1);
		System.out.println();
		System.out.println("Random_quickSort result:");
		for(int a:copiedS)
			System.out.print(a+" ");
		in.close();


	}
	
	//快速排序
	public static void quickSort(int[] S,int p,int r)
	{
		if(p<r)
		{
			int q=partition(S, p, r);
			quickSort(S, p, q-1);
			quickSort(S, q+1, r);
		}
		
	}
	
	//对数组的原址重排
	public static int partition(int[] S,int p,int r)
	{
		int x=S[r];
		int i=p-1;
		for(int j=p;j<r;j++)
		{
			if(S[j]<=x)
			{
				i+=1;
				swap(S, i, j);
			}
		}
		swap(S, i+1, r);
		return i+1;
	}
	
	//随机化快速排序
	public static void Random_quickSort(int[] S,int p,int r)
	{
		if(p<r)
		{
			int q=Random_partition(S, p, r);
			Random_quickSort(S, p, q-1);
			Random_quickSort(S, q+1, r);
		}
	}
	
	//随机化原址重排
	public static int Random_partition(int[] S,int p,int r)
	{
		//抽取随机数
		int i=p+(int)(Math.random()*(r-p+1));
		swap(S, r, i);
		return partition(S, p, r);
	}
	
	
	//交换数组中元素
	public static void swap(int[] S,int a,int b)
	{
		int temp=S[a];
		S[a]=S[b];
		S[b]=temp;
	}
	
}