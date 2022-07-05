public class River implements Event{
    @Override
    public String getSomeEvent(Trader trader) {
        String str = "River: Spent all day looking for a bridge";
        trader.setSpeed(0);
        return str;
    }
}
