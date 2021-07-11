package calculator;

public class Operations {

    public static class Addition extends Function {

        public Addition() {
            setSymbol("+");
        }

        public double computeResult(Input input) {
            return input.getFirstOperand() + input.getSecondOperand();
        }
    }

    public static class Subtraction extends Function {

        public Subtraction() {
            setSymbol("-");
        }

        public double computeResult(Input input) {
            return input.getFirstOperand() - input.getSecondOperand();
        }
    }

    public static class Multiplication extends Function {

        public Multiplication() {
            setSymbol("*");
        }

        public double computeResult(Input input) {
            return input.getFirstOperand() * input.getSecondOperand();
        }
    }

    public static class Division extends Function {

        public Division() {
            setSymbol("/");
        }

        public double computeResult(Input input) {
            return input.getFirstOperand() / input.getSecondOperand();
        }
    }

    public static class Log extends Function {

        public Log() {
            setSymbol("log");
        }

        public double computeResult(Input input) {
            return Math.log10(input.getFirstOperand());
        }
    }

    public static class Sqrt extends Function {

        public Sqrt() {
            setSymbol("sqrt");
        }

        public double computeResult(Input input) {
            return Math.sqrt(input.getFirstOperand());
        }
    }
}
