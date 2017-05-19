package Strategy;

public class Dutch_duck extends Duck {
    public Dutch_duck(){
        this.flyBehavior = new FlyNoWay();
    }
    @Override
    public void display() {
        System.out.println("I am a Dutch duck");
    }
}
