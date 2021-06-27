package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.helper.Direction;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * Данный класс обязан использовать StreamApi из функционала Java 8. Функциональность должна быть идентична
 * {@link SimpleTextStatisticsAnalyzer}.
 */
public class StreamApiTextStatisticsAnalyzer implements TextStatisticsAnalyzer {
    @Override
    public int countSumLengthOfWords(String text) {
        String[] array = text.split(" ");
        return Arrays.stream(array)
                .map(s -> s.replaceAll("[^A-Za-zА-Яа-я0-9]", ""))
                .mapToInt(String::length)
                .sum();
    }

    @Override
    public int countNumberOfWords(String text) {
        String[] array = text.replaceAll("\n", " ").split(" ");
        return (int) Arrays.stream(array)
                .map(s -> s.replaceAll("[^A-Za-zА-Яа-я0-9]", ""))
                .filter(s -> !s.equals(""))
                .count();


    }

    @Override
    public int countNumberOfUniqueWords(String text) {
        String[] array = text.replaceAll("\n", " ").split(" ");
        return (int) Arrays.stream(array)
                .map(s -> s.replaceAll("[^A-Za-zА-Яа-я0-9]", ""))
                .filter(s -> !s.equals(""))
                .distinct()
                .count();

    }

    @Override
    public List<String> getWords(String text) {
        String[] array = text.replaceAll("\n", " ").split(" ");
        return Arrays.stream(array)
                .map(s -> s.replaceAll("[^A-Za-zА-Яа-я0-9]", ""))
                .filter(s -> !s.equals(""))
                .collect(Collectors.toList());


    }

    @Override
    public Set<String> getUniqueWords(String text) {
        String[] array = text.replaceAll("\n", " ").split(" ");
        return Arrays.stream(array)
                .map(s -> s.replaceAll("[^A-Za-zА-Яа-я0-9]", ""))
                .filter(s -> !s.equals(""))
                .collect(Collectors.toSet());

    }

    @Override
    public Map<String, Integer> countNumberOfWordsRepetitions(String text) {
        String[] array = text.replaceAll("\n", " ").split(" ");
        return Arrays.stream(array)
                .map(s -> s.replaceAll("[^A-Za-zА-Яа-я0-9]", ""))
                .filter(s -> !s.equals(""))
                .collect(groupingBy(Function.identity(), summingInt(e -> 1)));
    }

    @Override
    public List<String> sortWordsByLength(String text, Direction direction) {
        String[] array = text.replaceAll("\n", " ").split(" ");
        return Arrays.stream(array)
                .map(s -> s.replaceAll("[^A-Za-zА-Яа-я0-9]", ""))
                .filter(s -> !s.equals(""))
                .sorted((o1, o2) -> {
                    int compareResult = 0;
                    switch (direction) {
                        case ASC:
                            compareResult = Integer.compare(o1.length(), o2.length());
                            break;
                        case DESC:
                            compareResult = Integer.compare(o2.length(), o1.length());
                            break;
                        default:
                            break;
                    }
                    return compareResult;
                })
                .collect(toList());
    }
}
