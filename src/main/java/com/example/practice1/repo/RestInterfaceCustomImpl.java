package com.example.practice1.repo;
import com.example.practice1.Model.QUser;
import com.example.practice1.Model.User;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RestInterfaceCustomImpl implements   RestInterfaceCustom {
    private final JPAQueryFactory  jpaQueryFactory;

    public RestInterfaceCustomImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public long GetAllUserCnt(){
        QUser qUser = QUser.user;
        return   jpaQueryFactory
                        .select(qUser.count())
                        .from(qUser)
                        .fetchOne();
    }

    @Override
    public List<User> UserSearch(User user) {
        QUser qUser = QUser.user;
        BooleanBuilder builder = new BooleanBuilder();

        if (user.getName() != null) {
            builder.and(qUser.name.eq(user.getName()));
        }

        if (user.getAge() != 0) {
            builder.and(qUser.age.eq(user.getAge()));
        }

        return jpaQueryFactory
                .select(qUser)
                .from(qUser)
                .where(builder)
                .fetch();
    }
}
