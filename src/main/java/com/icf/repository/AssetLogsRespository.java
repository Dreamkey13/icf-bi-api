package com.icf.repository;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AssetLogsRespository {

    private static SqlConnection connection = new SqlConnection();

    public void saveAssetLog(String serialNo, String key, Double value) {
        CallableStatement cstmt = null;

        try {
            cstmt = connection.getConnection().prepareCall(
                    "{call icf.dbo.add_asset_log(?,?,?)}");

            cstmt.setString("serialNo", serialNo);
            cstmt.setString("key", key);
            cstmt.setDouble("value", value);

            boolean results = cstmt.execute();
            int rowsAffected = cstmt.getUpdateCount();

        } catch (Exception ex) {
            Logger.getLogger(AssetLogsRespository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (cstmt != null) {
                try {
                    cstmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AssetLogsRespository.class.getName()).log(Level.WARNING, null, ex);
                }
            }
        }
    }

    /**
     * Close the database connection
     *
     * @return
     */
    public boolean closeConnection() {
        if (connection.getConnection() != null) {
            try {
                connection.getConnection().close();
            } catch (SQLException ex) {
                Logger.getLogger(AssetLogsRespository.class.getName()).log(Level.WARNING, null, ex);
                return false;
            }
        }
        return true;
    }
}
