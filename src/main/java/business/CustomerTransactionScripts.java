package business;

import business.exception.ApplicationException;
import dataaccess.exception.PersistenceException;
import dataaccess.rdgw.CustomerRowDataGateway;

public class CustomerTransactionScripts {

	public void addCustomer (int vat, String denomination, int phoneNumber, DiscountType discountType){
		// TODO complete me
	}

	private boolean isValidVAT(int vat) {
		return false;
		// TODO complete me
	}

	private boolean isFilled(String value) {
		return false;
		// TODO complete me
	}
}