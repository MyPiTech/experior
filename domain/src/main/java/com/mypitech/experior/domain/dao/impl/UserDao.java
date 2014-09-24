package com.mypitech.experior.domain.dao.impl;

import com.mypitech.experior.domain.bean.UserBean;
import com.mypitech.experior.domain.dao.IUserDao;
import com.mypitech.experior.domain.entity.UserEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

//import com.mypitech.experior.domain.mapper.GenericMapper;

/**
 * Created by Shawn Wheeler on 9/18/2014.
 */
@Stateless
public class UserDao implements IUserDao {
    @PersistenceContext(unitName = "experior")
    private EntityManager entityManager;

    /*@Inject
    private GenericMapper mapper;*/

    //@Inject
    //private UserEntityMapper userEntityMapper;

    @Override
    public UserBean read(String identity) {
        UserBean returnBean = new UserBean();
        UserEntity entity = entityManager.find(UserEntity.class, identity);
        returnBean.setIdentity(entity.getIdentity());
        returnBean.setName(entity.getName());
        returnBean.setDescription(entity.getDescription());
        return returnBean;
        //return mapper.map(entityManager.find(UserEntity.class, identity), UserBean.class);
    }

    @Override
    public String create(UserBean user) {
        UserEntity entity = new UserEntity();
        entity.setName(user.getName());
        entity.setDescription(user.getDescription());
        entityManager.persist(entity);
        return entity.getIdentity();
    }

    @Override
    public void update(String identity, UserBean user) {
        UserEntity existing = entityManager.find(UserEntity.class, identity);
        existing.setName(user.getName());
        existing.setDescription(user.getDescription());
        //UserEntity updated = mapper.map(user, UserEntity.class);
        //userEntityMapper.map(updated, existing);
        entityManager.persist(existing);
    }

    @Override
    public void delete(String identity) {
        entityManager.remove(entityManager.find(UserEntity.class, identity));
    }

    @Override
    public List<UserBean> all() {
        List<UserBean> returnList = new ArrayList<UserBean>();
        List<UserEntity> entities = entityManager.createNamedQuery(GET_ALL,UserEntity.class).getResultList();
        for(UserEntity entity: entities){
            UserBean userBean = new UserBean();
            userBean.setIdentity(entity.getIdentity());
            userBean.setName(entity.getName());
            userBean.setDescription(entity.getDescription());
            returnList.add(userBean);
        }
        return returnList;
        //return mapper.mapAsList(entityManager.createNamedQuery(GET_ALL,UserEntity.class).getResultList(), UserBean.class);
    }
}
