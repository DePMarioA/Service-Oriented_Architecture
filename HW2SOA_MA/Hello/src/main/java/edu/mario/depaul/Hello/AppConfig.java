package edu.mario.depaul.Hello;


import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import javax.ws.rs.ApplicationPath;
import java.util.HashSet;
import java.util.Set;

/**
 * This basically creates the server and configures everything.
 * ResourceConfig extends Application. Which helps run and configure all the necessary classes.
 *
 */

@Component
@ApplicationPath("/v1") // Versioning
public class AppConfig extends ResourceConfig   {

    public AppConfig() {
//        register(QuoteResource.class);
//        register(Quotes.class);
//        register(AppDB.class);
        packages("edu.mario.depaul.Resource"); //packages() ensures the classes in the packages are registered
        packages("edu.mario.depaul.Hello");

    }
//
//    public AppConfig(Set<Class<?>> classes) {
//        super(classes);
//    }
//
//    public AppConfig(Class<?>... classes) {
//        super(classes);
//    }
//
//    public AppConfig(ResourceConfig original) {
//        super(original);
//    }
}

