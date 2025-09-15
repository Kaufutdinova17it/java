public class Fraction
{
    public static double fraction(double x) {
        int wholePart = (int) x;
        return x - wholePart;
    }
    public static int charToNum(char x){
        if (x>= '0' && x <= '9') {
            return x - '0';
        }
        else {
            System.out.println("Ошибка: символ не является цифрой");
            return -1;
        }

    }
    public static boolean is2Digits(int x) {
        return (x >= 10 && x <= 99) || (x <= -10 && x >= -99);
    }
    public static boolean isInRange (int a,int b,int num) {
        return (a <= b && num >= a && num <= b) || (a >= b && num <= a && num >= b);
    }
    public static boolean isEqual(int a,int b,int c){
        return a == b && b == c;
    }
    public static int abc(int x) {
        if (x >= 0){
            return x;
        }
        else {
            return -x;
        }
    }
    public static boolean is35(int x){
        return (x % 3 == 0 || x % 5 == 0) && !(x % 3 == 0 && x % 5 == 0);
    }

    public static int max3(int x,int y,int z) {
        int max = x;
        if (y > max){
            max = y;
        }
        if (z > max){
            max = z;
        }
        return max;

    }
    public static int sum2(int x,int y) {
        int z = x + y;
        if (z >= 10 && z <= 19 ) {
            return 20;
        }
        else {
            return z;
        }
    }
    public static String day(int x) {
        switch (x) {
            case 1:
                System.out.println("Понедельник");
                break;
            case 2:
                System.out.println("Вторник");
                break;
            case 3:
                System.out.println("Среда");
                break;
            case 4:
                System.out.println("Четверг");
                break;
            case 5:
                System.out.println("Пятница");
                break;
            case 6:
                System.out.println("Суббота");
                break;
            case 7:
                System.out.println("Воскресенье");
                break;
            default:
                System.out.println("Это не день недели");
                break;
        }

        return "";
    }
    public static String listNums(int x) {
        String result = "";
        int count = 0;

        while (count <= x) {
            result = result + count + " ";
            count = count + 1;
        }

        return result;
    }
    public static String chet(int x) {
        String result = "";
        int count = 0;

        while (count <= x) {
            result = result + count + " ";
            count = count + 2;
        }

        return result;
    }
    public static int numLen(long x) {
        if (x == 0) {
            return 1;
        }

       
        int count = 0;
        long num = x;

        
        while (num != 0) {
            num /= 10;
            count++;
        }


        return count;
    }
    public static void square(int x){
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++){
                System.out.print('*');
            }
            System.out.println();
        }
    }
    public static void rightTriangle(int x){
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < x - i; j++) {
                System.out.print(' ');
            }

            for (int j = 0; j < i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }
    public static int findFirst(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }
    public static int maxAbs(int[] arr) {
        int maxAbsValue = arr[0]; 
        int maxAbs = Math.abs(arr[0]); 

        for (int i = 1; i < arr.length; i++) {
            int currentAbs = Math.abs(arr[i]);
            if (currentAbs > maxAbs) {
                maxAbs = currentAbs;
                maxAbsValue = arr[i]; 
            }
        }

        return maxAbsValue;
    }
    public static int[] add(int[] arr, int[] ins, int pos) {
        
        if (arr == null) arr = new int[0];
        if (ins == null) ins = new int[0];

        
        if (pos < 0) pos = 0;
        if (pos > arr.length) pos = arr.length;

        int[] result = new int[arr.length + ins.length];

        
        for (int i = 0; i < pos; i++) {
            result[i] = arr[i];
        }

        
        for (int i = 0; i < ins.length; i++) {
            result[pos + i] = ins[i];
        }

        
        for (int i = pos; i < arr.length; i++) {
            result[ins.length + i] = arr[i];
        }

        return result;
    }
    public static int[] reverseBack(int[] arr) {
        if (arr == null) {
            return new int[0];
        }

        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[arr.length - 1 - i];
        }

        return result;
    }
    public static int[] findAll(int[] arr, int x) {
        if (arr == null) {
            return new int[0];
        }

        
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                count++;
            }
        }


        int[] result = new int[count];
        int resultIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                result[resultIndex] = i;
                resultIndex++;
            }
        }

        return result;
    }




}

