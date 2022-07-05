import java.util.List;
import java.util.Random;

public class Rain implements Event {
    @Override
    public String getSomeEvent(Trader trader) {
        String str = String.format("It's rainy: speed slowed by 2. %s", spoiledGoods(trader));
        trader.setSpeed(Math.max(trader.getSpeed() - 2, 0));
        return str;
    }

    private String spoiledGoods(Trader trader) {
        int chance = new Random().nextInt(1, 11);
        String str = "";
        if (chance <= 3) {
            int randGoods = new Random().nextInt(trader.goodsList.size());
            if (!trader.goodsList.get(randGoods).getQualityObj().equals(Quality.FULLY_SPOILED)) {
                trader.goodsList.get(randGoods).setQualityObj(Quality.values()[+1]);
                str = String.format("%s lost quality", trader.goodsList.get(randGoods).getName());
            }
        }
        return str;
    }
}
