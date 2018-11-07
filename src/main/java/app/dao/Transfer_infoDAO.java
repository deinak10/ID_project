package app.dao;

import app.entities.Transfer_info;

import java.sql.SQLException;
import java.util.List;

public interface Transfer_infoDAO {
    //create
    void add(Transfer_info transfer_info) throws SQLException;

    //read
    List<Transfer_info> getALL() throws SQLException;
    Transfer_info getById(long id) throws SQLException;

    //update
    void update(Transfer_info transfer_info) throws SQLException;

    //delete
    void remove(Transfer_info transfer_info) throws SQLException;
}

