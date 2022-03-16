package ru.ogneva.multithreading;

import ru.ogneva.multithreading.node.AmountNode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

@RestController
public class TestController {

    AsyncAnnotationExample asyncAnnotationExample;

    @GetMapping(value = "/async")
    public String async() {
        for (int i=0; i<5; ++i) {
            asyncAnnotationExample.asyncMethodWithVoidValue(i);
        }
        List<Future<String>> futureList = new ArrayList<>();
        for (int i=0; i<5; ++i) {
            futureList.add(asyncAnnotationExample.asyncMethodWithReturnValue(i));
        }
        for (int i=0; i<5; ++i) {
            try {
                System.out.println("Future-"+i+": " + futureList.get(i).get());
            } catch(InterruptedException | ExecutionException e) {
                System.out.println(e.getMessage());
            }
        }
        return "success";
    }

    @GetMapping(value = "/fork-join")
    public Long forkJoin(){
        AmountNode root = new AmountNode(10L,
                List.of(
                        new AmountNode(5L),
                        new AmountNode(20L,
                                List.of(
                                        new AmountNode(15L),
                                        new AmountNode(30L,
                                                List.of(new AmountNode(25L))
                                        )
                                )) ));
        return new ForkJoinPool().invoke(new ValueSumCounter(root));
    }
}
