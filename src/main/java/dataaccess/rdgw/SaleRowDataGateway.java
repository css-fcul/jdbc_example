package dataaccess.rdgw;

import business.SaleStatus;
import dataaccess.DataSource;
import dataaccess.exception.PersistenceException;
import dataaccess.exception.RecordNotFoundException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class SaleRowDataGateway {

    private int id;
    private Date date;
    private SaleStatus status;
    private int customerId;
    private double totalSale;
    private double totalDiscount;

    private static final String GET_SALE_SQL = ""; //TODO complete me
    private static final String INSERT_SALE_SQL = ""; //TODO complete me

    
    public int getId() { return id; }
    public SaleStatus getStatus() { return status; }
    public int getCustomerId() { return customerId; }
    public double getDiscount() { return totalDiscount; }

     public void insert() throws PersistenceException {
       //TODO complete me
    }

    public static SaleRowDataGateway find(int id) throws PersistenceException {
        //TODO complete me
        return null;
    }

    private static SaleRowDataGateway load(ResultSet rs) throws SQLException {
        //TODO complete me
        return null;
    }
}