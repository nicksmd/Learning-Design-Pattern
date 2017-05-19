package Strategy;

public class Vietnam_duck extends Duck {
    public Vietnam_duck(){
        this.flyBehavior = new FlyWithWing();
    }
    @Override
    public void display() {
        System.out.println("I am a Vietnamese duck");
    }
}
