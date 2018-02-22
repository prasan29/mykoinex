package in.koinex.mykoinex.POJO;

/**
 * Created by 1130665 on 11/27/2017.
 */

public class KoinexJSON {
    private Stats stats;

    private Prices prices;

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public Prices getPrices() {
        return prices;
    }

    public void setPrices(Prices prices) {
        this.prices = prices;
    }

    @Override
    public String toString() {
        return "ClassPojo [stats = " + stats + ", prices = " + prices + "]";
    }
}
