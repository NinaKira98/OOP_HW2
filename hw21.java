package HW2;
import java.util.*;

/*Problem 1: 
Write a Java function boolean palindrome(int a[], int length)
that takes as its arguments an integer array int a[] of the specified length int length 
and checks, if the array elements for a palindrome. 
The elements form a palindrome, if their orders from left to right and 
from right to left are the same. */

public class hw21 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
				
		int[] one = {1, 2, 3, 4, 3, 2, 1};
		int[] two = {5, 1, 1, 2, 3, 3, 2, 1, 1, 5};
		int[] three = {11, 12, 13, 16, 23, 12, 11};
		
		show(one);
		System.out.println(" is a palindrome: " + palindrome(one));
		show(two);
		System.out.println(" is a palindrome: " + palindrome(two));
		show(three);
		System.out.println(" is a palindrome: " + palindrome(three));
		System.out.println();
		
		System.out.print("The length of your array: ");
		int n = sc.nextInt();
		int[] input = new int[n];
		System.out.println("Please input the values, press enter after each input :)");
		for(int i = 0; i < input.length; i++) {
			input[i] = sc.nextInt();			
		}
		show(input);
		System.out.println("Your array is a polindrome: " + palindrome(input));
		
		
		System.out.println();
		System.out.println("Input values for new array (ArrayList), press any noninteger to stop");
		ArrayList<Integer> arr = new ArrayList<Integer>();
		while(sc.hasNextInt()) {
			arr.add(sc.nextInt());
		}
		
		System.out.println("The array is a palindrome: " + palindromeAr(arr));
		
		sc.close();
		
		
		
	}
	
	static boolean palindrome(int a[]) {
		int count = 0;
		for(int i = 0; i < a.length/2; i++) {
			if(a[i] == a[a.length-1-i]) {
				count++;
			}
		}
		return count==a.length/2;
	}
	
	static void show(int[] a) {
		System.out.print("{ ");
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.print("} ");
	}
	
	static boolean palindromeAr(ArrayList<Integer> ar) {
		int count = 0;
		for(int i = 0; i < ar.size(); i++) {
			if(ar.get(i) == ar.get(ar.size()-1-i)) {
				count++;
			}
		}
		return count==ar.size();
	}
}