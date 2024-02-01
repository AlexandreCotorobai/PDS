public class OffState extends State {

    public OffState(Phone phone) {
        super(phone);
    }

    @Override
    public String onHome() {
        phone.setState(new LockedState(phone));
        return "Phone is locked";
    }

    @Override
    public String onOffOn() {
        phone.setState(new LockedState(phone));
        return "Phone is off";
    }

}
