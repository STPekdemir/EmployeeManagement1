package net.javaguides.emsbackend.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")

public class Employee implements UserDetails {
    /* @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;*/
    @GenericGenerator(name = "user_name", strategy = "net.javaguides.emsbackend.config.GeneratorClass")
    @GeneratedValue(generator = "user_name")
    @Id
    @Column(name = "user_name", unique = true)
    private String userName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id", unique = true)
    private String email;
    @UpdateTimestamp
    @Column(name = "updated_date")
    private Date updatedDate;
    @CreationTimestamp
    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "password", nullable = false)
    private String password;


    //istenilen kullanıcı varlığını her getirdiğimde bunla birlikte rolleri de getirir
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "employee_roles",
            joinColumns = @JoinColumn(name = "employee_user_name", referencedColumnName = "user_name"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}