package org.apache.maven.findpalindrome;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		boolean exit = false;
		int option = 0;
		
		while(!exit) {
			System.out.println("Press " + 1 + " to Find next palindrome ");
			System.out.println("Press " + 2 + " to Exit");
			option = new Scanner(System.in).nextInt();
			switch(option) {
			case 1:
				System.out.println("Please enter the number: ");
				int number = new Scanner(System.in).nextInt();
				checkLength(number);
				break;
			case 2:
				exit = true;
				break;
			}	
		}
    }
    /***
	 * Check length function checks length of the number entered by the user
	 *  
	 * @author Sharmik Hirpara
	 * @since 01/09/2021
	 */
	
	public static void checkLength(int number) {
		if (String.valueOf(number).length() % 2 == 0)
			findNextPalindromeForEvenLengthedNumber(number);
		else
			findNextPlaindromeForOddLengthedNumber(number);
	}

	/***
	 * This function finds the palindrome for even lengthed number
	 *
	 * @author Sharmik Hirpara
	 * @since 31/08/2019
	 */
	private static void findNextPalindromeForEvenLengthedNumber(int number) {
		StringBuilder originalString = new StringBuilder();
		originalString.append(number);
		
		StringBuilder result = new StringBuilder();
		result.append(originalString.subSequence(0, originalString.length()/2));
		result.append(originalString.reverse().subSequence(originalString.length()/2, originalString.length()));
		
		int finalNumber = Integer.parseInt(result.toString());
		
		if(finalNumber > number)
//			System.out.println("The next palindrome number is " + finalNumber);
			System.out.print(finalNumber);
		else {
			int firstHalf = Integer.valueOf(result.substring(0, originalString.length()/2));
			int oldLength = String.valueOf(firstHalf).length();
			++firstHalf;
			int newLength = String.valueOf(firstHalf).length();
			if(newLength == oldLength) {
				result.replace(0, originalString.length()/2, String.valueOf(firstHalf));
				checkLength(Integer.valueOf(result.toString()));
			}
			else {
				result.setLength(0);
				result.append(firstHalf);
				while(String.valueOf(number).length() + 1 != result.length())
					result.append(0);
				checkLength(Integer.valueOf(result.toString()));
			}
		}
	}

	/***
	 * This function finds the palindrome for odd lengthed number
	 *
	 * @author Sharmik Hirpara
	 * @since 31/08/2019
	 */
		
	private static void findNextPlaindromeForOddLengthedNumber(int number) {
		StringBuilder originalString = new StringBuilder();
		originalString.append(number);
		
		StringBuilder result = new StringBuilder();
		result.append(originalString.subSequence(0, originalString.length()/2 + 1));
		
		result.append(originalString.reverse().subSequence(originalString.length()/2 + 1, originalString.length()));
		
		int finalNumber = Integer.parseInt(result.toString());
		
		if(finalNumber > number)
//			System.out.println("The next palindrome number is " + finalNumber);
			System.out.print(finalNumber);
		else {
			int numberAtMidPos = Integer.parseInt(String.valueOf(result.charAt(originalString.length()/2)));
			if (numberAtMidPos < 9) {
				result.replace(originalString.length()/2, originalString.length()/2 + 1, String.valueOf(numberAtMidPos + 1));
				finalNumber = Integer.parseInt(result.toString());
//				System.out.println("The next palindrome number is " + finalNumber);
				System.out.print(finalNumber);
			}
			else {
				int numberTillMidPos = Integer.valueOf(result.substring(0, originalString.length()/2 + 1));
				int oldLength = String.valueOf(numberTillMidPos).length();
				++numberTillMidPos;
				int newLength = String.valueOf(numberTillMidPos).length();
				if(newLength == oldLength) {
					result.replace(0, originalString.length()/2 + 1, String.valueOf(numberTillMidPos));
					checkLength(Integer.valueOf(result.toString()));
				}
				else {
					result.setLength(0);
					result.append(numberTillMidPos);
					while(String.valueOf(number).length() + 1 != result.length())
						result.append(0);
					checkLength(Integer.valueOf(result.toString()));
				}
			}
		}
	}
}
