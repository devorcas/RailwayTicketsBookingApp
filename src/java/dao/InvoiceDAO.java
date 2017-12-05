package dao;

import entity.Entity;
import entity.Invoice;


public abstract class InvoiceDAO extends AbstractDAO<Object, Entity> {

    /**
     * Fills into a database new invoice record
     *
     * @param inpInvoice
     */
    public abstract int insertInvoice(Invoice inpInvoice);

}
