// Objec­tive: Given two string sequences, write an algo­rithm to find the length of longest sub­se­quence present in both of them
// start from reverse order, 2 cases: 1. the last chars are same.
// 								   	  2. the last chars are not the same.

public class LongestCommonSubsequence {
	public static int findLCS(String A, String B){
		if(A.length() == 0 || B.length() == 0)
			return 0;
		int lenA = A.length(),
			lenB = B.length();

		if(A.charAt(lenA - 1) == B.charAt(lenB - 1)){
			return(1 + findLCS(A.substring(0, lenA - 1), B.substring(0,lenB - 1)));
		} else {
			return Math.max(
							findLCS(A, B.substring(0, lenB - 1)), 
							findLCS(A.substring(0, lenA - 1), B));
		}
	}
}