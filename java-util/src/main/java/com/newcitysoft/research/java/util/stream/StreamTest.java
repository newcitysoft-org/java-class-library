package com.newcitysoft.research.java.util.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/10/12 11:40
 */
public class StreamTest {

    static Trader raoul = new Trader("Raoul", "Cambridge");
    static Trader mario = new Trader("Mario", "Milan");
    static Trader alan = new Trader("Alan", "Cambridge");
    static Trader brian = new Trader("Brian", "Cambridge");

    public static List<Trader> getTraderList() {
        List<Trader> traders = Arrays.asList(
                raoul,
                mario,
                alan,
                brian
        );

        return traders;
    }

    public static List<Transaction> getDataList() {


        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2011, 700),
                new Transaction(alan, 2012, 950)
        );

        return transactions;
    }


    /**
     * 找出2011年发生的所有交易，并按交易额排序（从低到高）
     */
    @Test
    public void test1() {
        List<Transaction> collect = getDataList().stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());

        System.out.println(collect);
    }

    /**
     * 交易员都在哪些不同的城市工作过？
     */
    @Test
    public void test2() {
        List<String> collect = getDataList().stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());

        Set<String> collect1 = getDataList().stream()
                .map(t -> t.getTrader().getCity())
                .collect(Collectors.toSet());

        System.out.println(collect);
    }

    /**
     * 查找所有来自剑桥的交易员，并按姓名排序
     */
    @Test
    public void test3() {
        List<Trader> collect = getTraderList().stream()
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());

        System.out.println(collect);
    }

    /**
     * 返回所有交易员的姓名字符串，按字母排序排序
     */
    @Test
    public void test4() {
        System.out.println("误解题意");
        List<String> collect = getTraderList().stream()
                .map(Trader::getName)
                .sorted(String::compareTo)
                .collect(Collectors.toList());

        System.out.println(collect);

        System.out.println("正题");

        String traderStr = getDataList().stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);

        System.out.println(traderStr);

        System.out.println("高效");
        String traderStr2 = getDataList().stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .collect(joining());

        System.out.println(traderStr2);
    }

    /**
     * 有没有交易员在米兰工作的？
     */
    @Test
    public void test5() {
        boolean b = getTraderList().stream()
                .anyMatch(trader -> trader.getCity().equals("Milan"));

        System.out.println(b);
    }

    /**
     * 打印生活在剑桥的交易员的所有交易额
     */
    @Test
    public void test6() {
        // 第一版本
        System.out.println("第一版本");
        getDataList().stream()
                .filter(t -> t.getTrader().getCity() == "Cambridge")
                .forEach(t -> {
                    // 交易员
                    Trader trader = t.getTrader();
                    // 交易额
                    int value = t.getValue();
                    System.out.println(trader.getName() + "的交易额：" + value);
                });
        // 第二版本
        System.out.println("第二版本");
        getDataList().stream()
                .filter(t -> t.getTrader().getCity() == "Cambridge")
                .collect(groupingBy(t -> t.getTrader().getName()))
                .forEach((k, v) -> {
                    // 交易员 k
                    // 交易额
                    int sum = v.stream()
                            .map(Transaction::getValue)
                            .reduce(0, (a, b) -> a + b);

                    System.out.println("交易员：" + k + "，交易额：" + sum);
                });
    }

    /**
     * 所有交易中，最高的交易额是多少？
     */
    @Test
    public void test7() {
        Optional<Integer> reduce = getDataList().stream().map(Transaction::getValue).distinct().reduce(Integer::max);

        reduce.ifPresent(i -> {
            System.out.println("所有交易中，最高的交易额是：" + i);
        });
    }

    /**
     * 找到交易额最小的交易
     */
    @Test
    public void test8() {
        Optional<Transaction> first = getDataList().stream()
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .findFirst();

        Optional<Transaction> min = getDataList().stream()
                .min(Comparator.comparing(Transaction::getValue));


        first.ifPresent(t -> {
            System.out.println("交易额最小的交易:" + t);
        });
    }
}