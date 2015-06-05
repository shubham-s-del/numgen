package Configuration;

import Service.MongoConfig;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

/**
 * Created by shubham.srivastava on 05/06/15.
 */
public class KnowStoreConfiguration extends Configuration {

    @JsonProperty("mongo-server")
    private MongoConfig mongo;

    public MongoConfig getMongoConfig() {
        return mongo;
    }

}
