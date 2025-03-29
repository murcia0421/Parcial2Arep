package com.example.mathService2.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class BinarySearchController {
    @GetMapping("/binarysearch")
    public String binarysearch(
            @RequestParam("list") String inputList,
            @RequestParam("value") int value) {

        int[] list = Arrays.stream(inputList.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        int index = binarySearch(list, value);

        return "{\n" +
                " \"operation\": \"linearSearch\",\n" +
                " \"inputlist\": \"" + inputList + "\",\n" +
                " \"value\": \"" + value + "\",\n" +
                " \"output\": \"" + index + "\"\n" +
                "}";
    }

    private int binarySearch(int[] list, int value) {
        return binarySearchRecursive(list, value, 0, list.length - 1);

    }

    private int binarySearchRecursive(int[] list, int value, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (list[mid] == value) {
            return mid;
        } else if (list[mid] < value) {
            return binarySearchRecursive(list, value, mid + 1, right);
        } else {
            return binarySearchRecursive(list, value, left, mid - 1);
        }
    }
}