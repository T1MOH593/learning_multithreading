package hometask;

import static java.lang.Math.*;

public final class RandomUtil {

    public static int getRandomDetail() {
        return (int) floor(random() * 9);
    }

    public static int getRandomSize() {
        return (int) floor(random() * 4) + 1;
    }
}
