
package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persitencia.ControladoraPersitencia;
import java.util.List;

public class Controladora {
    // instancia de controladora de persitencia
        ControladoraPersitencia controlPersis = new ControladoraPersitencia();
     
    
    //recibo los datos de IGU principal 
    public void guardar(String nombreMasco, String raza, String color, 
            String observaciones,
            String alergico, String ateEsp, String nombreDuenio, String celDuenio) {
        
       //creo el dueño y seteamos los valores correspondientes 
        Duenio duenio = new Duenio ();
       
        duenio.setNombre(nombreDuenio);
        duenio.setCelDuenio(celDuenio);
        
        //creo la mascota y setemas los valores correspondientes
        Mascota masco = new Mascota();
        
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(ateEsp);
        masco.setObservaciones(observaciones);
        masco.setUnDuenio(duenio);
        
        //guardar todos estos datos en la controladora de persistencia
        
        controlPersis.guardar(duenio,masco);
        
    }

    public List<Mascota> traerMascotas() {
        return controlPersis.traerMascotas();
    }
    //metodo borrar mascota
    public void borrarMascota(int num_cliente) {
        controlPersis.borrarMascota(num_cliente);
    }

    public void editarMascota() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    //para modificar editar mascota 

    public Mascota traerMascotas(int num_cliente) {
        return controlPersis.traerMascota(num_cliente);

    }
    
    //al objeto masco se le debe asignar los nuevos valores que le siguen
    public void modificarMascota(Mascota masco, String nombreMasco, String raza, 
            String color, String observaciones, String alergico, String ateEsp, 
            String nombreDuenio, String celDuenio) {
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observaciones);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(ateEsp);
        
        //modifico mascota
        controlPersis.modificarMascota(masco);
        
        Duenio dueno = this.buscarDuenio(masco.getUnDuenio().getId_duenio());
        
        //ahora si seteo los valores a duenio
        dueno.setNombre(nombreDuenio);
        dueno.setCelDuenio(celDuenio);
        
        //llamar al modificar duenio
        this.modificarDuenio(dueno);
    }

    private Duenio buscarDuenio(int id_duenio) {
        return controlPersis.traerDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio dueno) {
        controlPersis.modificarDuenio(dueno);
    }
    
}
