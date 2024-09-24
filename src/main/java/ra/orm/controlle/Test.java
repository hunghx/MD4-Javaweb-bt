package ra.orm.controlle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ra.orm.model.entity.Department;
import ra.orm.model.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Test {
//    @PersistenceContext
//    private EntityManager en;
    @Autowired
    private LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean;

    @GetMapping
    @Transactional
    public String test(){
        // thêmmoiwsi phong ban co nhan vien
        Department d1 = new Department(1,"Marketing",true,new ArrayList<>());
        Employee e1 = new Employee(1,"Nguyễn Văn A", LocalDate.of(1999,10,10),true,"09874353474","HN","a@gmail.com",true,d1);
        Employee e2 = new Employee(2,"Nguyễn Văn B", LocalDate.of(1999,10,11),false,"09874383474","HN","b@gmail.com",true,d1);
        List<Employee> list = d1.getEmployees();
        list.add(e1);
        list.add(e2);
        SessionFactory sessionFactory = (SessionFactory) localContainerEntityManagerFactoryBean.getObject();
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(d1);
        return "home";
    }
}
