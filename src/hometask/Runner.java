package hometask;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Двое безумных учёных устроили соревнование, кто из них соберёт больше роботов за 100 ночей.
 * Для этого каждую ночь каждый из них отправляет своего прислужника на свалку фабрики роботов за деталями.
 * Чтобы собрать одного робота им нужно:
 * Голова, Тело, Левая рука, Правая рука, Левая нога, Правая нога, CPU, RAM, HDD
 * В первую ночь на свалке находится 20 случайных деталей.
 * Каждую ночь фабрика выбрасывает на свалку от 1 до 4 случайных деталей.
 * В то же самое время прислужники обоих учёных отправляются на свалку,
 * и каждый собирает от 1 до 4 случайных деталей. Если на свалке деталей нет – прислужник уходит ни с чем.
 * Затем они возвращаются домой и отдают детали хозяевам.
 * Учёные пытаются собрать как можно больше роботов из деталей, которые они получили.
 * Написать программу, симулирующую этот процесс. Для симуляции принять, что каждая ночь наступает через 100мс.
 * Фабрика и два прислужника действуют в одно и то же время.
 * После 100 ночей (около 10 секунд) определить победителя соревнования.
 */

public class Runner {

    public static void main(String[] args) throws InterruptedException {
        var night = new Night();
        night.start();
        night.join();
        showTheWinner();
    }

    private static void showTheWinner() {

        int numberOfRobots1 = 0;
        int numberOfRobots2 = 0;

        Map<Integer, Integer> map1 = new HashMap<>();
        for (Integer temp : Night.bag1) {
            Integer count = map1.get(temp);
            map1.put(temp, (count == null) ? 1 : count + 1);
        }
        var min1 = map1.values().stream()
                .mapToInt(Integer::intValue)
                .min();
        if (min1.isPresent()) {
             numberOfRobots1 = min1.getAsInt();
        }

        Map<Integer, Integer> map2 = new HashMap<>();
        for (Integer temp : Night.bag2) {
            Integer count = map2.get(temp);
            map2.put(temp, (count == null) ? 1 : count + 1);
        }
        var min2 = map2.values().stream()
                .mapToInt(Integer::intValue)
                .min();
        if (min2.isPresent()) {
             numberOfRobots2 = min2.getAsInt();
        }


        System.out.println();
        if (numberOfRobots1 > numberOfRobots2) {
            System.out.println("первый победил");
        } else if (numberOfRobots1 < numberOfRobots2) {
            System.out.println("второй победил");
        } else {
            System.out.println("ничья");
        }
    }
}
