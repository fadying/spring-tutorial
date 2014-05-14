package com.ouyang.test.service.dao;

import com.ouyang.test.domain.Task;
import com.ouyang.test.service.GenericDao;

/**
 * DAO of Task.
 */
public interface TaskDao extends GenericDao<Task, Long> {

    /**
     * Tries to remove task from the system.
     * @param task Task to remove
     * @return {@code true} if there is no timesheet created on task.
     * Else {@code false}.
     */
    boolean removeTask(Task task);

}