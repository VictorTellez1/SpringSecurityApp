package com.app.SpringSecurityApp.persistence.entity;


import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder //Se utiliza para implementar el patron de diseño builder
@AllArgsConstructor
//Genera un constructor con argumentos para cada campo de clase, util para inicializar todos los campos de una clase en un solo paso
@NoArgsConstructor //Genera un constructor sin argumentos
@Entity
@Table(name = "permissions")
public class PermissionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false,updatable = false)
    private String name;
}
