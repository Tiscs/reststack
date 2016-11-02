package org.tiscs.reststack.core;

import ch.qos.logback.ext.spring.web.LogbackConfigListener;
import ch.qos.logback.ext.spring.web.WebLogbackConfigurer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.tiscs.reststack.core.contexts.AppContext;
import org.tiscs.reststack.core.contexts.WebContext;

public class AppEntry {
    public static void main(String[] args) throws Exception {
        org.apache.ibatis.logging.LogFactory.useSlf4jLogging();

        Server server = new Server(8080);

        ServletContextHandler servletContext = new ServletContextHandler(ServletContextHandler.SESSIONS);
        servletContext.setContextPath("/");

        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(AppContext.class);
        servletContext.setInitParameter(WebLogbackConfigurer.EXPOSE_WEB_APP_ROOT_PARAM, "false");
        servletContext.addEventListener(new ContextLoaderListener(appContext));
        servletContext.addEventListener(new LogbackConfigListener());

        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.register(WebContext.class);

        ServletHolder apiServlet = new ServletHolder("rest-api", new DispatcherServlet(webContext));
        servletContext.addServlet(apiServlet, "/api/*");
        apiServlet.getRegistration().setLoadOnStartup(1);
        apiServlet.setAsyncSupported(true);

        server.setHandler(servletContext);
        server.start();
        server.join();
    }
}
