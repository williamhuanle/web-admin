package mz.co.kr.webadmin.services;

import mz.co.kr.webadmin.dto.*;
import mz.co.kr.webadmin.restclient.AuthRestClient;
import mz.co.kr.webadmin.restclient.EmployeeRestClient;
import mz.co.kr.webadmin.restclient.UserRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRestClient employeeRestClient;

    public List<EmployeeDto> fetchAllEmployee() {
        return employeeRestClient.fetchAllEmployee();
    }

}
