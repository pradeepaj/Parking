package com.hcl.parking.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hcl.parking.dto.ReleaseReqDto;
import com.hcl.parking.dto.ReleaseResDto;
import com.hcl.parking.service.SlotReleaseService;

import junit.framework.TestCase;
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = { TestCase.class, SlotReleaseController.class })
@WebAppConfiguration
public class SlotReleaseControllerTest {

	@InjectMocks
	private SlotReleaseController slotReleaseController;
	

	
	@Mock
	private SlotReleaseService slotReleaseService;
	private MockMvc mockMvc;
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(slotReleaseController).build();
	}
	@Test
	public void releaseSlotTest() {
		ReleaseResDto an=new ReleaseResDto();
		an.setStatusCode(201);
		ReleaseReqDto resu=new ReleaseReqDto();
		resu.setSlotId(1);
		
		ResponseEntity<ReleaseResDto> expResult = new ResponseEntity<>(an, HttpStatus.CREATED);
		when(slotReleaseService.releaseSlot(resu)).thenReturn(an);
	
		ResponseEntity<ReleaseResDto> actResult = slotReleaseController.releaseSlot(resu);
		assertEquals(expResult, actResult);
		
	}

}
