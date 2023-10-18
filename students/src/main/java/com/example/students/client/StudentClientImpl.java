package com.example.students.client;

import com.example.students.domain.StudentFullName;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Repository
public class StudentClientImpl {
    private final StudentClient client;

    @Value("${path.urlNameService}")
    private String urlNameService;

    public String getStudentNameById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        String resourceURL = String.format(urlNameService, id);// service: name
        return restTemplate.getForObject(resourceURL, String.class);
    }

    public String getStudentLastNameById(Integer id) {
        return client.getStudentLastName(id);//service: last-name
    }
}