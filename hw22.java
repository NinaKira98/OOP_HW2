package HW2;
import java.util.*;

/*Problem 2: 
Write a Java boolean method that takes as its arguments an 2d array int a[][] and checks, 
whether it satisfies it’s requirements or not. This means that it
must be square, and that all row sums, all column sums, and the two diagonal-sums 
must all be equal.
*/

public class hw22 {
	public static void main(String[] args) {
		
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		
		//THOSE ARE CREATED AS EXAMPLES
		int[][] one = new int[3][3]; //must return true
		for(int i = 0; i < one.length; i++) {
			for(int j = 0; j < one[i].length; j++) {
				one[i][j] = 1;
			}
		}
		
		int[][] two = new int[4][4]; //should be false (unless Random gives a perfect combination of numbers :D )
		for(int i = 0; i < two.length; i++) {
			for(int j = 0; j < two[i].length; j++) {
				two[i][j] = rand.nextInt(15) + 1;
			}
		}
		
		int[][] three = new int[5][6]; //not square, thus should be false
		for(int i = 0; i < three.length; i++) {
			for(int j = 0; j < three[i].length; j++) {
				three[i][j] = 2;
			}
		}
		
		int[][] four = {{2, 1, 2, 5}, //total mess
				        {1, 1}, 
				        {1, 2, 2, 1, 5}, 
				        {2, 15, 2}};
		
		System.out.println("Here are some examples of the implementation");
		System.out.println();
		
		display(one);
		System.out.println(isValid(one));
		System.out.println();
		
		display(two);
		System.out.println(isValid(two));
		System.out.println();
		
		display(three);
		System.out.println(isValid(three));
		System.out.println();
		
		display(four);
		System.out.println(isValid(four));
		System.out.println();
		
		System.out.print("Input the number of rows: ");
		int m = sc.nextInt();
		System.out.print("Input the number of columns: ");
		int n = sc.nextInt();
		
		int[][] input = new int[m][n];
		
		System.out.println("Input the values in INT for each row: (press ENTER after each input)");
		
		for(int i = 0; i < input.length; i++) {
			int num = i + 1;
			System.out.println("Row " + num + " values are:");
			for(int j = 0; j < input[i].length; j++) {
				input[i][j] = sc.nextInt(); 
			}	        
		}
		sc.close();
		
		display(input);
		System.out.println("Your inputed array is: " + isValid(input));
		
	}
	
	
	
	static boolean isValid(int a[][]) {
		boolean square = true, sums = true;
		
		int colnum = a.length;
		for(int i = 0; i < a.length; i++) {
			if(a[i].length != colnum) square = false;
		}
		
		if(square) { // in this case it is checked to be square (if it wasn't, there is no point in going any further), so I'm using "colnum" as both rows' and columns' number
		
			int ssum = 0; //sum of numbers in the 1st row. All other sums must be equal to this, if a[][] is valid
			for(int i = 0; i < colnum; i++) {
				ssum += a[0][i];
			}
			
			//checking sums of rows and columns and diagonals
			for(int i = 0; i < colnum; i++) {
				int s1 = 0, //diagonal 1 (\)
					s2 = 0, //diagonal 2 (/)
				    rowSum = 0,
					colSum = 0;
				for(int j = 0; j < colnum; j++) {
					s1 += a[i][i];
					s2 += a[i][(colnum-1)-i];
					rowSum += a[i][j];
					colSum += a[j][i];					
				}
				if(s1 != ssum || s2 != ssum) sums = false; //turns false if sums of 2 diagonals are not the same
				if(rowSum != ssum || colSum != ssum) sums = false;				
			}
		}
		return square && sums;
	}
	
	
	
	static void display(int arr[][]) { //for printing the arrays
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " "); 
			}
	        System.out.println();
		}
	}
	
	
}