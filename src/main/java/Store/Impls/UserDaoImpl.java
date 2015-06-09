package Store.Impls;

import Store.MorphiaTemplate;
import Store.UserDao;
import Store.support.SellerInfo;
import Store.support.UserInfo;
import com.google.inject.Inject;
import org.mongodb.morphia.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by shubham.srivastava on 06/06/15.
 */
public class UserDaoImpl implements UserDao {

    private final static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Inject
    private MorphiaTemplate morphiat;

    public void initialize() {
        morphiat.map(SellerInfo.class);
        logger.debug("initialized");
    }


    @Override
    public void insert(UserInfo userInfo) {
        morphiat.getDatastore().save(userInfo);
    }

    @Override
    public void deleteAll() {
        Query<UserInfo> query = morphiat.getDatastore().createQuery(UserInfo.class);
        morphiat.getDatastore().delete(query);
    }

    @Override
    public void deleteUser(String email) {
        Query<UserInfo> query = morphiat.getDatastore().createQuery(UserInfo.class).field("emailId").equal(email);
        morphiat.getDatastore().delete(query);
    }

    @Override
    public UserInfo findUserByEmail(String email) {
        Query<UserInfo> query = morphiat.getDatastore().createQuery(UserInfo.class).field("emailId").equal(email);
        return query.get();
    }
}
