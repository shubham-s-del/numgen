package Service;

import Configuration.NumGenConfiguration;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by shubham.srivastava on 05/06/15.
 */
public class NumGenService extends Application<NumGenConfiguration> {

    private final static Logger LOGGER = LoggerFactory.getLogger(NumGenService.class);

    public static void main(String[] args) throws Exception {
        new NumGenService().run(args);
    }

    @Override
    public String getName() {
        return "KnowStore";
    }

    @Override
    public void initialize(Bootstrap<NumGenConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(NumGenConfiguration configuration,
                    Environment environment) {
        int startNumber = configuration.getStartNumber();
        LOGGER.info(String.format("Start number = ", configuration.getStartNumber()));
        environment.jersey().register(new NumberResource(startNumber));

        // nothing to do yet
    }

}
