package mz.co.kr.webadmin.restclient;

import mz.co.kr.webadmin.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class EmployeeRestClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value( "${restclient.admin-service.fetchAllEmployeeUrl}")
    private String fetchAllEmployeeUrl;

    public List<EmployeeDto> fetchAllEmployee() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity <> (headers);
        ResponseEntity<EmployeeDto[]> response = restTemplate.exchange(fetchAllEmployeeUrl, HttpMethod.GET, entity, EmployeeDto[].class);
        List<EmployeeDto> employees = List.of(response.getBody());
        return employees;
    }
}
