package com.users.validator.validation;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Format A1A 1A1, where A is a letter and 1 is a digit, with a space separating the third and fourth characters.
Postal codes do not include the letters D, F, I, O, Q or U, and the first position also does not make use of the letters W or Z.
*/

public class AddressValidator {

	private String postalCode;
	private static AddressValidator instance = new AddressValidator();

	private String regex = "^(?!.*[DFIOQU])[A-VXY][0-9][A-Z] ?[0-9][A-Z][0-9]$";
	private Pattern pattern = Pattern.compile(regex); //
	private Matcher matcher;

	private AddressValidator() {

	}

	public static AddressValidator getInstance() {
		return instance;
	}

	public boolean containSevenCharacterStringPostalCode(String code) {
		return (code.trim().length() == 7);
	}

	public boolean validatePostalCode(String postCode) {
		matcher = pattern.matcher(postCode);
	    return matcher.matches();
	}

	private String getProvince(String postCode)
	{
	    char firstLetter;  // first letter designates the destination
	    String province;

	    firstLetter = postCode.charAt(0);

	    // Check the area the postal code refers to
	    switch (firstLetter){
	      case 'A':
	        return "in Newfoundland";
	      case 'B':
	        return "in Nova Scotia";
	      case 'C':
	        return "in PEI";
	      case 'E':
	        return "in New Brunswick";
	      case 'G':
	        return "in Quebec";
	      case 'H':
	        return "in Metropolitan Montreal";
	      case 'J':
	        return "in Western Quebec";
	      case 'K':
	        return "in Eastern Ontario";
	      case 'L':
	        return "in Central Ontario";
	      case 'M':
	        return "in Metropolitan Toronto";
	      case 'N':
	        return "in Southwestern Ontario";
	      case 'P':
	        return "in Northern Ontario";
	      case 'R':
	        return "in Manitoba";
	      case 'S':
	        return "in Saskatchewan";
	      case 'T':
	        return "in Alberta";
	      case 'V':
	        return "in British Columbia";
	      case 'X':
	        return "in the Northwest Territories or Nunavut";
	      case 'Y':
	        return "in the Yukon Territories";
//	      default:
//	        throwException("Invalid first letter");
	    }
	    return "";
	  }

}
