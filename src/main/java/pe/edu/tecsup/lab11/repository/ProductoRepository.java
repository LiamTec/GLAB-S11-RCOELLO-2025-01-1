package pe.edu.tecsup.lab11.repository;
import pe.edu.tecsup.lab11.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
