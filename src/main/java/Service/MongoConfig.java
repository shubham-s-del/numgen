package Service;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by shubham.srivastava on 05/06/15.
 */
public class MongoConfig {

    @JsonProperty("hosts")
    private List<String> hosts;

    @JsonProperty("dbname")
    private String dbName;

    public List<String> getHosts() {
        return hosts;
    }

    public String getDbName() {
        return dbName;
    }
}