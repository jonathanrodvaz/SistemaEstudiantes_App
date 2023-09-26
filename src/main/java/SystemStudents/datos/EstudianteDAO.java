package SystemStudents.datos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import SystemStudents.conexion.Conexion;
import SystemStudents.dominio.Estudiante;
import static SystemStudents.conexion.Conexion.getConexion;

//DAO - Data Access Object
public class EstudianteDAO {
    public List<Estudiante> listar(){
        List<Estudiante> estudiantes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = Conexion.getConexion();
        String sql = "SELECT * FROM estudiante ORDER BY id_estudiante";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                var estudiante = new Estudiante();
                estudiante.setIdEstudiante(rs.getInt("id_estudiante"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApelllido(rs.getString("apelllido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));
                estudiantes.add(estudiante);
            }
        } catch(Exception e){
            System.out.println("Ocurrio un error al seleccionar datos: " + e.getMessage());
        }
        finally{
            try{
                con.close();
            } catch(Exception e){
                System.out.println("Ocurrio un error al cerrar conexion: " + e.getMessage());
            }
        }
        return estudiantes;
    }
    //findById
    public boolean buscarEstudiantePorId(Estudiante estudiante){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT * FROM estudiante WHERE id_estudiante = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, estudiante.getIdEstudiante());
            rs = ps.executeQuery();
            if(rs.next()){
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApelllido(rs.getString("apelllido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));
                return true;
            }
        } catch(Exception e){
            System.out.println("Ocurrio un error al buscar estudiante: " + e.getMessage());
        }
        finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Ocurrio un error al cerrar conexion: " + e.getMessage());
            }
        }
        return false;


    }

    public boolean agregarEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "INSERT INTO estudiante(nombre, apelllido, telefono, email) " + "VALUES(?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApelllido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("Error al agregar estudiante: " + e.getMessage());
        }
        finally{
            try{
                con.close();
            } catch(Exception e){
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }
        return false;
    }
    public boolean modificarEstudiante(Estudiante estudiante){
    PreparedStatement ps;
    Connection con = getConexion();
    String sql = "UPDATE estudiante SET nombre=?, apelllido=?, telefono=?, email=? WHERE id_estudiante = ?";
    try {
        ps = con.prepareStatement(sql);
        ps.setString(1, estudiante.getNombre());
        ps.setString(2, estudiante.getApelllido());
        ps.setString(3, estudiante.getTelefono());
        ps.setString(4, estudiante.getEmail());
        ps.setInt(5, estudiante.getIdEstudiante());
        ps.execute();
        return true;
    } catch(Exception e){
        System.out.println("Error al modificar estudiante: " + e.getMessage());
    }
    finally {
        try{
            con.close();
        } catch(Exception e){
            System.out.println("Error al cerrar conexion: " + e.getMessage());
        }
    }
    return false;
    }


    public static void main(String[] args) {
        var estudianteDao = new EstudianteDAO();

        // Agregar estudiante:
        // var nuevoEstudiante = new Estudiante("Carlos", "Lara", "555777000", "carlos@aol.com");
        //var agregado = estudianteDao.agregarEstudiante(nuevoEstudiante);
        //if(agregado)
        //  System.out.println("Estudiante agregado: " + nuevoEstudiante);
        //else
        //  System.out.println("No se agrego el estudiante: " + nuevoEstudiante);



        //Modificar estudiante:
        var estudianteModificar = new Estudiante(3, "Karla", "Gomez", "555888999", "karla@aol.com");
        var modificado = estudianteDao.modificarEstudiante(estudianteModificar);
        if(modificado)
            System.out.println("Estudiante modificado: " + estudianteModificar);
        else
            System.out.println("Estudiante no se modifico: " + estudianteModificar);


        // Listar los estudiantes
           System.out.println("Listado de Estudiantes: ");
           List<Estudiante> estudiantes = estudianteDao.listar();
           estudiantes.forEach(System.out::println);



        //Buscar por Id
        //var estudiante1 = new Estudiante(3);
        //System.out.println("Estudiante antes de la busqueda: " + estudiante1);
        //var encontrado = estudianteDao.buscarEstudiantePorId(estudiante1);
        //if(encontrado)
        //  System.out.println("Estudiante encontrado: " + estudiante1);
        //else
        //  System.out.println("No se encontro estudiante: " + estudiante1.getIdEstudiante());

    }
}
