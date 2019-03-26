package servicios;

import org.h2.tools.Server;
import logica.Articulo;
import javax.persistence.EntityManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ServiciosBoostrap {

    /**
     *
     * @throws SQLException
     */
    private static ServiciosBoostrap instancia;

    private ServiciosBoostrap(){

    }

    public static ServiciosBoostrap getInstancia(){
        if(instancia == null){
            instancia=new ServiciosBoostrap();
        }
        return instancia;
    }

    public void iniciarBD() {
        try {
            Server.createTcpServer("-tcpPort",
                    "9092",
                    "-tcpAllowOthers",
                    "-tcpDaemon").start();
        }catch (SQLException ex){
            System.out.println("Problema con la base de datos: "+ex.getMessage());
        }
    }

    public void init(){
        iniciarBD();
    }

}