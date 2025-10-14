import java.util.ArrayList;

public class Tienda implements Subject {
    
    private int cantP1;
    private int cantP2;
    private int cantP3;
    @SuppressWarnings("rawtypes")
    private ArrayList observers;

    @SuppressWarnings("rawtypes")
    public Tienda() {
        this.cantP1 = 0;
        this.cantP2 = 0;
        this.cantP3 = 0;
        this.observers = new ArrayList();
    }

    public void setCantP1(int cantP1) {
        this.cantP1 = cantP1;
        notifyObservers();
    }

    public void setCantP2(int cantP2) {
        this.cantP2 = cantP2;
        notifyObservers();
    }

    public void setCantP3(int cantP3) {
        this.cantP3 = cantP3;
        notifyObservers();
    }

  
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Object observer : observers) {
            ((Observer) observer).update(cantP1, cantP2, cantP3);
        }
    }
    
}
