package com.mypitech.experior.domain.dao.impl;

import com.mypitech.experior.domain.bean.UserBean;
import com.mypitech.experior.domain.dao.IUserDao;
import com.mypitech.experior.domain.entity.UserEntity;
import com.mypitech.experior.domain.mapper.GenericMapper;
import com.mypitech.experior.domain.mapper.UserEntityMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Shawn Wheeler on 9/18/2014.
 */
@Stateless
public class UserDao implements IUserDao {
    @PersistenceContext(unitName = "experior")
    private EntityManager entityManager;

    @Inject
    private GenericMapper mapper;

    @Inject
    private UserEntityMapper userEntityMapper;

    @Override
    public UserBean read(String identity) {
        return mapper.map(entityManager.find(UserEntity.class, identity), UserBean.class);
    }

    @Override
    public void create(UserBean user) {
        entityManager.persist(mapper.map(user, UserEntity.class));
    }

    @Override
    public void update(String identity, UserBean user) {
        UserEntity existing = entityManager.find(UserEntity.class, identity);
        UserEntity updated = mapper.map(user, UserEntity.class);
        userEntityMapper.map(updated, existing);
        entityManager.persist(existing);
    }

    @Override
    public void delete(String identity) {
        entityManager.remove(entityManager.find(UserEntity.class, identity));
    }

    @Override
    public List<UserBean> all() {
        return mapper.mapAsList(entityManager.createNamedQuery(GET_ALL,UserEntity.class).getResultList(), UserBean.class);
    }
}
