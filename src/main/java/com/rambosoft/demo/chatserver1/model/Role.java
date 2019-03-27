package com.rambosoft.demo.chatserver1.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by rambo on 2019/3/27.
 */
@Entity
public class Role {
    @Id
    @GeneratedValue
    private Integer id;
    private String roleName;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Promission> getPrommissions() {
        return prommissions;
    }

    public void setPrommissions(List<Promission> prommissions) {
        this.prommissions = prommissions;
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "role")
    private List<Promission> prommissions;
}
