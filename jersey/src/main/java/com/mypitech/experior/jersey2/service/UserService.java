package com.mypitech.experior.jersey2.service;

import com.mypitech.experior.jersey2.bean.UserBean;
import com.mypitech.experior.jersey2.domain.entity.UserEntity;
import com.mypitech.experior.jersey2.mapper.GenericMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Shawn Wheeler on 9/13/2014.
 */
@Stateless
public class UserService {

    @PersistenceContext(unitName = "test_data")
    private EntityManager entityManager;

    @Inject
    private GenericMapper mapper;

    public void create(UserBean user){
        entityManager.persist(mapper.map(user, UserEntity.class));
    }

    public void update(String identity, UserBean user){
        UserEntity existing = entityManager.find(UserEntity.class, identity);
        UserEntity updated = mapper.map(user, UserEntity.class);
        mapper.map(updated, existing);
        entityManager.persist(existing);
    }

    public UserBean read(String identity){
        return mapper.map(entityManager.find(UserEntity.class, identity), UserBean.class);
    }

    public void delete(String identity){
        entityManager.remove(entityManager.find(UserEntity.class, identity));
    }
}
