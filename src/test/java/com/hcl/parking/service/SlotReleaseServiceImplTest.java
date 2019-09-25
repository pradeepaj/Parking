package com.hcl.parking.service;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.parking.dto.ReleaseReqDto;
import com.hcl.parking.dto.ReleaseResDto;
import com.hcl.parking.entity.ReleasedSlot;
import com.hcl.parking.repository.ReleaseRepository;

@RunWith(MockitoJUnitRunner.class)
public class SlotReleaseServiceImplTest {

	@InjectMocks
	private SlotReleaseServiceImpl slotReleaseServiceImpl;
	@Mock
	private ReleaseRepository releaseRepository;

	@Test
	public void releaseSlotTest() {
		ReleaseReqDto resu = new ReleaseReqDto();
		resu.setUserId(1);
		resu.setSlotId(1);
		
		
		ReleaseResDto an = new ReleaseResDto();
        an.setStatusCode(201);
        
        
		ReleasedSlot releaseSlot = new ReleasedSlot();
		releaseSlot.setUserId(1);
		releaseSlot.setReleaseId(1);
		
		
		ReleasedSlot releaseSlot1 = new ReleasedSlot();
		releaseSlot1.setReleaseId(1);
		releaseSlot1.setUserId(1);
		
		
		
		Mockito.when(releaseRepository.findByUserId(resu.getUserId())).thenReturn(Optional.empty());
		ReleaseResDto actResult = slotReleaseServiceImpl.releaseSlot(resu);
		assertEquals(an.getStatusCode(), actResult.getStatusCode());
	}

}
