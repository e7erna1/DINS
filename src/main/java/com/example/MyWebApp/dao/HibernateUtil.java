package com.example.MyWebApp.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Support class {@link HibernateUtil}, which realise common functionality for hibernate.
 */

class HibernateUtil {

  /**
   * This service {@link StandardServiceRegistry} is basic for all hibernate, it needs ro start and
   * work with hibernate. SessionFactory {@link SessionFactory } this object creates sessions.
   */

  private static StandardServiceRegistry registry;
  private static SessionFactory sessionFactory;

  /**
   * Check if our session factory already exist. If it exist, return it, else create new;
   *
   * @return Ready for use session factory.
   */

  static SessionFactory getSessionFactory() {
    if (sessionFactory == null) {
      try {
        registry = new StandardServiceRegistryBuilder().configure().build();
        MetadataSources sources = new MetadataSources(registry);
        Metadata metadata = sources.getMetadataBuilder().build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();
      } catch (Exception e) {
        e.printStackTrace();
        if (registry != null) {
          StandardServiceRegistryBuilder.destroy(registry);
        }
      }
    }
    return sessionFactory;
  }
}
