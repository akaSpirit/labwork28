public class RoadsideInn implements Event {
    @Override
    public String getSomeEvent(Trader trader) {
        String str = "";
        String str1 = "";
        if (trader.getMoney() > 10) {
            trader.setMoney(trader.getMoney() - 10.0);
            trader.setSpeed(0);
            for (int i = 0; i < trader.goodsList.size(); i++) {
                if (trader.goodsList.get(i).getQualityObj().equals(Quality.FULLY_SPOILED)) {
                    trader.setMoney(trader.getMoney() + trader.goodsList.get(i).getPurchasePrice() * trader.goodsList.get(i).getQualityObj().getPriceMultiplier());
                    trader.goodsList.remove(i);
                    str1 = String.format("Sold %s", trader.goodsList.get(i).getName());
                    break;
                }
            }
            str = String.format("Staying at inn. %s", str1);
        } else str = "Have no money for staying at this inn";
        return str;
    }
}
