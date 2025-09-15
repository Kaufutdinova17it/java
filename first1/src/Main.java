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
        try {
            System.out.print("Введите вещественное число: ");
            double number = scanner.nextDouble();
            double result1_1 = Fraction.fraction(number);
            System.out.println("Дробная часть: " + result1_1);
        } catch (Exception e) {
            System.out.println("Ошибка! Введите число правильно.");
            scanner.next(); // очищаем неправильный ввод
        }
    }

    public static void task1_3(Scanner scanner) {
        try {
            System.out.print("Введите цифру (0-9): ");
            String input = scanner.next();
            if (input.length() != 1) {
                System.out.println("Ошибка! Введите только один символ.");
                return;
            }
            char symbol = input.charAt(0);
            int result1_3 = Fraction.charToNum(symbol);
            if (result1_3 == -1) {
                System.out.println("Ошибка! Это не цифра.");
            } else {
                System.out.println("Число: " + result1_3);
            }
        } catch (Exception e) {
            System.out.println("Ошибка ввода!");
        }
    }

    public static void task1_5(Scanner scanner) {
        try {
            System.out.println("Введите целое число:");
            int number1_5 = scanner.nextInt();
            boolean result1_5 = Fraction.is2Digits(number1_5);
            System.out.println(result1_5);
        } catch (Exception e) {
            System.out.println("Ошибка! Введите целое число.");
            scanner.next();
        }
    }

    public static void task1_7(Scanner scanner) {
        try {
            System.out.println("Введите первую целую границу");
            int a = scanner.nextInt();
            System.out.println("Введите вторую целую границу");
            int b = scanner.nextInt();
            System.out.println("Введите целое число,которое хотите проверить");
            int num = scanner.nextInt();
            boolean result1_7 = Fraction.isInRange(a,b,num);
            System.out.println(result1_7);
        } catch (Exception e) {
            System.out.println("Ошибка! Введите целые числа.");
            scanner.next();
        }
    }

    public static void task1_9(Scanner scanner) {
        try {
            System.out.println("Введите целое число a");
            int a = scanner.nextInt();
            System.out.println("Введите целое число b");
            int b = scanner.nextInt();
            System.out.println("Введите целое число c");
            int c = scanner.nextInt();
            boolean result1_9 = Fraction.isEqual(a,b,c);
            System.out.println(result1_9);
        } catch (Exception e) {
            System.out.println("Ошибка! Введите целые числа.");
            scanner.next();
        }
    }

    public static void task2_1(Scanner scanner) {
        try {
            System.out.println("Введите целое число:");
            int x = scanner.nextInt();
            int result2_1 = Fraction.abc(x);
            System.out.println("Модуль числа:" + result2_1);
        } catch (Exception e) {
            System.out.println("Ошибка! Введите целое число.");
            scanner.next();
        }
    }

    public static void task2_3(Scanner scanner) {
        try {
            System.out.println("Введите целое число:");
            int x = scanner.nextInt();
            boolean result2_3 = Fraction.is35(x);
            System.out.println(result2_3);
        } catch (Exception e) {
            System.out.println("Ошибка! Введите целое число.");
            scanner.next();
        }
    }

    public static void task2_5(Scanner scanner) {
        try {
            System.out.println("Введите целое число x");
            int x = scanner.nextInt();
            System.out.println("Введите целое число y");
            int y = scanner.nextInt();
            System.out.println("Введите целое число z");
            int z = scanner.nextInt();
            int result2_5 = Fraction.max3(x,y,z);
            System.out.println("Максимальное из трех чисел:"+result2_5);
        } catch (Exception e) {
            System.out.println("Ошибка! Введите целые числа.");
            scanner.next();
        }
    }

    public static void task2_7(Scanner scanner) {
        try {
            System.out.println("Введите первое целое число");
            int x = scanner.nextInt();
            System.out.println("Введите второе целое число");
            int y = scanner.nextInt();
            int result2_7 = Fraction.sum2(x,y);
            System.out.println("Вычесленное значение:" + result2_7);
        } catch (Exception e) {
            System.out.println("Ошибка! Введите целые числа.");
            scanner.next();
        }
    }

    public static void task2_9(Scanner scanner) {
        try {
            System.out.println("Введите целое число от 1 до 7");
            int x = scanner.nextInt();
            if (x < 1 || x > 7) {
                System.out.println("Ошибка! Число должно быть от 1 до 7.");
                return;
            }
            String result2_9 = Fraction.day(x);
            System.out.println(result2_9);
        } catch (Exception e) {
            System.out.println("Ошибка! Введите целое число.");
            scanner.next();
        }
    }

    public static void task3_1(Scanner scanner) {
        try {
            System.out.println("Введите целое число");
            int x = scanner.nextInt();
            if (x < 0) {
                System.out.println("Ошибка! Число не может быть отрицательным.");
                return;
            }
            String result3_1 = Fraction.listNums(x);
            System.out.println(result3_1);
        } catch (Exception e) {
            System.out.println("Ошибка! Введите целое число.");
            scanner.next();
        }
    }

    public static void task3_3(Scanner scanner) {
        try {
            System.out.println("Введите целое число");
            int x = scanner.nextInt();
            if (x < 0) {
                System.out.println("Ошибка! Число не может быть отрицательным.");
                return;
            }
            String result3_3 = Fraction.chet(x);
            System.out.println(result3_3);
        } catch (Exception e) {
            System.out.println("Ошибка! Введите целое число.");
            scanner.next();
        }
    }

    public static void task3_5(Scanner scanner) {
        try {
            System.out.println("Введите целое число");
            int x = scanner.nextInt();
            int result3_5 = Fraction.numLen(x);
            System.out.println(result3_5);
        } catch (Exception e) {
            System.out.println("Ошибка! Введите целое число.");
            scanner.next();
        }
    }

    public static void task3_7(Scanner scanner) {
        try {
            System.out.println("Введите целое число");
            int x = scanner.nextInt();
            if (x < 0) {
                System.out.println("Ошибка! Размер не может быть отрицательным.");
                return;
            }
            Fraction.square(x);
        } catch (Exception e) {
            System.out.println("Ошибка! Введите целое число.");
            scanner.next();
        }
    }

    public static void task3_9(Scanner scanner) {
        try {
            System.out.println("Введите целое число");
            int x = scanner.nextInt();
            if (x < 0) {
                System.out.println("Ошибка! Размер не может быть отрицательным.");
                return;
            }
            Fraction.rightTriangle(x);
        } catch (Exception e) {
            System.out.println("Ошибка! Введите целое число.");
            scanner.next();
        }
    }

    public static void task4_1(Scanner scanner) {
        try {
            System.out.println("Введите длину массива: ");
            int length = scanner.nextInt();
            if (length < 0) {
                System.out.println("Ошибка! Длина массива не может быть отрицательной.");
                return;
            }
            int[] arr = new int[length];
            System.out.println("Введите элементы массива: ");
            for (int i = 0; i < length; i++) {
                arr[i] = scanner.nextInt();
            }
            System.out.println("Введите число для поиска: ");
            int x = scanner.nextInt();
            int result4_1 = Fraction.findFirst(arr,x);
            System.out.println("Индекс первого вхождения: " + result4_1);
        } catch (Exception e) {
            System.out.println("Ошибка ввода! Проверьте данные.");
            scanner.next();
        }
    }

    public static void task4_3(Scanner scanner) {
        try {
            System.out.println("Введите длину массива: ");
            int length = scanner.nextInt();
            if (length <= 0) {
                System.out.println("Ошибка! Массив не может быть пустым.");
                return;
            }
            int[] arr = new int[length];
            System.out.println("Введите элементы массива: ");
            for (int i = 0; i < length; i++) {
                arr[i] = scanner.nextInt();
            }
            int result4_3 = Fraction.maxAbs(arr);
            System.out.println("Модуль наибольшего числа: " + result4_3);
        } catch (Exception e) {
            System.out.println("Ошибка ввода! Проверьте данные.");
            scanner.next();
        }
    }

    public static void task4_5(Scanner scanner) {
        try {
            System.out.println("Введите длину первого массива: ");
            int lengthArr = scanner.nextInt();
            if (lengthArr < 0) {
                System.out.println("Ошибка! Длина массива не может быть отрицательной.");
                return;
            }
            int[] arr = new int[lengthArr];
            System.out.println("Введите элементы первого массива: ");
            for (int i = 0; i < lengthArr; i++) {
                arr[i] = scanner.nextInt();
            }

            System.out.println("Введите длину второго массива: ");
            int lengthIns = scanner.nextInt();
            if (lengthIns < 0) {
                System.out.println("Ошибка! Длина массива не может быть отрицательной.");
                return;
            }
            int[] ins = new int[lengthIns];
            System.out.println("Введите элементы второго массива: ");
            for (int i = 0; i < lengthIns; i++) {
                ins[i] = scanner.nextInt();
            }

            System.out.println("Введите позицию для вставки: ");
            int pos = scanner.nextInt();
            if (pos < 0) {
                System.out.println("Ошибка! Позиция не может быть отрицательной.");
                return;
            }

            int[] result = Fraction.add(arr, ins, pos);
            System.out.print("Результат: [");
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i]);
                if (i < result.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        } catch (Exception e) {
            System.out.println("Ошибка ввода! Проверьте данные.");
            scanner.next();
        }
    }

    public static void task4_7(Scanner scanner) {
        try {
            System.out.println("Введите длину массива: ");
            int length = scanner.nextInt();
            if (length < 0) {
                System.out.println("Ошибка! Длина массива не может быть отрицательной.");
                return;
            }
            int[] arr = new int[length];
            System.out.println("Введите элементы массива: ");
            for (int i = 0; i < length; i++) {
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
        } catch (Exception e) {
            System.out.println("Ошибка ввода! Проверьте данные.");
            scanner.next();
        }
    }

    public static void task4_9(Scanner scanner) {
        try {
            System.out.println("Введите длину массива: ");
            int length = scanner.nextInt();
            if (length <= 0) {
                System.out.println("Ошибка! Массив не может быть пустым.");
                return;
            }
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
        } catch (Exception e) {
            System.out.println("Ошибка ввода! Проверьте данные.");
            scanner.next();
        }
    }