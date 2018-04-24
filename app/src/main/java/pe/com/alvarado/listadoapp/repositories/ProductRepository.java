package pe.com.alvarado.listadoapp.repositories;

import com.orm.SugarRecord;

import java.util.List;

import pe.com.alvarado.listadoapp.models.Product;
/**
 * Created by Alumno on 20/04/2018.
 */

public class ProductRepository {

    public static List<Product> list(){
        List<Product> products= SugarRecord.listAll(Product.class);
        return products;
    }

    public static Product read(Long id){
        Product product = SugarRecord.findById(Product.class, id);
        return product;
    }

    public static void create(String name, String category, String precio, String desc){
        Product product = new Product(name, category, precio, desc);
        SugarRecord.save(product);
    }

    public static void update(String name, String category, String precio, String desc, Long id){
        Product product = SugarRecord.findById(Product.class, id);
        product.setName(name);
        product.setCategory(category);
        product.setPrecio(precio);
        product.setDesc(desc);
        SugarRecord.save(product);
    }

    public static void delete(Long id){
        Product product = SugarRecord.findById(Product.class, id);
        SugarRecord.delete(product);
    }

}
