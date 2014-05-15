package com.ouyang.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.jdbc.JdbcTestUtils;

import com.ouyang.test.domain.Employee;
import com.ouyang.test.domain.Manager;
import com.ouyang.test.domain.Task;
import com.ouyang.test.service.dao.EmployeeDao;
import com.ouyang.test.service.dao.ManagerDao;

@ContextConfiguration(locations = "/persistence-beans.xml")
public class TimesheetServiceTest extends AbstractJUnit4SpringContextTests {
    
    @Autowired
    private TimesheetService timesheetService;

    // resources for accessing data during the testing
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private ManagerDao managerDao;

    private final String createScript = "src/main/resources/sql/create-data.sql";
    private final String deleteScript = "src/main/resources/sql/cleanup.sql";

    @Before
    public void insertData() {
        JdbcTestUtils.executeSqlScript(jdbcTemplate,
                new FileSystemResource(createScript), false);
	}

    @After
    public void cleanUp() {
        JdbcTestUtils.executeSqlScript(jdbcTemplate,
                new FileSystemResource(deleteScript), false);
    }

    @Test
    public void testBusiestTask() {
        Task task = timesheetService.busiestTask();
        assertTrue(1 == task.getId());
    }
    
    @Test
    public void testTasksForEmployees() {
        Employee steve = employeeDao.find(1L);
        Employee bill = employeeDao.find(2L);
        
        assertEquals(2, timesheetService.tasksForEmployee(steve).size());
        assertEquals(1, timesheetService.tasksForEmployee(bill).size());
    }
    
    @Test
    public void testTasksForManagers() {
        Manager eric = managerDao.find(1L);
        assertEquals(1, timesheetService.tasksForManager(eric).size());
    }
    
}
