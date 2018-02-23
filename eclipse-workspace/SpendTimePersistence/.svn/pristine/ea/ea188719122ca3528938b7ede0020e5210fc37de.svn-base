package db;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import commons.PropertiesManager;



public class HibernateConnection {

final static Logger logger = Logger.getLogger(HibernateConnection.class);
	
	protected static String dbUsername;
	protected static String dbPassword;
	protected static String dbDialect;
	protected static String connectorMainClass;
	protected static String dbUrl;
	
	static {
		dbUsername = PropertiesManager.getPropertyAsString("database.username");
		dbPassword = PropertiesManager.getPropertyAsString("database.password");
		dbDialect = PropertiesManager.getPropertyAsString("database.dialect");
		dbUrl = PropertiesManager.getPropertyAsString("database.connection.url");
		connectorMainClass = PropertiesManager.getPropertyAsString("database.connector.mainclass");
		
		logger.info("Properties loaded --> dbUsername: " + dbUsername + " - dbPassword: " + dbPassword + " - dbUrl: " + dbUrl + " - connectorMainClass: " + connectorMainClass + " - dbDialect: " + dbDialect);
	}
	
	protected static StandardServiceRegistry registry;
	protected static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
					// Create registry
				registry = new StandardServiceRegistryBuilder().configure().build();
					// Create MetadataSources
				MetadataSources sources = new MetadataSources(registry);
					// Create Metadata
				Metadata metadata = sources.getMetadataBuilder().build();
					// Create MetadataSources
				sessionFactory = metadata.getSessionFactoryBuilder().build();
			} catch (Exception e) {
				logger.error(e.getMessage());
					if (registry != null) {
						StandardServiceRegistryBuilder.destroy(registry);
					}
			}
		}
		return sessionFactory;
	}
	
	public static void shutdown() {
		if (registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

}
