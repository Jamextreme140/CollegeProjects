package backend;

import util.ToolBox;

/**
 * Barco
 */
public class Model {
    
    private String[] ports;
    private int nShips, nPorts;
    private Ship[] ships;
    private SeaPort[] seaports;


    public Model()
    {
        ports = setPorts();
        nShips = getRandShips();
        nPorts = getAmountSeaPorts();

        createSeaPorts();
        createShips();
    }

    // Zarpar
    public void setSail(Ship curShip)
    {
        
    }

    public int seaPortDestination()
    {
        return ToolBox.randInt(1, nPorts);
    }

    public void goToDestinationPort(Ship ship, int dPort)
    {
        ship.fillTank();

        for (int i = 0; i < dPort; i++) {
            ship.useFuel();
            if(ship.is70full()) return;
            else {
                int catched = ship.catchFish();
                ship.saveFish(catched);
            }

        }
    }

    private void createShips()
    {
        ships = new Ship[nShips];
        for (int i = 0; i < ships.length; i++) {
            ships[i] = new Ship();
        }
    }

    private void createSeaPorts()
    {
        seaports = new SeaPort[nPorts];

        for (int i = 0; i < seaports.length; i++) {
            seaports[i] = new SeaPort(ports[i]);
        }
    }

    private int getRandShips()
    {
        return ToolBox.randInt(5, 10);
    }

    private String[] setPorts()
    {
        String[] aux = {"Ensenada", "La paz", "Guaymas", "Topolobambo", "Mazatlan", "Vallarta", "Manzanillo", "Lazaro"};
        return aux;
    }

    private int getAmountSeaPorts() {
        return ports.length;
    }

    public int getnShips() {
        return nShips;
    }

    public int getnPorts() {
        return nPorts;
    }

    public Ship[] getShips() {
        return ships;
    }

    public Ship getShip(int index) {
        return ships[index];
    }

    public SeaPort[] getSeaports() {
        return seaports;
    }

    public SeaPort getSeaPort(int index) {
        return seaports[index];
    }
}
