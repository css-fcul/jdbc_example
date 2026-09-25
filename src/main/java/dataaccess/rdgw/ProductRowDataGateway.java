package dataaccess.rdgw;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dataaccess.DataSource;
import dataaccess.exception.PersistenceException;
import dataaccess.exception.RecordNotFoundException;

public class ProductRowDataGateway {

	private int id;
	private int prodCod;
	private String description;
	private double faceValue;
	private double qty;
	private String discountEligibility;
	private int unitId;

	private static final String	UPDATE_STOCK_SQL = ""; //TODO complete me
	private static final String GET_PRODUCT_BY_PROD_COD_SQL = ""; //TODO complete me
	private static final String GET_PRODUCT_BY_ID_SQL = ""; //TODO complete me

	private static final String ELIGIBLE = "E";
	private static final String NOT_ELIGIBLE = "N";

	public int getProductId() { return id; }
	public int getProdCod() { return prodCod; }
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	public double getFaceValue() { return faceValue; }
	public void setFaceValue(double faceValue) { this.faceValue = faceValue; }
	public double getQty() { return qty; }
	public void setQty(double qty) { this.qty = qty; }
	public boolean isEligibleForDiscount() { return ELIGIBLE.equals(discountEligibility); }
	public void setEligibleForDiscount(boolean eligibleForDiscount) { 
		this.discountEligibility = eligibleForDiscount ? ELIGIBLE : NOT_ELIGIBLE; }
	public int getUnitId() { return unitId; }
	public void setUnitId(int unitId) { this.unitId = unitId; }

	public static ProductRowDataGateway findWithProdCod (int prodCod) throws PersistenceException {
		//TODO complete me
		return null;
	}

	public static ProductRowDataGateway find (int id) throws PersistenceException {
		//TODO complete me
		return null;
	}

	public void updateStockValue () throws PersistenceException {
		//TODO complete me
	}

	private static ProductRowDataGateway loadProduct(ResultSet rs) throws RecordNotFoundException {
		//TODO complete me
		return null;
	}
}