package Store.Impls;

import Store.MorphiaTemplate;
import Store.SellerDao;
import Store.support.SellerInfo;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import org.mongodb.morphia.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by shubham.srivastava on 06/06/15.
 */
public class SellerDaoImpl implements SellerDao {

    private final static Logger logger = LoggerFactory.getLogger(SellerDaoImpl.class);

    @Inject
    private MorphiaTemplate morphiat;

    public void initialize() {
        morphiat.map(SellerInfo.class);
        logger.debug("initialized");
    }

    @Override
    public void insert(SellerInfo sellerInfo) {
        morphiat.getDatastore().save(sellerInfo);
    }

    @Override
    public void deleteAllSellers() {
        Query<SellerInfo> query = morphiat.getDatastore().createQuery(SellerInfo.class);
        morphiat.getDatastore().delete(query);
    }


    @Override
    public void deleteSeller(String email) {
        Query<SellerInfo> query = morphiat.getDatastore().createQuery(SellerInfo.class).field("emailId").equal(email);
        morphiat.getDatastore().delete(query);
    }

    @Override
    public List<SellerInfo> findNearest(double longitude, double latitude, int number) {
        Query<SellerInfo> query = morphiat.getDatastore().createQuery(SellerInfo.class);
        query.field("LocationIndex").near(longitude, latitude, 0.0008, true);
        query.limit(number);
        return query.asList();
    }


    @Override
    public List<String> findAll() {
        List<SellerInfo> listSellerInfo = findAllSellersInfo();
        List<String> emailIds = Lists.newArrayList();
        emailIds.addAll(listSellerInfo.stream().map(SellerInfo::getEmailId).collect(Collectors.toList()));
        return emailIds;
    }

    @Override
    public List<SellerInfo> findAllSellersInfo() {
        Query<SellerInfo> query = morphiat.getDatastore().find(SellerInfo.class);
        return query.asList();
    }

    @Override
    public SellerInfo findByEmailId(String emailId) {
        Query<SellerInfo> query = morphiat.getDatastore().find(SellerInfo.class).field("emailId").equal(emailId);
        return query.get();
    }

    @Override
    public List<SellerInfo> findNearByType(String storeType, double longitude, double latitude, int number) {
        Query<SellerInfo> query = morphiat.getDatastore().createQuery(SellerInfo.class).field("sellerType").equal(storeType);
        query.field("LocationIndex").near(longitude, latitude, 0.0008, true);
        return query.asList();
    }

    @Override
    public SellerInfo findNearestOneByType(String storeType, double longitude, double latitude) {
        return findNearByType(storeType, longitude, latitude, 1).get(0);
    }


}
