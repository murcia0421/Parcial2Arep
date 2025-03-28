package com.example.mathService1.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class LinearSearchController {

    @GetMapping("/linearsearch")
    public String linearSearch(
            @RequestParam("list") String inputList,
            @RequestParam("value") int value) {

        int[] list = Arrays.stream(inputList.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        int index = linearSearch(list, value);

        return "{\n" +
                " \"operation\": \"linearSearch\",\n" +
                " \"inputlist\": \"" + inputList + "\",\n" +
                " \"value\": \"" + value + "\",\n" +
                " \"output\": \"" + index + "\"\n" +
                "}";
    }

    private int linearSearch(int[] list, int value) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == value) {
                return i;
            }
        }
        return -1;
    }
}