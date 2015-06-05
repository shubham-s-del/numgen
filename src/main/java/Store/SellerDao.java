package Store;

import Store.support.SellerInfo;

import java.util.List;

/**
 * Created by shubham.srivastava on 05/06/15.
 */
public interface SellerDao {

    void insert(SellerInfo sellerInfo);

    void deleteAllSellers();

    List<String> findNearest(double latitude, double longitude, int number);

    List<String> findAll(double latitude, double longitude);

    SellerInfo findByEmailId(String emailId);


}
