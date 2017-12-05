package entity;

import java.sql.Time;


public class Route implements Entity {

    private String id;

    private String departureStation;

    private String destinationStation;

    private Time departureTime;

    private Time destinationTime;

    private int berthPlaces;

    private int coupePlaces;

    private int suitPlaces;

    /**
     * Get the value of suitPlaces
     *
     * @return the value of suitPlaces
     */
    public int getSuitPlaces() {
        return suitPlaces;
    }

    /**
     * Set the value of suitPlaces
     *
     * @param suitPlaces new value of suitPlaces
     */
    public void setSuitPlaces(int suitPlaces) {
        this.suitPlaces = suitPlaces;
    }

    /**
     * Get the value of coupePlaces
     *
     * @return the value of coupePlaces
     */
    public int getCoupePlaces() {
        return coupePlaces;
    }

    /**
     * Set the value of coupePlaces
     *
     * @param coupePlaces new value of coupePlaces
     */
    public void setCoupePlaces(int coupePlaces) {
        this.coupePlaces = coupePlaces;
    }

    /**
     * Get the value of berthPlaces
     *
     * @return the value of berthPlaces
     */
    public int getBerthPlaces() {
        return berthPlaces;
    }

    /**
     * Set the value of berthPlaces
     *
     * @param berthPlaces new value of berthPlaces
     */
    public void setBerthPlaces(int berthPlaces) {
        this.berthPlaces = berthPlaces;
    }

    /**
     * Get the value of destinationTime
     *
     * @return the value of destinationTime
     */
    public Time getDestinationTime() {
        return destinationTime;
    }

    /**
     * Set the value of destinationTime
     *
     * @param destinationTime new value of destinationTime
     */
    public void setDestinationTime(Time destinationTime) {
        this.destinationTime = destinationTime;
    }

    /**
     * Get the value of depatureTime
     *
     * @return the value of depatureTime
     */
    public Time getDepartureTime() {
        return departureTime;
    }

    /**
     * Set the value of depatureTime
     *
     * @param depatureTime new value of depatureTime
     */
    public void setDepartureTime(Time depatureTime) {
        this.departureTime = depatureTime;
    }

    /**
     * Get the value of destinationStation
     *
     * @return the value of destinationStation
     */
    public String getDestinationStation() {
        return destinationStation;
    }

    /**
     * Set the value of destinationStation
     *
     * @param destinationStation new value of destinationStation
     */
    public void setDestinationStation(String destinationStation) {
        this.destinationStation = destinationStation;
    }

    /**
     * Get the value of depatureStation
     *
     * @return the value of depatureStation
     */
    public String getDepartureStation() {
        return departureStation;
    }

    /**
     * Set the value of depatureStation
     *
     * @param depatureStation new value of depatureStation
     */
    public void setDepartureStation(String depatureStation) {
        this.departureStation = depatureStation;
    }

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public String getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(String id) {
        this.id = id;
    }

}
