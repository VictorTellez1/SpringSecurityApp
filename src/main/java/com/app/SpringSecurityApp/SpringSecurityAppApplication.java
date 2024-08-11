package com.app.SpringSecurityApp;

import com.app.SpringSecurityApp.persistence.entity.PermissionEntity;
import com.app.SpringSecurityApp.persistence.entity.RoleEntity;
import com.app.SpringSecurityApp.persistence.entity.RoleEnum;
import com.app.SpringSecurityApp.persistence.entity.UserEntity;
import com.app.SpringSecurityApp.persistence.entity.repository.UserRepository;
import jakarta.persistence.Table;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SpringSecurityAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityAppApplication.class, args);
	}


	//Se va a ejecutar cuando se corra la aplicacion
//	@Bean
//	CommandLineRunner init(UserRepository userRepository){
//		return args ->{
//			//Create permissions
//			PermissionEntity createPermission = PermissionEntity.builder()
//					.name("CREATE")
//					.build(); //Ver el video de builder
//			PermissionEntity readPermission = PermissionEntity.builder()
//					.name("READ")
//					.build(); //Ver el video de builder
//			PermissionEntity updatePermission = PermissionEntity.builder()
//					.name("UPDATE")
//					.build(); //Ver el video de builder
//			PermissionEntity deletePermission = PermissionEntity.builder()
//					.name("DELETE")
//					.build(); //Ver el video de builder
//			PermissionEntity refactorPermission = PermissionEntity.builder()
//					.name("REFACTOR")
//					.build(); //Ver el video de builder
//
//
//			//CREAR LOS ROLES
//
//			RoleEntity roleAdmin = RoleEntity.builder()
//					.roleEnum(RoleEnum.ADMIN)
//					.permissionList(Set.of(createPermission,readPermission,updatePermission,deletePermission)) //Crear un set inmutable
//					.build();
//			RoleEntity roleUser = RoleEntity.builder()
//					.roleEnum(RoleEnum.USER)
//					.permissionList(Set.of(createPermission,readPermission)) //Crear un set inmutable
//					.build();
//			RoleEntity roleInvited = RoleEntity.builder()
//					.roleEnum(RoleEnum.INVITED)
//					.permissionList(Set.of(readPermission)) //Crear un set inmutable
//					.build();
//			RoleEntity roleDeveloper = RoleEntity.builder()
//					.roleEnum(RoleEnum.DEVELOPER)
//					.permissionList(Set.of(createPermission,readPermission,updatePermission,deletePermission,refactorPermission)) //Crear un set inmutable
//					.build();
//
//			//Crear los usuarios
//
//			UserEntity userSantiago = UserEntity.builder()
//					.username("Santiago")
//					.password("1234")
//					.isEnable(true)
//					.accountNoExpired(true)
//					.accountNoLocked(true)
//					.credentialNoExpired(true)
//					.roles(Set.of(roleAdmin))
//					.build();
//			UserEntity userDaniel = UserEntity.builder()
//					.username("Daniel")
//					.password("1234")
//					.isEnable(true)
//					.accountNoExpired(true)
//					.accountNoLocked(true)
//					.credentialNoExpired(true)
//					.roles(Set.of(roleUser))
//					.build();
//			UserEntity userAndrea = UserEntity.builder()
//					.username("Andrea")
//					.password("1234")
//					.isEnable(true)
//					.accountNoExpired(true)
//					.accountNoLocked(true)
//					.credentialNoExpired(true)
//					.roles(Set.of(roleInvited))
//					.build();
//			UserEntity userAnyi = UserEntity.builder()
//					.username("Anyi")
//					.password("1234")
//					.isEnable(true)
//					.accountNoExpired(true)
//					.accountNoLocked(true)
//					.credentialNoExpired(true)
//					.roles(Set.of(roleDeveloper))
//					.build();
//
//			userRepository.saveAll(List.of(userSantiago,userDaniel,userAndrea,userAnyi));
//
//		};


}
