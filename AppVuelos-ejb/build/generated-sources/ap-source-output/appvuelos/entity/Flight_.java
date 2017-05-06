package appvuelos.entity;

import appvuelos.entity.City;
import appvuelos.entity.FlightPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-05T13:07:36")
@StaticMetamodel(Flight.class)
public class Flight_ { 

    public static volatile SingularAttribute<Flight, Date> arriveTime;
    public static volatile SingularAttribute<Flight, Character> meal;
    public static volatile SingularAttribute<Flight, Date> departTime;
    public static volatile SingularAttribute<Flight, String> aircraft;
    public static volatile SingularAttribute<Flight, FlightPK> flightPK;
    public static volatile SingularAttribute<Flight, Double> flyingTime;
    public static volatile SingularAttribute<Flight, City> destAirport;
    public static volatile SingularAttribute<Flight, Integer> miles;
    public static volatile SingularAttribute<Flight, City> origAirport;

}