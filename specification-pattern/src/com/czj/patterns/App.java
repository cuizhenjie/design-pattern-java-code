package com.czj.patterns;

import com.czj.patterns.base.ISpecification;
import com.czj.patterns.base.SpecificationFactory;

import java.util.ArrayList;
import java.util.List;


/**
 * 运行效果
 * @author czj
 */
public class App {

    public static void main(String[] args) {

        List<String> sourceList = new ArrayList();
        sourceList.add("123456789-");
        sourceList.add("===123-");
        sourceList.add("-1-");
        sourceList.add("super");

        // 规则1，字符中需包含-
        ISpecification<String> spec1 = new SpecificationFactory<>(s -> s.indexOf("-") > 0);
        // 规则2，字符长度需大于5
        ISpecification<String> spec2 = new SpecificationFactory<>(s -> s.length() > 9);
        // 规则3，字符==super
        ISpecification<String> spec3 = new SpecificationFactory<>(s -> s.equals("super"));

        // 规则1  and  规则2  or 规则3
        ISpecification<String> specifications = spec1.and(spec2)
                .or(spec3);

        sourceList.stream()
                .map(s -> specifications.isSatisfiedBy(s))
                .forEach(System.out::println);
    }
}
