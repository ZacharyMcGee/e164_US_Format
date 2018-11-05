package e164;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class e164 {
	public static void main(String args[]) {
		String num = getNumber();
		
		if(validateNumber(num)) {
			System.out.println(returnNormalized(num));
		}
	}
	
	public static String getNumber() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a United States Phone Number: ");
		String number = scan.nextLine();
		return number;
	}
	
	public static boolean validateNumber(String number) {
	    String pattern = "^\\(?[0-9]{3}\\)?-?[0-9]{3}-?[0-9]{4}$";
	    Pattern r = Pattern.compile(pattern);
	    Matcher m = r.matcher(number);
	      if (m.find( )) {
	          return true;
	       }else {
	    	  System.out.println("Invalid Number");
	          return false;
	       }
	}
	
	public static boolean containsSymbols(String number) {
  	  if(number.contains("-") || number.contains("(") || number.contains(")")){
		 return true;
	  }
  	  else
  	  {
  		  return false;
  	  }
	}
	
	public static String stripNumber(String number) {
		  number = number.replace("-", "");
		  number = number.replace("(", "");
		  number = number.replace(")", "");
		  return number;
	}
	
	public static String returnNormalized(String number) {
		if(containsSymbols(number)) {
			number = stripNumber(number);
		}
		
		String normalizedNumber = "+1" + number;
		return normalizedNumber;
	}
}
