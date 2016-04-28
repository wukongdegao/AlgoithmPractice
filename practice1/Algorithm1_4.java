package practice1;

/*
 * Suppose that we have an array of n data records to sort.The key of each record has the 
 * value of 0 or 1 An algorithm for sorting such a set of records might possess some 
 * subset of the following three desirable 
 * characteristics:
 * 1. The algorithm runs in O(n) time.
 * 2. The algorithm is stable.
 * 3. The algorithm sorts in place, using no more than a constant amount 
 *    of storage space in addition to the original array.
 * a. Give an algorithm that satisfies criteria 1 and 2 above.
 * b. Give an algorithm that satisfies criteria 1 and 3 above.
 * c. Give an algorithm that satisfies criteria 2 and 3 above.
 * 
 * @author 袁点 13130110031
 */

public class Algorithm1_4 {

	public static void main(String[] args) 
	{
		int[] S={0,0,1,0,1,0,1,0,1,0,1,0,1,0,1};
		for(int i:a_algorithm(S))
			System.out.print(i+" ");
		System.out.println();
		for(int i:b_algorithm(S))
			System.out.print(i+" ");
		System.out.println();
		for(int i:c_algorithm(S))
			System.out.print(i+" ");
	}
	
	public static int[] a_algorithm(int S[])
	{
		int[] A=new int[2];
		//记录0与1的个数
		for(int i=0;i<S.length;i++)
			A[S[i]]++;
		
		//得出元素在结果序列中的位置
		A[1]=A[1]+A[0]-1;
		A[0]--;
		
		//申请数组记录结果
		int[] R=new int[S.length];
		for(int i=S.length-1;i>=0;i--)
		{
			R[A[S[i]]]=S[i];
			A[S[i]]--;
		}
		
		return R;
			
	}
	
	public static int[] b_algorithm(int S[])
	{
		//int one=0;
		int zero=0;
		for(int i:S)
		{
			if(i==0) zero++;
			//if(i==1) one++;
		}
		for(int i=0;i<zero;i++)
			S[i]=0;
		for(int i=zero;i<S.length;i++)
			S[i]=1;
		return S;
	}
	
	public static int[] c_algorithm(int S[])
	{
		for(int i=0;i<S.length;i++)
		{
			for(int j=0;j<S.length;j++)
			{
				if(S[i]<S[j])
					Algorithm1_3.swap(S, i, j);
			}
		}
		return S;
	}
}
