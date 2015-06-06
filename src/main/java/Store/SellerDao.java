package Store;

import Store.support.SellerInfo;

import java.util.List;

/**
 * Created by shubham.srivastava on 05/06/15.
 */
public interface SellerDao {

    void insert(SellerInfo sellerInfo);

    void deleteAllSellers();

    void deleteSeller(String email);

    List<SellerInfo> findNearest(double longitude, double latitude, int number);

    List<String> findAll();

    List<SellerInfo> findAllSellersInfo();

    SellerInfo findByEmailId(String emailId);

    List<SellerInfo> findNearByType(String storeType, double longitude, double latitude, int number);

    SellerInfo findNearestOneByType(String storeType, double longitude, double latitude);


}
