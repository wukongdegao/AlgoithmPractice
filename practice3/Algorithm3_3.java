package practice3;

/*
 * 3��A simple scheduling problem. We are given jobs j1, j2�� jn, 
 * all with known running time t1, t2�� tn, respectively. We have a 
 * single processor. What is the best way to schedule these jobs in 
 * orderto minimize the average completion time. Assume that it is a 
 * no preemptive scheduling: once a job is started, it must run to completion. 
 * The following are some instances:
 * a)(j1, j2, j3, j4) : (15��8��3��10)
 */


public class Algorithm3_3 {

	public static void main(String[] args) 
	{
		int[] jobTime={0,15,8,3,10};
		simpleScheduling(jobTime);
		

	}
	
	public static void simpleScheduling(int[] times)
	{
		
		int completeTime=0;
		//�����ʱ��
		int sumCompleteTime=0;
		int numbers=times.length-1;
		Jobs[] jobs=new Jobs[numbers+1];
		for(int i=1;i<=numbers;i++)
			jobs[i]=new Jobs("j"+i, times[i]);
		
		//�Ƚϸ���������ʱ�䣬ð������
		for(int i=1;i<=numbers;i++)
		{
			for(int j=1;j<=numbers;j++)
			{
				if(jobs[i].getTime()<jobs[j].getTime())
					swap(jobs, i, j);
			}
		}
		
		//��ӡ
		System.out.println("���ȵ�˳��");
		for(int i=1;i<=numbers;i++)
		{
			completeTime+=jobs[i].getTime();
			jobs[i].setCompleteTime(completeTime);
			System.out.println(jobs[i].getJobID()+" ���ʱ�䣺"+jobs[i].getCompleteTime());
		}

		for(int i=1;i<=numbers;i++)
		{
			sumCompleteTime+=jobs[i].getCompleteTime();
		}
		
		System.out.println("ƽ�����ʱ�䣺"+sumCompleteTime/4.0);
	}
	
	//����������Ԫ��
	public static void swap(Jobs[] S,int a,int b)
	{
		Jobs temp=S[a];
		S[a]=S[b];
		S[b]=temp;
	}

}

class Jobs
{
	private int time;
	private String jobID;
	private int compleTime;
	
	public Jobs(String id,int time) 
	{
		jobID=id;
		this.time=time;
	}
	
	public int getTime()
	{
		return time;
	}
	
	public String getJobID()
	{
		return jobID;
	}
	
	public int getCompleteTime()
	{
		return compleTime;
	}
	
	public void setCompleteTime(int completeTime)
	{
		this.compleTime=completeTime;
	}
}
