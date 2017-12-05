package entity;


public class Invoice implements Entity {

    private int userId;
    private int trainId;
    private BerthType placeType;
    private int price;

    /**
     * Set the value of BerthType
     *
     * @param BerthType new value of price
     */
    public void setPlaceType(BerthType placeType) {
        this.placeType = placeType;
    }

    /**
     * Get the value of BerthType
     *
     * @param BerthType new value of BerthType
     */
    public BerthType getPlaceType() {
        return placeType;
    }

    /**
     * Get the value of price
     *
     * @return the value of price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Set the value of price
     *
     * @param price new value of price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Get the value of trainId
     *
     * @return the value of trainId
     */
    public int getTrainId() {
        return trainId;
    }

    /**
     * Set the value of trainId
     *
     * @param trainId new value of trainId
     */
    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    /**
     * Get the value of userId
     *
     * @return the value of userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Set the value of userId
     *
     * @param userId new value of userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

}
