package Store;

import Store.support.UserInfo;

/**
 * Created by shubham.srivastava on 06/06/15.
 */
public interface UserDao {

    void insert(UserInfo userInfo);

    void deleteAll();

    void deleteUser(String email);

    void findUserByEmail(String email);


}
