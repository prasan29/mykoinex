package in.koinex.mykoinex.POJO;

/**
 * Created by 1130665 on 11/27/2017.
 */

public class Stats {
    private XRP XRP;

    private BCH BCH;

    private ETH ETH;

    private BTC BTC;

    private LTC LTC;

    public XRP getXRP() {
        return XRP;
    }

    public void setXRP(XRP XRP) {
        this.XRP = XRP;
    }

    public BCH getBCH() {
        return BCH;
    }

    public void setBCH(BCH BCH) {
        this.BCH = BCH;
    }

    public ETH getETH() {
        return ETH;
    }

    public void setETH(ETH ETH) {
        this.ETH = ETH;
    }

    public BTC getBTC() {
        return BTC;
    }

    public void setBTC(BTC BTC) {
        this.BTC = BTC;
    }

    public LTC getLTC() {
        return LTC;
    }

    public void setLTC(LTC LTC) {
        this.LTC = LTC;
    }

    @Override
    public String toString() {
        return "ClassPojo [in.koinex.mykoinex.POJO.XRP = " + XRP + ", in.koinex.mykoinex.POJO.BCH = " + BCH + ", in.koinex.mykoinex.POJO.ETH = " + ETH + ", in.koinex.mykoinex.POJO.BTC = " + BTC + ", in.koinex.mykoinex.POJO.LTC = " + LTC + "]";
    }
}
