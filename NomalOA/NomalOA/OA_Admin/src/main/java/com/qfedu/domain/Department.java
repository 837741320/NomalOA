package com.qfedu.domain;

import java.util.List;

public class Department {

    private int id;
    private String d_name;

    private String d_desc;

    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public String getD_desc() {
        return d_desc;
    }

    public void setD_desc(String d_desc) {
        this.d_desc = d_desc;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", d_name='" + d_name + '\'' +
                ", d_desc='" + d_desc + '\'' +
                ", users=" + users +
                '}';
    }
}
