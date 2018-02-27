package com.elementa.server.api;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.elementa.shared.api.LogsResource;
import com.google.inject.Singleton;

@Singleton
public class LogsResourceImpl implements LogsResource {
	
	public final Logger logger;
	
	@Inject
	private LogsResourceImpl() {
		this.logger = LogManager.getLogger(LogsResourceImpl.class);
	}

	@Override
	public void log(int uid, String msg) {
		this.logger.traceEntry();
		this.logger.info("From account {}: {}", uid, msg);
		this.logger.traceExit();
	}

}
