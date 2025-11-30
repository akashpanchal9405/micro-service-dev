package com.inn.product;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inn.product.entity.Product;

@SpringBootTest
//@Testcontainers
@AutoConfigureMockMvc
class ProductServiceApplicationTests {

//	@Container
//	static OracleContainer container = new OracleContainer("gvenzl/oracle-xe:21-slim-faststart");

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

//	@DynamicPropertySource
//	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
//		dynamicPropertyRegistry.add("spring.datasource.url", container::getJdbcUrl);
//	}

	@Test
	void shouldCreateProduct() throws Exception {
		Product product = getProductRequest();
		String writeValueAsString = objectMapper.writeValueAsString(product);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/product").contentType(MediaType.APPLICATION_JSON)
				.content(writeValueAsString)).andExpect(status().isCreated());

	}

	private Product getProductRequest() {
		return Product.builder().name("Iphone 13").description("Iphone 13").price(BigDecimal.valueOf(56000)).build();

	}

}
