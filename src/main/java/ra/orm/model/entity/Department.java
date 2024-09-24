package ra.orm.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private int id;
    @Column(name = "department_name", columnDefinition = "varchar(100)", unique = true)
    private String name;
    private boolean status;
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL ) // 2 chiều
    private List<Employee> employees;
}
