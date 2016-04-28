package practice1;

import java.util.*;

/*
 * 2�� Implement priority queue.
 * 
 * @author Ԭ�� 13130110031
 */

public class Algorithm1_2 {

	public static void main(String[] args) 
	{
		Scanner in=new Scanner(System.in);
		priorityQueue A;
		System.out.println("please input your Integer:");
		String get=in.nextLine();
		
		//������������Ϊ�ַ�����洢
		String[] str=get.split("\\D");
		int[] S=new int[str.length];
		
		//���ַ���ת��Ϊ���ִ���
		for(int i=0;i<S.length;i++)
			S[i]=Integer.parseInt(str[i]);
		
		A=new priorityQueue(S);
		System.out.println("Priority queue is:");
		A.printfQueue();
		
		System.out.println("Maximum:");
		System.out.println(A.heap_Maximum());
		
		System.out.println("Extract-Max");
		A.heap_Extract_Max();
		A.printfQueue();
		
		System.out.println("Insert 100 to queue");
		A.Max_Heap_Insert(100);
		A.printfQueue();
		
		System.out.println("Increase-key:increase 3rd to 66");
		A.Heap_Increase_Key(2, 66);
		A.printfQueue();
		in.close();
	}
	
}

class priorityQueue
{
	private int[] Heap;
	private int heapSize;
	
	public priorityQueue(int[] A)
	{
		Heap=Arrays.copyOf(A, 100);
		heapSize=A.length-1;
		build_Max_Heap(Heap);
	}
	
	//ʵ�ִ�ӡ���ȼ����в���
	public void printfQueue()
	{
		for(int i=0;i<=heapSize;i++)
			System.out.print(Heap[i]+" ");
		System.out.println();
	}
	
	//ʵ�����ȼ����е�Maximum����
	public int heap_Maximum()
	{
		return Heap[0];
	}
	
	//ʵ�����ȼ����е�Extract-Max����
	public int heap_Extract_Max()
	{
		int max=Heap[0];
		Heap[0]=Heap[heapSize];
		heapSize--;
		maxHeapify(Heap, 0);
		return max;	
	}
	
	//ʵ�����ȼ����е�Increase_Key����
	public void Heap_Increase_Key(int i,int key)
	{
		if(key<Heap[i])
			System.out.println("new key is smaller than current key");
		else
		{
			Heap[i]=key;
			while (i>0&&Heap[parent(i)]<Heap[i]) 
			{
				Algorithm1_3.swap(Heap, i, parent(i));
				i=parent(i);
			}
		}
	}
	
	//ʵ�����ȼ�������Insert����
	public void Max_Heap_Insert(int key)
	{
		heapSize++;
		Heap[heapSize]=-1;
		Heap_Increase_Key(heapSize, key);
	}
	
	//������ת��Ϊ����
	private void build_Max_Heap(int[] A)
	{
		for(int i=(heapSize+1)/2-1;i>=0;i--)
			maxHeapify(A, i);
	}
	
	//ά����������
	private void maxHeapify(int[] A,int i)
	{
		int L=left(i);
		int r=right(i);
		int largest;
		//�ȽϽڵ����亢��֮�����ֵ�������±�
		if(L<=heapSize&&A[L]>A[i])
			largest=L;
		else
			largest=i;
		if(r<=heapSize&&A[r]>A[largest])
			largest=r;
		if(largest!=i)
		{
			Algorithm1_3.swap(A, i, largest);
		    maxHeapify(A, largest);
		}
	}
	
	//������
	public int[] heapSort()
	{
		for(int i=Heap.length-1;i>0;i--)
		{
			Algorithm1_3.swap(Heap, 0, i);
			heapSize--;
			maxHeapify(Heap, 0);
		}
		return Heap;
	}
	
	
	//�õ�����i�ĸ��ڵ�
	private int parent(int i)
	{
		return (i-1)/2;
	}
	
	//�õ�����i������
	private int left(int i)
	{
		return (i+1)*2-1;
	}
	
	//�õ�����i���Һ���
	private int right(int i)
	{
		return (i+1)*2;
	}
}
