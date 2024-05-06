package components.multicapture;

public class Main {
    public static void main(String[] args) {
        CaptureProgram app = new CaptureProgram();
        CapturePanelController ctrl = new CapturePanelController(app.getPanel());
        CapturePanelController ctrl2 = new CapturePanelController(app.getPanel2());
        app.getPanel().addListeners(ctrl);
        app.getPanel2().addListeners(ctrl2);
    }
}
