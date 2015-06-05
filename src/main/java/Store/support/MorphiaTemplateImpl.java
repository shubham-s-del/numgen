package Store.support;

import Store.MorphiaTemplate;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.UnknownHostException;
import java.util.List;

/**
 * Created by shubham.srivastava on 06/06/15.
 */
public class MorphiaTemplateImpl implements MorphiaTemplate {

    private static final Logger LOGGER = LoggerFactory.getLogger(MorphiaTemplateImpl.class);

    @Inject
    @Named("morphia.hosts")
    private List<String> hostNames;

    @Inject
    @Named("morphia.dbname")
    private String dbName;

    private Morphia morphia;
    private Datastore ds;

    public void initialize() throws UnknownHostException {
        LOGGER.info("called");
        morphia = new Morphia();
        List<ServerAddress> hostAddresses = Lists.newArrayList();
        for (String host : hostNames) {
            hostAddresses.add(new ServerAddress(host));
        }
        MongoClient mc = new MongoClient(hostAddresses);
        ds = morphia.createDatastore(mc, dbName);
    }

    @Override
    public void map(Class<?> type) {
        morphia.map(type);
        ds.ensureIndexes(type);
    }

    @Override
    public Datastore getDatastore() {
        return ds;
    }
}
