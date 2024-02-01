public class Light {
    private boolean on;
    public void switchOn() {
        on = true;
        System.out.println("Light is on");
    }
    public void switchOff() {
        on = false;
        System.out.println("Light is off");
    }
}
