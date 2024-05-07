public class Main {
    public static void main(String[] args) {
        Program app = new Program();
        Model model = new Model();
        ProgramControl ctrl = new ProgramControl(app, model);
        app.setListeners(ctrl);
    }
}
