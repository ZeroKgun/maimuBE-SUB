package com.maimu.login.api.repository.maimu;


import com.maimu.login.api.domain.Maimu;
import com.maimu.login.api.dto.request.maimu.MaimuSearch;

import java.util.List;

public interface MaimuRepositoryCustom {

    List<Maimu> getList(MaimuSearch maimuSearch);
}
