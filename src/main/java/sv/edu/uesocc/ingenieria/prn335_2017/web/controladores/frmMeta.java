/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2017.web.controladores;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.acceso.MetaFacadeLocal;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.definiciones.Meta;

/**
 *
 * @author luis
 */
@Named
@ViewScoped
public class frmMeta implements Serializable {

    @EJB
    private MetaFacadeLocal metaEJB;
    private Meta m;
    private List<Meta> metas;

    @PostConstruct
    public void init() {
        metas = metaEJB.findAll();
        m = new Meta();
        m.setIdMeta(null);
        m.setNombre("");
        m.setActivo(false);
        m.setDescripcion("");
    }
    
    
    /**
     * manda a llamar los datos de la variable
     * @return 
     */
    public List<Meta> getMetas() {
        return metas;
    }
    
    /**
     * se le asigna los valores a la variable
     * @param metas 
     */
    public void setMetas(List<Meta> metas) {
        this.metas = metas;
    }

    /**
     * manda a llamar los datos de la variable
     * @return 
     */
    public Meta getM() {
        return m;
    }

    /**
     * se le asigna los valores a la variable
     * @param m 
     */
    public void setM(Meta m) {
        this.m = m;
    }

    /**
     * metodo sirve para guardar los campos ingresados
     * @return 
     */
    public String guardar() {
        if (m != null) {
            System.out.println("¡¡SI HA INGRESADO DATOS!!");
            metaEJB.create(m);
            metas = metaEJB.findAll();
            
        } else {
            System.out.println("¡¡NO INGRESO DATOS: NULL!!");
            
        }
        this.limpiar();
        return "c_guardar";
    }
    
    /**
     * metodo usado para limpiar la interfaz del usuario
     * @return 
     */
    public void limpiar() {
        System.out.println("ENTRO AL LIMPIADOR");
        m = new Meta();
      
    }

}
