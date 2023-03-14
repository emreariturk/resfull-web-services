package com.in28minutes.rest.webservices.resfullwebservices.controller;

import com.in28minutes.rest.webservices.resfullwebservices.dto.HelloWorldDto;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    private MessageSource messageSource;

    public HelloWorldController (MessageSource messageSource){
        this.messageSource=messageSource;
    }

    @RequestMapping(method = RequestMethod.GET,path = "/hello-world")
    public String helloWorld()
    {
        return "Hello World";
    }

    @RequestMapping(method = RequestMethod.GET,path = "/hello-world-dto")
    public HelloWorldDto helloWorldDto()
    {
        return new HelloWorldDto("naber lan");
    }

    @RequestMapping(method = RequestMethod.GET,path = "/hello-world-dto/{message}")
    public HelloWorldDto helloWorldDtoMessage(@PathVariable("message") String message)
    {
        return new HelloWorldDto(message);
    }

    @RequestMapping(method = RequestMethod.GET,path = "/hello-world-dto-message/{message}")
    public String helloWorldDtoMessageString(@PathVariable("message") String message)
    {
        HelloWorldDto worldDto= new HelloWorldDto(message);
        return worldDto.toString();
    }

    @RequestMapping(method = RequestMethod.GET,path = "/division/{message}")
    public Double getDivision(@PathVariable("message") Integer sayi)
    {
        return Double.parseDouble("3" + sayi.toString()) ;
    }

    @RequestMapping(method = RequestMethod.GET,path = "/hello-world-internationalized")
    public String helloWorldInternationalized()
    {
        Locale locale= LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null,"Default Message",locale);
        //return "Hello World V2";
    }
}
