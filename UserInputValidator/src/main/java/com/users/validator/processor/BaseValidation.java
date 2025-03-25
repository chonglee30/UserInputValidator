package com.users.validator.processor;

import com.users.validator.validation.*;

public class BaseValidation {

	final static int MAX_FIELD_LENGTH = 256;

	final static int FIRST_NAME = 0;
	final static int LAST_NAME = 1;
	final static int COMPANY_NAME =2;
	final static int ADDRESS = 3;
	final static int CITY = 4;
	final static int PROVINCE = 5;

	final static int POSTAL = 6;
	final static int PHONE1 = 7;
	final static int PHONE2 = 8;
	final static int EMAIL = 9;
	final static int WEB = 10;


	protected AddressValidator getAddressValidator() {
		return AddressValidator.getInstance();
	}

	protected EmailAddressValidator getEmailValidator() {
		return EmailAddressValidator.getInstance();
	}

	protected FieldsValidator getFieldsValidator() {
		return FieldsValidator.getInstance();
	}

	protected NameValidator getNameValidator() {
		return NameValidator.getInstance();
	}
}
