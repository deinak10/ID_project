package app.dao;

import app.entities.Scout;

import java.sql.SQLException;
import java.util.List;

public interface ScoutDAO {
    //create
    void add(Scout scout) throws SQLException;

    //read
    List<Scout> getALL() throws SQLException;
    Scout getById(long id) throws SQLException;

    //update
    void update(Scout scout) throws SQLException;

    //delete
    void remove(Scout scout) throws SQLException;
}

