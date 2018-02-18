package HW2;
import java.util.*;

/*Problem 4:
Write a Java program that can count all sentences and all words that 
have more than 3 letters in a string. */

public class hw24 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String input;		
		System.out.println("Your input: ");
		input = sc.nextLine();
		sc.close();
		
		int sent = sentenceCount(input),
		    wrd = wordCount(input),
		    wrd2 = ultimateWordCount(input);
		
		System.out.println("The number of sentences is: " + sent);
		System.out.println("The number of words is: " + wrd);
		System.out.println("The number of words by the ultimate method is: " + wrd2);
	}
	
	
	static int sentenceCount(String str) {
		int sentN = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '.' || str.charAt(i) == '!' || str.charAt(i) == '?')
				sentN++;
		}
		return sentN;
	}
	
	
	static int wordCount(String str) {
		int wordN = 0;
		
		while(str.contains(" ")) { //as long as there are more than one words in the string, this will check length of each substring up until the next " ", add +1 to the # of words if it's longer than 3(checking for any punctuation directly before it), and then cuts that word out of the string, so that it repeats the process in the next loop
			int space = str.indexOf(" ");
			String sub = str.substring(0, space);
			sub = checkPunct(sub);
			if(sub.length() > 3) wordN++;
			
			str = str.substring(space+1);
		}
		if(str.length() - 1 > 3) wordN++; //for the last word,, -1 for the last '.' '?' or '!' as it is the end of the sentence
		
		return wordN;
	}
	
	static int ultimateWordCount(String str) { //calculating words using regular expressions
		int wn = 0;
		String[] wrdStr = str.split("\\s+");
		for(int i = 0; i < wrdStr.length; i++) {
			if(checkPunct(wrdStr[i]).length() > 3)
				wn++;
		}
		return wn;
	}
	
	
	static String checkPunct(String sub) { //checks the last character for punctuation chars, if present, gets rid of it (for counting the letters - if more than 3)
		char ch = sub.charAt(sub.length()-1);
		if(ch == '.' || ch == '?'|| ch == '!' || ch == ',' || ch == ':') {
			sub = sub.substring(0, sub.length()-1);
		}
		return sub;
	}
	
}