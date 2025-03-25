package com.users.validator.processor;
import com.users.validator.validation.AddressValidator;
import com.users.validator.validation.EmailAddressValidator;
import com.users.validator.validation.NameValidator;
import com.users.validator.model.*;
import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.Map;
import java.util.HashMap;

public class FileValidation extends BaseValidation{

	Map<String, User> userMap;

	public FileValidation() {
		userMap = new HashMap<String,User>();
	}

	private File getCSVFilePath(String fileName)  {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = null;
		file = new File(classLoader.getResource(".").getFile()+fileName);

		if (!file.exists()) {
			try {
				throw new FileNotFoundException("File is NOT found!");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		if (!file.canRead()) {
			throw new SecurityException("Cannot read file for some reason!");
		}

		return file;
	}

	// Count valid users
	public int getValidUserNumber() {
		return userMap.keySet().size();
	}

	@SuppressWarnings("deprecation")
	public Map<String, User> validateFromFile(String fileName) {
		CSVReader reader = null;

		boolean invalidRow = false;
		int numValidRows=0;

		try {
			reader = new CSVReader(new FileReader(getCSVFilePath(fileName)));
			String [] data;

			int row =1;
			boolean checkedFirst=false;
			boolean checkedLast=false;
			boolean checkedEmail=false;
			boolean checkedPostal=false;

			reader.readNext();		// skip the first head line;

			  while ((data=reader.readNext()) !=null) {

				for (int i=0; i<data.length; i++) {

					if (!(data[i] instanceof String)) {
						System.out.println("Following Row:"+row+" and Column: "+i+" is not instance of String type.");
						invalidRow=true;
					}

					if (data[i].length()>MAX_FIELD_LENGTH) {
						System.out.println("Following Row:"+row+" and Column: "+i+" contains more than Maximum allowed characters");
						invalidRow=true;
					}

					// First Name:
					if (data[FIRST_NAME].isEmpty()&&!checkedFirst) {
						System.out.println("First Name on Row#:"+row+ "is empty. Must contain data");
						checkedFirst = true;
						invalidRow=true;

					} else if (!data[FIRST_NAME].isEmpty()&&!checkedFirst) {
						if (getNameValidator().nameFieldValidator(data[FIRST_NAME]))  {
							//
						} else {
							System.out.println("First Name contains invalid data format.");
							invalidRow=true;
						}
						checkedFirst = true;
					}

					// Last Name:
					if (data[LAST_NAME].isEmpty()&&!checkedLast) {
						System.out.println("Last Name on Row#:"+row+ "is empty. Must contain data");
						checkedLast = true;
						invalidRow=true;
					} else if (!data[LAST_NAME].isEmpty()&&!checkedLast) {
						if (getNameValidator().nameFieldValidator(data[LAST_NAME]))  {
							//
						} else {
							System.out.println("Last Name contains invalid data format.");
							invalidRow=true;
						}
						checkedLast = true;
					}

					// Postal Code: check for the postal code format
					if	(getAddressValidator().containSevenCharacterStringPostalCode(data[POSTAL])&&!checkedPostal) {
						if (!getAddressValidator().validatePostalCode(data[POSTAL])) {
							System.out.println("Invalid Postal Code Format: "+data[POSTAL]);
							invalidRow=true;
						} else {
							//System.out.println("Valid Postal Code Format: "+data[POSTAL]);
						}
						checkedPostal = true;
					} else if (!getAddressValidator().containSevenCharacterStringPostalCode(data[POSTAL])&&!checkedPostal) {
						System.out.println("Incorrect Numbers of Postal Code: "+data[POSTAL].trim().length());
						checkedPostal = true;
						invalidRow=true;
					}

					// Email:
					if	(data[EMAIL].isEmpty()&&!checkedEmail) {
						System.out.println("Email Address on Row#:"+row+ "is empty. Must contain data");
						checkedEmail = true;
						invalidRow=true;

					} else if (!data[EMAIL].isEmpty()&&!checkedEmail) {
						if (getEmailValidator().validate(data[EMAIL])) {
							//System.out.print("Valid Email Address! ");

							if (getEmailValidator().checkUniqueUserEmail(data[EMAIL])) {
								//System.out.println("Unique User Email Address: "+);
							} else {
								System.out.println("Email Address already exist: "+data[EMAIL]);
								invalidRow=true;
							}

						} else {
							System.out.println("Invalid Email Address! "+data[EMAIL]);
							invalidRow=true;
						}
						checkedEmail = true;
					}


				}
				checkedFirst=false;
				checkedLast =false;
				checkedEmail = false;
				checkedPostal = false;
				row++;

				if (!invalidRow) {
					User validUser = new User(data[FIRST_NAME], data[LAST_NAME], data[COMPANY_NAME], data[ADDRESS], data[CITY],
							data[PROVINCE], data[POSTAL], data[PHONE1], data[PHONE2], data[EMAIL], data[WEB]);

					if (!userMap.containsKey(validUser.getEmail())) {
						userMap.put(validUser.getEmail(), validUser);
					}

					numValidRows++;
				}
				invalidRow = false;
			}
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (reader!=null) {
				try {
					reader.close();
				} catch (IOException io) {
					io.printStackTrace();
				}
			}
		}

		// **** Save for the last ****
		//System.out.println("Total count of valid rows: "+String.valueOf(numValidRows));

		return userMap;

	}
}
