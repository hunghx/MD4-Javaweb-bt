package ra.mvc.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.DataOutput;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "DongVat")
public class Animals {
    @Id
    private Integer id;
    @Column(name = "ten")
    private String name;
    @Column(name = "cannang")
    private Double weight;
}
