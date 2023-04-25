package com.healthcare.repo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.healthcare.entity.specialization.Specialization;

@DataJpaTest(showSql = true)
@DisplayName("SpecializationRepoTest")
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
//@TestMethodOrder(OrderAnnotation.class)
public class SpecializationRepoTest {

	@Autowired
	private SpecializationRepo repo;

	private Specialization spec;

	private String expected;
	private String actual;

	//@BeforeAll
	public void preset() {

		expected = "";
		actual = "";
	}

	@Disabled
	@Test
	@Order(1)
	@DisplayName("Save Test")
	public void save() {
		Specialization spec = new Specialization(0, "Derm", "Dermatologist",
				"They are experts in Skin, Hair, Nails related problems");
		spec = repo.save(spec);
		long id = spec.getId();
		assertNotNull(spec.getId());
	}

	@Test
	@Order(2)
	@DisplayName("Fetch Test")
	//@Disabled
	public void fetchAll() {
		List<Specialization> list = repo.findAll();
		assertNotNull(list);
		assertThat(list.size()>0);
		if (list.isEmpty()) {
			fail("No Data exist in Database");
		} else {

		}
	}

	//@AfterAll
	public void cleanUp() {
		spec = null;
		expected = actual = null;
	}

}
