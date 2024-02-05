import java.util.ArrayList;

public class Calculator {
    private int countPerson;
    private float costAllGoods;
    private float costPerPerson;
    private ArrayList<Goods> goodsList;
    public Calculator(int countPerson) {
        this.countPerson = countPerson;
        this.costAllGoods = 0;
        goodsList = new ArrayList<>();
    }

    public void addGood(String name, float cost) {
        goodsList.add(new Goods(name, cost));
        System.out.printf("Товар \"%s\" ценой %.2f %s добавлен!\n", name, cost, getRub(cost));
    }

    public void calculate() {
        System.out.println("Добавленные товары:");
        for (Goods good: goodsList) {
            String goodName = good.getName();
            float cost = good.getCost();
            costAllGoods += cost;
            System.out.printf("\"%s\" цена: %.2f %s\n", goodName, cost, getRub(cost));
        }
        System.out.printf("Полная стоимость товаров: %.2f %s\n", costAllGoods, getRub(costAllGoods));
        costPerPerson = costAllGoods / countPerson;
        System.out.printf("Соимость которую должен заплатить каждый человек: %.2f %s.\n",
                costPerPerson, getRub(costPerPerson));
    }

    private String getRub(float cost) {
        int costInt = (int)cost;
        if (costInt > 20) {
           int des = costInt / 10;
           costInt -= des * 10;
        }
        switch (costInt) {
            case 1:
                return "рубль";
            case 2, 3, 4:
                return "рубля";
            default:
                return "рублей";
        }
    }
}
