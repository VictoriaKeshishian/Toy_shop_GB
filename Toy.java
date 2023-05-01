import java.util.ArrayList;
import java.util.List;

/**
 * Класс Игрушка
 */

public class Toy {

    public int id; //  id игрушки
    public String name; // название игрушки
    public int sum; // количество игрушек с данным id
    public float frequency; // частота выпадения игрушки

    private static List<Toy> toysList = new ArrayList<>();
    

    public Toy(int id, String name, int sum) {
        this.id = id;
        this.name = name;
        this.sum = sum;
        toysList.add(this);
    }

    // вычисление общего количества всех игрушек

    public static int getTotalToys() {
        int totalToys = 0;
        for (Toy toy : toysList) {
            totalToys += toy.sum;
        }
        return totalToys;
    }

    // вычисление частоты выпадения игрушки

    public void calculateFrequency(int totalToys){
        if (totalToys == 0) {
            frequency = 0;
        } else {
            frequency = ((float)sum / totalToys) * 100;
        }
    }

    // метод для увеличения количества игрушек и пересчета веса
    public void addQuantity(int sum, int totalToys) {
        this.sum += sum;
        calculateFrequency(totalToys);
    }

    // метод для увеличения количества игрушек и пересчета веса
    public void reduceQuantity(int sum, int totalToys) {
        this.sum -= sum;
        calculateFrequency(totalToys);
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public float getFrequency() {
        return frequency;
    }

    public void setFrequency(float frequency) {
        this.frequency = frequency;
    }

    public static List<Toy> getToysList() {
        return toysList;
    }

    public static void setToysList(List<Toy> toysList) {
        Toy.toysList = toysList;
    }

    @Override
    public String toString() {
        return "Toy [id=" + id + ", name=" + name + ", sum=" + sum + ", frequency=" + frequency + "]";
    }


}
