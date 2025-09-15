//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int number1;
        int number2;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите номер блока задач (1-4)");
        number1 = scanner.nextInt();

        switch (number1) {
            case 1:
                System.out.println("Выберите номер задачи (нечетный:1,3,5,7,9)");
                number2 = scanner.nextInt();
                switch (number2) {
                    case 1:
                        task1_1(scanner);
                        break;
                    case 3:
                        task1_3(scanner);
                        break;
                    case 5:
                        task1_5(scanner);
                        break;
                    case 7:
                        task1_7(scanner);
                        break;
                    case 9:
                        task1_9(scanner);
                        break;
                    default:
                        System.out.println("Ошибка!Неверный номер задачи!");
                        break;
                }
                break;

            case 2:
                System.out.println("Выберите номер задачи (нечетный:1,3,5,7,9)");
                number2 = scanner.nextInt();
                switch (number2) {
                    case 1:
                        task2_1(scanner);
                        break;
                    case 3:
                        task2_3(scanner);
                        break;
                    case 5:
                        task2_5(scanner);
                        break;
                    case 7:
                        task2_7(scanner);
                        break;
                    case 9:
                        task2_9(scanner);
                        break;
                    default:
                        System.out.println("Ошибка!Неверный номер задачи!");
                        break;
                }
                break;

            case 3:
                System.out.println("Выберите номер задачи (нечетный:1,3,5,7,9)");
                number2 = scanner.nextInt();
                switch (number2) {
                    case 1:
                        task3_1(scanner);
                        break;
                    case 3:
                        task3_3(scanner);
                        break;
                    case 5:
                        task3_5(scanner);
                        break;
                    case 7:
                        task3_7(scanner);
                        break;
                    case 9:
                        task3_9(scanner);
                        break;
                    default:
                        System.out.println("Ошибка!Неверный номер задачи!");
                        break;
                }
                break;

            case 4:
                System.out.println("Выберите номер задачи (нечетный:1,3,5,7,9)");
                number2 = scanner.nextInt();
                switch (number2) {
                    case 1:
                        task4_1(scanner);
                        break;
                    case 3:
                        task4_3(scanner);
                        break;
                    case 5:
                        task4_5(scanner);
                        break;
                    case 7:
                        task4_7(scanner);
                        break;
                    case 9:
                        task4_9(scanner);
                        break;
                    default:
                        System.out.println("Ошибка!Неверный номер задачи!");
                        break;
                }
                break;

            default:
                System.out.println("Ошибка!Неверный номер блока!");
                break;
        }
        scanner.close();
    }


    public static void task1_1(Scanner scanner) {
        System.out.print("Введите вещественное число: ");
        double number = scanner.nextDouble();
        double result1_1 = Fraction.fraction(number);
        System.out.println("Дробная часть: " + result1_1);
    }

    public static void task1_3(Scanner scanner) {
        System.out.print("Введите цифру (0-9): ");
        char symbol = scanner.next().charAt(0);
        int result1_3 = Fraction.charToNum(symbol);
        System.out.println("Число: " + result1_3);
    }

    public static void task1_5(Scanner scanner) {
        System.out.println("Введите целое число:");
        int number1_5 = scanner.nextInt();
        boolean result1_5 = Fraction.is2Digits(number1_5);
        System.out.println(result1_5);
    }

    public static void task1_7(Scanner scanner) {
        System.out.println("Введите первую целую границу");
        int a = scanner.nextInt();
        System.out.println("Введите вторую целую границу");
        int b = scanner.nextInt();
        System.out.println("Введите целое число,которое хотите проверить");
        int num = scanner.nextInt();
        boolean result1_7 = Fraction.isInRange(a,b,num);
        System.out.println(result1_7);

    }

    public static void task1_9(Scanner scanner) {
        System.out.println("Введите целое число a");
        int a = scanner.nextInt();
        System.out.println("Введите целое число b");
        int b = scanner.nextInt();
        System.out.println("Введите целое число c");
        int c = scanner.nextInt();
        boolean result1_9 = Fraction.isEqual(a,b,c);
        System.out.println(result1_9);
    }


    public static void task2_1(Scanner scanner) {
        System.out.println("Введите целое число:");
        int x = scanner.nextInt();
        int result2_1 = Fraction.abc(x);
        System.out.println("Модуль числа:" + result2_1);
    }

    public static void task2_3(Scanner scanner) {
        System.out.println("Введите целое число:");
        int x = scanner.nextInt();
        boolean result2_3 = Fraction.is35(x);
        System.out.println(result2_3);

    }

    public static void task2_5(Scanner scanner) {
        System.out.println("Введите целое число x");
        int x = scanner.nextInt();
        System.out.println("Введите целое число y");
        int y = scanner.nextInt();
        System.out.println("Введите целое число z");
        int z = scanner.nextInt();
        int result2_5 = Fraction.max3(x,y,z);
        System.out.println("Максимальное из трех чисел:"+result2_5);
    }

    public static void task2_7(Scanner scanner) {
        System.out.println("Введите первое целое число");
        int x = scanner.nextInt();
        System.out.println("Введите второе целое число");
        int y = scanner.nextInt();
        int result2_7 = Fraction.sum2(x,y);
        System.out.println("Вычесленное значение:" + result2_7);
    }

    public static <string> void task2_9(Scanner scanner) {
        System.out.println("Введите целое число от 1 до 7");
        int x = scanner.nextInt();
        string result2_9 = (string) Fraction.day(x);


    }


    public static void task3_1(Scanner scanner) {
        System.out.println("Введите целое число");
        int x = scanner.nextInt();
        String result3_1;
        result3_1 = Fraction.listNums(x);
        System.out.println(result3_1);
    }

    public static void task3_3(Scanner scanner) {
        System.out.println("Введите целое число");
        int x = scanner.nextInt();
        String result3_3;
        result3_3 = Fraction.chet(x);
        System.out.println(result3_3);

    }

    public static void task3_5(Scanner scanner) {
        System.out.println("Введите целое положительное число");
        int x = scanner.nextInt();
        int result3_5 = Fraction.numLen(x);
        System.out.println(result3_5);

    }

    public static void task3_7(Scanner scanner) {
        System.out.println("Введите целое число");
        int x = scanner.nextInt();
        Fraction.square(x);
    }

    public static void task3_9(Scanner scanner) {
        System.out.println("Введите целое число");
        int x = scanner.nextInt();
        Fraction.rightTriangle(x);
    }


    public static void task4_1(Scanner scanner) {
        System.out.println("Введите длину массива: ");
        int length = scanner.nextInt();
        int[] arr = new int[length];
        System.out.println("Введите элементы массива: ");
        for (int i = 0; i < length;i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println("Введите число для поиска: ");
        int x = scanner.nextInt();
        int result4_1 = Fraction.findFirst(arr,x);
        System.out.println("Индекс первого вхождения: " + result4_1);
    }

    public static void task4_3(Scanner scanner) {
        System.out.println("Введите длину массива: ");
        int length = scanner.nextInt();
        int[] arr = new int[length];
        System.out.println("Введите элементы массива: ");
        for (int i = 0; i < length;i++) {
            arr[i] = scanner.nextInt();
        }
        int result4_3 = Fraction.maxAbs(arr);
        System.out.println("Модуль наибольшего числа: " + result4_3);
    }


    public static void task4_5(Scanner scanner) {
        // Ввод первого массива arr
        System.out.println("Введите длину первого массива: ");
        int lengthArr = scanner.nextInt();
        int[] arr = new int[lengthArr];
        System.out.println("Введите элементы первого массива: ");
        for (int i = 0; i < lengthArr; i++) {
            arr[i] = scanner.nextInt();
        }

        // Ввод второго массива ins
        System.out.println("Введите длину второго массива: ");
        int lengthIns = scanner.nextInt();
        int[] ins = new int[lengthIns];
        System.out.println("Введите элементы второго массива: ");
        for (int i = 0; i < lengthIns; i++) {
            ins[i] = scanner.nextInt();
        }

        // Ввод позиции для вставки
        System.out.println("Введите позицию для вставки: ");
        int pos = scanner.nextInt();

        // Вызов метода add
        int[] result = Fraction.add(arr, ins, pos);
        System.out.print("Результат: [");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void task4_7(Scanner scanner) {
        System.out.println("Введите длину массива: ");
        int length = scanner.nextInt();
        int[] arr = new int[length];
        System.out.println("Введите элементы массива: ");
        for (int i = 0; i < length;i++) {
            arr[i] = scanner.nextInt();
        }
        int[] reversedArray = Fraction.reverseBack(arr);
        System.out.print("Новый массив: [");
        for (int i = 0; i < reversedArray.length; i++) {
            System.out.print(reversedArray[i]);
            if (i < reversedArray.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void task4_9(Scanner scanner) {
        System.out.println("Введите длину массива: ");
        int length = scanner.nextInt();
        int[] arr = new int[length];
        System.out.println("Введите элементы массива: ");

        
        for (int i = 0; i < length; i++) {
            arr[i] = scanner.nextInt();
        }

        
        System.out.println("Введите число для поиска: ");
        int x = scanner.nextInt();

        
        int[] result4_9 = Fraction.findAll(arr, x);

        
        System.out.print("Индексы вхождений: [");
        for (int c = 0; c < result4_9.length; c++) {
            System.out.print(result4_9[c]);
            if (c < result4_9.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        }
    }
