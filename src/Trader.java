public class Trader {
    private Double capacity;
    private Integer speed;
    private Double money;

    public Trader(Double capacity, Integer speed, Double money) {
        this.capacity = capacity;
        this.speed = speed;
        this.money = money;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
