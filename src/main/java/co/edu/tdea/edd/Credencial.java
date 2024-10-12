package co.edu.tdea.edd;

public class Credencial {
    public String servicio; // NFD // SKJ
    private String usuario; // admin // user
    private String contrasena; // 12345690 // asd12123

    public Credencial(
        String in_servicio,
        String in_usuario,
        String in_contrasena
    ) {
        this.servicio = in_servicio;
        this.usuario = in_usuario;
        this.contrasena = in_contrasena;
    }
}
