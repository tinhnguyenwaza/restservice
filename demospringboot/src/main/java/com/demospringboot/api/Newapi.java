package com.demospringboot.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demospringboot.dto.NewDTO;;

@RestController
public class Newapi {

	@PostMapping(value = "/new")
	public NewDTO createNew(@RequestBody NewDTO model) {
		return model;

	}

	@PutMapping(value = "/new")
	public NewDTO updateNew(@RequestBody NewDTO model) {
		return model;

	}

	@DeleteMapping(value = "/new")
	public NewDTO dateleNew(@RequestBody NewDTO model) {
		return model;

	}
}
