package com.app.SpringSecurityApp.persistence.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Builder //Se utiliza para implementar el patron de diseño builder
@AllArgsConstructor
//Genera un constructor con argumentos para cada campo de clase, util para inicializar todos los campos de una clase en un solo paso
@NoArgsConstructor //Genera un constructor sin argumentos
@Entity
@Table(name = "roles")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name")
    @Enumerated(EnumType.STRING)
    private RoleEnum roleEnum;


    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "role_permission",joinColumns = @JoinColumn(name="role_id"),inverseJoinColumns = @JoinColumn(name="permission_id"))
    private Set<PermissionEntity> permissionList = new HashSet<>();

}
