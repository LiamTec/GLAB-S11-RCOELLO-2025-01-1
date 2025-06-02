package pe.edu.tecsup.lab11.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Laboratorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codLab;

    private String razonSocial;
    private String direccion;
    private String telefono;
    private String email;
    private String contacto;

    @OneToMany(mappedBy = "laboratorio", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore  // O usa JsonManagedReference / JsonIgnoreProperties si quieres verlas
    private List<OrdenCompra> ordenes = new ArrayList<>();
    // Getters y Setters

    public Long getCodLab() {
        return codLab;
    }

    public void setCodLab(Long codLab) {
        this.codLab = codLab;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public List<OrdenCompra> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<OrdenCompra> ordenes) {
        this.ordenes = ordenes;
    }
}

