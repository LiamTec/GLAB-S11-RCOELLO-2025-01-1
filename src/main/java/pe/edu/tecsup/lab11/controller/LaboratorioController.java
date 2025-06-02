package pe.edu.tecsup.lab11.controller;

import pe.edu.tecsup.lab11.model.Laboratorio;
import pe.edu.tecsup.lab11.repository.LaboratorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laboratorios")
public class LaboratorioController {

    @Autowired
    private LaboratorioRepository repo;

    @GetMapping
    public List<Laboratorio> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Laboratorio guardar(@RequestBody Laboratorio lab) {
        return repo.save(lab);
    }

    @GetMapping("/{id}")
    public Laboratorio buscar(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Laboratorio actualizar(@PathVariable Long id, @RequestBody Laboratorio lab) {
        lab.setCodLab(id);
        return repo.save(lab);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repo.deleteById(id);
    }
}

