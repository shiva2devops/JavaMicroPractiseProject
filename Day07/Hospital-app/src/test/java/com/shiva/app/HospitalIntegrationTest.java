package com.shiva.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shiva.app.controller.HospController;
import com.shiva.app.model.HospitalInfo;
import com.shiva.app.service.HospitalService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest({HospController.class})
@ActiveProfiles(value = "test")
class HospitalIntegrationTest {

	@InjectMocks
	HospController hospController;
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	HospitalService hospitalService;

	@Value("${hospital.save.url}")
	String saveurl;

	@Value("${hospital.update.url}")
	String updateurl;

	@Test
	public void testSaveHospitalPost() throws Exception {
		HospitalInfo hospitalInfo = new HospitalInfo("hosp101", "tata", "Hyd");
		ResultActions responseEntity = mockMvc.perform(post(saveurl).contentType(MediaType.APPLICATION_JSON).
				content(asObjectToJsonString(hospitalInfo)).accept(MediaType.APPLICATION_JSON));
		responseEntity.andExpect(status().isOk());
		String result = responseEntity.andReturn().getResponse().getContentAsString();
		HospitalInfo hospitalResult = asJsonStringToObject(result);
		assertNotNull(hospitalResult);
		assertEquals(hospitalResult.getName(),"tata");
	}
	@Test
	public void testSaveHospitalCityPost() throws  Exception{
		HospitalInfo hospital = new HospitalInfo("01", "tata", "Hyd");
		ResultActions responseEntity = mockMvc.perform(post(saveurl).contentType(MediaType.APPLICATION_JSON)
				.content(asObjectToJsonString(hospital)).accept(MediaType.APPLICATION_JSON));
		responseEntity.andExpect(status().isOk());
		String result = responseEntity.andReturn().getResponse().getContentAsString();
		HospitalInfo hospitalResult = asJsonStringToObject(result);
		assertNotNull(hospitalResult);
		assertEquals(hospitalResult.getCity(), "Hyd");
	}

	@Test
	public void testSaveHospitalWithoutNamePost() throws Exception {
		HospitalInfo patient=new HospitalInfo("hosp01",null,"Hyd");
		ResultActions responseEntity  = mockMvc.perform(post(saveurl).contentType(MediaType.APPLICATION_JSON)
				.content(asObjectToJsonString(patient)).accept(MediaType.APPLICATION_JSON));
		responseEntity.andExpect(status().isBadRequest());
	}
	@Test
	public void testSaveHospitalWithoutCityPost() throws Exception {
		HospitalInfo patient=new HospitalInfo("hosp01","tata",null);
		ResultActions responseEntity  = mockMvc.perform(post(updateurl).contentType(MediaType.APPLICATION_JSON)
				.content(asObjectToJsonString(patient)).accept(MediaType.APPLICATION_JSON));
		responseEntity.andExpect(status().isNotFound());
	}

	private String asObjectToJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private HospitalInfo asJsonStringToObject(String result) {
		try {
			final ObjectMapper mapper= new ObjectMapper();
			HospitalInfo hospitalInfo=mapper.readValue(result,HospitalInfo.class);
			return hospitalInfo;
		} catch (Exception e){
			 throw new RuntimeException(e);
		}
	}


}
