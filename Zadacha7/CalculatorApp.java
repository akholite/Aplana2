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
        Scanner subscan;

        while (true) {
            input.setOperation(scan.next());
            consoleInput = scan.nextLine();
            subscan = new Scanner(consoleInput);

            if (input.getOperation().equals("Выход"))
                break;

/* Исключение при выполнении программы возникает только при считывании
   первого числа, поэтому ради упражнения создано кастомное исключение
   в случае ввода некорректной операции */
            try {
                boolean isCorrectOperation = false;

                for (Function function : operationList) {
                    if (function.getSymbol().equals(input.getOperation())) {
                        isCorrectOperation = true;
                        break;
                    }
                }

                if (!isCorrectOperation)
                    throw new IncorrectOperationException(input.getOperation());
            }
            catch (IncorrectOperationException e){
                System.out.println("Введена некорректная операция: " + e.getOperation());
                continue;
            }


            try {
                input.setFirstOperand(subscan.nextDouble());
            } catch (Exception e) {
                System.out.println("В строке \"" + input.getOperation() + consoleInput + "\" вторым должно быть число");
                continue;
            }

            if (subscan.hasNextDouble())
                input.setSecondOperand(subscan.nextDouble());
            else if (!input.getOperation().equals("log") && !input.getOperation().equals("sqrt")) {
                System.out.println("Недостаточно аргументов");
                continue;
            }


            for (Function function : operationList) {
                if (function.getSymbol().equals(input.getOperation())) {
                    printResult(input, function);
                    break;
                }
            }
        };

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

    public class IncorrectOperationException extends Exception {
        private String operation;

        public IncorrectOperationException(String operation) {
            this.operation = operation;
        }

        public String getOperation() {
            return operation;
        }
    }

    public static void main(String[] args) {
        CalculatorApp app = new CalculatorApp();
        app.executeApp();
    }
}
