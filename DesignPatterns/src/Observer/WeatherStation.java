package Observer;

import java.util.ArrayList;

public class WeatherStation implements Observable {
    private ArrayList<Observer> observers;
    private float temp;
    private float humidity;

    public WeatherStation(){
        this.observers = new ArrayList<Observer>();
    }
    public void add(Observer o) {
        observers.add(o);
    }

    @Override
    public void remove(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        for (int i =0 ;i< observers.size();i++){
            observers.get(i).update(temp, humidity);
        }
    }

    public void measurementsChanged(){
        notifyObserver();
    }

    public void setMeasurement(float new_temp, float new_humidity){
        this.temp = new_temp;
        this.humidity = new_humidity;
        measurementsChanged();
    }
}
