package ie.atu.homeworklab1y4cicd;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @GetMapping("/calculate")
    public String calculate(
            @RequestParam double num1,
            @RequestParam double num2,
            @RequestParam String operation
            /*
            @PathVariable double num1,
        @PathVariable double num2,
        @PathVariable String operation
             */
    ) {
        double result;

        // Perform the requested calculation based on the 'operation' parameter
        switch (operation) {
            case "add":
                result = num1 + num2;
                break;
            case "subtract":
                result = num1 - num2;
                break;
            case "multiply":
                result = num1 * num2;
                break;
            case "divide":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    return "Division by zero is not allowed.";
                }
                break;
            default:
                return "Invalid operation. Please use 'add', 'subtract', 'multiply', or 'divide'.";
        }

        return "Operation: " + result;
    }
}
