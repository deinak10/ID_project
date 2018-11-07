package app;

import app.entities.Club;
import app.services.ClubService;

import java.sql.SQLException;
import java.util.List;

public class Domain {
    public static void main(String[] args) {
        ClubService clubService = new ClubService();

        Club club = new  Club();

        try{
            List<Club> clubList = clubService.getALL();
            for (Club a : clubList){
                System.out.println(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

