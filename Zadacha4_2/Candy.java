public class Candy extends Sweet{
    private String flavor;

    public Candy(String name, int weight, double price, String flavor) {
        super(name, weight, price);
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public String toString() {
        return "Конфета: [" + super.toString() + ", вкус: " + flavor + "]";
    }
}
