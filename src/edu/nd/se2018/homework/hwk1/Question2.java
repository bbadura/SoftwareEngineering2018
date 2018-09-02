package edu.nd.se2018.homework.hwk1;
import java.util.*;

public class Question2 {

	public Question2(){}
	
	public String getMostFrequentWord(String input, String stopwords){
		
		// String tokenize the stop words and put them in a List
		StringTokenizer stopst = new StringTokenizer(stopwords);
		String stopTempString = new String();
		List<String> stopArray = new ArrayList<String>();
		while (stopst.hasMoreTokens()) {
		     stopTempString=stopst.nextToken();
		     stopArray.add(stopTempString);
		}
		
		// String tokenize the sentence and add them to a hashmap counter
		HashMap<String, Integer> counter = new HashMap<String, Integer>();
		StringTokenizer st = new StringTokenizer(input);
		String tempString = new String();
		while (st.hasMoreTokens()) {
		     tempString=st.nextToken();
		     
		     if (!stopArray.contains(tempString)) {
		    	 if(counter.containsKey(tempString))
			     {
			         int currcnt = counter.get(tempString);
			         currcnt++;
			         counter.put(tempString, currcnt);
			     }
			     else
			     {
			    	 counter.put(tempString, 1);
			     }
		     }
		}
		
		// find top count
		int topCnt = 0;
		String topString = "";
		for (Map.Entry<String, Integer> entry : counter.entrySet()) {
			if (entry.getValue() >= topCnt) {
				topCnt = entry.getValue();
				topString = entry.getKey();
			}
		}
		
		// see if top count occurs more than once
		int topCntCnt = 0;
		for (Map.Entry<String, Integer> entry : counter.entrySet()) {
			if (entry.getValue() == topCnt) {
				topCntCnt++;
			}
		}
		
		if (topCntCnt == 1)
			return topString;
		else
			return null;
	}
}
