
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Класс Розыгрыш игрушек
 */

public class DrawingToys {
    private List<Toy> toysList;
    private List<Toy> prizeToysList;

    public DrawingToys(List<Toy> toysList) {
        this.toysList = toysList;
        prizeToysList = new ArrayList<>(); // инициализация списка призовых игрушек
    }

    public Toy choice_toy() {
        float randomValue = new Random().nextFloat() * 100; // генерация случайного числа от 0 до 100
        float sumFrequency = 0;
        for (Toy toy : toysList) {
            sumFrequency += toy.frequency;
            if (randomValue <= sumFrequency) {
                return toy; // возвращаем игрушку, если сумма частот превысила случайное число
            }
        }
        return null; // возвращаем null, если ни одна игрушка не выбрана
    }

    public void addPrizeToy(Toy prizeToy) {
        if (toysList.contains(prizeToy) && prizeToy.sum > 0 && !prizeToysList.contains(prizeToy)) { // проверяем, есть ли такая игрушка и она не закончилась
            toysList.get(toysList.indexOf(prizeToy)).reduceQuantity(1, Toy.getTotalToys()); // уменьшаем количество игрушек
            prizeToysList.add(prizeToy); // добавляем игрушку в список призовых
        }
    }

    public Toy getPrizeToy() {
        if (prizeToysList.isEmpty()) { // проверяем, есть ли призовые игрушки
            return null;
        }
        Toy prizeToy = prizeToysList.get(0); // получаем первую игрушку в списке
        prizeToysList.remove(0); // удаляем ее из списка призовых
        return prizeToy;
    }
}