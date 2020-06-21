
//package usaco2018january;
//2 hours
//5,6 timed out, the rest of the tests are a success
//Difficulty 10/10
//I was really struggling with this problem and had to look at the solution for some inspiration, I really felt like I learned a lot
//about silver level programming from this problem
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


class lifeguardTime implements Comparable<lifeguardTime>{
	int Time;
	int cowNumber;
	lifeguardTime(){}
	lifeguardTime(int Time, int cowNumber){
		this.Time=Time;
		this.cowNumber=cowNumber;
	}
	@Override
	public int compareTo(lifeguardTime c)
	{
		// TODO Auto-generated method stub
		return Time-c.getTime();
	}
	
	public int getCowNumber() {
		return cowNumber;
	}
	public int getTime() {
		return Time;
	}
}

public class lifeguardsSilver
{

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("lifeguards.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
		int N=Integer.parseInt(br.readLine());
		lifeguardTime[] log = new lifeguardTime[2*N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			log[2*i]=new lifeguardTime(Integer.parseInt(st.nextToken()),i+1);
			log[(2*i)+1]= new lifeguardTime(Integer.parseInt(st.nextToken()),i+1);
		}
		Arrays.sort(log);
		
		//-----------------------------------------------------------------------------------------------------------------------------------
		ArrayList<Integer> CowsOnDuty = new ArrayList<Integer>();
		int[] singleWorkTime=new int[N];
		int totalCoveredTime=0;
		
		
		//-----------------------------------------------------------------------------------------------------------------------------------
		int previousCowTime=0;
		for(lifeguardTime element:log) {
			
			if(!CowsOnDuty.isEmpty()) {
				totalCoveredTime=totalCoveredTime+(element.getTime()-previousCowTime);
				
			}
			if(CowsOnDuty.size()==1) {
				singleWorkTime[CowsOnDuty.get(0)-1]+=element.getTime()-previousCowTime;
			}
			
			if(CowsOnDuty.contains((Integer)element.getCowNumber())) {
				CowsOnDuty.remove((Integer)element.getCowNumber());
			}
			else {
				CowsOnDuty.add(element.getCowNumber());
			}
			
			previousCowTime=element.getTime();
			
		}
		//----------------------------------------------------------------------------------------------------------------------------------
		
		int maxTime=0;
		for(int element:singleWorkTime) {
			maxTime=Math.max(maxTime, totalCoveredTime-element);
		}
		
		pw.print(maxTime);
		pw.close();
		
		
		
			
			
			
			
			
		}
		
		
		
		
		
		

}


