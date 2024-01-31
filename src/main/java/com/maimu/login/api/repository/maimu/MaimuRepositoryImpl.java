package com.maimu.login.api.repository.maimu;

import com.maimu.login.api.domain.Maimu;
import com.maimu.login.api.dto.request.maimu.MaimuSearch;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;



@RequiredArgsConstructor
public class MaimuRepositoryImpl implements MaimuRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Maimu> getList(MaimuSearch maimuSearch) {
        return jpaQueryFactory.selectFrom(maimu)
                .limit(maimuSearch.getSize())
                .offset(maimuSearch.getOffset())
                .orderBy(maimu.id.desc())
                .fetch();
    }

}
