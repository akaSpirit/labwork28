public enum Quality {
    GOOD("Good",1.2),
    SLIGHTLY_SPOILED("Slightly spoiled",0.95),
    HALF_SPOILED("Half spoiled",0.55),
    ALMOST_ALL_SPOILED("Almost all spoiled",0.25),
    FULLY_SPOILED("Fully spoiled",0.1);

    private final String name;
    private final Double priceMultiplier;

    public Double getPriceMultiplier() {
        return priceMultiplier;
    }

    public String getName() {
        return name;
    }

    Quality(String name, Double priceMultiplier) {
        this.name = name;
        this.priceMultiplier = priceMultiplier;
    }
}
