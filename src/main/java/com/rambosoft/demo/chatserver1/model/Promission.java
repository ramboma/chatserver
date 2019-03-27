package com.rambosoft.demo.chatserver1.model;

import javax.persistence.*;

/**
 * Created by rambo on 2019/3/27.
 */
@Entity
public class Promission {
    @Id
    @GeneratedValue
    private Integer id;
    private String promission;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPromission() {
        return promission;
    }

    public void setPromission(String promission) {
        this.promission = promission;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;
}
