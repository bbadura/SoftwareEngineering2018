package edu.nd.se2018.homework.hwk1;

public class Question3 {
	
	public Question3(){}	
	
    public int getMirrorCount(int[] numbers){
    	
    	int n = numbers.length;
		int maxLen = 0;
		
		// return 0 if list is empty
		if (n == 0)
			return 0;
		
		// work from outside in
		for (int i = 0; i < n/2; i++) {
			if (numbers[i] == numbers[n-1-i])
				maxLen++;
		}
		
		// if the list is perfectly symmetrical
		if (maxLen == n/2) {
			maxLen = maxLen*2;
			if (n%2 == 1)
				maxLen++;
		}
		else if (maxLen == 0) // if the list has values but no palindrome
			return 1;

		return maxLen;
	}
}
