public class Robbers implements Event {
    @Override
    public String getSomeEvent(Trader trader) {
        String str = "";
        if (trader.getMoney() > 0) {
            str = "Robbers: got all your money";
            trader.setMoney(0.0);
        } else {
            lostBestGoods(trader);
            str = lostBestGoods(trader);
        }
        return str;
    }

    private String lostBestGoods(Trader trader) {
        String str = "";
        for (int i = 0; i < trader.goodsList.size(); i++) {
            if (trader.goodsList.get(i).getQualityObj().equals(Quality.GOOD)) {
                str = String.format("Robbers got %s", trader.goodsList.get(i).getName());
                trader.goodsList.remove(i);
                break;
            } else {
                if (trader.goodsList.get(i).getQualityObj().equals(Quality.SLIGHTLY_SPOILED)) {
                    str = String.format("Robbers got %s", trader.goodsList.get(i).getName());
                    trader.goodsList.remove(i);
                    break;
                }
            }
        }
        return str;
    }
}
