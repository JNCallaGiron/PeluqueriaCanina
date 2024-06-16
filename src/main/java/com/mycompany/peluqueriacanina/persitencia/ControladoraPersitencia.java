
package com.mycompany.peluqueriacanina.persitencia;

import com.mycompany.peluqueriacanina.logica.Duenio;
import com.mycompany.peluqueriacanina.logica.Mascota;
import com.mycompany.peluqueriacanina.persitencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersitencia {
    DuenioJpaController duenioJpa = new DuenioJpaController();
    MascotaJpaController mascoJpa = new MascotaJpaController();
    
    
    //metodo creado desde la CONTROLADORA LOGICA
    public void guardar(Duenio duenio, Mascota masco) {
        //instancio primero  duenio por ser el principal en la relacion 1 a 1
        //creo en la BD duenio
        duenioJpa.create(duenio);
        //creo en la BD mascota
        mascoJpa.create(masco);
    }

    public List<Mascota> traerMascotas() {
        return mascoJpa.findMascotaEntities();
    }
    //metodo borrar mascota
    public void borrarMascota(int num_cliente) {
        try {
            mascoJpa.destroy(num_cliente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersitencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //llamado de logica para buscar la mascota
    public Mascota traerMascota(int num_cliente) {
       return  mascoJpa.findMascota(num_cliente);
    }
    //modificacion solo de mascota 
    public void modificarMascota(Mascota masco) {
        try {
            mascoJpa.edit(masco);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersitencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //busca al dueño correspondiente
    public Duenio traerDuenio(int id_duenio) {
        return duenioJpa.findDuenio(id_duenio);
    }
    //metodo de modificacion de dueño
    public void modificarDuenio(Duenio dueno) {
        try {
            duenioJpa.edit(dueno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersitencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
