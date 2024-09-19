package ra.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person {
    private int id;
    private String name;
    private int age;
    private String checkbox;
    private List<String> checkboxes;
    private String select;
}
