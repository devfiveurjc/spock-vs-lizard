import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DatabaseIntegrationTest {
    private Connection conexion;


    /*
     * Este método se va a ejecutar una vez antes de realizar cualquier tipo de prueba
     */
    @Before
    public void setUp() throws SQLException {

        // Obtener una conexión
        conexion = DriverManager.getConnection(//aqui tendríamos que añadir nuestra base de datos);
        // creamos el objeto
        Statement sentencia = new Statement();

        sentencia = conexion.createStatement();

        /*Ejecutamos una declaración SQL de actualización, en este caso de CREATE TABLE*/
        sentencia.executeUpdate("" +
                "CREATE TABLE users " +
                "(id INT PRIMARY KEY, " +
                "name VARCHAR(255), " +
                "email VARCHAR(255))"
        );
    }

    /*
     * Este método se va a ejecutar una vez tras de realizar cualquier tipo de prueba
     */
    @After
    public void tearDown() throws SQLException {
        conexion.close();
    }

    /*Método para insertar usuarios*/
    @Test
    public void testInsertUser() throws SQLException {
        Statement sentencia = new Statement();
        sentencia = conexion.createStatement();
        // Insertamos un registro en la tabla.
        sentencia.executeUpdate(
                "INSERT INTO users (id, name, email) " +
                        "VALUES (1, 'Juan', 'juan@gmail.com')");

        // Comprobamos que se ha insertado correctamente, para ello realizamos una consulta SQL en la ta
        ResultSet resultados = new ResultSet();

        resultados = sentencia.executeQuery(
                "SELECT * " +
                        "FROM users");

        assertTrue(resultados.next());

        assertEquals(1, resultados.getInt("id"));
        assertEquals("Juan", resultados.getString("name"));
        assertEquals("juan@gmail.com", resultados.getString("email"));

        assertFalse(resultados.next());
    }
}
