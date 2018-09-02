package edu.nd.se2018.homework.hwk1;

import java.util.*;

public class Question1 {
		
	public Question1(){}
	
	public int getSumWithoutDuplicates(int[] numbers){
		HashSet<Integer> hashNums = new HashSet<Integer>();
		
		for(int i = 0; i < numbers.length; i++) {
			hashNums.add(numbers[i]);
		}
		
		int sum = 0;
		
		// use an iterator to go through hashset and sum numbers
		Iterator<Integer> iterator = hashNums.iterator();
        while (iterator.hasNext())
            sum += iterator.next();
        
		return sum;	
	}
}
