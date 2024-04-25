package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Creator
 */
@Controller
public class HelloController {

    //Handles request at path /hello

//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring";
//    }

    //lives /hello/goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring";
    }

    //Handles request at form /hello?name=LaunchCode
//    @GetMapping("hello")
//    @PostMapping("hello")
    //@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    @GetMapping("/hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) {
        String  greeting= "Hello, " + name + "!";
        return greeting;
    }

    //Handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name) {
        String  greeting= "Hello, " + name + "!";
        return greeting;
    }

    // /hello/form
    @GetMapping("/form")
    @ResponseBody
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" +
                "<input type='text' name='name'/>" +
                "<select name='language'>"+
                    "<option value='english'>English</option>"+
                    "<option value='french'>French</option>"+
                    "<option value='spanish'>Spanish</option>"+
                    "<option value='italian'>Italian</option>"+
                    "<option value='turkish'>Turkish</option>"+
                "</select>"+
                "<input type='submit' value='Great Me!'/>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @RequestMapping(value = "hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "World";
        }
        return createMessage(name, language);
    }

    public static String createMessage(String nm, String lng) {
        String greeting="";
        if (lng.equals("english")) {
            greeting = "Hello";
        } else if (lng.equals("french")) {
            greeting = "Bonjour";
        }else if (lng.equals("spanish")) {
            greeting = "Hola";
        }else if (lng.equals("italian")) {
            greeting = "Bonjourno";
        }else if (lng.equals("turkish")) {
            greeting = "Merhaba";
        }
        String str = greeting +", "+ nm + "!";;
       return str;
    }
}
