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

    public static void main(String[] args) {
        var estudianteDao = new EstudianteDAO();
        // Listar los estudiantes
        System.out.println("Listado de Estudiantes: ");
        List<Estudiante> estudiantes = estudianteDao.listar();
        estudiantes.forEach(System.out::println);
    }
}
