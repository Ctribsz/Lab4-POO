import java.util.List;
import java.util.Scanner;

public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        boolean log = false;
        boolean prem = false;
        Gestor g = new Gestor();
        List<Cuenta> cuentas = new Gestor().leerCSV("Cuentas.csv");
        List<Objeto> productos = new Gestor().leerCSV2("Objetos.csv");

        while(true){
            System.out.println("MENU");
            System.out.println("1. Registrarme.");
            System.out.println("2. Ingresar a mi cuenta");
            System.out.println("3. Cerrar sesion.");
            System.out.println("4. Realizar una compra.");
            System.out.println("5. Prestar libros.");
            System.out.println("6. Modificar perfil");
            System.out.println("7. Salir");
            Scanner sc = new Scanner(System.in);  
            System.out.println("Elige la accion que quieras realizar: ");
            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    System.out.println("Ingrese su nombre de usuario:");
                    String usua = sc.nextLine();
            
                    if (usua.isEmpty()) {
                        System.out.println("El nombre de usuario no puede estar vacío.");
                        return;
                    }

                    System.out.println("Ingrese su nombre de usuario:");
                    String passw = sc.nextLine();

                     if (passw.isEmpty()) {
                        System.out.println("La contraseña no puede estar vacía.");
                        return;
                    }
                    
                    System.out.println("Ingrese el tipo de usuario (Premium o Gratis):");
                    String est = sc.nextLine();

                     if (est.isEmpty()) {
                        System.out.println("El estado de usuario no puede estar vacio.");
                        return;
                    }

                    Cuenta usuario = new Cuenta(usua, passw, est);
                    cuentas.add(usuario);
                    System.out.println("Cuenta registrada con exito");
                    break;
                
                case 2:
                    if(log == true){
                        System.out.println("Ya hay una sesion activa, debes cerrar sesion");
                        break;
                    }
                    System.out.println("Ingrese su nombre de usuario:");
                    String usu = sc.nextLine();
            
                    if (usu.isEmpty()) {
                        System.out.println("El nombre de usuario no puede estar vacío.");
                        return;
                    }
            
                    System.out.println("Ingrese su contraseña:");
                    String pass = sc.nextLine();
            
                    if (pass.isEmpty()) {
                        System.out.println("La contraseña no puede estar vacía.");
                        return;
                    }

                    for (Cuenta cuenta : cuentas) {
                        if (cuenta.getUsuario().equals(usu) && cuenta.getPass().equals(pass)) {
                            log = true;
                            System.out.println("INICIO DE SESION EXITOSO");
                            break;
                        } else {
                            System.out.println("Nombre de usuario o contraseña incorrectos");
                        }
                    }

                    for (Cuenta cuenta : cuentas) {
                        if (cuenta.getSus().equals("Premium")) {
                            prem = true;
                            break;
                        } else {
                            prem = false;
                        }
                    }
                    break;

                case 3:
                    log = false;
                    System.out.println("Sesion cerrada");
                    break;
                
                case 4:
                    if(log == false){
                        System.out.println("Debes de inciar sesion para poder hacer una compra");
                        break;
                    }

                    g.imprimirProd(productos);
                    
                    break;

                case 5:
                    break;
                
                case 6:
                    
                    break;
                
                case 7:
                    g.guardarCSV(cuentas, "Cuentas.csv");
                    System.out.println("Gracias por elegirnos, adios");
                    log = false;
                    System.exit(0);

                default:
                    System.out.println("Ingrese una opcion valida"); 
                    break;
            }
        }
    }
}
