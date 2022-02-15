package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
public class TestController {

    @Autowired
    AsyncAnnotationExample asyncAnnotationExample;

    @GetMapping(value = "/async")
    public String async() {
//        for (int i=0; i<5; ++i) {
//            asyncAnnotationExample.asyncMethodWithVoidValue(i);
//        }
        List<Future> futureList = new ArrayList<>();
        for (int i=0; i<5; ++i) {
            futureList.add(asyncAnnotationExample.asyncMethodWithReturnValue(i));
        }
        for (int i=0; i<5; ++i) {
            try {
                System.out.println("Future-"+i+": " + futureList.get(i).get());
            } catch(InterruptedException | ExecutionException e) {
            }
        }
        return "success";
    }
}
