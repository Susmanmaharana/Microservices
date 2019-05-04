package com.spring_mongo.app.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user")
public class Users {

    @Id
    private Object id;
    private String name;
    private String teamName;
    private Long salary;

    public Users(Object id, String name, String teamName, Long salary) {
        this.id = id;
        this.name = name;
        this.teamName = teamName;
        this.salary = salary;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
