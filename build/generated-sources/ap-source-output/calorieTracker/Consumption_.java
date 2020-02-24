package calorieTracker;

import calorieTracker.Food;
import calorieTracker.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-03T15:38:07")
@StaticMetamodel(Consumption.class)
public class Consumption_ { 

    public static volatile SingularAttribute<Consumption, String> date;
    public static volatile SingularAttribute<Consumption, Integer> quantityperservings;
    public static volatile SingularAttribute<Consumption, Food> foodid;
    public static volatile SingularAttribute<Consumption, Integer> index;
    public static volatile SingularAttribute<Consumption, Users> userid;

}