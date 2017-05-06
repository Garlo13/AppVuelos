/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appvuelos.ejb;

import appvuelos.entity.Flight;
import java.util.Arrays;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Adrián
 */
@Stateless
public class FlightFacade extends AbstractFacade<Flight> {

    @PersistenceContext(unitName = "AppVuelos-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FlightFacade() {
        super(Flight.class);
    }

    public List<Flight> findByCountries(String[] countriesIsoCodes) {
        List<String> countries = Arrays.asList(countriesIsoCodes);
        Query q; 
        q = this.em.createQuery("select f from Flight f where f.origAirport.countryIsoCode in :countries");
        q.setParameter("countries", countries);
        return q.getResultList();
    }
    
    public Flight findByPK(String flightId, int segmentNumber){
        Query q;
        q = this.em.createQuery("select f from Flight f where f.flightPK.flightId = :id "
                + "and f.flightPK.segmentNumber = :segmentNumber");
        q.setParameter("id", flightId);
        q.setParameter("segmentNumber", segmentNumber);
        Flight res = (Flight) q.getSingleResult();
        return res;
    }
    
}
