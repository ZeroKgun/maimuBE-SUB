package com.maimu.login.api.domain;

import com.maimu.login.api.domain.group.Group;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Maimu {

    @Id
    @GeneratedValue
    @Column(name = "maimu_id")
    private Long id;

    @Lob
    private String message;

    private String maimuColor;

    private String writerName;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;


    @Builder
    public Maimu(String message, String maimuColor, String writerName, Group group){
        this.message = message;
        this.maimuColor = maimuColor;
        this.writerName = writerName;
        this.group = group;
    }

    public void updateGroup(Group group){
        this.group = group;
    }


}
