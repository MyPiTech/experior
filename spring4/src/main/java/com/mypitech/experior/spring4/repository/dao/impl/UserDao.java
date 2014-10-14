package com.mypitech.experior.spring4.repository.dao.impl;

import com.mypitech.experior.spring4.repository.bean.UserBean;
import com.mypitech.experior.spring4.repository.dao.IUserDao;
import com.mypitech.experior.spring4.repository.entity.UserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Shawn Wheeler on 9/18/2014.
 */
@Repository
public class UserDao implements IUserDao {
    @PersistenceContext(unitName = "experior")
    private EntityManager entityManager;

    @Override
    public UserBean read(String identity) {
        UserBean returnBean = new UserBean();
        UserEntity entity = entityManager.find(UserEntity.class, identity);
        returnBean.setIdentity(entity.getIdentity());
        returnBean.setName(entity.getName());
        returnBean.setDescription(entity.getDescription());
        return returnBean;
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
        entityManager.persist(existing);
    }

    @Override
    public void delete(String identity) {
        entityManager.remove(entityManager.find(UserEntity.class, identity));
    }

    @Override
    public List<UserBean> all() {
        List<UserBean> returnList = new ArrayList<UserBean>();
        List<UserEntity> entities = entityManager.createNamedQuery(GET_ALL, UserEntity.class).getResultList();
        for(UserEntity entity: entities){
            UserBean userBean = new UserBean();
            userBean.setIdentity(entity.getIdentity());
            userBean.setName(entity.getName());
            userBean.setDescription(entity.getDescription());
            returnList.add(userBean);
        }
        return returnList;
    }
}
