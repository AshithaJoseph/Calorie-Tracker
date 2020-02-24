package calorieTracker;

import calorieTracker.ReportPK;
import calorieTracker.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-03T15:38:07")
@StaticMetamodel(Report.class)
public class Report_ { 

    public static volatile SingularAttribute<Report, ReportPK> reportPK;
    public static volatile SingularAttribute<Report, Integer> totalcaloriesconsumed;
    public static volatile SingularAttribute<Report, Integer> caloriegoal;
    public static volatile SingularAttribute<Report, Integer> totalcaloriesburned;
    public static volatile SingularAttribute<Report, Integer> totalstepstaken;
    public static volatile SingularAttribute<Report, Users> users;

}