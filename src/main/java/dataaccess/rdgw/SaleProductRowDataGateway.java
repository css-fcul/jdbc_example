package dataaccess.rdgw;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import dataaccess.DataSource;
import dataaccess.exception.PersistenceException;

public class SaleProductRowDataGateway {

    private int saleId;
    private int productId;
    private double qty;

    private static final String INSERT_PRODUCT_SALE_SQL = ""; //TODO complete me
    private static final String GET_SALE_PRODUCTS_SQL = ""; //TODO complete me


    public int getProductId() { return productId; }
    public double getQty() { return qty; }

    public void insert() throws PersistenceException {
        //TODO complete me
    }

    public static Set<SaleProductRowDataGateway> findSaleProducts(int saleId) throws PersistenceException {
        //TODO complete me
        return null;
    }

    private static SaleProductRowDataGateway load(ResultSet rs) throws SQLException {
        //TODO complete me
        return null;
    }
}