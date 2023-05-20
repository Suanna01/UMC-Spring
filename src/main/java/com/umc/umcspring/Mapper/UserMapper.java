package com.umc.umcspring.Mapper;

import com.umc.umcspring.domain.User;
import org.mapstruct.Mapper;

//@Mapper
public interface UserMapper {
    void saveUser(User user);
}
