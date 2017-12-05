package entity;

import java.sql.Date;


public class Train implements Entity {

    private int id;
    private String routeId;
    private Date date;
    private int coupeReserved;
    private int berthReserved;
    private int suitReserved;
    private int coupePrice;
    private int suitPrice;
    private int berthPrice;

    /**
     * Get the value of berthPrice
     *
     * @return the value of berthPrice
     */
    public int getBerthPrice() {
        return berthPrice;
    }

    /**
     * Set the value of berthPrice
     *
     * @param berthPrice new value of berthPrice
     */
    public void setBerthPrice(int berthPrice) {
        this.berthPrice = berthPrice;
    }

    /**
     * Get the value of suitPrice
     *
     * @return the value of suitPrice
     */
    public int getSuitPrice() {
        return suitPrice;
    }

    /**
     * Set the value of suitPrice
     *
     * @param suitPrice new value of suitPrice
     */
    public void setSuitPrice(int suitPrice) {
        this.suitPrice = suitPrice;
    }

    /**
     * Get the value of coupePrice
     *
     * @return the value of coupePrice
     */
    public int getCoupePrice() {
        return coupePrice;
    }

    /**
     * Set the value of coupePrice
     *
     * @param coupePrice new value of coupePrice
     */
    public void setCoupePrice(int coupePrice) {
        this.coupePrice = coupePrice;
    }

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the value of suiteReserved
     *
     * @return the value of suiteReserved
     */
    public int getSuitReserved() {
        return suitReserved;
    }

    /**
     * Set the value of suiteReserved
     *
     * @param suiteReserved new value of suiteReserved
     */
    public void setSuitReserved(int suiteReserved) {
        this.suitReserved = suiteReserved;
    }

    /**
     * Get the value of coupeReserved
     *
     * @return the value of coupeReserved
     */
    public int getCoupeReserved() {
        return coupeReserved;
    }

    /**
     * Set the value of coupeReserved
     *
     * @param coupeReserved new value of coupeReserved
     */
    public void setCoupeReserved(int coupeReserved) {
        this.coupeReserved = coupeReserved;
    }

    /**
     * Get the value of berthReserved
     *
     * @return the value of berthReserved
     */
    public int getBerthReserved() {
        return berthReserved;
    }

    /**
     * Set the value of berthReserved
     *
     * @param berthReserved new value of berthReserved
     */
    public void setBerthReserved(int berthReserved) {
        this.berthReserved = berthReserved;
    }

    /**
     * Get the value of date
     *
     * @return the value of date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Set the value of date
     *
     * @param date new value of date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Get the value of routeId
     *
     * @return the value of routeId
     */
    public String getRouteId() {
        return routeId;
    }

    /**
     * Set the value of routeId
     *
     * @param routeId new value of routeId
     */
    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public int getPrice(String type) {
        BerthType berthType = BerthType.valueOf(type.toUpperCase());
        switch (berthType) {
            case BERTH:
                return getBerthPrice();
            case SUIT:
                return getSuitPrice();
            case COUPE:
                return getCoupePrice();
            default:
                throw new AssertionError(berthType.name());
        }
    }
}
