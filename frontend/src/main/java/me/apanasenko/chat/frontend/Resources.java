package me.apanasenko.chat.frontend;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.PathSegment;
import java.io.InputStream;

/**
 * @author Anton Panasenko
 * Date: 17.12.10
 */

@Path("/")
public class Resources {
    private @Context ServletContext servletController;

    @Path("/jquery/{id}")
    @Produces("text/plain")
    public @GET InputStream getJQuery(@PathParam("id") PathSegment ps) {
        return servletController.getResourceAsStream("/jquery/" + ps.getPath());
    }

    @Path("/css/{id}")
    @Produces("text/css")
    public @GET InputStream getCss(@PathParam("id") PathSegment ps) {
        return servletController.getResourceAsStream("/css/" + ps.getPath());
    }

    @Produces("text/html")
    public @GET InputStream getIndex() {
        return servletController.getResourceAsStream("/index.html");
    }
}
