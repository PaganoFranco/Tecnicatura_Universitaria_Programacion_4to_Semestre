package UTN.datos;

import UTN.dominio.Estudiante;
import static  UTN.conexion.Conexion.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAO {

    // Método Listar
    public List<Estudiante> ListarEstudiantes() {
        List<Estudiante> estudiantes = new ArrayList<>();
        // Creamos algunos objetos que son necesarios para comunicarnos con la base de datos
        PreparedStatement ps;
        ResultSet rs;
        // Creamos un objeto de tipo conexion
        Connection con = getConnection();
        String sql = "SELECT * FROM estudiantes.estudiantes2024";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                var estudiante = new Estudiante();
                estudiante.setIdEstudiante(rs.getInt("idestudiantes2024"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));
                // Agregamos el estudiante a la lista
                estudiantes.add(estudiante);
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error al seleccionar datos: " + e.getLocalizedMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Ocurrió un error al cerrar la conexión: " + e.getMessage());
            }
        }
        return estudiantes;
    }

    // Método por id -> find by id
    public boolean buscarEstudiantePorId(Estudiante estudiante) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConnection();
        String sql = "SELECT * FROM estudiantes.estudiantes2024 WHERE idestudiantes2024=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, estudiante.getIdEstudiante());
            rs = ps.executeQuery();
            if (rs.next()) {
                estudiante.setNombre(rs.getString("nombre"));  // Corregido de 'mombre' a 'nombre'
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));
                return true; // Se encontró un registro
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error al buscar estudiante: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Ocurrió un error al cerrar la conexión: " + e.getMessage());
            }
        }
        return false;
    }

    // Método para agregar un nuevo estudiante
    public boolean agregarEstudiante(Estudiante estudiante) {
        PreparedStatement ps;
        Connection con = getConnection();
        String sql = "INSERT INTO estudiantes.estudiantes2024 (nombre, apellido, telefono, email) VALUES (?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Ocurrió un error al agregar estudiante: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Ocurrió un error al cerrar la conexión: " + e.getMessage());
            }
        }
        return false;
    }

    // Método para modificar estudiante
    public boolean modificarEstudiante(Estudiante estudiante) {
        PreparedStatement ps;
        Connection con = getConnection();
        String sql = "UPDATE estudiantes.estudiantes2024 SET nombre=?, apellido=?, telefono=?, email=? WHERE idestudiantes2024=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());
            ps.setInt(5, estudiante.getIdEstudiante());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Ocurrió un error al modificar estudiante: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Ocurrió un error al cerrar la conexión: " + e.getMessage());
            }
        }
        return false;
    }

    public boolean eliminarEstudiante(Estudiante estudiante) {
        PreparedStatement ps;
        Connection con = getConnection();
        String sql = "DELETE FROM estudiantes2024 WHERE idestudiantes2024=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, estudiante.getIdEstudiante());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar estudiante: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexion: " + e.getMessage());
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Instancia del DAO
        EstudianteDAO estudianteDao = new EstudianteDAO();

        // // Eliminar estudiante con id 3
        // var estudianteEliminar = new Estudiante(3);
        // var eliminado = estudianteDao.eliminarEstudiante(estudianteEliminar);
        // if(eliminado)
        //     System.out.println("Estudiante eliminado  = " + estudianteEliminar);
        // else
        //     System.out.println("No se eliminado al estudiante = " + estudianteEliminar);

        // // Listar los estudiantes
        // System.out.println("Listado de estudiantes: ");
        // List<Estudiante> estudiantes = estudianteDao.ListarEstudiantes();
        // estudiantes.forEach(System.out::println); // Función lambda para imprimir

        // Agregar estudiante (descomentarlo si se desea probar)
        // var nuevoEstudiante = new Estudiante("Carlos", "Peralta", "111415555", "carlosP@mail.com");
        // var agregado = estudianteDao.agregarEstudiante(nuevoEstudiante);
        // if (agregado)
        //     System.out.println("Estudiante agregado: " + nuevoEstudiante);
        // else
        //     System.out.println("No se ha agregado estudiante: " + nuevoEstudiante);

        // Buscar por id (descomentarlo si se desea probar)
        // var estudiante1 = new Estudiante(1);
        // System.out.println("Estudiante antes de la búsqueda: " + estudiante1);
        // var encontrado = estudianteDao.buscarEstudiantePorId(estudiante1);
        // if (encontrado) {
        //     System.out.println("Estudiante encontrado: " + estudiante1);
        // } else {
        //     System.out.println("No se encontró el estudiante: " + estudiante1.getIdEstudiante());
        // }

        // Modificar estudiante (descomentarlo si se desea probar)
        // var estudianteModificado = new Estudiante(1, "Juan Carlos", "Juarez", "123455656", "juarezjuan@mail.com");
        // var modificado = estudianteDao.modificarEstudiante(estudianteModificado);
        // if (modificado)
        //     System.out.println("Estudiante modificado: " + estudianteModificado);
        // else
        //     System.out.println("No se modificó el estudiante: " + estudianteModificado);
    }
}
