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
            int t = Integer.parseInt(view.getTimes().getText());
            if(t <= 0) return;
            model.simular(t);
            updateUI();
        }
    }

    public void updateUI()
    {
        view.createTable(model.getData(), model.getColumns());
    }
}
