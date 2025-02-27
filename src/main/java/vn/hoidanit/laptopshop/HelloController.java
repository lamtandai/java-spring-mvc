package vn.hoidanit.laptopshop;

public class HelloController {
    @GetMapping("/")
	public String index() {
		return "Hello World from Spring Boot!";
	}

}
