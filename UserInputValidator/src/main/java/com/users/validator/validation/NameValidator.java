package com.users.validator.validation;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidator {

	private static NameValidator instance = new NameValidator();

	private NameValidator() {

	}

	public static NameValidator getInstance() {
		return instance;
	}

	// CHECK#1: contains At least One Alphabet
	public boolean containsAtLeastOneAlphabet(String str) {
	     Pattern pattern = Pattern.compile(".*[a-zA-Z]+.*");
	     Matcher matcher = pattern.matcher(str);

	     boolean checkAlphabet;

	      if (matcher.matches()) {
	           //System.out.println("String '"+str + "' contains at least one alphabets/letters");
	           checkAlphabet = true;
	      } else {
	           System.out.println("String '"+str + "' does not contains any alphabets/letters value");
	           checkAlphabet = false;
	      }
	      return checkAlphabet;
	}

	// CHECK#2: consist of letters only
	public boolean isLetter(String str) {
	    char[] chars = str.toCharArray();

	    for (char c : chars) {
	        if(!Character.isLetter(c)) {
	            return false;
	        }
	    }
	    return true;
	}

	// CHECK#3: consist of no space
	public boolean containsWhitespace(String str) {
		int strLen = str.length();

	    for (int i = 0; i < strLen; i++) {
	      if (Character.isWhitespace(str.charAt(i))) {
	        return true;
	      }
	    }
	    return false;
	}

	// CHECK#4: check for no punctuation
	public boolean containsPunctuation(String str) {
		char[] chars = str.toCharArray();
		boolean checkPunctuation = false;

		for (char c: chars) {
			if (c == ','|| c == '.'|| c == '!'|| c == '?'|| c == ':'|| c == ';') {
				checkPunctuation = true;
			}
		}
		return checkPunctuation;
    }

	// CHECK#5: check whether contains ASCII values only
	public boolean isASCIIOnly(String str) {
		byte bytearray []  = str.getBytes();
	    CharsetDecoder d = Charset.forName("US-ASCII").newDecoder();
	    try {
	      CharBuffer r = d.decode(ByteBuffer.wrap(bytearray));
	      r.toString();
	    }
	    catch(CharacterCodingException e) {
	      return false;
	    }
	    return true;
	}

	// CHECK#5: check for ASCII values [OPTION]
//	private boolean containsASCII(String str) {
//
//		final CharsetEncoder asciiEncoder = Charset.forName("US-ASCII").newEncoder();
//		return asciiEncoder.canEncode(str);
//	}

	public boolean nameFieldValidator(String input) {
		boolean hasValid = true;

		// CHECK#1:
		if (!containsAtLeastOneAlphabet(input)) {
			System.out.print("String does Not contain At Least One Alphabet.");
			hasValid = false;
		}

		// CHECK#2:
		if (!isLetter(input)) {
			System.out.print("String does Not contain Letter");
			hasValid = false;
		}

		// CHECK#3:
		if (containsWhitespace(input)) {
			System.out.print("String contains Whitespace.");
			hasValid = false;
		}

		// CHECK#4:
		if (containsPunctuation(input)) {
			System.out.print("String contains Punctuation;");
			hasValid = false;
		}

		// CHECK#5: check whether contains ASCII values only
		if (!isASCIIOnly(input)) {
			System.out.print("String contains non-ASCII!");
			hasValid = false;
		}
		return hasValid;
	}

}
