import java.util.Objects;

public class Fraction implements FractionInterface {
    private int numerator;
    private int denominator;
    private Double cachedDecimalValue;

    public Fraction(int numerator, int denominator) {
        validateDenominator(denominator);
        normalizeSign(numerator, denominator);
    }

    private void validateDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен 0");
        }
    }

    private void normalizeSign(int numerator, int denominator) {
        if (denominator < 0) {
            this.numerator = -numerator;
            this.denominator = -denominator;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    @Override
    public double getDecimalValue() {
        if (cachedDecimalValue == null) {
            cachedDecimalValue = (double) numerator / denominator;
            System.out.println("Вычислено значение: " + cachedDecimalValue);
        }
        return cachedDecimalValue;
    }

    @Override
    public void setNumerator(int numerator) {
        this.numerator = numerator;
        this.cachedDecimalValue = null;
        System.out.println("Кэш сброшен");
    }

    @Override
    public void setDenominator(int denominator) {
        validateDenominator(denominator);
        if (denominator < 0) {
            this.numerator = -this.numerator;
            this.denominator = -denominator;
        } else {
            this.denominator = denominator;
        }
        this.cachedDecimalValue = null;
        System.out.println("Кэш сброшен");
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Fraction fraction = (Fraction) obj;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }
}