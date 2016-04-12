package practice2;

/*
 * 3.Problem description
 * Max Sum of the array. The following are some instances:(-2,11,-4,13,-5,-2),
 * the max sum is 20
 * 
 * @author by 袁点 13130110031
 */

public class Algorithm3 
{

	public static void main(String[] args) 
	{
		int[] result;
		int[] n={-2,11,-4,13,-5,-2};
		result=maxSumOfArray(n);
		System.out.print("最大子数组为:");
		printArray(n, result);
		System.out.println("和为："+result[0]);

	}
	
	//用带两个元素的数组保存运算结果，一个储存最大子数组和，一个储存此子数组尾编号
	public static int[] maxSumOfArray(int[] n)
	{
		int[] result=new int[2];
		
		//sum储存和，i储存编号
		int Sum,i;
		Sum=n[0];
		i=0;
		result[0]=Sum;
		
		//以第i个元素结尾的最大子数组sum[i]其组成要么是以第i-1个元素结尾的最大子数组加上n[i]：
		//sum[i-1]+n[i]，要么//是只包含n[i]，取决于sum[i-1]是否大于0
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
