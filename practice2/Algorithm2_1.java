package practice2;

/*
 * 1.Problem description
 * Matrix-chain product. The following are some instances:
 * a) <3, 5, 2, 1,10>
 * b) <2, 7, 3, 6, 10>
 * c) <10, 3, 15, 12, 7, 2> 
 * d) <7, 2, 4, 15, 20, 5>
 * 
 * @author by 袁点 13130110031
 */

public class Algorithm2_1 
{

	public static void main(String[] args) 
	{
		int result[][][];
		int a[]={3, 5, 2, 1,10};
		int b[]={2, 7, 3, 6, 10};
		int c[]={10, 3, 15, 12, 7, 2};
		int d[]={7, 2, 4, 15, 20, 5};
		
		//分别打印abcd矩阵链的最优解
		result=MatrixChainOrder(a);
		System.out.print("a:");
		PrintOptimalParens(result[1], 1, a.length-1);
		System.out.println();
		
		result=MatrixChainOrder(b);
		System.out.print("b:");
		PrintOptimalParens(result[1], 1, b.length-1);
		System.out.println();
		
		result=MatrixChainOrder(c);
		System.out.print("c:");
		PrintOptimalParens(result[1], 1, c.length-1);
		System.out.println();
		
		result=MatrixChainOrder(d);
		System.out.print("d:");
		PrintOptimalParens(result[1], 1, d.length-1);
		System.out.println();

	}
	
	//用一个三维数组保存得到的两个二维数组，第一个保存代价，第二个记录对应最优值时的切割点
	public static int[][][] MatrixChainOrder(int[] p)
	{
		//m储存代价，s记录切割点
		int n=p.length-1;
		int[][] m=new int[n+1][n+1];
		int[][] s=new int[n+1][n+1];
		int[][][] result=new int[2][][];
		//长度为1的链代价为0
		for(int i=1;i<=n;i++)
			m[i][i]=0;
		
		//L为链长度
		for(int L=2;L<=n;L++)
		{
			for(int i=1;i<=n-L+1;i++)
			{
				int j=i+L-1;
				m[i][j]=Integer.MAX_VALUE;
				for(int k=i;k<j;k++)
				{
					int q=m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
					if(q<m[i][j])
					{
						m[i][j]=q;
						s[i][j]=k;
					}
				}
			}
		}
		
		result[0]=m;
		result[1]=s;
		return result;
	}
	
	//递归打印最优解
	public static void PrintOptimalParens(int[][] s,int i,int j)
	{
		if(i==j)
			System.out.print("A"+i);
		else
		{
			System.out.print("(");
			PrintOptimalParens(s, i, s[i][j]);
			PrintOptimalParens(s, s[i][j]+1, j);
			System.out.print(")");
		}
	}

}
