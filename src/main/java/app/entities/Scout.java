package app.entities;

import java.util.Objects;

public class Scout {
    private long scout_id;
    private String name;
    private String club;
    private int age;
    private String players ;

    public Scout(){

    }

    public long getScout_id() {
        return scout_id;
    }

    public void setScout_id(long scout_id) {
        this.scout_id = scout_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPlayers() {
        return players;
    }

    public void setPlayers(String players) {
        this.players = players;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scout scout = (Scout) o;
        return scout_id == scout.scout_id &&
                Objects.equals(name, scout.name) &&
                Objects.equals(club, scout.club) &&
                Objects.equals(age, scout.age) &&
                Objects.equals(players, scout.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scout_id, name, club, age, players);
    }

    @Override
    public String toString() {
        return "Scout{" +
                "scout_id=" + scout_id +
                ", name='" + name + '\'' +
                ", club='" + club + '\'' +
                ", age=" + age +
                ", players='" + players + '\'' +
                '}';
    }
}
