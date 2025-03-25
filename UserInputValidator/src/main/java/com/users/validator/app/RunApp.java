package com.users.validator.app;

import java.util.Scanner;
import com.users.validator.processor.FileValidation;
import com.users.validator.processor.TerminalValidation;

public class RunApp {

	public static void promptForFile() {
		FileValidation fileHelper = new FileValidation();
		fileHelper.validateFromFile("users.csv");
		System.out.println("Total Number of valid rows(Users): " +String.valueOf(fileHelper.getValidUserNumber()));
	}

	public static void promptForUserInput() {
		TerminalValidation userTerminalValidation = new TerminalValidation();
		userTerminalValidation.userInputFunction();
	}


	public static void main(String[] args) {
		int mode = 0;

		do {
	        System.out.println("If you want to enter file, enter 1. If you want to enter record from the terminal, enter 2");
	        Scanner s = new Scanner(System.in);
	        mode = s.nextInt();

	        if (mode == 1) {
	        	promptForFile();
	        } else if (mode == 2) {
	        	promptForUserInput();
	        }

	    } while (mode == 1 || mode ==2);

	}

}
