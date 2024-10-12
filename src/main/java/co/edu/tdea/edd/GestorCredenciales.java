package co.edu.tdea.edd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * Propiedades:
 * Credenciales: List
 * Metodos:
 * Crear Credencial() -> Credencial
 * 
 */

public class GestorCredenciales {

    private List<Credencial> credenciales = new ArrayList<>();

    public Credencial crearCredencial() //void return no esta | int/string return siempre!
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del servicio: ");
        String servicio = sc.nextLine();
        System.out.print("Ingrese el nombre del usuario: ");
        String usuario = sc.nextLine();
        System.out.print("Ingrese la contraseña: ");
        String contrasena = sc.nextLine();

        Credencial credencial = new Credencial(servicio, usuario, contrasena);
        
        System.out.println("Credencial creada!");
        return credencial;
    }

    public void agregarCredencial(Credencial credencial)
    {
        this.credenciales.add(credencial);
        System.out.println("La credencial fue almacenada!");
    }

    public void listarCredenciales()
    {
        System.err.println("-------------------");
        for(Credencial c : this.credenciales) {
            System.out.println("Servicio: "+c.servicio);
        }
        System.err.println("-------------------");
    }
    
}
