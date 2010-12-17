package me.apanasenko.chat.frontend;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.atmosphere.annotation.Broadcast;
import org.atmosphere.cpr.Broadcaster;
import org.atmosphere.jersey.Broadcastable;
import org.atmosphere.jersey.SuspendResponse;

import javax.ws.rs.*;

/**
 * @author Anton Panasenko
 * Date: 17.12.10
 */

@Path("/pubsub/{topic}")
@Produces("text/html;charset=utf-8")
public class PubSub {
    private final static Log logger = LogFactory.getLog(PubSub.class);
    private @PathParam("topic") Broadcaster topic;

    public @GET SuspendResponse<String> subscribe() {
        return new SuspendResponse.SuspendResponseBuilder<String>()
                .broadcaster(topic)
                .outputComments(true)
                .addListener(new ActionLogger())
                .build();
    }

    @Broadcast
    public @POST Broadcastable publish(@FormParam("name") String name,
                                       @FormParam("message") String message,
                                       @FormParam("transport") String transport) {
        logger.debug("transport: " + transport);
        logger.debug("message: " + message);
        logger.debug("name: " + name);
        return new Broadcastable(name + ": " + message, "", topic);
    }
}
