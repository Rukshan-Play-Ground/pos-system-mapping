package lk.ijse.dep12.jpa.relationship.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "`user`")
public class User implements Serializable {
    @Id
    @Column(name = "username")
    private String userName;
    private String name;
    private String password;
}
