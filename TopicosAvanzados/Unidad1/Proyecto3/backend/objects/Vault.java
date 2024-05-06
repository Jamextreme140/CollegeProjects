package backend.objects;

public class Vault {
    private int capacity, currentCapacity;

    public Vault(int capacity)
    {
        this.capacity = capacity;
        currentCapacity = 0;
    }

    public boolean isFull()
    {
        return currentCapacity == getCapacityInKg();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCapacityInKg() {
        return capacity * 1000;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public int getCurrentCapacityInTons() {
        return currentCapacity / 1000;
    }

    public void setCurruentCapacity(int currentWeight) {
        this.currentCapacity = currentWeight;
    }
    
}
