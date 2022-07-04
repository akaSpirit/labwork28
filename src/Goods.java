public enum Goods {
    MEAT("Meat", 1.0, 10.0, Quality.GOOD),
    DRIED_FRUITS("Dried fruits", 1.0, 1.0, Quality.GOOD),
    GRAIN("Grain", 5.0, 2.0, Quality.GOOD),
    FLOUR("Flour", 5.0, 5.0, Quality.GOOD),
    FABRICS("Fabrics", 2.0, 10.0, Quality.GOOD),
    PAINT("Paint", 3.0, 15.0, Quality.GOOD);

    private final String name;
    private final Double weight;
    private final Double purchasePrice;
    private Quality qualityObj;

    public String getName() {
        return name;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public Quality getQualityObj() {
        return qualityObj;
    }

    public void setQualityObj(Quality qualityObj) {
        this.qualityObj = qualityObj;
    }

    Goods(String name, Double weight, Double purchasePrice, Quality qualityObj) {
        this.name = name;
        this.weight = weight;
        this.purchasePrice = purchasePrice;
        this.qualityObj = qualityObj;
    }
}
