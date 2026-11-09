
package org.codedecode.userinfo.mapper;

import org.codedecode.userinfo.dto.UserDTO;
import org.codedecode.userinfo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "userName", source = "userName")
    @Mapping(target = "userPassword", source = "userPassword")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "city", source = "city")
    User mapUserDTOtoUser(UserDTO userDTO);

    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "userName", source = "userName")
    @Mapping(target = "userPassword", source = "userPassword")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "city", source = "city")
    UserDTO mapUserToUserDTO(User user);
}
