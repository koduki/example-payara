/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.orz.pascal.example.payara_micro;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author koduki
 */
@Path("session")
@Stateless
public class SessionResource {

    @Inject
    private User user;

    /**
     * Creates a new instance of SessionResource
     */
    public SessionResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String get() {
        String version = "2.0";
        String msg = "Application version " + version + System.lineSeparator();
        msg += String.format("I am %s. I am %d years old.", user.getName(), user.getAge());
        return msg;
    }

    @GET
    @Path("update/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public User update(@PathParam("name") String name, @QueryParam("age") int age, @Context HttpServletRequest request) {
        user.setName(name);
        user.setAge(age);

        return user;
    }
}
