package Strategy;

/**
 * Created by quangh on 4/7/2017.
 */
public abstract class Duck {
    FlyBehavior flyBehavior;
    public Duck(){

    }

    public void performFly(){
        flyBehavior.fly();
    }
    public void setFlyBehavior(FlyBehavior fb){
        flyBehavior = fb;
    }
    public abstract void display();
}
