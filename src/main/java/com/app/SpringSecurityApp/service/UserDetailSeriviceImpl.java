package com.app.SpringSecurityApp.service;


import com.app.SpringSecurityApp.persistence.entity.UserEntity;
import com.app.SpringSecurityApp.persistence.entity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailSeriviceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity =  userRepository.findUserEntityByUsername(username).orElseThrow(() -> new UsernameNotFoundException("El usuario no existe"));
        //HAy que convertir el UserEntity a un UserDetails

        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        userEntity.getRoles() //Mapeamos cada rol de administrador del enum a un SimpleGrantedAuthority
                .forEach(role->authorityList.add(new SimpleGrantedAuthority("ROLE_".concat(role.getRoleEnum().name()))));

        //Hay que agregar tambien cada uno de los permisos
        userEntity.getRoles().stream()
                .flatMap(role->role.getPermissionList().stream())
                .forEach(permission -> authorityList.add(new SimpleGrantedAuthority(permission.getName())));

        return new User(userEntity.getUsername(),userEntity.getPassword(),userEntity.getIsEnable(),userEntity.getAccountNoExpired(),
                userEntity.getCredentialNoExpired(), userEntity.getAccountNoLocked(), authorityList);
    }
}
