import Observer.DevideDisplay;
import Observer.WeatherStation;

public class main {
    public static void main(String[] args){
        /*
        Strategy.Duck quang = new Strategy.Vietnam_duck();
        Strategy.Duck jac = new Strategy.Dutch_duck();
        quang.display();
        quang.performFly();
        jac.display();
        jac.performFly();
        jac.setFlyBehavior(new Strategy.FlyWithWing());
        jac.performFly(); */

        WeatherStation weatherStation = new WeatherStation();
        DevideDisplay phone = new DevideDisplay(weatherStation);
        DevideDisplay pc = new DevideDisplay(weatherStation);

        weatherStation.setMeasurement(100,200);
        System.out.println("----------");
        weatherStation.setMeasurement(150,150);
    }
}