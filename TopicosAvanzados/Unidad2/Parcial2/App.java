public class App {
    
    public App()
    {
        // Interfaz
        MainView app = new MainView();
        // Modelo
        Backend model = new Backend();
        // Controlador
        Actions ctrl = new Actions(app, model);
        app.setListeners(ctrl);
    }
    
    public static void main(String[] args) {
        new App();
    }
}
