/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appvuelos.ejb;

import appvuelos.entity.Airline;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Adrián
 */
@Stateless
public class AirlineFacade extends AbstractFacade<Airline> {

    @PersistenceContext(unitName = "AppVuelos-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AirlineFacade() {
        super(Airline.class);
    }
    
}
