package practice3;


/*
 * 1.0-1 knapsack problem. 
 *Instance : weight capacity is 100
 *item	weights	values
 *A		50		200
 *B		30		180
 *C		45		225
 *D		25		200
 *E		5		50
 *
 *@author by Ԭ�� 13130110031
 */

public class Algorithm3_1 
{

	public static void main(String[] args) 
	{
		int[] weight={0,50,30,45,25,5};
		int[] value={0,200,180,225,200,50};
		knapsack0_1(weight, value, 100);

	}

	//0-1��������
	public static void knapsack0_1(int[] weight,int[] value,int capacity)
	{
		int numbers=weight.length-1;
		//c[i][j]�������浱��ѡ��ǰi����Ʒ�������jʱ��ѡ�������ֵ��
		int[][] c=new int[numbers+1][capacity+1];
		//s��ʾ��ǰ����Ƿ�ѡ�У�1��ʾѡ��
		int[][] s=new int[numbers+1][capacity+1];
		
		//c[i][j]=max(c[i-1][j],c[i-1][j-w[i]]+v[i])
		for(int i=1;i<=numbers;i++)
		{
			for(int j=0;j<=capacity;j++)
			{
				if(j<weight[i])
				{
					c[i][j]=c[i-1][j];
					s[i][j]=0;
				}
				else if(c[i-1][j-weight[i]]+value[i]>c[i-1][j])
				{
					c[i][j]=c[i-1][j-weight[i]]+value[i];
					s[i][j]=1;
				}
				else
				{
					c[i][j]=c[i-1][j];
					s[i][j]=0;
				}
			}
		}
		
		//�������ӡ����
		System.out.println("����ֵΪ"+c[weight.length-1][capacity]);
		System.out.print("ѡ��");
		for(int i=numbers,j=capacity;i>0;i--)
		{
			if(s[i][j]==1)
			{
				System.out.print(i+"��");
				j=j-weight[i];
			}
		}
	}
	
}


