package co.carmen.superapptwo.model;


import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;


@Table(name = "BaseClient")

public class BaseClient extends Model {

    @Column(name = "Nombre")
    public String name;
    @Column(name = "Supermercado")
    public String supermercado;
    @Column(name = "direccion")
    public String direccion;
    @Column(name = "precio")
    public Float precio;


    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupermercado() {
        return supermercado;
    }

    public void setSupermercado(String supermercado) {
        this.supermercado = supermercado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
}

