package com.sofkau.microservicio2.services;

import com.sofkau.microservicio2.model.Producto;
import com.sofkau.microservicio2.repository.ProductoRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServices {
    @Autowired
    ProductoRepository productoRepository;

    public void save (Producto producto){
        this.productoRepository.save(producto);
    }

    public Optional<Producto> findById(String id){
        return this.productoRepository.findById(id);
    }

    public Producto update(String id, Producto producto){
        var p =this.productoRepository.findById(id).get();
        p.setNombre(producto.getNombre());
        p.setPrecio(producto.getPrecio());
        p.setDescripcion(producto.getDescripcion());
        p.setStock(producto.getStock());
        save(p);
        return p;
    }

    public List<Producto> findAll(){
        return this.productoRepository.findAll();
    }
}
