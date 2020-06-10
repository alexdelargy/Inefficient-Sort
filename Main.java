import java.util.ArrayList;
import java.util.Scanner;
public class Main {
	public static void main(String[]args) {
		ArrayList<Integer>dataList=new ArrayList<Integer>();
		Scanner console=new Scanner(System.in);
		System.out.println("How many data points would you like?");
		int max=console.nextInt();
		System.out.println("Enter bottom bound for data points: ");
		int bottom=console.nextInt();
		System.out.println("Enter top bound for data points: ");
		int top=console.nextInt();
		long time=System.currentTimeMillis();
		for(int i=0;i<max;i++) {
			dataList.add((int)Math.round(Math.random()*(top-bottom)+bottom));
		}
		ArrayList<Integer>newData=sort(dataList);
		for(int i=0;i<dataList.size();i++) {
			System.out.println(newData.get(i));
		}
		console.close();
	}
	
	public static ArrayList<Integer> sort(ArrayList<Integer>dataList) {
		while(!checkOrder(dataList)) {
			int tempIndex=(int)Math.abs(Math.round(Math.random()*dataList.size()-1));
			int tempElement=dataList.get(tempIndex);
			int temp2Index=(int)Math.abs(Math.round(Math.random()*dataList.size()-1));
			int temp2Element=dataList.get(temp2Index);
			dataList.set(tempIndex,temp2Element);
			dataList.set(temp2Index, tempElement);
		}
		return dataList;
	}
	
	public static boolean checkOrder(ArrayList<Integer>dataList) {
		for(int i=0;i<dataList.size()-1;i++) {
			if(dataList.get(i)>dataList.get(i+1)) return false;
		}
		return true;
	}
}