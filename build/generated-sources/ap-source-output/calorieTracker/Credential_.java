package calorieTracker;

import calorieTracker.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-03T15:38:07")
@StaticMetamodel(Credential.class)
public class Credential_ { 

    public static volatile SingularAttribute<Credential, String> signupdate;
    public static volatile SingularAttribute<Credential, String> password;
    public static volatile SingularAttribute<Credential, Users> userid;
    public static volatile SingularAttribute<Credential, String> username;

}