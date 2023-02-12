package com.demospringboot.api;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demospringboot.model.Employee;;

@RestController
public class Newapi {
	private static Map<Integer, Employee> employeeRepo = new HashMap<>();

	static {
		employeeRepo.put(1, new Employee(1, "Tinh", "Nguyeen"));
		employeeRepo.put(2, new Employee(2, "Tinh2", "Nguyeen"));
		employeeRepo.put(3, new Employee(3, "Tinh3", "Nguyeen"));
	}

	@GetMapping(value = "/employee")
	public ResponseEntity<Object> retrieveAllEmployees() {
		if (employeeRepo.isEmpty()) {
			return new ResponseEntity<>("No employees", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(employeeRepo.values(), HttpStatus.OK);

	}

	@GetMapping(value = "/employee/{id}")
	public ResponseEntity<Object> retrieveAllEmployees(@PathVariable int id) {
		if (employeeRepo.containsKey(id)) {
			return new ResponseEntity<>(employeeRepo.get(id), HttpStatus.OK);

		}
		return new ResponseEntity<>("No employees", HttpStatus.NOT_FOUND);
	}

	@PostMapping(value = "/employee")
	public ResponseEntity<Object> createAllEmployees(@RequestBody Employee employee) {
		if (employeeRepo.containsKey(employee.getId())) {
			return new ResponseEntity<>("employee already  exist", HttpStatus.OK);

		}
		employeeRepo.put(employee.getId(), employee);
		return new ResponseEntity<>("created sucessfull", HttpStatus.CREATED);
	}

	@PostMapping(value = "/employees")
	public ResponseEntity<Object> createsAllEmployees(@RequestBody List<Employee> employee) {
		for (Employee emp : employee) {
			if (employeeRepo.containsKey(emp.getId())) {
				return new ResponseEntity<>("employee already  exist", HttpStatus.OK);
			}
			employeeRepo.put(emp.getId(), emp);
		}
		return new ResponseEntity<>("created sucessfull", HttpStatus.CREATED);

	}

	@DeleteMapping(value = "/employee/{id}")
	public ResponseEntity<Object> deleteEmployees(@PathVariable int id) {
		if (employeeRepo.containsKey(id)) {
			employeeRepo.remove(id);
			return new ResponseEntity<>("delete employee sucessful", HttpStatus.OK);

		}

		return new ResponseEntity<>("employee is not ", HttpStatus.OK);
	}

	@GetMapping(value = "/employee/{id}")
	public EntityModel<Employee> retrievEmployees(@PathVariable int id) {
		
		Employee employee = employeeRepo.get(id);
		EntityModel<Employee> resource = EntityModel.of(employee);
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllEmployees());
		resource.add(link.withRel("all- employee"));
		return resource;
	}
}
