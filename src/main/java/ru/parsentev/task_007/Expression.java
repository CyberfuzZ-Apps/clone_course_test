package ru.parsentev.task_007;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.parsentev.task_001.Calculator;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Реализовать класс Expression. Класс должен принимать строку из простого
 * математического выражения и методы double calc().
 * Должен поддерживать операции + - / * exp. Например, "2+2" - 4, "2-2" - 0
 * Если выражение не корректное выбросить исключение java.lang.IllegalStateException
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class Expression {
    private static final Logger log = getLogger(Expression.class);

    private final String expr;

    public Expression(final String expr) {
        this.expr = expr;
    }

    public double calc() {
        Calculator calculator = new Calculator();
        int first;
        int second;
        int indexPlus = expr.indexOf("+");
        int indexMinus = expr.indexOf("-");
        int indexMulti = expr.indexOf("*");
        int indexDev = expr.indexOf("/");
        int indexExp = expr.indexOf("^");
        double rsl = 0;
        try {
            if (indexPlus != -1) {
                first = Integer.parseInt(expr.substring(0, indexPlus));
                second = Integer.parseInt(expr.substring(indexPlus));
                calculator.add(first, second);
            } else if (indexMinus != -1) {
                first = Integer.parseInt(expr.substring(0, indexMinus));
                second = Integer.parseInt(expr.substring(indexMinus));
                calculator.expand(first, second);
            } else if (indexMulti != -1) {
                first = Integer.parseInt(expr.substring(0, indexMulti));
                second = Integer.parseInt(expr.substring(indexMulti));
                calculator.multiple(first, second);
            } else if (indexDev != -1) {
                first = Integer.parseInt(expr.substring(0, indexDev));
                second = Integer.parseInt(expr.substring(indexDev));
                calculator.div(first, second);
            } else if (indexExp != -1) {
                first = Integer.parseInt(expr.substring(0, indexExp));
                second = Integer.parseInt(expr.substring(indexExp));
                calculator.expand(first, second);
            }
        } catch (NumberFormatException e) {
            throw new IllegalStateException();
        }
        return calculator.getResult();
    }

    public static void main(String[] args) {
        Expression expression = new Expression("2+");
        expression.calc();
    }
}
