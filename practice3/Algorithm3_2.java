package practice3;

/*
 * 2.Fractional knapsack problem
 *   Instance: same as 1
 *   
 *   @author by Ԭ�� 13130110031
 */

public class Algorithm3_2 
{

	public static void main(String[] args) 
	{
		int[] weight={0,50,30,45,25,5};
		int[] value={0,200,180,225,200,50};
		knapsackFractional(weight, value, 100);

	}
	
	//������������
	public static void knapsackFractional(int[] weight,int[] value,int capacity)
	{
		int maxValue=0;
		int numbers=weight.length-1;
		items[] item=new items[numbers+1];
		
		//�����������ݴ�����Ʒ��
		for(int i=1;i<=numbers;i++)
			item[i]=new items(i, weight[i], value[i]);
		
		//�Ƚ�ƽ���۸�ð������
		for(int i=1;i<=numbers;i++)
		{
			for(int j=1;j<=numbers;j++)
			{
				if(item[i].getUnitPrice()<item[j].getUnitPrice())
					swap(item, i, j);
			}
		}
		
		//��ӡ����������
		System.out.println("ѡ��");
		for(int i=numbers,j=capacity;i>0&&j>0;i--)
		{
			if(item[i].getWeight()<=j)
			{
				System.out.println(item[i].getItemNumber()+"����Ʒ "+item[i].getWeight()+"��");
				maxValue+=item[i].getValue();
				j-=item[i].getWeight();
			}
			else
			{
				System.out.println(item[i].getItemNumber()+"����Ʒ "+j+"��");
				maxValue+=item[i].getUnitPrice()*j;
				j=0;
			}
		}
		System.out.print("����ֵΪ:"+maxValue);
	}

	//����������Ԫ��
	public static void swap(items[] S,int a,int b)
	{
		items temp=S[a];
		S[a]=S[b];
		S[b]=temp;
	}
}

//����һ���ഢ����Ʒ��Ϣ
class items
{
	private int itemNumber;
	private int weight;
	private int value;
	private int unitPrice;
	
	public items(int itemNumber,int weight,int value) 
	{
		this.itemNumber=itemNumber;
		this.weight=weight;
		this.value=value;
		unitPrice=value/weight;
	}
	
	public int getItemNumber()
	{
		return itemNumber;
	}
	
	public int getWeight()
	{
		return weight;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public int getUnitPrice()
	{
		return unitPrice;
	}
}
