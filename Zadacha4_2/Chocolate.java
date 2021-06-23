public class Chocolate extends Sweet{
    private int numberOfPieces;

    public Chocolate(String name, int weight, double price, int numberOfPieces) {
        super(name, weight, price);
        this.numberOfPieces = numberOfPieces;
    }

    public int getNumberOfPieces() {
        return numberOfPieces;
    }

    public void setNumberOfPieces(int numberOfPieces) {
        this.numberOfPieces = numberOfPieces;
    }

    @Override
    public String toString() {
        return "Шоколад: [" + super.toString() + ", количество квадратиков: " + numberOfPieces + "]";
    }
}