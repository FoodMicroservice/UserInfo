package org.codedecode.userinfo.service;


import org.codedecode.userinfo.dto.UserDTO;
import org.codedecode.userinfo.entity.User;
import org.codedecode.userinfo.mapper.UserMapper;
import org.codedecode.userinfo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserDTO addUser(UserDTO userDTO) {
       User Saveduser= userRepo.save(UserMapper.INSTANCE.mapUserDTOtoUser(userDTO));

       UserDTO savedDto=UserMapper.INSTANCE.mapUserToUserDTO(Saveduser);
       return savedDto;
    }

    public ResponseEntity<UserDTO> fetchUserDetailsById(Integer id) {
        Optional<User> fetchUser=userRepo.findById(id);

        if(fetchUser.isPresent()){
            return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTO(fetchUser.get()), HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }
}
