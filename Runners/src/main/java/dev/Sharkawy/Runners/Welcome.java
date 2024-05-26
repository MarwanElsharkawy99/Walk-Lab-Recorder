package dev.Sharkawy.Runners;

import org.springframework.stereotype.Component;

@Component
public class Welcome {

    public String welcomeMessage(){
        return "Hello World";
    }
}
