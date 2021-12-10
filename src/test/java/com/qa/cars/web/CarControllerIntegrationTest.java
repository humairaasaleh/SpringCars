package com.qa.cars.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.cars.domain.Car;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:car-schema.sql",
		"classpath:car-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class CarControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {
		Car testCar = new Car(null, "BMW", 3, "Blue", 50500);
		String testCarAsJSON = this.mapper.writeValueAsString(testCar);
		RequestBuilder req = post("/create").contentType(MediaType.APPLICATION_JSON).content(testCarAsJSON);

		Car testCreatedCar = new Car(2, "BMW", 3, "Blue", 50500);
		String testCreatedCarAsJSON = this.mapper.writeValueAsString(testCreatedCar);
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().json(testCreatedCarAsJSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testCreate2() throws Exception {
		Car testCar = new Car(null, "BMW", 3, "Blue", 50500);
		String testCarAsJSON = this.mapper.writeValueAsString(testCar);
		RequestBuilder req = post("/create").contentType(MediaType.APPLICATION_JSON).content(testCarAsJSON);

		Car testCreatedCar = new Car(2, "BMW", 3, "Blue", 50500);
		String testCreatedCarAsJSON = this.mapper.writeValueAsString(testCreatedCar);
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().json(testCreatedCarAsJSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testGetAll() throws Exception {

		List<Car> testCars = List.of(new Car(1, "Suzuki", 5, "green", 23000));
		String json = this.mapper.writeValueAsString(testCars);

		RequestBuilder req = get("/getAll");
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);

	}

	@Test
	void testGetById() throws Exception {
		Car testCar = new Car(1, "Suzuki", 5, "green", 23000);
		String json = this.mapper.writeValueAsString(testCar);

		RequestBuilder req = get("/get/1");
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);

	}

	@Test
	void testGetByMake() throws Exception {
		List<Car> testCar = List.of(new Car(1, "Suzuki", 5, "green", 23000));
		String json = this.mapper.writeValueAsString(testCar);

		RequestBuilder req = get("/getByMake/Suzuki");
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);

	}

	@Test
	void testReplaceById() throws Exception {
		Car testCar = new Car(1, "Suzuki", 3, "green", 23000);
		String json = this.mapper.writeValueAsString(testCar);

		RequestBuilder req = put("/replace/1").contentType(MediaType.APPLICATION_JSON).content(json);
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(json);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testRemoveById() throws Exception {
		RequestBuilder req = delete("/remove/1");
		ResultMatcher checkStatus = status().isNoContent();

		this.mvc.perform(req).andExpect(checkStatus);
	}
}
