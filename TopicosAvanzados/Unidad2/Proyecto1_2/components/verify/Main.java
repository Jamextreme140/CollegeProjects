package components.verify;

import components.verify.backend.VerifySystem;

public class Main {
    public static void main(String[] args) {
        VerifyField app = new VerifyField();
        VerifySystem backend = new VerifySystem();
        ProgramControl ctrl = new ProgramControl(backend, app);
        app.addListeners(ctrl);
    }
}
