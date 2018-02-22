package in.koinex.mykoinex.POJO;

/**
 * Created by 1130665 on 11/27/2017.
 */

public class LTC {
    private String highest_bid;

    private String min_24hrs;

    private String max_24hrs;

    private String last_traded_price;

    private String vol_24hrs;

    private String lowest_ask;

    public String getHighest_bid() {
        return highest_bid;
    }

    public void setHighest_bid(String highest_bid) {
        this.highest_bid = highest_bid;
    }

    public String getMin_24hrs() {
        return min_24hrs;
    }

    public void setMin_24hrs(String min_24hrs) {
        this.min_24hrs = min_24hrs;
    }

    public String getMax_24hrs() {
        return max_24hrs;
    }

    public void setMax_24hrs(String max_24hrs) {
        this.max_24hrs = max_24hrs;
    }

    public String getLast_traded_price() {
        return last_traded_price;
    }

    public void setLast_traded_price(String last_traded_price) {
        this.last_traded_price = last_traded_price;
    }

    public String getVol_24hrs() {
        return vol_24hrs;
    }

    public void setVol_24hrs(String vol_24hrs) {
        this.vol_24hrs = vol_24hrs;
    }

    public String getLowest_ask() {
        return lowest_ask;
    }

    public void setLowest_ask(String lowest_ask) {
        this.lowest_ask = lowest_ask;
    }

    @Override
    public String toString() {
        return "ClassPojo [highest_bid = " + highest_bid + ", min_24hrs = " + min_24hrs + ", max_24hrs = " + max_24hrs + ", last_traded_price = " + last_traded_price + ", vol_24hrs = " + vol_24hrs + ", lowest_ask = " + lowest_ask + "]";
    }
}
