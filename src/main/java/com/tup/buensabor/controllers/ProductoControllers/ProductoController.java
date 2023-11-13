package com.tup.buensabor.controllers.ProductoControllers;


import com.tup.buensabor.DTO.DTOProducto;
import com.tup.buensabor.controllers.BaseControllerImpl;
import com.tup.buensabor.entities.Producto.Producto;
import com.tup.buensabor.services.ProductoServices.ProductoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/productos")
public class ProductoController extends BaseControllerImpl<Producto, ProductoServiceImpl> {

    @GetMapping("/list")
    public ResponseEntity<?> obtenerProductos(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.obtenerProductos());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> agregarProducto(@RequestBody DTOProducto dtoProducto){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.agregarProducto(dtoProducto));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> actualizarProducto(@PathVariable Long id, @RequestBody DTOProducto DTOProducto){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.actualizarProducto(DTOProducto, id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> bajaProducto(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.bajaProducto(id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/searchDenominacion")
    public ResponseEntity<?> searchDenominacion(@RequestParam String filtro){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.searchDenominacion(filtro));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() +"\"}"));
        }
    }

    @GetMapping("/searchCategoria")
    public ResponseEntity<?> searchCategoria(@RequestParam String cate){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.searchCategoria(cate));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() +"\"}"));
        }
    }

    @GetMapping("/Receta/{id}")
    public ResponseEntity<?> getReceta(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.getReceta(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(("{\"error\": \"" + e.getMessage() +"\"}"));
        }
    }

    @GetMapping("/productosPagPrincipal")
    public ResponseEntity<?> getProdPagPrincipal(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.getProdPagPrincipal());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() +"\"}"));
        }
    }

}
