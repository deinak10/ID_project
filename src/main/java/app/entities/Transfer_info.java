package app.entities;

import java.sql.Date;
import java.util.Objects;

public class Transfer_info {
    private long transfer_info_id;
    private String lefted;
    private String joined;
    private Date transfer_date;
    private int market_value;
    private String scout_name;

    public Transfer_info(){

    }

    public long getTransfer_info_id() {
        return transfer_info_id;
    }

    public void setTransfer_info_id(long transfer_info_id) {
        this.transfer_info_id = transfer_info_id;
    }

    public String getLefted() {
        return lefted;
    }

    public void setLefted(String lefted) {
        this.lefted = lefted;
    }

    public String getJoined() {
        return joined;
    }

    public void setJoined(String joined) {
        this.joined = joined;
    }

    public Date getTransfer_date() {
        return transfer_date;
    }

    public void setTransfer_date(Date transfer_date) {
        this.transfer_date = transfer_date;
    }

    public int getMarket_value() {
        return market_value;
    }

    public void setMarket_value(int market_value) {
        this.market_value = market_value;
    }

    public String getScout_name() {
        return scout_name;
    }

    public void setScout_name(String scout_name) {
        this.scout_name = scout_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transfer_info that = (Transfer_info) o;
        return transfer_info_id == that.transfer_info_id &&
                market_value == that.market_value &&
                Objects.equals(lefted, that.lefted) &&
                Objects.equals(joined, that.joined) &&
                Objects.equals(transfer_date, that.transfer_date) &&
                Objects.equals(scout_name, that.scout_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transfer_info_id, lefted, joined, transfer_date, market_value, scout_name);
    }

    @Override
    public String toString() {
        return "Transfer_info{" +
                "transfer_info_id=" + transfer_info_id +
                ", lefted='" + lefted + '\'' +
                ", joined='" + joined + '\'' +
                ", transfer_date=" + transfer_date +
                ", market_value=" + market_value +
                ", scout_name='" + scout_name + '\'' +
                '}';
    }
}

