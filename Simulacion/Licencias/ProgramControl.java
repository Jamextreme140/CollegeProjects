import java.awt.event.*;

public class ProgramControl implements ActionListener{

    Program view;
    Model model;

    public ProgramControl(Program view, Model model)
    {
        this.view = view;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.getGenerate())
        {
            model.simulate(Integer.parseInt(view.getTimes().getText()), Integer.parseInt(view.getLicenses().getText()));
            updateUI();
            view.setMediaVarianza("Media: " + model.getMedia() + " | Varianza: " + Double.toString(model.getVarianza()));
            System.out.println("Media: " + model.getMedia() + " | Varianza: " + Double.toString(model.getVarianza()));
        }
    }

    public void updateUI()
    {
        view.createTable(model.getData(), model.getColumns());
    }

}
