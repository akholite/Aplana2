public class Zadacha4_2 {
    public static void main(String[] args) {
        Candy chupachups = new Candy("Чупачупс", 40,25, "клубничный");
        Jellybean jellybeans = new Jellybean("Мармеладки", 250, 80.99, "красный");
        Chocolate chocolateBar = new Chocolate("Альпин Гольд", 125, 120.5, 12);

        Sweet[] christmasGift = {chupachups, jellybeans, chocolateBar};

        int weight = 0;
        double price = 0;

        System.out.println("Состав новогоднего подарка:");

        for (Sweet sweet : christmasGift) {
            System.out.println(sweet.toString());
            weight += sweet.getWeight();
            price += sweet.getPrice();
        }

        System.out.println("Общий вес подарка: " + weight + " г");
        System.out.println("Общая стоимость подарка: " + price + " рублей");
    }
}

