package Agenda.diu;

import Agenda.modelo.ConexionJDBC;
import Agenda.modelo.Person;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonRepositoryImpl implements PersonRepository {
    private final ConexionJDBC conexion = new ConexionJDBC();
    private Statement stmt;
    private String sentencia;
    private ArrayList<PersonVO> personas;
    private PersonVO persona;

    public PersonRepositoryImpl() {
    }

    public ArrayList<PersonVO> ObtenerListaPersonas() throws ExcepcionPersona {
        try {
            Connection conn = this.conexion.conectarBD();
            this.personas = new ArrayList();
            this.stmt = conn.createStatement();
            this.sentencia = "SELECT * FROM persona";
            ResultSet rs = this.stmt.executeQuery(this.sentencia);

            while(rs.next()) {
                Integer id = rs.getInt("id");
                String m = rs.getString("nombre");
                String p = rs.getString("apellido");
                String d = rs.getString("direccion");
                String c = rs.getString("ciudad");
                Integer cp = rs.getInt("codigo postal");
                String br = rs.getString("nacimiento");


                this.persona = new PersonVO(m, p, d, c, cp, br);
                this.persona.setCodigo(id);
                this.personas.add(this.persona);
            }

            this.conexion.desconectarBD(conn);
            return this.monedas;
        } catch (SQLException var6) {
            throw new ExcepcionMoneda("No se ha podido realizar la operación");
        }
    }

    public void addMoneda(MonedaVO m) throws ExcepcionMoneda {
        try {
            Connection conn = this.conexion.conectarBD();
            this.stmt = conn.createStatement();
            this.sentencia = "INSERT INTO monedas (nombre, multiplicador) VALUES ('" + m.getNombre() + "','" + m.getMultiplicador() + "');";
            this.stmt.executeUpdate(this.sentencia);
            this.stmt.close();
            this.conexion.desconectarBD(conn);
        } catch (SQLException var3) {
            throw new ExcepcionMoneda("No se ha podido realizar la operación");
        }
    }

    public void deleteMoneda(Integer idMoneda) throws ExcepcionMoneda {
        try {
            Connection conn = this.conexion.conectarBD();
            this.stmt = conn.createStatement();
            Statement comando = conn.createStatement();
            String sql = String.format("DELETE FROM monedas WHERE codigo = %d", idMoneda);
            comando.executeUpdate(sql);
            this.conexion.desconectarBD(conn);
        } catch (SQLException var5) {
            throw new ExcepcionMoneda("No se ha podido relaizr la eliminación");
        }
    }

    public void editMoneda(MonedaVO monedaVO) throws ExcepcionMoneda {
        try {
            Connection conn = this.conexion.conectarBD();
            this.stmt = conn.createStatement();
            String sql = String.format("UPDATE monedas SET nombre = '%s', multiplicador = '%s' WHERE codigo = %d", monedaVO.getNombre(), monedaVO.getMultiplicador(), monedaVO.getCodigo());
            this.stmt.executeUpdate(sql);
        } catch (Exception var4) {
            throw new ExcepcionMoneda("No se ha podido relaizr la edición");
        }
    }

    public int lastId() throws ExcepcionMoneda {
        int lastMonedaId = 0;

        try {
            Connection conn = this.conexion.conectarBD();
            Statement comando = conn.createStatement();

            for(ResultSet registro = comando.executeQuery("SELECT codigo FROM monedas ORDER BY codigo DESC LIMIT 1"); registro.next(); lastMonedaId = registro.getInt("codigo")) {
            }

            return lastMonedaId;
        } catch (SQLException var5) {
            throw new ExcepcionMoneda("No se ha podido realizar la busqueda del ID");
        }
    }
}