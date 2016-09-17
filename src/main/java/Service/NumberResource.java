package Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by shubham.srivastava on 05/06/15.
 */
@Path("/get")
public class NumberResource {

    private static int num = 0;

    public NumberResource(int number) {
        num = number;
    }

    @Path("/number")
    @GET
    public String registerUser() {
        String response = String.valueOf(num);
        num++;
        return response;
    }
}