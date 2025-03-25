package com.users.validator.processor;
import java.util.Scanner;

public class TerminalValidation extends BaseValidation{

	public TerminalValidation() {
	}

	// First and Last Name Validator Function:
	public void nameFieldValidation(String userInput, String nameType) {
		boolean invalidInput;
		do {
			invalidInput = false;
			if (userInput.isEmpty()) {
				invalidInput = true;
			} else if (!userInput.isEmpty()) {

				if (!(getFieldsValidator().checkType(userInput))) {
					System.out.println("Invalid Type");
					invalidInput = true;
				}

				if (!getFieldsValidator().checkMaximumLength(userInput)) {
					System.out.println("Invalid Maximum Length");
					invalidInput = true;
				}

				if (getNameValidator().nameFieldValidator(userInput))  {
					//
				} else {
					System.out.println("First Name contains invalid data format.");
					invalidInput=true;
				}
			}

			if (invalidInput) {
				userInput = userInputData(nameType);
			}

		} while(userInput.compareTo("-1")!=0 && invalidInput);
	}

	public void otherFieldsValidation(String userInput, String nameType) {
		Boolean invalidInput;
		do {
			invalidInput = false;

			if (!(getFieldsValidator().checkType(userInput))) {
				System.out.println("Invalid Type");
				invalidInput = true;
			}

			if (!getFieldsValidator().checkMaximumLength(userInput)) {
				System.out.println("Invalid Maximum Length");
				invalidInput = true;
			}

			if (invalidInput) {
				userInput = userInputData(nameType);
			}

		} while(userInput.compareTo("-1")!=0 && invalidInput);
	}

	public void postalCodeValidation(String userInput, String nameType) {
		boolean invalidInput;
		do {
			invalidInput = false;

			// Postal Code Check: check for the postal code format
			if	(getAddressValidator().containSevenCharacterStringPostalCode(userInput)) {
				if (!getAddressValidator().validatePostalCode(userInput)) {
					System.out.println("Invalid Postal Code Format: "+userInput);
					invalidInput = true;

				} else {
					//System.out.println("Valid Postal Code Format: "+data[POSTAL]);
				}

			} else if (!getAddressValidator().containSevenCharacterStringPostalCode(userInput)) {
				System.out.println("Incorrect Numbers of Postal Code: "+userInput.trim().length());
				invalidInput = true;
			}

			if (invalidInput) {
				userInput = userInputData(nameType);
			}

		} while(userInput.compareTo("-1")!=0 && invalidInput);
	}

	public void emailAddressValidation(String userInput, String nameType) {
		boolean invalidInput;
		do {
			invalidInput = false;

			if	(userInput.isEmpty()) {
				System.out.println("Email Address is empty. Must contain data");
				invalidInput=true;

			} else if (!userInput.isEmpty()) {

				if (!(getFieldsValidator().checkType(userInput))) {
					System.out.println("Invalid Type");
					invalidInput = true;
				}

				if (!getFieldsValidator().checkMaximumLength(userInput)) {
					System.out.println("Invalid Maximum Length");
					invalidInput = true;
				}

				if (getEmailValidator().validate(userInput)) {

					if (getEmailValidator().checkUniqueUserEmail(userInput)) {
						//System.out.println("Unique User Email Address: "+);
					} else {
						System.out.println("Email Address already exist: "+userInput);
						invalidInput=true;
					}
				} else {
					System.out.println("Invalid Email Address! "+userInput);
					invalidInput=true;
				}
			}

			if (invalidInput) {
				userInput = userInputData(nameType);
			}

		} while(userInput.compareTo("-1")!=0 && invalidInput);
	}

	private String userInputData(String input) {
		String userInput;
		Scanner in = new Scanner(System.in);

		System.out.print("Please Enter "+input+": ");
		userInput = in.nextLine();
		//System.out.println("Input String is: "+userInput);

		if (userInput.equals("-1")) {
			System.exit(0);
		}
		return userInput;
	}


	// UserInputFunction
	public void userInputFunction () {
		String userInput="start";

		while (userInput.compareTo("-1")!=0) {
			userInput = userInputData("First Name");
			nameFieldValidation(userInput,"First Name");

			userInput = userInputData("Last Name");
			nameFieldValidation(userInput,"Last Name");

			userInput = userInputData("Company Name");
			otherFieldsValidation(userInput,"Company Name");

			userInput = userInputData("Address");
			otherFieldsValidation(userInput,"Address");

			userInput = userInputData("City");
			otherFieldsValidation(userInput,"City");

			userInput = userInputData("Province");
			otherFieldsValidation(userInput,"Province");

			// 7:
			userInput = userInputData("Postal Code");
			postalCodeValidation(userInput, "Postal Code");

			// 8: Email Address
			userInput = userInputData("Email Address");
			emailAddressValidation(userInput, "Email Address");

			// 9:
			userInput = userInputData("Website");
			otherFieldsValidation(userInput,"Website");
		}
	}

	// Test:
//	public static void main(String[] args) {
//		TerminalValidation userTerminalValidation = new TerminalValidation();
//		userTerminalValidation.userInputFunction();
//	}
}
