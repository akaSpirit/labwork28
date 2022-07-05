public class SmoothRoad implements Event{
    @Override
    public String getSomeEvent(Trader trader) {
        String str = "Smooth road: speed +2";
        trader.setSpeed(Math.min(5, trader.getSpeed()+2));
        return str;
    }
}
