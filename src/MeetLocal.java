import java.util.Random;

public class MeetLocal implements Event{
    @Override
    public String getSomeEvent(Trader trader) {
        String str = "Met a local: found a shortcut";
        return str;
    }
}
