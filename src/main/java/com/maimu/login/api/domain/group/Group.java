package com.maimu.login.api.domain.group;

import com.maimu.login.api.domain.Locker;
import com.maimu.login.api.domain.Maimu;
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
@Table(name ="mainPage")
public class Group {

    @Id
    @GeneratedValue
    @Column(name = "group_id")
    private Long id;

    private String groupName;
    private String groupColor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "locker_id")
    private Locker locker;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    private List<Maimu> maimus = new ArrayList<>();

    @Builder
    public Group(String groupName, String groupColor, Locker locker){
        this.groupName = groupName;
        this.groupColor = groupColor;
        this.locker = locker;
    }

    public GroupEditor.GroupEditorBuilder toEditor(){
        return GroupEditor.builder()
                .groupName(groupName)
                .groupColor(groupColor);
    }

    public void edit (GroupEditor groupEditor){
        groupName = groupEditor.getGroupName();
        groupColor = groupEditor.getGroupColor();
    }




    public void addMaimu(Maimu maimu){
        maimu.updateGroup(this);
        this.maimus.add(maimu);
    }


    public void setLocker(Locker locker){
        this.locker = locker;
        locker.getGroups().add(this);
    }


}
