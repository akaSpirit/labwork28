import java.util.Random;

public class MeetLocal implements Event{
    @Override
    public String getSomeEvent(Trader trader) {
        String str = "Met a local: Found a shortcut";
        return str;
    }
}
