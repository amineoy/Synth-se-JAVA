package net.amineoy;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class AppFunc {
    public static void main(String[] args){
        Consumer<String> consumer=(inpt) ->
        {System.out.println(inpt);
        };
        consumer.accept("hello");


        Supplier<String> supplier=()->{
            return  "azerty";
        };
        System.out.println(supplier.get());


        Function<Integer,Integer> function=a->a*4;

       System.out.println(function.apply(43));

}}
