//package usaco2018january;
//All 10 tests work no errors
//50 min to complete
//Difficulty may have been a 7/10
//I thought I did okay but I didn't read the question cafefully and wasted 20 minutes overthinking the question
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class billboard
{


	public static void main(String[] args) throws IOException
	{
		//----------------------------------------------------------------------------------------------------------------------------------------------------
		BufferedReader br = new BufferedReader(new FileReader("billboard.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));
        //----------------------------------------------------------------------------------------------------------------------------------------------------------------
		StringTokenizer st = new StringTokenizer(br.readLine());
		int MowerX1=Integer.parseInt(st.nextToken());
	    int MowerY1=Integer.parseInt(st.nextToken());
	    int MowerX2=Integer.parseInt(st.nextToken());
	    int MowerY2=Integer.parseInt(st.nextToken());        
        st = new StringTokenizer(br.readLine());
        int CowFeedX1=Integer.parseInt(st.nextToken());
        int CowFeedY1=Integer.parseInt(st.nextToken());
        int CowFeedX2=Integer.parseInt(st.nextToken());
        int CowFeedY2=Integer.parseInt(st.nextToken());
        //-------------------------------------------------------------------------------------------------------------------------------------------------
        
        if((MowerX1>=CowFeedX1 && MowerX2<=CowFeedX2)&&(MowerY1>=CowFeedY1 && MowerY2<=CowFeedY2)) {
        	pw.print(0);
        }
        else if(((MowerY1>CowFeedY1 && MowerY2<CowFeedY2)&&((MowerX1>CowFeedX1 && MowerX1<CowFeedX2)||(MowerX2>CowFeedX1 && MowerX2<CowFeedX2)))||((MowerX1>CowFeedX1 && MowerX2<CowFeedX2)&&((MowerY1>CowFeedY1 && MowerY1<CowFeedY2)||(MowerY2>CowFeedY1 && MowerY2<CowFeedY2)))) {
        	int IntersectX1=Math.max(MowerX1, CowFeedX1);
        	int IntersectY1=Math.max(MowerY1, CowFeedY1);
        	int IntersectX2=Math.min(MowerX2, CowFeedX2);
        	int IntersectY2=Math.min(MowerY2, CowFeedY2);
        	pw.print(((MowerX2-MowerX1)*(MowerY2-MowerY1))-(IntersectX2-IntersectX1)*(IntersectY2-IntersectY1));
        }
        else {
        	pw.print((MowerX2-MowerX1)*(MowerY2-MowerY1));
        }
        pw.close();
        
        
	}

}
