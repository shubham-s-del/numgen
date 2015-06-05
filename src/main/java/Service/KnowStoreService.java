package Service;

import Configuration.KnowStoreConfiguration;
import Store.support.StoreMod;
import com.google.inject.Guice;
import com.google.inject.Injector;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by shubham.srivastava on 05/06/15.
 */
public class KnowStoreService extends Application<KnowStoreConfiguration> {

    private final static Logger LOGGER  = LoggerFactory.getLogger(KnowStoreService.class);
    public static void main(String[] args) throws Exception {
        new KnowStoreService().run(args);
    }

    @Override
    public String getName() {
        return "KnowStore";
    }

    @Override
    public void initialize(Bootstrap<KnowStoreConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(KnowStoreConfiguration configuration,
                    Environment environment) {

        StoreMod storeMod = new StoreMod();
        storeMod.setMongoHosts(configuration.getMongoConfig().getHosts());
        storeMod.setDbName(configuration.getMongoConfig().getDbName());
        LOGGER.info(String.format("mongo host: %s, dbName: %s\n", configuration.getMongoConfig().getHosts(), configuration.getMongoConfig().getDbName()));

        Injector injector = Guice.createInjector(storeMod);

        environment.jersey().register(new RegisterResource());

        // nothing to do yet
    }

}
