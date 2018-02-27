package com.elementa.server.dao;

import com.elementa.server.dao.sql.MySqlUserDAO;
import com.elementa.server.dao.sql.MySqlUserRelationshipsDAO;
import com.google.inject.AbstractModule;

public class DaoModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(UserDAO.class).to(MySqlUserDAO.class);
		bind(UserRelationshipsDAO.class).to(MySqlUserRelationshipsDAO.class);
	}

}
