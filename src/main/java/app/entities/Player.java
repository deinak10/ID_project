package app.entities;

import java.sql.Date;
import java.util.Objects;

public class Player {
    private long player_id;
    private String first_name;
    private String last_name;
    private int age;
    private String international;
    private String club;
    private String position;
    private int player_cost;
    private String agent;
    private Date contract_term;

    public Player(){

    }

    public long getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(long player_id) {
        this.player_id = player_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getInternational() {
        return international;
    }

    public void setInternational(String international) {
        this.international = international;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getPlayer_cost() {
        return player_cost;
    }

    public void setPlayer_cost(int player_cost) {
        this.player_cost = player_cost;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public Date getContract_term() {
        return contract_term;
    }

    public void setContract_term(Date contract_term) {
        this.contract_term = contract_term;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return player_id == player.player_id &&
                age == player.age &&
                player_cost == player.player_cost &&
                Objects.equals(first_name, player.first_name) &&
                Objects.equals(last_name, player.last_name) &&
                Objects.equals(international, player.international) &&
                Objects.equals(club, player.club) &&
                Objects.equals(position, player.position) &&
                Objects.equals(agent, player.agent) &&
                Objects.equals(contract_term, player.contract_term);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player_id, first_name, last_name, age, international, club, position, player_cost, agent, contract_term);
    }

    @Override
    public String toString() {
        return "Player{" +
                "player_id=" + player_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", age=" + age +
                ", international='" + international + '\'' +
                ", club='" + club + '\'' +
                ", position='" + position + '\'' +
                ", player_cost=" + player_cost +
                ", agent='" + agent + '\'' +
                ", contract_term=" + contract_term +
                '}';
    }
}

