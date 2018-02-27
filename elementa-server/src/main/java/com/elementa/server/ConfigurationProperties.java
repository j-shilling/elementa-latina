package com.elementa.server;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Singleton Class to hold project configurations.
 * 
 * @author Jake Shilling
 * @version 0.1
 *
 */
@Singleton
public class ConfigurationProperties {
	private final Logger logger = 
			LogManager.getLogger(ConfigurationProperties.class);
	
	private static final String fileName = "config.properties";
	
	private final Properties prop;
	private final Optional<InputStream> input;
	
	/**
	 * Construct and instance of ConfigurationProperties and
	 * warn if the file cannot be opened.
	 */
	@Inject
	private ConfigurationProperties() {
		
		InputStream is = null;
		
		try {
			is = this.getClass().getClassLoader().getResourceAsStream(fileName);
		} finally {
			this.input = Optional.ofNullable(is);
		}
		
		if (this.input.isPresent()) {
			this.logger.info("Reading server configurations from " + fileName);
		} else {
			this.logger.info("Using only default server configurations.");
		}
		
		this.prop = new Properties();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void finalize() {
		if (this.input.isPresent()) {
			try {
				input.get().close();
			} catch (IOException e) {
				logger.warn(e.getMessage(), e);
			}
		}
	}
	
	/**
	 * Look for a property key in the input file and return its
	 * value or the default value.
	 * 
	 * @param key				Key to look for
	 * @param ifNotFound		default value
	 * 
	 * @return	The value of saved in the properties file, or the
	 * 			value of ifNotFound.
	 */
	private String getProperty (String key, String ifNotFound) {
		this.logger.traceEntry("Looking up property " + key);
		
		if (!this.input.isPresent()) {
			this.logger.traceExit("There is not input file; using default value.");
			return ifNotFound;
		}
		
		String ret = null;
		
		try {
			prop.load(input.get());
			ret = prop.getProperty(key);
		} catch (Exception e) {
			logger.warn(e.getMessage(), e);
		} finally {
			if (ret == null || ret.isEmpty()) {
				this.logger.trace("Properties file did not define " 
						+ key + "; using default value.");
				ret = ifNotFound;
			}
		}
		
		return ret;
	}
	
	/*
	 * SQL Server Configurations
	 */
	
	/** Get the Url for the SQL DB */
	public String getDBUrl()	{ return this.getProperty("db_url", ""); }
	/** Get the User account for the SQL DB Server */
	public String getDBUser()	{ return this.getProperty("db_user", ""); }
	/** Get the password for the SQL DB Server */
	public String getDBPwd()	{ return this.getProperty("db_pwd", ""); }

	/*
	 * Users DB Configurations
	 */
	
	/** Get the name of the SQL table for user accounts */
	public String getUsersTable()		{ return this.getProperty("users_table", "users"); }
	/** Get the name of the row for UIDs */
	public String getUsersUID() 		{ return this.getProperty("users_uid", "uid"); }
	/** Get the name of the row for usernames */
	public String getUsersUsername() 	{ return this.getProperty("users_username", "username"); }
	/** Get the name of the row for passwords */
	public String getUsersPassword() 	{ return this.getProperty("users_password", "password"); }
	/** Get the name of the row for credentials */
	public String getUsersCredentials() { return this.getProperty("users_credentials", "credential"); }
	/** Get the name of the row for account types */
	public String getUsersAccountType() { return this.getProperty("users_type", "account_type"); }
	/** Get the name of the row for the user's first name */
	public String getUsersFirstName() 	{ return this.getProperty("users_first", "first_name"); }
	/** Get the name of the row for the user's last name */
	public String getUsersLastName() 	{ return this.getProperty("users_last", "last_name"); }
	/** Get the name of the row for the user's email */
	public String getUsersEmail() 		{ return this.getProperty("users_email", "email"); }
	/** Get the name of the row for the uid of the creating account */
	public String getUsersCreator() 	{ return this.getProperty("users_creator", "creatorid"); }
	/** Get the name of the row for the user's preferences */
	public String getUsersPreferences()	{ return this.getProperty("users_config", "config"); }
	
	/*
	 * User's Relationships DB Configurations
	 */
	
	/** Get the name of the SQL table for account relationships */
	public String getUserRelationshipsTable()	{ return this.getProperty("user_relationships", "user_rel"); }
	public String getUserRelationshipsId()		{ return this.getProperty("user_relationships_id", "user_rel_id"); }
	public String getUserRelationshipsParent()	{ return this.getProperty("user_relationships_parent", "user_rel_parent"); }
	public String getUserRelationshipsChild()	{ return this.getProperty("user_relationships_child", "user_rel_child"); }
	
	
}
