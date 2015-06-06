package Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by shubham.srivastava on 05/06/15.
 */
@Path("/register")
public class RegisterResource {



    @Path("/seller/{sellerId}")
    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    public RegisterResponse registerSeller (@PathParam("sellerId") String sellerId) {
        return null;

        //TODO: Complete this
    }

    @Path("/user/{userId}")
    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    public RegisterResponse registerUser (@PathParam("userId") String userId) {
        return null;

        //TODO: Complete this
    }
}