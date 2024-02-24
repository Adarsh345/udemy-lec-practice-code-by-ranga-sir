package com.in23minutes.rest.webservices.restfulwebservices.restController;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Locale;

@RestController
public class HelloWorldController {

    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;

    }

    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "HelloWord";
    }

    @GetMapping(path = "/hello-world/internalization")
    public String helloWorldInternalization() {
        Locale local = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null,"Default Message",local);

        /*i have learn internalization that will give response based on
        language header for example, if we pass Accept-Language = nl
        it will return Goedemorgen in the response .
         en = English (Good morning)
         nl = Dutch (GoedemorgenO
         fr = French (Bonjour)
         de = Deutsch (Gute morgen)
         */

    }
}
