//package usaco2018january;
//All ten tests work no errors
//30 min
//Difficulty:3/10
//I thought it was pretty easy, I could've given the variables better names


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class lifeguards
{

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("lifeguards.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
		//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] schedule =new int [2][N];
		int maxtime=0;
		for (int i=0; i<N; i++) {
			st= new StringTokenizer(br.readLine());
			schedule[0][i]=Integer.parseInt(st.nextToken());
			schedule[1][i]=Integer.parseInt(st.nextToken());
		}
		//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		//find out time interval listings
		
		
		int [] timeline=new int[1000];
		for(int i=0; i<N; i++) {
			for(int j=schedule[0][i]; j<schedule[1][i];j++) {
				timeline[j]++;
			}
		}
		int []permanentTimeline= timeline.clone();
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		//create temporary cow firings
		
		
		for(int i=0;i<N; i++) {
			for(int j=schedule[0][i]; j<schedule[1][i]; j++) {
				timeline[j]--;
			}
			int length1=0;
			for(int j=0;j<timeline.length; j++) {
				if(timeline[j]>0)length1++;
			}
			if(length1>maxtime) {maxtime=length1;}
			timeline=permanentTimeline.clone();
		}
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		pw.print(maxtime);
		pw.close();
		

		
	}


}
