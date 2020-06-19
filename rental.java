//package usaco2018january;
//1 hour 45 min
//1,2,7 is a success, 3,4 are wrong, 5,6,8,9,10 timed out
//Difficulty 9/10
//I thought this problem was really challenging, it made me think a lot and I felt like I may have took the wrong path in solving this problem
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class storeOffer implements Comparable<storeOffer>{
	int pricePerGallon;
	int maxGallons;
	
	
	@Override
	public int compareTo(storeOffer c)
	{
		// TODO Auto-generated method stub
		return pricePerGallon-c.getPricePerGallon();
	}
	
	public storeOffer(int maxGallons, int pricePerGallon) {
		this.pricePerGallon=pricePerGallon;
		this.maxGallons=maxGallons;
	}
	
	public int getPricePerGallon() {
		return pricePerGallon;
	}
	
	public int getMaxGallons() {
		return maxGallons;
	}
	
}

public class rental
{

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("rental.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("rental.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int R=Integer.parseInt(st.nextToken());
		
		//---------------------------------------------------------------------------------------------------------------------------------------------
		Integer[] cowList=new Integer[N];
		for(int i=0; i<N; i++) {
			cowList[i]=Integer.parseInt(br.readLine());
		}
		
		storeOffer[] storeOffers=new storeOffer[M];
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			storeOffers[i]=new storeOffer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Integer[] rentalOffers= new Integer[R];
		for(int i=0; i<R; i++) {
			rentalOffers[i]=Integer.parseInt(br.readLine());
		}
		
		 Arrays.sort(cowList, Collections.reverseOrder());
		 Arrays.sort(storeOffers, Collections.reverseOrder());
		 Arrays.sort(rentalOffers, Collections.reverseOrder());
		 //----------------------------------------------------------------------------------------------------------------------------------------------
		 
		 int[]profitPossibilities=new int[N+1];
		 
		 
		 for(int i=0;i<N+1; i++) {
			 
			 int totalGallonsMilked=0;
			 int totalCowsRented=0;
			 int totalMoneyEarned=0;
			 //-----------------------------------------------------
			 for(int j=0; j<N; j++) {
				 
				 if(j<N-i) {
					 //for cows that are getting milked
					 totalGallonsMilked=totalGallonsMilked+(int)cowList[j];
				 }
				 else {
					 //for cows that are getting rented
					 totalCowsRented++;
				 }
			 }
			 if(totalCowsRented>rentalOffers.length) {
				 continue;
			 }
			 //-----------------------------------------------------
			 //Finds Money earned from Milking
			 int gallonsLeft=totalGallonsMilked;
			 
			 for(int j=0; j<storeOffers.length; j++) {
				 
				 if(gallonsLeft==0) {
					 break;
				 }
				 
				 if(storeOffers[j].getMaxGallons()-gallonsLeft<=0) {
					 totalMoneyEarned+=storeOffers[j].getPricePerGallon()*storeOffers[j].getMaxGallons();
					 gallonsLeft=Math.abs(storeOffers[j].getMaxGallons()-gallonsLeft);
				 }
				 else {
					 totalMoneyEarned+=gallonsLeft*storeOffers[j].getPricePerGallon();
					 break;
				 }
			 }
			 //----------------------------------------------------
			 //Finds Money earned from Rental
			 for(int j=0;j<totalCowsRented;j++) {
				 totalMoneyEarned+=(int)rentalOffers[j];
			 }
			 
			 profitPossibilities[i]=totalMoneyEarned; 
		 }
		 
		 int maxProfit=0;
		 for(int element:profitPossibilities) {
			 maxProfit=Math.max(maxProfit, element);
		 }
		 
		 pw.print(maxProfit);
		 pw.close();
		 
		 
		
		
		
	}

}
