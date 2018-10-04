package poc.spring.boot.domain.model;

import javax.persistence.*;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;

import java.util.ArrayList;
import java.util.List;
 
@Entity
public class User extends AbstractNamedDomainClass  {
 
    @Transient
    private String password;
 
    private String encryptedPassword;
    private Boolean enabled = true;
 
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles = new ArrayList<>();
    private Integer failedLoginAttempts = 0;
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
        this.encryptedPassword=PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(password);
    }
 
    public String getEncryptedPassword() {
        return encryptedPassword;
    }
 
    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }
 
    public Boolean getEnabled() {
        return enabled;
    }
 
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
 
 
    public List<Role> getRoles() {
        return roles;
    }
 
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
 
    public void addRole(Role role){
        if(!this.roles.contains(role)){
            this.roles.add(role);
        }
 
        if(!role.getUsers().contains(this)){
            role.getUsers().add(this);
        }
    }
 
    public void removeRole(Role role){
        this.roles.remove(role);
        role.getUsers().remove(this);
    }
 
    public Integer getFailedLoginAttempts() {
        return failedLoginAttempts;
    }
 
    public void setFailedLoginAttempts(Integer failedLoginAttempts) {
        this.failedLoginAttempts = failedLoginAttempts;
    }
}