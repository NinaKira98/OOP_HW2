package HW2;
import java.util.*;
//import java.lang.*;

/*Problem 3: 
Write a Java boolean method that will return “true” if a string is valid 
and “false” if it is not. Valid means a string must have at least eight characters, 
consists of only letters and digits and must contain at least one uppercase letter
and one digit.
 
Input a string: Abcdefgh2        

Expected Output:
String is valid:  true   */

public class hw23 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Input a string to see if valid or type 'exit' to stop execution");
		
		String str;
		
		while(true) {
			
			System.out.print("Input: ");
			str = sc.next();
			
			if(str.toLowerCase().trim().equals("exit")) {
				System.out.println("Thank You! Bye!");
				break;
			}
			
			System.out.println("String is valid: " + isValid(str));
		}
		
		sc.close();
	}
	
	
	static boolean isValid(String s) { //this method returns false even if only one of the properties is not valid, thus execution stops, to avoid needless operations to be performed
		
		if(s.length() < 8) return false;
		
		int numOfUp = 0, //uppercase chars in the string
			numOfN = 0; //digits(numbers)
		
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			
			if(!Character.isLetterOrDigit(ch))
				return false;
			
			if(Character.isLetter(ch)) {
				if(ch == Character.toUpperCase(ch)) 
					numOfUp++;
			}			
			
			if(Character.isDigit(ch)) numOfN++;
		}
		
		if(numOfUp < 1 || numOfN < 1) return false;				
		
		return true;
	}
}