package Agenda.modelo.repository.impl;

import Agenda.modelo.ExcepcionPersona;
import Agenda.modelo.PersonVO;
import Agenda.modelo.repository.PersonRepository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class PersonRepositoryImpl implements PersonRepository {
    private ConexionJDBC conexion = new ConexionJDBC();
    private Statement stmt;
    private String sentencia;
    private ArrayList<PersonVO> personas;
    private PersonVO persona;

    public PersonRepositoryImpl(ConexionJDBC conexion) {
        this.conexion = conexion;
        // Aquí debes inicializar la conexión
    }

    public PersonRepositoryImpl() {}

    public ArrayList<PersonVO> ObtenerListaPersonas() throws ExcepcionPersona {
        try {
            Connection conn = this.conexion.conectarBD();
            this.personas = new ArrayList<>();
            this.stmt = conn.createStatement();
            this.sentencia = "SELECT * FROM `persona`";
            ResultSet rs = this.stmt.executeQuery(this.sentencia);

            while (rs.next()) {
                Integer code = rs.getInt("codigo");
                String firstName = rs.getString("nombre");
                String lastName = rs.getString("apellido");
                String street = rs.getString("direccion");
                String city = rs.getString("ciudad");
                String postalCode = rs.getString("codigo_postal");
                LocalDate birthday = rs.getDate("nacimiento").toLocalDate();

                this.persona = new PersonVO(code, firstName, lastName, street, city, postalCode, birthday);
                this.persona.setCodigo(code);
                this.personas.add(this.persona);
            }

            this.conexion.desconectarBD(conn);
            return this.personas;
        } catch (SQLException e) {
            System.out.println("No se ha podido realizar la operación: " + e);
        }
        return null; // Asegúrate de retornar algo si ocurre un error.
    }

    public void añadirPersona(PersonVO m) throws ExcepcionPersona {
        try {
            Connection conn = this.conexion.conectarBD();
            this.stmt = conn.createStatement();
            this.sentencia = "INSERT INTO persona (codigo, nombre, apellido, direccion, ciudad, codigo_postal, nacimiento) VALUES ('"
                    + m.getCodigo() + "','"
                    + m.getNombre() + "','"
                    + m.getApellido() + "','"
                    + m.getDireccion() + "','"
                    + m.getCiudad() + "','"
                    + m.getCodigoPostal() + "','"
                    + m.getNacimiento() + "')";
            this.stmt.executeUpdate(this.sentencia);
            this.stmt.close();
            this.conexion.desconectarBD(conn);
        } catch (SQLException var3) {
            throw new ExcepcionPersona("No se ha podido realizar la operación");
        }
    }

    public void borrarPersona(Integer idPersona) throws ExcepcionPersona {
        try {
            Connection conn = this.conexion.conectarBD();
            this.stmt = conn.createStatement();
            Statement comando = conn.createStatement();
            String sql = String.format("DELETE FROM persona WHERE codigo = %d", idPersona);
            comando.executeUpdate(sql);
            this.conexion.desconectarBD(conn);
        } catch (SQLException var5) {
            throw new ExcepcionPersona("No se ha podido realizar la eliminación");
        }
    }

    public void editarPersona(PersonVO personaVO) throws ExcepcionPersona {
        try {
            Connection conn = this.conexion.conectarBD();
            this.stmt = conn.createStatement();
            String sql = String.format("UPDATE persona SET nombre = '%s', apellido = '%s', direccion = '%s', ciudad = '%s', codigo_postal = '%s', nacimiento = '%s' WHERE codigo = %d",
                    personaVO.getNombre(), personaVO.getApellido(), personaVO.getDireccion(),
                    personaVO.getCiudad(), personaVO.getCodigoPostal(), personaVO.getNacimiento(), personaVO.getCodigo());
            this.stmt.executeUpdate(sql);
            this.stmt.close();
            this.conexion.desconectarBD(conn);
        } catch (Exception var4) {
            throw new ExcepcionPersona("No se ha podido realizar la edición");
        }
    }

    public int lastId() throws ExcepcionPersona {
        int lastPersonaId = 0;

        try {
            Connection conn = this.conexion.conectarBD();
            Statement comando = conn.createStatement();
            ResultSet registro = comando.executeQuery("SELECT codigo FROM persona ORDER BY codigo DESC LIMIT 1");
            if (registro.next()) {
                lastPersonaId = registro.getInt("codigo");
            }
            registro.close();
            comando.close();
            this.conexion.desconectarBD(conn);
        } catch (SQLException var5) {
            throw new ExcepcionPersona("No se ha podido realizar la búsqueda del ID");
        }
        return lastPersonaId;
    }

    // Esta llave cierra la clase
}
