package Observer;

public class DevideDisplay implements Observer {
    private float temp;
    private float humidity;
    private Observable weatherStation;

    public DevideDisplay(Observable o){
        this.weatherStation = o;
        o.add(this);
    }
    @Override
    public void update(float temp, float humidity) {
        this.temp = temp;
        this.humidity = humidity;
        display();
    }

    public void display(){
        System.out.println("Current Conditions: " + temp + " C degree and " + humidity + "% humidity");
    }
}
