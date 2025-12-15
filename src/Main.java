import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Point[] points = new Point[3];
        ForPoint forPoint = new ForPoint();
        // 1 задание
        System.out.println("Задание 1.1: ");
        for (int i = 0; i < points.length; i++) {
            System.out.println("Введите координаты точки " + (i + 1) + ": ");
            double x = forPoint.Coordinate("x");
            double y = forPoint.Coordinate("y");
            points[i] = new Point(x, y);
        }

        System.out.println("Созданные точки: ");
        for (Point point : points) {
            System.out.println(point);
        }
        System.out.println("Задание 1.3: ");
        Name CleopatraName = new Name("Клеопатра");
        Name PushkinName = new Name("Пушкин", "Александр", "Сергеевич");
        Name VladimirName = new Name("Маяковский", "Владимир");
        System.out.println(CleopatraName);
        System.out.println(PushkinName);
        System.out.println(VladimirName);

        // 2 задание
        // 2.1 Линия 1 с началом в т. {1;3} и концом в т. {23;8}
        Point line1Start = new Point(1, 3);
        Point line1End = new Point(23, 8);
        Line line1 = new Line(line1Start, line1End);

        // 2.2 Линия 2, горизонтальная, на высоте 10,от точки 5 до точки 25
        Point line2Start = new Point(5, 10);
        Point line2End = new Point(25, 10);
        Line line2 = new Line(line2Start, line2End);

        // 2.3 Линия 3, которая начинается там же, где линия 1 и заканчивается там же, где линия 2
        Line line3 = new Line(line1.getStart(), line2.getEnd());
        System.out.println("2.1-2.3, выводим линии: ");
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        // 2.4 Изменяем координаты 1 и 2 линии, но чтобы координаты 3 линии соответствовали 3 пункту
        line1Start = new Point(1, 18);
        line2End = new Point(15, 10);

        line1 = new Line(line1Start, line1End);
        line2 = new Line(line2Start, line2End);
        line3 = new Line(line1.getStart(), line2.getEnd());

        System.out.println("2.4, после изменения координат 1 и 2 линии: ");
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);

        // 2.5 Измените координаты 1 линии так, чтобы при этом не изменились, координаты 3 линии
        line1Start = new Point(1, 18);
        line1End = new Point(-7, 5);
        line1 = new Line(line1Start, line1End);
        System.out.println("2.5, после измнения координат 1 линии: ");
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);

        System.out.println("Задание 3.3, 4.8: ");

        City A = new City("A");
        City B = new City("B");
        City C = new City("C");
        City D = new City("D");
        City E = new City("E");
        City F = new City("F");

        A.addPath(B, 5);
        B.addPath(A, 5);

        B.addPath(C, 3);
        C.addPath(B, 3);

        C.addPath(D, 4);
        D.addPath(C, 4);

        D.addPath(E, 2);

        F.addPath(E, 2);
        E.addPath(F, 2);

        F.addPath(B, 1);

//        // С помощью нового конструктора
//                D.addPath(A, 6);
//                A.addPath(D, 6);
//                A.addPath(F, 1);

        Map<City, Integer> pathsForD = new HashMap<>();
        pathsForD.put(A, 6);
        pathsForD.put(E, 2);

        D = new City("D", pathsForD);

        Map<City, Integer> pathsForA = new HashMap<>();
        pathsForA.put(F, 1);
        pathsForA.put(D, 6);

        A = new City("A", pathsForA);

        City[] cities = {A, B, C, D, E, F};

        for (City city : cities) {
            System.out.println(city);
        }

        System.out.println("Задание 5.5: ");

        Scanner scanner = new Scanner(System.in);

        Fraction f1 = new Fraction(scanner);
        System.out.println("Вы создали дробь f1: " + f1);

        Fraction f2 = new Fraction(scanner);
        System.out.println("Вы создали дробь f2: " + f2);

        Fraction f3 = new Fraction(scanner);
        System.out.println("Вы создали дробь f3: " + f3);

        System.out.println(f1 + " + " + f2 + " = " + f1.sum(f2));
        System.out.println(f1 + " - " + f2 + " = " + f1.minus(f2));
        System.out.println(f1 + " * " + f2 + " = " + f1.multiply(f2));
        System.out.println(f1 + " / " + f2 + " = " + f1.div(f2));

        Fraction result = f1.sum(f2).div(f3).minus(5);
        System.out.println("Результат выражения: f1.sum(f2).div(f3).minus(5) = (" + f1 + " + " + f2 + ") / " + f3 + " - 5 = " + result);
    }
}
