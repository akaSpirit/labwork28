public enum Cities {
    BEIJING("Beijing", 0),
    MOSCOW("Moscow",0),
    LONDON("London", 0),
    BERLIN("Berlin",0),
    ROME("Rome",0),
    WASHINGTON("Washington",0),
    SEOUL("Seoul",0);

    private final String name;
    private Integer distance;

    Cities(String name, Integer distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}
