package com.maimu.login.api.repository.maimu;


import com.maimu.login.api.domain.Maimu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaimuRepository extends JpaRepository<Maimu, Long>, MaimuRepositoryCustom{
}
