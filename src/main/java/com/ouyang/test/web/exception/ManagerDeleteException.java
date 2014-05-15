package com.ouyang.test.web.exception;

import com.ouyang.test.domain.Manager;

/**
 * When manager cannot be deleted
 */
public class ManagerDeleteException extends Exception {

	private Manager manager;

	public ManagerDeleteException(Manager manager) {
		this.manager = manager;
	}

	public Manager getManager() {
		return manager;
	}
}