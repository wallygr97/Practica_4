package servicios;

import logica.Articulo;
import logica.LikesArticulo;
import logica.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ServiciosLikes extends MetodosDB<LikesArticulo>{

    private static ServiciosLikes instancia;

    private ServiciosLikes() {
        super(LikesArticulo.class);
    }

    public static ServiciosLikes getInstancia(){
        if(instancia==null){
            instancia = new ServiciosLikes();
        }
        return instancia;
    }

    @SuppressWarnings("JpaQlInspection")
    public void deleteLikes(Articulo articulo, Usuario user){
        EntityManager em = getEntityManager();
        Query query = em.createQuery("select la from LikesArticulo la where la.usuario = :user AND la.articulo = :articulo");
        query.setParameter("user", user);
        query.setParameter("articulo", articulo);
        List<LikesArticulo> resultado = query.getResultList();

        for(int i = resultado.size() - 1; i >= 0; i-- ) {//
            if (i == resultado.size() - 1) {
                eliminar(resultado.get(i).getId());
            }
        }
        return;
    }
}