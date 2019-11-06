package com.example.MyWebApp.config;

import com.sun.faces.config.FacesInitializer;
import java.util.Set;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Application start point
 */

public class MainWebAppInitializer extends FacesInitializer {

  /**
   * Configure faces servlet
   */

  @Override
  public void onStartup(Set<Class<?>> classes, ServletContext servletContext)
      throws ServletException {
    super.onStartup(classes, servletContext);
  }

}
