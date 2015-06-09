package Service;

import Store.SellerDao;
import Store.UserDao;
import Store.support.SellerInfo;
import com.google.inject.Injector;
import utils.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

/**
 * Created by shubham.srivastava on 05/06/15.
 */
@Path("/register")
public class RegisterResource {

    private SellerDao sellerDao;
    private UserDao userDao;

    public RegisterResource(Injector injector) {
        sellerDao = injector.getInstance(SellerDao.class);
        userDao = injector.getInstance(UserDao.class);
    }


    @Path("/seller/{sellerEmailId}")
    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    public RegisterResponse registerSeller(@PathParam("sellerEmailId") String sellerEmailId, HttpServletRequest request) {

        Map<String, String[]> requestMap = request.getParameterMap();


        SellerInfo sellerInfo = sellerDao.findByEmailId(sellerEmailId);
        if (sellerInfo == null || StringUtils.isNullOrEmpty(sellerInfo.getSellerName())) {
        }


        return null;

        //TODO: Complete this
    }

    @Path("/user/{userId}")
    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    public RegisterResponse registerUser(@PathParam("userId") String userId) {
        return null;

        //TODO: Complete this
    }
}