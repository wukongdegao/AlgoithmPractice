package practice2;

/*
 * 2.Problem description
 * Longest Common Subsequence (LCS). The following are some instances��
 * a) X: xzyzzyx  Y: zxyyzxz
 * b) X: ALLAAQANKESSSESFISRLLAIVAD
 * Y: KLQKKLAETEKRCTLLAAQANKENSNESFISRLLAIVAG
 * 
 * @author by Ԭ�� 13130110031
 */

public class Algorithm2 
{

	public static void main(String[] args) 
	{
		int[][][] result;
		String X1="xzyzzyx",Y1="zxyyzxz";
		String X2="ALLAAQANKESSSESFISRLLAIVAD",Y2="KLQKKLAETEKRCTLLAAQANKENSNESFISRLLAIVAG";
		
		result=LCS_Length(X1, Y1);
		printLCS(result[0], X1,  X1.length(), Y1.length());
		System.out.println();
		
		result=LCS_Length(X2, Y2);
		printLCS(result[0], X2,  X2.length(), Y2.length());
		System.out.println();
	}
	
	//����LCS���ȣ���һ����ά���鷵�ؼ���Ķ�Ӧ���Ž����ӦLCS����
	public static int[][][] LCS_Length(String X,String Y)
	{
		int[][][] result=new int[2][][];
		int m=X.length(),n=Y.length();
		
		//b�������Ž⣬c���泤��
		int[][] b=new int[m+1][n+1];
		int[][] c=new int[m+1][n+1];
		
		for(int i=1;i<=m;i++)
			c[i][0]=0;
		for(int j=1;j<=n;j++)
			c[0][j]=0;
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				//b�в�ͬ��ȡֵ�ڽ�����б�ʾ��ָͬ��1ָ�����ϣ��ұ�ʾ��Ӧ����LCS��Ԫ�أ�
				//2ָ���Ϸ���0ָ����ߣ���ѡ��
				if(X.charAt(i-1)==Y.charAt(j-1))
				{
					c[i][j]=c[i-1][j-1]+1;
					b[i][j]=1;
				}
				
				else if(c[i-1][j]>=c[i][j-1])
				{
					c[i][j]=c[i-1][j];
					b[i][j]=2;
				}
				
				else
				{
					c[i][j]=c[i][j-1];
					b[i][j]=0;
				}
			}
		}
		
		result[0]=b;
		result[1]=c;
		return result;
	}
	
	
	//���ݼ�����Ľ����ӡ��LCS
	public static void printLCS(int[][] b,String X,int i,int j)
	{
		if(i==0||j==0)
			return;
		
		if(b[i][j]==1)
		{
			printLCS(b, X, i-1, j-1);
			System.out.print(X.charAt(i-1));
		}
		
		else if(b[i][j]==2)
			printLCS(b, X, i-1, j);
		
		else 
			printLCS(b, X, i, j-1);
		
	}

}
