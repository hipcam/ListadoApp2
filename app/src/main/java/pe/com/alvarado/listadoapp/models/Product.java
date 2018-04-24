package pe.com.alvarado.listadoapp.models;

import com.orm.dsl.Table;

/**
 * Created by Alumno on 20/04/2018.
 */
@Table
public class Product {
    private Long id;
    private String name;
    private String category;
    private String precio;
    private String desc;

    public Product(){

    }

    public Product(String name, String category, String precio, String desc) {
        this.name = name;
        this.category = category;
        this.precio = precio;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", precio='" + precio + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

