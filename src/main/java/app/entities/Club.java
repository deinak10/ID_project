package app.entities;

import java.sql.Date;
import java.util.Objects;


public class Club {

    private long club_id ;
    private String name ;
    private String location ;
    private String league;
    private Date foundation_year;
    private String stadium;
    private int number_titles;
    private double club_cost_bil;

    public Club(){

    }

    public long getClub_id() {
        return club_id;
    }

    public void setClub_id(long club_id) {
        this.club_id = club_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public Date getFoundation_year() {
        return foundation_year;
    }

    public void setFoundation_year(Date foundation_year) {
        this.foundation_year = foundation_year;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public int getNumber_titles() {
        return number_titles;
    }

    public void setNumber_titles(int number_titles) {
        this.number_titles = number_titles;
    }

    public double getClub_cost_bil() {
        return club_cost_bil;
    }

    public void setClub_cost_bil(double club_cost_bil) {
        this.club_cost_bil = club_cost_bil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Club club = (Club) o;
        return club_id == club.club_id &&
                number_titles == club.number_titles &&
                Double.compare(club.club_cost_bil, club_cost_bil) == 0 &&
                Objects.equals(name, club.name) &&
                Objects.equals(location, club.location) &&
                Objects.equals(league, club.league) &&
                Objects.equals(foundation_year, club.foundation_year) &&
                Objects.equals(stadium, club.stadium);
    }

    @Override
    public int hashCode() {
        return Objects.hash(club_id, name, location, league, foundation_year, stadium, number_titles, club_cost_bil);
    }

    @Override
    public String toString() {
        return "Club{" +
                "club_id=" + club_id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", league='" + league + '\'' +
                ", foundation_year=" + foundation_year +
                ", stadium='" + stadium + '\'' +
                ", number_titles=" + number_titles +
                ", club_cost_bil=" + club_cost_bil +
                '}';
    }
}


