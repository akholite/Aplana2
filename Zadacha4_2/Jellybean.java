public class Jellybean extends Sweet{
    private String color;

    public Jellybean(String name, int weight, double price, String color) {
        super(name, weight, price);
        this.color = color;
    }

    public String getFlavor() {
        return color;
    }

    public void setFlavor(String flavor) {
        this.color = flavor;
    }

    @Override
    public String toString() {
        return "Мармелад: [" + super.toString() + ", цвет: " + color + "]";
    }
}