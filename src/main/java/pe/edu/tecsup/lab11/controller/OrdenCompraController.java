package pe.edu.tecsup.lab11.controller;

import pe.edu.tecsup.lab11.model.OrdenCompra;
import pe.edu.tecsup.lab11.repository.OrdenCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordenes")
public class OrdenCompraController {

    @Autowired
    private OrdenCompraRepository repo;

    @GetMapping
    public List<OrdenCompra> listar() {
        return repo.findAll();
    }

    @PostMapping
    public OrdenCompra guardar(@RequestBody OrdenCompra orden) {
        return repo.save(orden);
    }

    @GetMapping("/{id}")
    public OrdenCompra buscar(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public OrdenCompra actualizar(@PathVariable Long id, @RequestBody OrdenCompra orden) {
        orden.setNroOrdenC(id);
        return repo.save(orden);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
