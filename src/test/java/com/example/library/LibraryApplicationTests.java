package com.example.library;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import com.ASHP.library.LibraryApplication;

@SpringBootTest(classes = LibraryApplication.class)
/*@WebMvcTest
@AutoConfigureMockMvc*/
class LibraryApplicationTests {

	@Test
	void contextLoads() {
		
	}

}
