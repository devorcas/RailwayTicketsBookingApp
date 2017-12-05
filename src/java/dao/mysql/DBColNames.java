package dao.mysql;


public enum DBColNames {

    // Train
    ID("id"),
    ROUTE_ID("routeID"),
    DATE("date"),
    SUITE_RESERVED("suiteReserved"),
    COUPE_RESERVED("coupeReserved"),
    BERTH_RESERVED("berthReserved"),
    BERTH_PRICE("berthPrice"),
    COUPE_PRICE("routePrice"),
    SUITE_PRICE("suitePrice"),
    //Route
    DEPARTURE_STATION("departureStation"),
    DESTINATON_STATION("destinationStation"),
    DEPARTURE_TIME("departureTime"),
    DESTINATION_TIME("destinationTime"),
    COUPE_PLACES("coupePlaces"),
    BERTH_PLACES("berthPlaces"),
    SUITE_PLACES("suitePlaces"),
    //User

    EMAIL("email"),
    FIRST_NAME("firstName"),
    PASSWORD("password"),
    PHONE("phone"),
    SURNAME("surname"),
    IS_ACTIVATED("isActivated");

    private String content;

    private DBColNames(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}
