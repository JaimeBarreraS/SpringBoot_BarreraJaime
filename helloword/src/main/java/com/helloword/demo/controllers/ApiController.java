package com.helloword.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.helloword.demo.domain.Producto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ApiController {

    @GetMapping("/")
    public String home(){
        return "Home campers!";
    }

    @GetMapping("/saludo") //  /saludo?nombre=Jaime
    public String saludo(
        @RequestParam(name= "nombre", required = true) String name,
        @RequestParam(name= "apellido", required = false, defaultValue = "apellido comun") String lastName
    ){
        return "Hello " + name + " " + lastName;
    }

    @GetMapping("/search") //  /saludo?nombre=Jaime
    public Map<String, String> buscar(
        @RequestParam(name= "name", defaultValue = "") String name
        ){
            Map<String, String> cities = new HashMap<>();
            cities.put("BUC", "Bucaramanga");
            cities.put("NYC", "New York");
            cities.put("BOG", "Bogota");
            cities.put("NVA", "Neiva");
            cities.put("LET", "Leticia");
            cities.put("PER", "Pereira");
            
            if(cities.containsKey(name)){
                return Map.of(name, cities.get(name));
            } else {
                return cities;
            }
    }

    @GetMapping("/tax") //  /saludo?nombre=Jaime
    public Map<String, Object> calcular(
        @RequestParam(defaultValue = "0") Double impuestos
        ){
            List<Producto> productos = new ArrayList<>(
                List.of(new Producto(1,"Pan", 2000)));
            productos.add(new Producto(2, "Gaseosa", 3500));
            productos.add(new Producto(3, "Salchichon Zenu", 1500));

            double precios = productos.stream().map(producto -> producto.getPrice()).reduce(0.0,(precioA, precioB) -> precioA +precioB);



            return Map.of("prodcutos", productos , "total", (precios+(precios*(impuestos/100))), "valor_neto" , precios, "IVA", impuestos+"%");
    }
}
