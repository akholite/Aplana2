package calculator;

public abstract class Function {
    private String symbol;
    public abstract double computeResult(Input input);

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
