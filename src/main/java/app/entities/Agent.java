package app.entities;

import java.sql.Date;
import java.util.Objects;

public class Agent {
    private long agent_id ;
    private String name;
    private Date founded;
    private String international;
    private String website;
    private String players;

    public Agent(){

    }

    public long getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(long agent_id) {
        this.agent_id = agent_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFounded() {
        return founded;
    }

    public void setFounded(Date founded) {
        this.founded = founded;
    }

    public String getInternational() {
        return international;
    }

    public void setInternational(String international) {
        this.international = international;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
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
        Agent agent = (Agent) o;
        return agent_id == agent.agent_id &&
                Objects.equals(name, agent.name) &&
                Objects.equals(founded, agent.founded) &&
                Objects.equals(international, agent.international) &&
                Objects.equals(website, agent.website) &&
                Objects.equals(players, agent.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(agent_id, name, founded, international, website, players);
    }

    @Override
    public String toString() {
        return "Agent{" +
                "agent_id=" + agent_id +
                ", name='" + name + '\'' +
                ", founded=" + founded +
                ", international='" + international + '\'' +
                ", website='" + website + '\'' +
                ", players='" + players + '\'' +
                '}';
    }
}

