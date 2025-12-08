import java.util.Scanner;
public class Fraction {
    private int numerator;
    private int denominator;

    // Конструктор, принимающий числитель и знаменатель
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            System.out.println("Знаменатель не может быть равен нулю");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    // Конструктор, принимающий Scanner для ввода значений
    public Fraction(Scanner scanner) {
        inputFraction(scanner);
        simplify();
    }

    // Метод для ввода числителя и знаменателя
    private void inputFraction(Scanner scanner) {
        while (true) {
            System.out.print("Введите числитель: ");
            numerator = Check.validateIntInput(scanner);
            System.out.print("Введите знаменатель: ");
            denominator = Check.validateIntInput(scanner);

            if (denominator == 0) {
                System.out.println("Знаменатель не может быть равен нулю. Пожалуйста, введите снова.");
            } else {
                break;
            }
        }
    }

    // Метод для упрощения дроби
    private void simplify() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;

        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    // Метод для получения НОД
    private int gcd(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return gcd(b, a % b);
    }

    // Метод для строкового представления дроби
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    // Сложение дробей
    public Fraction sum(Fraction other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    // Вычитание дробей
    public Fraction minus(Fraction other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    // Умножение дробей
    public Fraction multiply(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    // Деление дробей
    public Fraction div(Fraction other) {
        if (other.numerator == 0) {
            System.out.println("Деление на ноль невозможно");
        }
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    // Сложение с целым числом
    public Fraction sum(int other) {
        return this.sum(new Fraction(other, 1));
    }

    // Вычитание с целым числом
    public Fraction minus(int other) {
        return this.minus(new Fraction(other, 1));
    }

    // Умножение на целое число
    public Fraction multiply(int other) {
        return new Fraction(this.numerator * other, this.denominator);
    }

    // Деление на целое число
    public Fraction div(int other) {
        if (other == 0) {
            System.out.println("Деление на ноль невозможно");
        }
        return new Fraction(this.numerator, this.denominator * other);
    }
}
