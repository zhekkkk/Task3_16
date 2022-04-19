package ru.vsu.cs.course1;


import java.util.LinkedList;
import java.util.Queue;

public class Task {
    public static String[] Process1(String[] array) throws Exception{
        SimpleLinkedListQueue2<String> input2 = stringArrayToSimpleQueue(array);
        try {
            SimpleLinkedListQueue2<String> res = solution1(input2);
            return simpleQueueToArray(res);
        } catch (Exception e) {
            System.out.println("прошу, не ставьте два");
            return null;
        }
    }

    public static String[] Process2(String[] array) throws Exception {
        Queue<String> input2 = stringArrayToQueue(array);
        Queue<String> res = solution2(input2);
        return queueToArray(res);
    }

    public static Queue<String> stringArrayToQueue(String[] input) {
        Queue<String> result = new LinkedList<>();
        for(String element: input) {
            result.add(element);
        }
        return result;
    }

    public static SimpleLinkedListQueue2<String> stringArrayToSimpleQueue(String[] input) {
        SimpleLinkedListQueue2<String> result = new SimpleLinkedListQueue2<>();
        for(String element: input) {
            result.add(element);
        }
        return result;
    }

    public static String[] queueToArray(Queue<String> input) {
        String[] result = new String[input.size()];
        int k = input.size();
        for(int i = 0; i < k; i++) {
            result[i] = input.poll();
        }
        return result;
    }

    public static String[] simpleQueueToArray(SimpleLinkedListQueue2<String> input) throws Exception {
        String[] result = new String[input.count()];
        int k = input.count();
        for(int i = 0; i < k; i++) {
            result[i] = input.element();
        }
        return result;
    }

    public static SimpleLinkedListQueue2<String> solution1(SimpleLinkedListQueue2<String> input) throws Exception {
        return reverseQueue1(input);
    }

    public static Queue<String> solution2(Queue<String> input) {
        return reverseQueue2(input);
    }

    public static SimpleLinkedListQueue2<String> reverseQueue1(SimpleLinkedListQueue2<String> input, SimpleLinkedListQueue2<String> result) throws Exception {
        if (!input.empty()) {
            String element = input.element();
            reverseQueue1(input, result);
            result.add(element);
        }
        return result;
    }

    public static SimpleLinkedListQueue2<String> reverseQueue1(SimpleLinkedListQueue2<String> input) throws Exception {
        SimpleLinkedListQueue2<String> target = new SimpleLinkedListQueue2<>();
        return reverseQueue1(input, target);
    }

    public static Queue<String> reverseQueue2(Queue<String> input, Queue<String> result) {
        if (!input.isEmpty()) {
            String element = input.poll();
            reverseQueue2(input, result);
            result.add(element);
        }
        return result;
    }

    public static Queue<String> reverseQueue2(Queue<String> input) {
        Queue<String> target = new LinkedList<>();
        return reverseQueue2(input, target);
    }
}
