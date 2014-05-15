package com.ouyang.test.service.dao;

import com.ouyang.test.domain.Timesheet;
import com.ouyang.test.service.GenericDao;

/**
 * DAO of Timesheet.
 */
public interface TimesheetDao extends GenericDao<Timesheet, Long> {
    // no additional business operations atm
}
