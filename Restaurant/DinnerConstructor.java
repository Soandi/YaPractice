import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    private HashMap<String, ArrayList<String>> dishesBase;
    Random rnd = new Random();

    public DinnerConstructor() {
        dishesBase = new HashMap<>();
    }

    void add(String type, String dish) {
        if (type != null && dish != null) {
            ArrayList<String> dishAdd = new ArrayList<>();
            if (dishesBase.containsKey(type)) {
                dishesBase.get(type).add(dish);
            } else {
                dishAdd.add(dish);
                dishesBase.put(type, dishAdd);
            }
        }
    }

    boolean checkType(String type) {
        return dishesBase.containsKey(type);
    }

    void comboGenerator(int quantity, ArrayList<String> typeList) {
        if (dishesBase.isEmpty()) {
            System.out.println("Нет данных для генерации. Сначала добавьте блюда");
            return;
        }
        ArrayList<String> myCombo;
        for (int i = 0; i < quantity; i++) {
            myCombo = new ArrayList<>();
            System.out.println("Комбо " + (i + 1));
            for (int k = 0; k < typeList.size(); k++) {
                int lengthOfDishesList = dishesBase.get(typeList.get(k)).size();
                myCombo.add(dishesBase.get(typeList.get(k)).get(rnd.nextInt(lengthOfDishesList)));
            }
            System.out.println(myCombo);
        }
    }
}