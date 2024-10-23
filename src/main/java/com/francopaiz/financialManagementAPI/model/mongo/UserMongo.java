package com.francopaiz.financialManagementAPI.model.mongo;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Data
@Document(collection = "users")
public class UserMongo {

    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String phone;

    public UserMongo() {
    }

    public UserMongo(String id, String name, String email, String password, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        // Aplicar cifrado de BCrypt siempre que se cambie la contraseña
        this.password = new BCryptPasswordEncoder().encode(password);
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}