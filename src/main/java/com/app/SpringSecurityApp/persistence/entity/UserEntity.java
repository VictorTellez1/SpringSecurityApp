package com.app.SpringSecurityApp.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Builder //Se utiliza para implementar el patron de diseño builder
@AllArgsConstructor //Genera un constructor con argumentos para cada campo de clase, util para inicializar todos los campos de una clase en un solo paso
@NoArgsConstructor //Genera un constructor sin argumentos
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;

    //Va a ser unidireccional, solo se declara de un lado. Usamos una lista de set para evitar que se repitan roles
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL) //Carga la relacion inmediatamente cuando la entidad principal se recupera de la base de datos, es decir que la entidad
    //principal se recupera de la base de datos junto a la relacionada
    @JoinTable(name = "user_role",joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="role_id"))
    //name es el nombre de la tabla union en la base de datos.
    //user_id define la columna en la tabla de union(user_roles) que se utiliza para hacer referencia a la entidad origne que en este caso es user
    //hacer referencia ala entidad destino que es role_id
    private Set<RoleEntity> roles = new HashSet<>(); //Una buena practica es inicializar de inmediato las colecciones




    @Column(name = "is_enabled") //Es el nombre que se va a colocar en la base de datos
    private Boolean isEnable;
    @Column(name = "account_No_Expired")
    private Boolean accountNoExpired;
    @Column(name = "account_No_Locked")
    private Boolean accountNoLocked;
    @Column(name = "credential_No_Expired")
    private Boolean credentialNoExpired;


}
