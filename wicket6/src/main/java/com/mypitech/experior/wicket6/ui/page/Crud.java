package com.mypitech.experior.wicket6.ui.page;


import com.mypitech.experior.wicket6.domain.entity.UserEntity;
import com.mypitech.experior.wicket6.ui.panel.CrudPanel;
import com.mypitech.experior.wicket6.ui.panel.layout.Template;
import com.mypitech.experior.wicket6.ui.panel.layout.TopNav;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Shawn Wheeler on 10/1/2014.
 */
public class Crud extends Template {

    @PersistenceContext(unitName = "experior")
    private EntityManager entityManager;

    public Crud() {
        super();
        //List<UserBean> users = userDao.all();
        UserEntity user = entityManager.find(UserEntity.class,"b0b8daf0-44ed-11e4-94aa-f1a255884f61");
        replace(new CrudPanel(CONTENT_ID));
        TopNav topNav = (TopNav) getTopNav();
        topNav.setCrudItemActive();
    }
}
