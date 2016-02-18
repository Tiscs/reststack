package org.tiscs.reststack.core;

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
        Server server = new Server(8080);

        ServletContextHandler servletContext = new ServletContextHandler(ServletContextHandler.SESSIONS);
        servletContext.setContextPath("/");

        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(AppContext.class);
        servletContext.addEventListener(new ContextLoaderListener(appContext));

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
