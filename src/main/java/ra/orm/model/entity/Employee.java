package ra.orm.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int id;
    @Column(name = "employee_name")
    private String name;
    @Column(columnDefinition = "date")
    private LocalDate dob;
    private boolean sex;
    private String phone;
    private String address;
    private String email;
    private boolean status;
//    private int departmentId;
    @ManyToOne
    // định nghia khoa ngoai
    @JoinColumn(name="department_id")
    private Department department;
//    quan hệ 1 chiều
}
