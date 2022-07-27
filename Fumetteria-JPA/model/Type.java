package school.devskill.demoJPA.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
public class Type {
    @Id
    @Column(length = 13)
    private String value;
}
