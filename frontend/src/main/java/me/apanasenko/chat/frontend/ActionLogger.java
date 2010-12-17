package me.apanasenko.chat.frontend;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.atmosphere.cpr.AtmosphereResourceEvent;
import org.atmosphere.cpr.AtmosphereResourceEventListener;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Anton Panasenko
 * Date: 17.12.10
 */

public class ActionLogger implements AtmosphereResourceEventListener {
    private final static Log logger = LogFactory.getLog(ActionLogger.class);

    public void onSuspend(final AtmosphereResourceEvent<HttpServletRequest, HttpServletResponse> event){
        logger.debug("onSuspend: " + event.getResource().getRequest().getRemoteAddr()
                + event.getResource().getRequest().getRemotePort());
    }

    public void onResume(AtmosphereResourceEvent<HttpServletRequest, HttpServletResponse> event) {
        logger.debug("onResume: " + event.getResource().getRequest().getRemoteAddr());
    }

    public void onDisconnect(AtmosphereResourceEvent<HttpServletRequest, HttpServletResponse> event) {
        logger.debug("onDisconnect: " + event.getResource().getRequest().getRemoteAddr()
                + event.getResource().getRequest().getRemotePort());
    }

    public void onBroadcast(AtmosphereResourceEvent<HttpServletRequest, HttpServletResponse> event) {
        logger.debug("onBroadcast: " + event.getMessage());
    }
}