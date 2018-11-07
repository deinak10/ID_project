package app.dao;

import app.entities.Club;

import java.sql.SQLException;
import java.util.List;

public interface ClubDAO {
    //create
    void add(Club club) throws SQLException;

    //read
    List<Club> getALL() throws SQLException;
    Club getById(long id) throws SQLException;

    //update
    void update(Club club) throws SQLException;

    //delete
    void remove(Club club) throws SQLException;
}

