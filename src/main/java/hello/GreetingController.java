package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    //Esto mapea todos los requests (GET POST PUT) ver como poner method=GET
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/date")
    public Greeting greeting() {
        long millis=System.currentTimeMillis();
        java.util.Date date=new java.util.Date(millis);
        return new Greeting(counter.incrementAndGet(), date.toString());
    }
}