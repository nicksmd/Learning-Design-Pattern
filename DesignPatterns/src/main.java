public class main {
    public static void main(String[] args){
        Duck quang = new Vietnam_duck();
        Duck jac = new Dutch_duck();
        quang.display();
        quang.performFly();
        jac.display();
        jac.performFly();
        jac.setFlyBehavior(new FlyWithWing());
        jac.performFly();
    }
}