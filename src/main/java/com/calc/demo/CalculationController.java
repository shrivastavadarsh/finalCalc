package com.calc.demo;

import org.springframework.web.bind.annotation.*;

import java.util.Stack;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CalculationController {
    private static final String template = "Calculated string  , %s!";
    private final AtomicLong counter = new AtomicLong();
    private String[] list;


    @GetMapping("/a")
    public Calculation add(@RequestParam(value = "operands", defaultValue = "world") String[] val) {

//        System.out.println(name);
        for (String c : val) System.out.println(c);
        double ans = 0;
        for (String s : val) {
            ans += (Double.parseDouble(s));
        }

        return new Calculation(String.format(template, ans));

    }


    @GetMapping("/s")
    public Calculation subtract(@RequestParam(value = "operands", defaultValue = "world") String[] val) {

//        System.out.println(name);
        for (String c : val) System.out.println(c);
        double ans = Double.parseDouble(val[0]) - Double.parseDouble(val[1]);


        return new Calculation(String.format(template, ans));

    }

    @GetMapping("/m")
    public Calculation multiply(@RequestParam(value = "operands", defaultValue = "world") String[] val) {

        System.out.println("multiplication triggere");
//        for(String c:val) System.out.println(c);
        double ans = Double.parseDouble(val[0]) * Double.parseDouble(val[1]);


        return new Calculation(String.format(template, ans));

    }

    @GetMapping("/d")
    public Calculation divide(@RequestParam(value = "operands", defaultValue = "world") String[] val) {

//        System.out.println(name);
//        for(String c:val) System.out.println(c);
        if (val[1].equals(0))
            return new Calculation(String.format(template, "denominator cannot be 0"));

        else {
            double ans = Double.parseDouble(val[0]) / Double.parseDouble(val[1]);


            return new Calculation(String.format(template, ans));

        }


    }

    @GetMapping("/p")
    public Calculation percent(@RequestParam(value = "operands", defaultValue = "world") String[] val) {

//        System.out.println(name);
//        for(String c:val) System.out.println(c);
        if (val[1].equals(0))
            return new Calculation(String.format(template, "denominator cannot be 0"));

        else {
            double ans = Double.parseDouble(val[0]) / Double.parseDouble(val[1]);
            ans *= 100;


            return new Calculation(String.format(template, ans));

        }


    }

}