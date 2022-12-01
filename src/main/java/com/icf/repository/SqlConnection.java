package com.icf.repository;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class SqlConnection {

    private static Connection connection = null;
    private static SQLServerDataSource dataSource = new SQLServerDataSource();

    /**
     * @return the dataSource
     */
    public static SQLServerDataSource getDataSource() {
        return dataSource;
    }

    /**
     * Constructor
     */
    public SqlConnection() {
        try {
            createConnection();
        } catch (Exception ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * @return @throws Exception
     */
    private static Connection createConnection() {

        try {
            getDataSource().setUser(System.getenv("RDS_USERNAME"));
            getDataSource().setPassword(System.getenv("RDS_PASSWORD"));
            getDataSource().setServerName(System.getenv("RDS_HOSTNAME"));
            getDataSource().setDatabaseName(System.getenv("RDS_DB_NAME"));

            connection = getDataSource().getConnection();
        } catch (Exception ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
}