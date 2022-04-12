package com.sofkau.microservicio2.controller;

import com.sofkau.microservicio2.model.Producto;
import com.sofkau.microservicio2.services.ProductoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductoController {
    @Autowired
    ProductoServices productoServices;

    @PostMapping("/productos")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Producto producto){
        this.productoServices.save(producto);
    }

    @PutMapping("/productos/{id}")
    public Producto update(@PathVariable("id") String id, @RequestBody Producto producto) {
        return this.productoServices.update(id, producto);
    }


}
