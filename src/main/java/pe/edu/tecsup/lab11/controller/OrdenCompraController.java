package pe.edu.tecsup.lab11.controller;

import pe.edu.tecsup.lab11.model.OrdenCompra;
import pe.edu.tecsup.lab11.repository.OrdenCompraRepository;
import pe.edu.tecsup.lab11.repository.LaboratorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordenes")
public class OrdenCompraController {

    @Autowired
    private OrdenCompraRepository ordenRepo;

    @Autowired
    private LaboratorioRepository labRepo;

    @GetMapping
    public List<OrdenCompra> listar() {
        return ordenRepo.findAll();
    }

    @PostMapping("/{codLab}")
    public OrdenCompra guardar(@RequestBody OrdenCompra orden, @PathVariable Long codLab) {
        orden.setLaboratorio(labRepo.findById(codLab).orElse(null));
        return ordenRepo.save(orden);
    }

    @GetMapping("/{id}")
    public OrdenCompra buscar(@PathVariable Long id) {
        return ordenRepo.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public OrdenCompra actualizar(@PathVariable Long id, @RequestBody OrdenCompra orden) {
        orden.setNroOrdenC(id);
        return ordenRepo.save(orden);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        ordenRepo.deleteById(id);
    }
}

