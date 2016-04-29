package practice2;

/*
 * 3.Problem description
 * Max Sum of the array. The following are some instances:(-2,11,-4,13,-5,-2),
 * the max sum is 20
 * 
 * @author by Ԭ�� 13130110031
 */

public class Algorithm3 
{

	public static void main(String[] args) 
	{
		int[] result;
		int[] n={-2,11,-4,13,-5,-2};
		result=maxSumOfArray(n);
		System.out.print("���������Ϊ:");
		printArray(n, result);
		System.out.println("��Ϊ��"+result[0]);

	}
	
	//�ô�����Ԫ�ص����鱣����������һ���������������ͣ�һ�������������β���
	public static int[] maxSumOfArray(int[] n)
	{
		int[] result=new int[2];
		
		//sum����ͣ�i������
		int Sum,i;
		Sum=n[0];
		i=0;
		result[0]=Sum;
		
		//�Ե�i��Ԫ�ؽ�β�����������sum[i]�����Ҫô���Ե�i-1��Ԫ�ؽ�β��������������n[i]��
		//sum[i-1]+n[i]��Ҫô//��ֻ����n[i]��ȡ����sum[i-1]�Ƿ����0
		for(int j=1;j<n.length;j++)
		{
			if(Sum>0)
				Sum+=n[j];
			else
				Sum=n[j];
			if(Sum>result[0])
			{
				result[0]=Sum;
				i=j;
			}
		}
		result[1]=i;
		return result;
	}
	
	public static void printArray(int[] n,int[] result)
	{
		int j=result[1]+1;
		int s=0;
		do
		{
			j--;
			s+=n[j];
		}while(s!=result[0]);
		
		for(;j<=result[1];j++)
			System.out.print(n[j]+" ");;
		System.out.println();
	}
}
