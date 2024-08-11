package com.app.SpringSecurityApp.config;

import com.app.SpringSecurityApp.service.UserDetailSeriviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity //Activar la seguridad
@EnableMethodSecurity //Permite hacer configuraciones con anotaciones junto con PreAuthorize en el Controller
public class SecurityConfig {

//    @Autowired
//    AuthenticationConfiguration authenticationConfiguration;

    //Sin annotaciones
    //Esto en la arquitectura es el Security Filter Chain
//    @Bean //indica que el metodo securityFilterChain sera administrado por Srping
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception { //HttpSecurity: Es una clase en Spring Security que proporciona una API para configurar la seguridad HTTP de la aplicación.
////        SecurityFilterChain: Es una interfaz en Spring Security que define una cadena de filtros (filters) aplicados a
////        las solicitudes HTTP. Estos filtros son responsables de manejar la autenticación, autorización, y otros aspectos de la seguridad
////        en tu aplicación.
//
//        //A continuacion vamos a definir las condiciones de los filtros de seguridad a traves de DelegatingFilterProxy
//
//
//        return httpSecurity
//                .csrf(csrf -> csrf.disable()) //desactivamos la proteccion porquen en sistemas REST no es necesaria
//                .httpBasic(Customizer.withDefaults()) //Se utiliza cuando unicamente te vas a loggear con usuario y contraseña, por defecto
//                .sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) //Sin estado, para evitar
//                //que se creen objetos de session en memoria, la sesion va a depender de la expiracion de los tokens. Evita que se generen sesiones
//                .authorizeHttpRequests(http->{ //vamos a filtar los enpoints por publicos y no publicos
//                    //Configurar los endpoints publicos
//                    http.requestMatchers(HttpMethod.GET,"/auth/hello").permitAll(); //va a ser un enpoint public
//                    //configurar los enpoints privados
//                    http.requestMatchers(HttpMethod.GET,"/auth/hello-secured").hasAuthority("CREATE");
//                    //Cualquier otro request deniegas el acceso
//                    //Configurar el resto de enpoints o no especificados
//                    //http.anyRequest().denyAll();//Con esto se van a bloquear todas las otras peticiones
//                    //Cualquier otro enpoint necesita autenticacion
//                    http.anyRequest().authenticated();
//
//                })
//                .build();
//    }

    //Con anotaciones
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build(); //Las autorizaciones de los enpoints se coloca en el controller con PreAuthorized

    }

    //Esta es la parte de Auhtentication Manager
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    //Vamos por la parte de autenticacion Provider, vamos a usar DAO que se conectar a una base de datos
    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailSeriviceImpl userDetailSerivice){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        //Dao necesita dos modulos, PasswordEncoder y UserDetailService
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailSerivice);
        return provider;
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
////        List<UserDetails> userDetails = new ArrayList<>();
////        userDetails.add(User.withUsername("santiago") //Con esto se van a validar los usuarios
////                .password("1234")
////                .roles("ADMIN")
////                .authorities("READ","CREATE") //LOS PERMISOS
////                .build()); //Patron de diseño builder: https://www.youtube.com/watch?v=zfW9uEoGx2c
////        userDetails.add(User.withUsername("daniel") //Con esto se van a validar los usuarios
////                .password("1234")
////                .roles("User")
////                .authorities("READ") //LOS PERMISOS
////                .build()); //Patron de diseño builder: https://www.youtube.com/watch?v=zfW9uEoGx2c)
////        return new InMemoryUserDetailsManager(userDetails); //Este usuario lo va a guardar en memoria
//        //Por ahora van a existir dos usuarios en memoria
//    }

    //Ahora con una base de datos

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance(); //Solo es para usar pruebas
    }

    public static void main(String[] args) {

    }
}

