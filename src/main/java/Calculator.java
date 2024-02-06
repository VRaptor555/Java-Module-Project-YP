import static java.lang.Math.min;

import java.util.ArrayList;

public class Calculator {
    private final int countPerson;
    private float costAllGoods;
    private final ArrayList<Goods> goodsList;
    public Calculator(int countPerson) {
        this.countPerson = countPerson;
        this.costAllGoods = 0;
        goodsList = new ArrayList<>();
    }

    public void addGood(String name, float cost) {
        goodsList.add(new Goods(name, cost));
        System.out.printf("Товар \"%s\" ценой %.2f %s добавлен!\n\n", name, cost, getRub(cost));
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
        float costPerPerson = costAllGoods / countPerson;
        System.out.printf("Соимость которую должен заплатить каждый человек: %.2f %s.\n",
                costPerPerson, getRub(costPerPerson));
    }

    private String getRub(float cost) {
        String[] rubWord = {"рубль", "рубля", "рублей"};
        int[] indexRubWord = {2, 0, 1, 1, 1, 2};
        int costInt = (int)cost;

        if (costInt % 100 > 4 && costInt % 100 < 20) {
            return rubWord[2];
        } else {
            return rubWord[indexRubWord[min(costInt % 10, 5)]];
        }
    }
}
