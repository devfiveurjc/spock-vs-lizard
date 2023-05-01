
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


/*

En este Test de Integración se va a comprobar que no hay datos repetidos, para ello, vamos a comprbar:
*
Que dos usuarios no tengan el mismo correo
*
*/

public class TestIntegracionBasesDatos {


    //implementamos las conexion
    private static Connection conexion;

    //implementamos un objeto para ejecutar las sentencias de SQL
    private static Statement sentencia;


   /*
   * Este método se va a ejecutar una vez antes de realizar cualquier tipo de prueba
   */
    @BeforeClass
    public static void conectarBD() throws SQLException {
        // Conectamos a la base de datos o al servidor
        conexion = DriverManager.getConnection(//aqui tendríamos que añadir nuestra base de datos);
        // creamos el objeto
        sentencia = conexion.createStatement();
    }
    /*
     * Este método se va a ejecutar una vez tras de realizar cualquier tipo de prueba
     */
    @AfterClass
    public static void desconectarBD() throws SQLException {
        // Cerramos la conexión
        sentencia.close();
        conexion.close();
    }

    /*Definimos las pruebas que vamos a realizar*/


    /*Método para ver si hay emails repetidos*/

    @Test
    public void EmailsRepetidos() throws SQLException {


        /*
        * Contamos el número de veces que aparece cada correo electrónico en la tabla.
        * Devolvemos solo aquellos correos electrónicos que aparecen más de una vez.
        *
        * Utilizamos el método "assertFalse" para verificar que el objeto "resultados" no tiene filas.
        * En caso de encontrar correos electrónicos repetidos:
        *    "resultados" tendría al menos una fila y la prueba fallaría.
        *
        */
        ResultSet resultados = new ResultSet();
        resultados = sentencia.executeQuery("" +
                "SELECT COUNT(*) " +
                    "FROM usuarios " +
                        "GROUP BY correos " +
                            "HAVING COUNT(*) > 1"

        ); //ResultSet nos permite ejecutar las sentencias en SQL

        assertFalse(resultados.next());
    }

    /*Método para insertar usuarios*/

    @Test
    public void InsertarUsuario() throws SQLException {

        // Insertamos un usuario con un email que no está en la base de datos
        String email = "/*añadir un email*/";
        // Insertamos un registro en la tabla.
        sentencia.executeUpdate("" +
                "INSERT INTO usuarios (email) " +
                "VALUES ('" + email + "')" +
                "");
        // Comprobamos que se ha insertado correctamente, para ello realizamos una consulta SQL en la tabla.
        ResultSet resultados = new ResultSet();
        resultados = sentencia.executeQuery(
                "SELECT COUNT(*) " +
                        "FROM usuarios " +
                            "WHERE email = '" + email + "'");

        assertTrue(resultados.next());
        assertTrue(resultados.getInt(1) == 1);
    }

}
