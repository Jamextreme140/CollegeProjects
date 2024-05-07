public class App {
    public static void main(String[] args) throws Exception {
        Program app = new Program();
        Model model = new Model();
        ProgramControl ctrl = new ProgramControl(app, model);
        app.setListener(ctrl);
        app.setVisible(true);
    }
}
