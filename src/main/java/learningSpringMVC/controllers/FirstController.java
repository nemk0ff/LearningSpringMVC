package learningSpringMVC.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("first")
public class FirstController {
  @GetMapping("/hello")
  public String helloPage(@RequestParam(value = "name", required = false) String name,
                          @RequestParam(value = "surname", required = false) String surname,
                          Model model) {
    model.addAttribute("message", "Hello, " + surname + " " + name);
    return "first/hello";
  }

  @GetMapping("/goodbye")
  public String goodByePage() {
    return "first/goodbye";
  }

  @GetMapping("/calculator")
  public String calculator(@RequestParam(value = "a", required = false) int a,
                           @RequestParam(value = "b", required = false) int b,
                           @RequestParam(value = "operation", required = false) String operation,
                           Model model) {
    double result;
    switch (operation) {
      case "mul":
        result = a * b;
        break;
      case "div":
        result = (double) a / b;
        break;
      case "sub":
        result = a - b;
        break;
      case "add":
        result = a + b;
        break;
      default:
        result = 0;
    }
    model.addAttribute("result", result);
    return "/first/calculator";
  }
}
