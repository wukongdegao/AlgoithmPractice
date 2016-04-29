package practice1;

import java.util.*;

/*
 * 3. Implement Quicksort and Randomized Quicksort. 
 * 
 * @author Ԭ�� 13130110031
 */

public class Algorithm3 
{

	public static void main(String[] args) 
	{
		Scanner in=new Scanner(System.in);
		System.out.println("please input your Integer:");
		String get=in.nextLine();
		
		//������������Ϊ�ַ�����洢
		String[] str=get.split("\\D");
		int[] S=new int[str.length];
		
		//���ַ���ת��Ϊ���ִ���
		for(int i=0;i<S.length;i++)
			S[i]=Integer.parseInt(str[i]);
		
		//����һ���µ�������Ϊ�������ʹ��
		int[] copiedS=Arrays.copyOf(S, S.length);
		
		//���Ž��
		quickSort(S, 0, S.length-1);
		System.out.println("quickSort result:");
		for(int a:S)
			System.out.print(a+" ");
		
		//��������Ž��
		Random_quickSort(copiedS, 0, copiedS.length-1);
		System.out.println();
		System.out.println("Random_quickSort result:");
		for(int a:copiedS)
			System.out.print(a+" ");
		in.close();


	}
	
	//��������
	public static void quickSort(int[] S,int p,int r)
	{
		if(p<r)
		{
			int q=partition(S, p, r);
			quickSort(S, p, q-1);
			quickSort(S, q+1, r);
		}
		
	}
	
	//�������ԭַ����
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
	
	//�������������
	public static void Random_quickSort(int[] S,int p,int r)
	{
		if(p<r)
		{
			int q=Random_partition(S, p, r);
			Random_quickSort(S, p, q-1);
			Random_quickSort(S, q+1, r);
		}
	}
	
	//�����ԭַ����
	public static int Random_partition(int[] S,int p,int r)
	{
		//��ȡ�����
		int i=p+(int)(Math.random()*(r-p+1));
		swap(S, r, i);
		return partition(S, p, r);
	}
	
	
	//����������Ԫ��
	public static void swap(int[] S,int a,int b)
	{
		int temp=S[a];
		S[a]=S[b];
		S[b]=temp;
	}
	
}