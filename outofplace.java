
//package usaco2018january;
//Only tests 1,3,4,6,7,9,10 work, the rest do not
//60 min to complete
//Difficulty is a 6/10
//This problem was a bit tricky and I'm sure there is an alternative way to do this. 
//I was missing a case where Bessie traveled back into the line instead of up front.
//I tried to fix the case but it didn't work and it was too late to turn back.
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class outofplace
{

	public static void main(String[] args)throws IOException
	{
		//receive data
		BufferedReader br = new BufferedReader(new FileReader("outofplace.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("outofplace.out")));
		int N=Integer.parseInt(br.readLine());
		int[]order=new int[N];
		for(int i=0; i<N; i++) {
			order[i]=Integer.parseInt(br.readLine());
		}
		//------------------------------------------------------------------------------------------------------------------------------------------------
		int pbessie=0;
		int counter=0;
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------
		//Find bessie's position
		for(int i=0; i<N-1; i++) {
			if(order[i]>order[i+1])pbessie=i+1;
		}
		//--------------------------------------------------------------------------------------------------------------------------------------------------
		//Simulate the sorting case 1 
		if(order[pbessie]<order[pbessie-1]) {
			while(order[pbessie]<order[pbessie-1]) {
				int increment=2;
				while(order[pbessie-1]==order[pbessie-increment]) {
					increment++;
				}
				increment--;
				int temp=order[pbessie-increment];
				order[pbessie-increment]=order[pbessie];
				order[pbessie]=temp;
				pbessie=pbessie-increment;
				counter++;
			}
		}
		//----------------------------------------------------------------------------------------------------------------------------------------------------------
		pw.print(counter);
		pw.close();
		

	}

}
