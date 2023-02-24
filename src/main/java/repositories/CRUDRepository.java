package repositories;

import Beans.CRUDBean;
import entity.User;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("users")
public class CRUDRepository {

    @Inject
    CRUDBean CRUD;

    @GET
    public Response getUsers(){
        try {
            return Response.ok(CRUD.FindAll()).build();
        }catch (Exception e){
            return Response.ok(false).build();
        }
    };

    @GET
    @Path("test")
    public  Response test(){
        User user = new User();
        user.setName("Omar");
        user.setDetails("junior software engineer");
        try {
            CRUD.createUser(user);
            return Response.ok(user.getName()).build();
        } catch (Exception e){
            return Response.ok(false).build();
        }
    }

    @POST
    @Path("oneuser")
    @Consumes("application/x-www-form-urlencoded")
    public Response addUser(User user){
        try {
            CRUD.createUser(user);
            return Response.ok(user).build();
        }catch (Exception e){
            return Response.ok(false).build();
        }
    };
}
