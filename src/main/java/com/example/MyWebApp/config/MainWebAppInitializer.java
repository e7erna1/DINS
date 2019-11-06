package com.example.MyWebApp.config;

import com.sun.faces.config.FacesInitializer;
import java.util.Set;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class MainWebAppInitializer extends FacesInitializer implements WebApplicationInitializer {

  /**
   * Register and configure all Servlet container components necessary to power the web
   * application.
   */

  @Override
  public void onStartup(Set<Class<?>> classes, ServletContext servletContext)
      throws ServletException {
    super.onStartup(classes, servletContext);
  }

  /**
   * Register and configure all Servlet container components necessary to power the web
   * application.
   */
  @Override
  public void onStartup(final ServletContext servletContext) throws ServletException {
    final AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
    servletContext.addListener(new ContextLoaderListener(context));
  }
}
