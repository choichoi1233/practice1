package com.example.practice1;

import com.example.practice1.Model.Product;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;


public class StreamTest1 {
    public static void main(String[] arg) {
        List<Product> products = Arrays.asList(new Product("콜라", 1000), new Product("사이다", 5900), new Product("환타", 9100), new Product("쥬스", 1300), new Product("아이스크림", 1400), new Product("과자", 5000));

        // 2. Stream을 이용하여 가격이 5000원 이상인 제품들만 골라서 리스트로 만드세요.
        System.out.println("2. 가격이 5000원 이상인 제품들:");
        List<Product> expensiveProducts = products.stream().filter(p -> p.getPrice() >= 5000).toList();
        expensiveProducts.forEach(p -> System.out.println(p.getName()));

        // 3. Stream을 이용하여 제품들의 이름만 추출하여 리스트로 만드세요.
        System.out.println("3. 제품들의 이름:");
        List<String> productNames = products.stream().map(Product::getName).toList();
        productNames.forEach(System.out::println);

        // 4. Stream을 이용하여 제품들의 평균 가격을 계산하세요.
        System.out.println("4. 제품들의 평균 가격:");
        OptionalDouble averagePrice = products.stream().mapToDouble(Product::getPrice).average();
        averagePrice.ifPresentOrElse(avg -> System.out.println(avg), () -> System.out.println("평균 가격을 계산할 수 없습니다."));

        // 5. Stream을 이용하여 가장 비싼 제품을 찾으세요.
        System.out.println("5. 가장 비싼 제품:");
        OptionalInt maxPrice = products.stream().mapToInt(Product::getPrice).max();
        maxPrice.ifPresentOrElse(max -> System.out.println(max), () -> System.out.println("가장 비싼 제품을 찾을 수 없습니다."));
    }
}
