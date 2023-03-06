package leetcode.array;

/*-
 * Probelm: Given an array arr of positive integers sorted in a strictly increasing
 * order, and an integer k. Return the kth positive integer that is missing from this array
 * 
 * 
 * Input: arr = [2,3,4,7,11], k = 5 
 * Output: 9 
 * Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
 * 
 * 
 * Input: arr = [1,2,3,4], k = 2
 * Output: 6
 * Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
 * 
 * 
 * LINK: https://leetcode.com/problems/kth-missing-positive-number/description/
 */
public class KthMissingPositiveNumber {
	
	/*-
	 	def findKthPositive(self, arr, k):
	        i = 1
	        count = 0;
	        missing = []
	        while count != k:
	            if i not in arr:
	                count = count + 1;
	                missing.append(i)
	            i = i + 1
	        return missing[k - 1]
	        
	     
	    result = findKthPositive([2, 3, 4, 7, 11], 5)
		result = findKthPositive([1, 2, 3, 4], 2)
		result = findKthPositive([1], 1)
		print(result)
	 */
}
