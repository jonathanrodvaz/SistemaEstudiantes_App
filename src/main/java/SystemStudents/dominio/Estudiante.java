package SystemStudents.dominio;

public class Estudiante {
    private int idEstudiante;
    private String nombre;
    private String apelllido;
    private String telefono;
    private String email;

    public Estudiante(){}

    public Estudiante(int idEstudiante){
        this.idEstudiante = idEstudiante;
    }
    public Estudiante(String nombre, String apelllido, String telefono, String email){
        this.nombre = nombre;
        this.apelllido = apelllido;
        this.telefono = telefono;
        this.email = email;
    }

    public Estudiante(int idEstudiante, String nombre, String apelllido, String telefono, String email){
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.apelllido = apelllido;
        this.telefono = telefono;
        this.email = email;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApelllido() {
        return apelllido;
    }

    public void setApelllido(String apelllido) {
        this.apelllido = apelllido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "idEstudiante=" + idEstudiante +
                ", nombre='" + nombre + '\'' +
                ", apelllido='" + apelllido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
