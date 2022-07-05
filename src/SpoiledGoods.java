import java.util.Random;

public class SpoiledGoods implements Event {
    @Override
    public String getSomeEvent(Trader trader) {
        String str = "";
        int randGoods = new Random().nextInt(trader.goodsList.size());
        if (!trader.goodsList.get(randGoods).getQualityObj().equals(Quality.FULLY_SPOILED)) {
            trader.goodsList.get(randGoods).setQualityObj(Quality.values()[+1]);
            str = String.format("Spoiled goods: %s lost quality", trader.goodsList.get(randGoods).getName());
        }
        return str;
    }
}
