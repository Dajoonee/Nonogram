package nonogramPuzzle.game;

import java.util.Set;
import java.util.TreeSet;

public class PuzzleIndex {
	int [] dogIndex = {00, 01, 10, 20, 21, 22, 23, 24, 25, 26, 31, 32, 
			34, 35, 36, 37, 41, 42, 43, 44, 46, 47, 48, 49, 51, 52, 53, 
			54, 55, 56, 57, 59, 61, 62, 64, 65, 66, 67, 69, 70, 71, 72, 
			73, 74, 75, 76, 78, 79, 80, 86, 87, 88, 89, 90, 91, 97, 98, 99};
	
	String clickNemo;
		
	public boolean checkIndex(String clickNemo) {
		this.clickNemo = clickNemo;
		for(int index : dogIndex) {
			if(index <10) {
				if(clickNemo.equals("0"+(Integer.toString(index)))) {
					System.out.println("index<10");
					return true;
				}
					
			}else {
				if(clickNemo.equals(Integer.toString(index))) {
					System.out.println("index>10");
					return true;
				}
					
					
			}
			
		}
		return false;
	}
	
	
	}
	

	

