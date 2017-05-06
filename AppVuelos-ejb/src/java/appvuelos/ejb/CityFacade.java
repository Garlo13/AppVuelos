/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appvuelos.ejb;

import appvuelos.entity.City;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Adrián
 */
@Stateless
public class CityFacade extends AbstractFacade<City> {

    @PersistenceContext(unitName = "AppVuelos-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CityFacade() {
        super(City.class);
    }

    public City findByAirport(String aeropuertoOrigen) {
        Query q;
        q = this.em.createNamedQuery("City.findByAirport");
        q.setParameter("airport", aeropuertoOrigen);
        return (City) q.getSingleResult();
    }
    
}
