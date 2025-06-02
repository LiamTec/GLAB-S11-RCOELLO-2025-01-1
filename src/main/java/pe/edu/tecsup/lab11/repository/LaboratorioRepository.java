package pe.edu.tecsup.lab11.repository;

import pe.edu.tecsup.lab11.model.Laboratorio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaboratorioRepository extends JpaRepository<Laboratorio, Long> {
}