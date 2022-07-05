public class BrokenWheel implements Event{
    @Override
    public String getSomeEvent(Trader trader) {
        String str = "Broken wheel: Spent whole day repairing the wheel";
        trader.setSpeed(0);
        return str;
    }
}
