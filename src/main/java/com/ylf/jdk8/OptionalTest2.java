package com.ylf.jdk8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class OptionalTest2 {

    public static void main(String[] args) {

        Employee employee1 = new Employee();
        employee1.setName("zhangsan");

        Employee employee2 = new Employee();
        employee2.setName("lisi");

        Company company = new Company();
        company.setName("company1");
        company.setEmployees(Arrays.asList(employee1, employee2));

        List<Employee> employeeList = company.getEmployees();

        Optional<Company> optional = Optional.ofNullable(company);
        optional.map((item) -> item.getEmployees()).ifPresent(p -> p.forEach(e -> System.out.println(e.getName())));

        System.out.println(optional.map(theCompany -> theCompany.getEmployees()).orElse(Collections.emptyList()));
    }
}
