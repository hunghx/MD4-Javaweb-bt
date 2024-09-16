package service;

import model.Product;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    public List<Product> productList = Arrays.asList(
            new Product(1,"Quan kaki nam1","mua he",1000000,"https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lzelm4q4tm4t35"),
            new Product(2,"Quan kaki nam2","mua he",1000000,"https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lzelm4q4tm4t35"),
            new Product(3,"Quan kaki nam3","mua he",1000000,"https://down-vn.img.susercontent.com/file/vn-11134207-7r98o-lzelm4q4tm4t35")
    );
    public List<Product> findAll(){
        return productList;
    }
}
