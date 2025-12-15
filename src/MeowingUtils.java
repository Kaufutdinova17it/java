import java.util.List;

public class MeowingUtils {
    public static void makeAllMeow(List<Meowable> meowables) {
        for (Meowable meowable : meowables) {
            meowable.meow();
        }
    }
}