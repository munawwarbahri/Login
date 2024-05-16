package com.amigoscode.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@SuperBuilder
@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonProperty("full_name")
    @Column(unique = true, nullable = false, length = 60)
    private String fullname;

    @JsonProperty("no_handphone")
    @Column(unique = true, nullable = false, length = 30)
    private String nohandphone;

    @JsonProperty("email")
    @Column(name = "email", unique = true, nullable = false, length = 60)
    private String email;

    @JsonProperty("password")
    @Column(name = "password", unique = true, nullable = false, length = 255)
    private String password;

    @Column
    private Boolean verified;

    @Column
    private Boolean account_expired;

    @Column
    private Boolean account_non_locked;

    @Column
    private Boolean password_expired;

    @Column
    private Boolean enabled;

    @CreationTimestamp
    @Column(name =  "create_date_time")
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    @Column(name = "update_date_time")
    private LocalDateTime update_Date_time;

}
