package practice1;

import java.util.*;

/*
 * 2． Implement priority queue.
 * 
 * @author 袁点 13130110031
 */

public class Algorithm1_2 {

	public static void main(String[] args) 
	{
		Scanner in=new Scanner(System.in);
		priorityQueue A;
		System.out.println("please input your Integer:");
		String get=in.nextLine();
		
		//将输入数字作为字符数组存储
		String[] str=get.split("\\D");
		int[] S=new int[str.length];
		
		//将字符串转化为数字储存
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
	
	//实现打印优先级队列操作
	public void printfQueue()
	{
		for(int i=0;i<=heapSize;i++)
			System.out.print(Heap[i]+" ");
		System.out.println();
	}
	
	//实现优先级队列的Maximum操作
	public int heap_Maximum()
	{
		return Heap[0];
	}
	
	//实现优先级队列的Extract-Max操作
	public int heap_Extract_Max()
	{
		int max=Heap[0];
		Heap[0]=Heap[heapSize];
		heapSize--;
		maxHeapify(Heap, 0);
		return max;	
	}
	
	//实现优先级队列的Increase_Key操作
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
	
	//实现优先级队列中Insert操作
	public void Max_Heap_Insert(int key)
	{
		heapSize++;
		Heap[heapSize]=-1;
		Heap_Increase_Key(heapSize, key);
	}
	
	//将数组转化为最大堆
	private void build_Max_Heap(int[] A)
	{
		for(int i=(heapSize+1)/2-1;i>=0;i--)
			maxHeapify(A, i);
	}
	
	//维护最大堆性质
	private void maxHeapify(int[] A,int i)
	{
		int L=left(i);
		int r=right(i);
		int largest;
		//比较节点与其孩子之间最大值，储存下标
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
	
	//堆排序
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
	
	
	//得到堆中i的父节点
	private int parent(int i)
	{
		return (i-1)/2;
	}
	
	//得到堆中i的左孩子
	private int left(int i)
	{
		return (i+1)*2-1;
	}
	
	//得到堆中i的右孩子
	private int right(int i)
	{
		return (i+1)*2;
	}
}
