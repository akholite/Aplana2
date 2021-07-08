package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CalculatorApp {

    private List<Function> operationList;

    public CalculatorApp() {

        this.operationList = Arrays.asList(
                new Operations.Addition(),
                new Operations.Subtraction(),
                new Operations.Division(),
                new Operations.Multiplication(),
                new Operations.Log(),
                new Operations.Sqrt()
        );

    }
    public void executeApp() {

        System.out.println("Введите знак операции +, -, /, * и 2 числа через пробел " +
                "или одну из функций log, sqrt и число через пробел. \"Выход\" для выхода");

        Scanner scan = new Scanner(System.in);
        Input input = new Input();
        String consoleInput;

        //проверки на ввод будут добавлены позже
        input.setOperation(scan.next());
        consoleInput = scan.nextLine();

        Scanner subscan = new Scanner(consoleInput);

        while (!input.getOperation().equals("Выход")) {

            input.setFirstOperand(subscan.nextDouble());

            if (subscan.hasNextDouble())
                input.setSecondOperand(subscan.nextDouble());

            for (Function function : operationList) {
                if (function.getSymbol().equals(input.getOperation())) {
                    printResult(input, function);
                    break;
                }
            }

            consoleInput = scan.nextLine();
            subscan = new Scanner(consoleInput);
            input.setOperation(subscan.next());
        }

        scan.close();
        subscan.close();
    }

    public void printResult(Input input, Function function) {

        if (input.getOperation().equals("log") || input.getOperation().equals("sqrt"))
            System.out.println(input.getOperation() + " " + input.getFirstOperand() + " = " + function.computeResult(input));
        else
            System.out.println(input.getFirstOperand() + " " + input.getOperation() + " " +
                    input.getSecondOperand() + " = " + function.computeResult(input));
    }

    public static void main(String[] args) {
        CalculatorApp app = new CalculatorApp();
        app.executeApp();
    }
}
