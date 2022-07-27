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
public class Category {
    @Id
    @Column(length = 100)
    private String name;
    @Column(length = 300, nullable = false)
    private String description;
}
