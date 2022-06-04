package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import java.util.List;


@Controller
public class CarsController {
	private List<Car> cars;
	private CarService carService;

	@Autowired
	public CarsController(CarService carService) {
		this.carService = carService;
	}

	@GetMapping(value = "/cars")
	public String printCars(@RequestParam(value = "count", required = false) String count, ModelMap model) {

		if (count == null){
			cars = CarService.cars;
		} else cars = carService.showCars(count);
		model.addAttribute("cars", cars);
		return "cars";
	}
	
}