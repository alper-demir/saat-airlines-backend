package saatairlinesapi.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController // Bu sınıfın bir api döndüreceğini belirten anotasyondur. Kullanılmassa response dönmez.
public class HelloWordController {
    @GetMapping("/hello/{name}") // İstek gelecek url, {} içerisinde ismi yakala.
    public String helloUser(@PathVariable String name) { // @PathVariable istek üzerinde gelen değişkenin değerini alır.
        return "Hello " + name;
    }

}
