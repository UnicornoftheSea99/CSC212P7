package edu.smith.cs.csc212.p7;

import java.util.ArrayList;
import java.util.List;

//Sources:
//https://www.youtube.com/watch?v=Pr2Jf83_kG0
//https://stackoverflow.com/questions/32445391/merge-sort-recursion

public class MergeSortRecurs {
	public static ArrayList<Integer> a;
	
	public ArrayList<Integer> returnA() {
		//System.out.println(a);
		return a;	
	}
	
	public static void mergeSortRecurs(ArrayList<Integer> input){
		int N=input.size();
		int mid=N/2;
		
		ArrayList<Integer> left= new ArrayList<>();
		ArrayList<Integer> right= new ArrayList<>();
		
		if (N<2) {
			return;
		}
		
		else {
			
			for (int i=0;i<mid;i++) {
				left.add(i, input.get(i));
				System.out.println("start left");
				System.out.print(left);
				
			}
			for (int j=mid;j<N-1;j++) {
				//System.out.print(j);
				right.add(j,input.get(j));
				System.out.println("start right");
				System.out.print(right);
			
			}
//			System.out.print("left");
//			System.out.println(left);
//			System.out.println("right");
//			System.out.println(right);
			mergeSortRecurs(left);
			mergeSortRecurs(right);
			a = MergeSortLong.mergeSortLong(right,left);
		}
	}
}
