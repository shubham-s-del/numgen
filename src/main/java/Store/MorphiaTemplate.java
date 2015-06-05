package Store;

import org.mongodb.morphia.Datastore;

/**
 * Created by shubham.srivastava on 06/06/15.
 */
public interface MorphiaTemplate {

    void map(Class<?> type);

    Datastore getDatastore();
}