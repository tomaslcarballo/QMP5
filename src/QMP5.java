import java.util.List;

public class QMP5 {

  public class Usuario {
    //1er requerimiento: El usuario tiene una lista de guardaropas que pueden ser distintos.
    List<Guardarropa> guardarropas;
    List<Recomendacion> recomendaciones;
    List<Recomendacion> recomendacionesAceptadas;

    //2do requerimiento
    void compartiGuardarropasConOtroUsuario(Usuario otroUsuario, Guardarropa guardarropa){
      otroUsuario.guardarropas.add(guardarropa);
    }
    

  void agregarRecomendacion(Recomendacion recomendacion){
    recomendaciones.add(recomendacion);
      }
  void quitarRecomendacion(Recomendacion recomendacion){
    recomendaciones.remove(recomendacion);
      }

   void agregarRecomendacionAprobada(Recomendacion recomendacion){
      recomendacionesAceptadas.add(recomendacion);
    }


    //5to requerimiento
    public List<Recomendacion> getRecomendaciones() {
      return recomendaciones;
    }

    void aplicarRecomendacion(Recomendacion recomendacion){
    recomendacion.aplicarEn(this);
    agregarRecomendacionAprobada(recomendacion);
    recomendaciones.remove(recomendacion);
      }

    void rechazarRecomendacion(Recomendacion recomendacion){
      quitarRecomendacion(recomendacion);
    }


    //6to requerimiento
    void deshacerRecomendacion(Recomendacion recomendacion){
      recomendacion.deshacerEn(this);
      recomendacionesAceptadas.remove(recomendacion);

    }

  }


  class Guardarropa {
    List<Prenda> prendas;
    boolean esCompartible;

  public Guardarropa(List<Prenda> prendas) {
    this.prendas = prendas;

  }

  public void agregarPrenda(Prenda prenda){
    prendas.add(prenda);
  }

    public void quitarPrenda(Prenda prenda) {
    }
  }

 class Prenda{

}

  //3er y 4to requerimiento

  interface Recomendacion{
   abstract void aplicarEn(Usuario usuario);
    //4to requerimiento
   abstract void deshacerEn(Usuario usuario);
  }

  class AgregarPrenda implements Recomendacion{
    private Prenda prenda;
    private Guardarropa guardarropa;

    @Override
    public void aplicarEn(Usuario usuario) {
      guardarropa.agregarPrenda(prenda);
    }

    @Override
    public void deshacerEn(Usuario usuario) {
      guardarropa.quitarPrenda(prenda);
    }

  }


  class QuitarPrenda implements Recomendacion{
    private Prenda prenda;
    private Guardarropa guardarropa;
    @Override
    public void aplicarEn(Usuario usuario) {
      guardarropa.quitarPrenda(prenda);
    }

    @Override
    public void deshacerEn(Usuario usuario) {
        guardarropa.agregarPrenda(prenda);
    }

  }

}




