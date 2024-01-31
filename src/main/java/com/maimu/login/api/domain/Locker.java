package com.maimu.login.api.domain;

import com.maimu.login.api.domain.group.Group;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Locker {

    @Id
    @GeneratedValue
    @Column(name = "locker_id")
    private Long id;
    private String lockerName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private Users users;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locker")
    private List<Group> groups = new ArrayList<>();

    @Builder
    public Locker(String lockerName, Users users){
        this.lockerName = lockerName;
        this.users = users;
    }

    public void setUsers(Users users){
        this.users = users;
        users.getLockers().add(this);
    }

}
