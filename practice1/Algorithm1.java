package practice1;

import java.util.*;

/*
 * 1��Describe a ��(n lg n)-time algorithm that, given a set S of n 
 *    integers and another integer x, determines whether or not there 
 *    exist two elements in S whose sum is exactly x.
 *    
 *@author Ԭ��   13130110031
 */

public class Algorithm1 {

	public static void main(String[] args) 
	{
		Scanner in=new Scanner(System.in);
		System.out.println("please input Integers in S:");
		String get=in.nextLine();
		//������������Ϊ�ַ�����洢
		String[] str=get.split("\\D");
		int[] S=new int[str.length];
		
		//���ַ���ת��Ϊ���ִ���
		for(int i=0;i<S.length;i++)
			S[i]=Integer.parseInt(str[i]);
		
		System.out.println("the x that you want to know if exist "
		           + "two elements in S whose sum is exactly x");
		
		int x=in.nextInt();
		if(!twoElementSumIsX(S, 0, S.length-1, x))
			System.out.println("not exist");
		in.close();	
	}
	
	//�ڳ��ȴ�p��r��S�����в����Ƿ��������Ԫ��֮��ΪX
	public static boolean twoElementSumIsX(int[] S,int p,int r,int x)
	{
		//���Ƚ�S����
		priorityQueue A=new priorityQueue(S);
		S=A.heapSort();
		for(int i=0;i<S.length;i++)
		{
			if(search(S, i, S.length-1, x-S[i]))
			{
				System.out.println("two element sum is x:");
				System.out.println(S[i]+" and "+(x-S[i]));
				return true;
			}
		}
		return false;
	}
	
	//���ַ�����ָ����Χ������
	public static boolean search(int[] S,int left,int right,int x)
	{
		if(S==null) return false;
		while(left<=right)
		{
			int mid=(left+right)/2;
			if(S[mid]==x) return true;
			else if(S[mid]<x)
				left=mid+1;
			else
				right=mid-1;
		}
		return false;
	}
	

}
