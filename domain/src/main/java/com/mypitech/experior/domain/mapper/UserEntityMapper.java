package com.mypitech.experior.domain.mapper;

import com.mypitech.experior.domain.entity.UserEntity;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

/**
 * Created by Shawn Wheeler on 9/19/2014.
 */
public class UserEntityMapper extends ConfigurableMapper {
    @Override
    public void configure(MapperFactory mapperFactory) {
        mapperFactory.classMap(UserEntity.class, UserEntity.class).mapNulls(false).byDefault().register();
    }
}
