package ra.mvc.service.customer;

import org.springframework.stereotype.Service;
import ra.mvc.model.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    private List<Customer> list = new ArrayList<>();

    public CustomerService() {
        // khơi tao giá trị ban dau
        list.add(new Customer(1,"Nguyễn Văn A","Hưng Nguyên","hung@gmail.com"));
        list.add(new Customer(2,"Nguyễn Văn B","Hưng Nguyên","hung@gmail.com"));
        list.add(new Customer(3,"Nguyễn Văn C","Hưng Nguyên","hung@gmail.com"));
    }

    @Override
    public List<Customer> findAll() {
        return list;
    }

    @Override
    public Customer findById(Integer id) {
        return list.stream().filter(c->c.getId()==id)
                .findFirst().orElse(null);
    }

    @Override
    public void save(Customer customer) {
        if (findById(customer.getId())==null){
            // ko tồn tại, thêm mới
            customer.setId(getNewId());
            list.add(customer);
        }else {
            // chỉnh sửa
            list.set(list.indexOf(findById(customer.getId())),customer);
        }
    }

    @Override
    public void delete(Integer id) {
        Customer del = findById(id);
        if (del !=null){
            list.remove(del); // xóa
        }
    }
    private int getNewId(){
        // dùng stream
        // tìm ra thằng id lớn nhất + 1
        return list.stream().map(Customer::getId)
                .max(Comparator.naturalOrder())
                .orElse(0) + 1;
    }
}
