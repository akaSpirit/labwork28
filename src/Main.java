import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        List<Goods> goodsList = new ArrayList<>();
        Integer speed = 0;
        Double money = new Random().nextDouble(200.0, 501.0);
        Trader trader = new Trader(100.0, speed, money);
        purchaseGoods(trader, goodsList);
        int distance = chooseCity();
        int day = 0;
        System.out.println("+-------------+----------------+----------------+");
        System.out.println("|     Day     |    Distance    |     Event      |");
        System.out.println("+-------------+----------------+----------------+");
        while(distance > 0){
            day++;
            trader.setSpeed(new Random().nextInt(1, 6));
            distance -= trader.getSpeed();
            if (distance < 0){
                distance = 0;
            }
            System.out.printf("| %-11s | %-14s |%n", day, distance);
            System.out.println("+-------------+----------------+");
        }
        double proceed = 0.0;
        for (Goods g: goodsList) {
            proceed += g.getPurchasePrice() * g.getQualityObj().getPriceMultiplier();
        }
        double purchase = money - trader.getMoney();
        System.out.printf("%.1f, %.1f %n", purchase, proceed);

        if (proceed > purchase){
            System.out.printf("You got profit: %.1f", proceed-purchase);
        } else System.out.println("That was bad business");
    }

    public static void purchaseGoods(Trader trader, List<Goods> goodsList) {
        boolean isPurchase = true;
        while (isPurchase) {
            int rand = new Random().nextInt(0, 6);
            if (trader.getMoney() >= Goods.values()[rand].getPurchasePrice() && trader.getCapacity() >= Goods.values()[rand].getWeight()) {
                trader.setCapacity(trader.getCapacity() - Goods.values()[rand].getWeight());
                System.out.printf("capacity: %s%n", trader.getCapacity());
                trader.setMoney(trader.getMoney() - Goods.values()[rand].getPurchasePrice());
                System.out.printf("money: %.0f%n", trader.getMoney());
                goodsList.add(Goods.values()[rand]);

            } else if (trader.getMoney() <= 0 || trader.getCapacity() <= 0) {
                isPurchase = false;
            }
        }
        System.out.println("+--------------+----------------+----------------+");
        System.out.println("|     Name     |      Price     |     Quality    |");
        System.out.println("+--------------+----------------+----------------+");
        for (Goods g: goodsList) {
            System.out.printf("| %-12s | %-14s | %-14s |%n", g.getName(), g.getPurchasePrice(), g.getQualityObj().getName());
            System.out.println("+--------------+----------------+----------------+");
        }
    }

    public static int chooseCity() {
        List<Cities> citiesList = new ArrayList<>();
        System.out.println("+--------------+----------------+");
        System.out.println("|     City     |    Distance    |");
        System.out.println("+--------------+----------------+");
        for (int i = 0; i < Cities.values().length; i++) {
            citiesList.add(Cities.values()[i]);
            int rand = new Random().nextInt(50,101);
            Cities.values()[i].setDistance(Cities.values()[i].getDistance() + rand);
            System.out.printf("| %-12s | %8s       |%n", Cities.values()[i].getName(), Cities.values()[i].getDistance());
            System.out.println("+--------------+----------------+");
        }
        System.out.println("\n+--------------+----------------+");
        System.out.println("| Chosen City  |    Distance    |");
        System.out.println("+--------------+----------------+");
        int rand = new Random().nextInt(0,7);
        System.out.printf("| %-12s | %8s       |%n", citiesList.get(rand).getName(), citiesList.get(rand).getDistance());
        System.out.println("+--------------+----------------+");

        return citiesList.get(rand).getDistance();
    }
}
