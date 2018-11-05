# e164_US_Format

## The problem received:

* Write a function that accepts a user input phone number as a string and returns a normalized United States phone number in E.164 format. Return null (or an equivalent value) if the user input is invalid.
* Use your preferred general purpose programming language.
* Write a readme.txt file that describes the code's functionality and why you decided on your solution.
* There is no time limit. Out of respect for your time, you can document the remainder of your solution if this problem takes more than 1 hour.
* Document any online resources, third party libraries, and assumptions made when coding your solution.

## Explanation:

** Imports

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

I have imported a scanner for system input to allow the user to input a phone number. I also imported regex pattern and matcher for the regular expression
provided later in the program.

** Main Method

public static void main(String args[]) {
	String num = getNumber();
		
	if(validateNumber(num)) {
		System.out.println(returnNormalized(num));
	}
}

Here is the main method that first calls the method getNumber() and assigns the returned string to the variable num. Then we call the method 
validateNumber() with the num variable as the parameter. If validateNumber() returns true then the phone number is valid and we can proceed to returning 
the e164 United States normalized format by calling returnNormalized() on the variable num.

** getNumber() 

public static String getNumber() {
	Scanner scan = new Scanner(System.in);
	System.out.println("Enter a United States Phone Number: ");
	String number = scan.nextLine();
	return number;
}

getNumber() creates a scanner object and gets user input with System.in. 

** validateNumber()

public static boolean validateNumber(String number) {
    String pattern = "^\\(?[0-9]{3}\\)?-?[0-9]{3}-?[0-9]{4}$";
    Pattern r = Pattern.compile(pattern);
    Matcher m = r.matcher(number);
       if (m.find( )) {
          return true;
       } else {
	  System.out.println("Invalid Number");
          return false;
       }
}

The variable pattern defines the regex syntax:

	^ states that we will start at the beginning of the string
	\\(? states that we can accept ( optionally 
	[0-9]{3} states that we accept numbers 0-9 and must be 3 digits in length
	\\)? states that we can accept ) optionally
	-? states that we can accept - optionally
	[0-9]{3} states that we accept numbers 0-9 and must be 3 digits in length
	-? states that we can accept - optionally
	[0-9]{4} states that we accept numbers 0-9 and must be 4 digits in length
	$ states that we will stop at the end of the string

This regex will allow numbers such as:

	1112223333
	(111)2223333
	(111)-222-3333

** containsSymbols()

public static boolean containsSymbols(String number) {
	if(number.contains("-") || number.contains("(") || number.contains(")")){
		return true;
	}
  	else
  	{
		return false;
  	}
}

This checks to see if the inputted number contains ( or ) or - and returns true if it does.

** stripNumber() 

public static String stripNumber(String number) {
	number = number.replace("-", "");
	number = number.replace("(", "");
	number = number.replace(")", "");
	return number;
}

This will remove ( or ) or - from the given string.

** normalizeNumber()

public static String returnNormalized(String number) {
	if(containsSymbols(number)) {
		number = stripNumber(number);
	}
		
	String normalizedNumber = "+1" + number;
	return normalizedNumber;
}

First we call containsSymbols() and then we call stripNumber() if it contains symbols. We append +1 to the front of the number and return.

