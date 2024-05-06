package backend;

import javax.swing.*;

import util.ToolBox;

import java.awt.event.*;
import java.awt.*;
import view.View;

public class Controller implements ActionListener{

    private View view;
    private Model model;

    public Controller(View view, Model model)
    {
        this.model = model;
        this.view = view;
        sendToView();
    }

    public void sendToView() 
    {
        view.setLayout(new GridLayout(0, model.getnPorts() + 1));
        // Puertos
        view.seaPortName = new JLabel[model.getnPorts()];
        view.add(new JLabel(""));
        for (int i = 0; i < model.getnPorts(); i++) {
            view.seaPortName[i] = new JLabel(model.getSeaPort(i).getName());
            view.add(view.seaPortName[i]);
        }
        //Barcos
        view.btnShip = new JButton[model.getnShips()];
        view.delivered = new JLabel[model.getnShips()][model.getnPorts()];
        for (int i = 0; i < model.getnShips(); i++) //Barco
        {
            view.btnShip[i] = new JButton();
            view.add(view.btnShip[i]);
            for (int j = 0; j < model.getnPorts(); j++) //Puerto
            {
                view.delivered[i][j] = new JLabel("0", JLabel.CENTER);
                view.add(view.delivered[i][j]);
            }
        }

        
    }

    public void addButtonImages()
    {
        for (JButton ship : view.btnShip)
        {
            ImageIcon image = ToolBox.createImageIcon(
                Integer.toString(ToolBox.randInt(4)) + ".png",
                 ship.getWidth(), 
                 ship.getHeight());
            ship.setIcon(image);
        }
        view.repaint();
        view.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        JButton aux = (JButton) evt.getSource();
        Ship ship = model.getShip(searchBtnIndex(aux));
        int dSeaPort = model.seaPortDestination();

        //model.setSail(ship);
        setSail(ship, dSeaPort);
    }

    private void setSail(Ship ship, int dPort)
    {
        goToDestinationPort(ship, dPort);
        returnToInitialPort(ship, dPort);
    }

    private void goToDestinationPort(Ship ship, int dPort)
    {
        ship.fillTank();

        for (int i = 0; i < dPort; i++) {
            ShipAction(ship, i);
        }
    }

    private void returnToInitialPort(Ship ship, int dPort)
    {
        ship.fillTank();
        for (int i = dPort - 1; i >= 0; i--) {
            ShipAction(ship, i);
        }
    }

    private void deliverToPort(Ship ship, int seaport)
    {
        SeaPort port = model.getSeaPort(seaport);

        port.saveFishOnPort(ship.getCurVault().getCurrentCapacity());
        ship.emptyVault();

        JLabel curSeaPort = view.delivered[searchShipIndex(ship)][seaport];
        curSeaPort.setText(Integer.toString(port.getCurVault().getCurrentCapacityInTons()));
    }

    private void ShipAction(Ship curShip, int curSeaPort)
    {
        curShip.useFuel();
        int catched = curShip.catchFish();
        curShip.saveFish(catched);
        if(!curShip.is70full()){
            catched = curShip.catchFish();
            curShip.saveFish(catched);
        }
        else {return;}
        deliverToPort(curShip, curSeaPort);
    }

    private int searchBtnIndex(JButton btn)
    {
        for (int i = 0; i < view.btnShip.length; i++) {
            if(view.btnShip[i] == btn) return i;
        }
        return -1;
    }

    private int searchShipIndex(Ship ship)
    {
        for (int i = 0; i < model.getSeaports().length; i++) {
            if(model.getShip(i) == ship) return i;
        }
        return -1;
    }

}
