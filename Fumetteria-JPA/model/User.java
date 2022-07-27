package school.devskill.demoJPA.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
public class User {
    @Id
    @Column(length = 18)
    private String username;
    @Column(length = 30, nullable = false)
    private String password;
    @Column(length = 20, nullable = false)
    private String name;
    @Column(length = 22, nullable = false)
    private String surname;
}
