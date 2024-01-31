package com.maimu.login.api.repository.group;

import com.maimu.login.api.domain.group.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
