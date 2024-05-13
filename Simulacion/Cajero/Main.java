public class Main {
    public static void main(String[] args) throws Exception {
        Interfaz vista = new Interfaz();
        Modelo modelo = new Modelo();
        Controlador controlador = new Controlador(vista, modelo);
        vista.creaEscuchas(controlador);
        vista.mostrarInterfaz();
    }
}
