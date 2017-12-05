package dao;

import entity.Entity;
import entity.Route;


public abstract class RouteDAO extends AbstractDAO<Object, Entity> {

    /**
     * Finds routes by initial route by specified route depatureStation,
     * destinationStation and depatureTime are declared
     *
     * @param initRoute route with declared depatureStation,destinationStation
     * and depatureTime are declared
     * @return list if routes that correspond to our initial route
     */
    public abstract Iterable<Route> findRoutes(Route initRoute);
}
