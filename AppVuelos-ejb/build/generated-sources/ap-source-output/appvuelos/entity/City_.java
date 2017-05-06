package appvuelos.entity;

import appvuelos.entity.Country;
import appvuelos.entity.Flight;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-05T13:07:36")
@StaticMetamodel(City.class)
public class City_ { 

    public static volatile SingularAttribute<City, String> country;
    public static volatile SingularAttribute<City, String> cityName;
    public static volatile SingularAttribute<City, Country> countryIsoCode;
    public static volatile CollectionAttribute<City, Flight> flightCollection1;
    public static volatile SingularAttribute<City, String> language;
    public static volatile CollectionAttribute<City, Flight> flightCollection;
    public static volatile SingularAttribute<City, String> airport;

}