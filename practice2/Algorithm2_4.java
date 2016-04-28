package practice2;

/*
 * 4.Problem description
 * Longest Common Substring. The following are some instances.
 * a) X: xzyzzyx  Y: zxyyzxz
 * b) X: ALLAAQANKESSSESFISRLLAIVAD
 * Y: KLQKKLAETEKRCTLLAAQANKENSNESFISRLLAIVAG
 * 
 * @author by Ԭ�� 13130110031
 */

public class Algorithm2_4 
{

	public static void main(String[] args) 
	{
		int[] result;
		String X1="xzyzzyx",Y1="zxyyzxz";
		String X2="ALLAAQANKESSSESFISRLLAIVAD",Y2="KLQKKLAETEKRCTLLAAQANKENSNESFISRLLAIVAG";
		result=LC_Substring(X1, Y1);
		printCommonArray(X1, result);
		result=LC_Substring(X2, Y2);
		printCommonArray(X2, result);
		

	}
	
	//�����鱣��õ������������һ��������������ַ������ȣ�һ����������ַ�����β���
	public static int[] LC_Substring(String X,String Y)
	{
		int[] result=new int[2];
		int length=result[0],number=result[1];
		
		int m=X.length(),n=Y.length();
		
		//L[i][j]����ֱ���X[i-1]��Y[j-1]��β�����ַ������ȣ�number�����β�����XΪ��׼
		int[][] L=new int[m+1][n+1];
		//int[][] s=new int[m+1][n+1];
		
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				//��ĩβ���ȣ��򲻴�������������β�Ĺ����ַ�������ŵ�����һ������
				if(X.charAt(i-1)!=Y.charAt(j-1))
					L[i][j]=0;					
				else
					L[i][j]=L[i-1][j-1]+1;
				
				if(L[i][j]>length)
				{
					length=L[i][j];
					number=i-1;
				}	
			}		
		}
		
		result[0]=length;
		result[1]=number;
		
		return result;
	}
	
	//��ӡ������ַ���
	public static void printCommonArray(String X,int[] result)
	{
		int length=result[0];
		int number=result[1];
		System.out.println(X.substring(number-length+1, number+1));
	}

}
