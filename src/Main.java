import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        List<Event> eventList = new ArrayList<>();
        eventList.add(new OrdinaryDay());
        eventList.add(new Rain());
        eventList.add(new SmoothRoad());
        eventList.add(new BrokenWheel());
        eventList.add(new River());
        eventList.add(new MeetLocal());
        eventList.add(new Robbers());
        eventList.add(new RoadsideInn());
        eventList.add(new SpoiledGoods());

        Integer speed = 0;
        Double money = new Random().nextDouble(200.0, 501.0);
        Trader trader = new Trader(100.0, speed, money);
        purchaseGoods(trader, trader.goodsList);
        int distance = chooseCity(trader);
        int day = 0;
        System.out.println("+-------------+----------------+----------------------------------------------------------+");
        System.out.println("|     Day     |    Distance    |                          Event                           |");
        System.out.println("+-------------+----------------+----------------------------------------------------------+");
        while(distance > 0){
            day++;
            trader.setSpeed(new Random().nextInt(1, 5));
            int randomEvent = new Random().nextInt(0,9);
            eventList.get(randomEvent).getSomeEvent(trader);
            distance -= trader.getSpeed();
            if (eventList.get(randomEvent).equals(new MeetLocal())){
                int shortCut = new Random().nextInt(3,7);
                distance -= shortCut;
            }
            if (distance < 0){
                distance = 0;
            }
            System.out.printf("| %-11s | %-14s | %-56s |%n", day, distance, eventList.get(randomEvent).getSomeEvent(trader));
            System.out.println("+-------------+----------------+----------------------------------------------------------+");
        }
        double proceed = 0.0;
        for (Goods g: trader.goodsList) {
            proceed += g.getPurchasePrice() * g.getQualityObj().getPriceMultiplier();
        }
        double purchase = money - trader.getMoney();
        System.out.printf("Purchase: %.1f, proceed: %.1f %n", purchase, proceed);

        if (proceed > purchase) System.out.printf("Got profit: %.1f", proceed-purchase);
        else System.out.println("That was bad business");
    }

    public static void purchaseGoods(Trader trader, List<Goods> goodsList) {
        boolean isPurchase = true;
        while (isPurchase) {
            int rand = new Random().nextInt(0, 6);
            if (trader.getMoney() >= Goods.values()[rand].getPurchasePrice() && trader.getCapacity() >= Goods.values()[rand].getWeight()) {
                trader.setCapacity(trader.getCapacity() - Goods.values()[rand].getWeight());
                trader.setMoney(trader.getMoney() - Goods.values()[rand].getPurchasePrice());
//                System.out.printf("capacity: %s%n", trader.getCapacity());  //test capacity
//                System.out.printf("money: %.0f%n", trader.getMoney());      //test money
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

    public static int chooseCity(Trader trader) {
        System.out.println("+--------------+----------------+");
        System.out.println("|     City     |    Distance    |");
        System.out.println("+--------------+----------------+");
        for (int i = 0; i < Cities.values().length; i++) {
            trader.citiesList.add(Cities.values()[i]);
            int rand = new Random().nextInt(50,101);
            Cities.values()[i].setDistance(Cities.values()[i].getDistance() + rand);
            System.out.printf("| %-12s | %8s       |%n", Cities.values()[i].getName(), Cities.values()[i].getDistance());
            System.out.println("+--------------+----------------+");
        }
        System.out.println("\n+--------------+----------------+");
        System.out.println("| Chosen City  |    Distance    |");
        System.out.println("+--------------+----------------+");
        int rand = new Random().nextInt(0,7);
        System.out.printf("| %-12s | %8s       |%n", trader.citiesList.get(rand).getName(), trader.citiesList.get(rand).getDistance());
        System.out.println("+--------------+----------------+");

        return trader.citiesList.get(rand).getDistance();
    }
}
