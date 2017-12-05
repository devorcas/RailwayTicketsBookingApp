package dao;

import entity.Entity;
import entity.Train;


public abstract class TrainDAO extends AbstractDAO<Object, Entity> {

    /**
     * Finds specified train
     *
     * @param inputTrain train to find by its id and departure date
     * @return train with all info from database
     */
    public abstract Train findTrain(Train inputTrain);

    /**
     * Finds specified train prices for berths and adds properties to obj Train
     *
     * @param inputTrain train to find its prices
     * @return train with all prices info from database
     */
    public abstract Train getPrices(Train inputTrain);
}
