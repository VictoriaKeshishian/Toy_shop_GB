import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // создаем список игрушек
        List<Toy> toys = new ArrayList<>();
        toys.add(new Toy(1, "Мишка", 5));
        toys.add(new Toy(2, "Кукла", 5));
        toys.add(new Toy(3, "Машинка", 8));
        toys.add(new Toy(4, "Конструктор", 15));
        toys.add(new Toy(5, "Мячик", 12));
        toys.add(new Toy(6, "Пазлы", 17));

        int totalToys = Toy.getTotalToys();
        for (Toy toy : toys) {
            toy.calculateFrequency(totalToys);
        }
    
        // создаем объект класса Drawing_toys
        DrawingToys toyLottery = new DrawingToys(toys);
    
        // получаем призовую игрушку 
        Toy prizeToy = toyLottery.choice_toy();
        if (prizeToy != null) {
            try {
                FileWriter writer = new FileWriter("prizeToys.txt");
                writer.write(prizeToy.toString()); // запись призовой игрушки в файл
                writer.close(); // закрытие файла
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Поздравляем! Вы выиграли игрушку: " + prizeToy.getName());
        }
    }
}
