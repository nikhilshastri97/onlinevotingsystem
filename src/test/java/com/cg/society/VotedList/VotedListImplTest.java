package com.cg.society.VotedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.ovs.entities.CooperativeSociety;
import com.cg.ovs.entities.NominatedCandidate;
import com.cg.ovs.entities.RegisteredSocietyVoters;
import com.cg.ovs.entities.VotedList;
import com.cg.ovs.repository.CooperativeSocietyRepository;
import com.cg.ovs.repository.NominatedCandidateRepository;
import com.cg.ovs.repository.RegisteredSocietyVotersRepository;
import com.cg.ovs.repository.VotedListDao;
import com.cg.ovs.service.IRegisteredSocietyService;
import com.cg.ovs.service.VotedListService;

@SpringBootTest
public class VotedListImplTest {

	@Autowired
	private VotedListService votedListService;
	private IRegisteredSocietyService registeredSocietyService;

	@MockBean
	private VotedListDao votedListDao;
	private RegisteredSocietyVotersRepository registeredSocietyVotersRepository;
	private CooperativeSocietyRepository cooperativeSocietyRepository;
	private NominatedCandidateRepository nominatedCandidateRepository;

	@BeforeEach
	void setUp() throws Exception {
		VotedList votedList = new VotedList();
		RegisteredSocietyVoters registeredSocietyVoters = new RegisteredSocietyVoters();
		CooperativeSociety cooperativeSociety = new CooperativeSociety();
		NominatedCandidate nominatedCandidate = new NominatedCandidate();
		votedList.setId(1);
		// votedList.setDatetime("2021-06-14 10:58:20");
		registeredSocietyVoters.setVoterIdCardNo("1234");
		registeredSocietyVoters.setFirstName("nikhil");
		registeredSocietyVoters.setFirstName("shastri");
		registeredSocietyVoters.setGender("male");
		registeredSocietyVoters.setMobileNo("9987456321");
		registeredSocietyVoters.setEmailId("Pune");
		registeredSocietyVoters.setDistrict("Thane");
		registeredSocietyVoters.setPincode("400610");
		registeredSocietyVoters.setCastedVote(true);
		cooperativeSociety.setDistrict("Thane");
		cooperativeSociety.setHeadOfSociety("Sharma");
		cooperativeSociety.setPincode("400610");
		cooperativeSociety.setSocietyName("Kanchan");
		cooperativeSociety.setVillage("Thane");
		nominatedCandidate.setCandidateId(1);
		nominatedCandidate.setNominationFormNo("form1");

	}

	@Test
	@DisplayName("Verify add VotedList function")
	void CastVotedListTest() {
		VotedList votedList = new VotedList();
		when(votedListDao.save(votedList)).thenReturn(votedList);
		assertEquals(votedList, votedListService.castVotedList(votedList));
	}
	
	@Test
	@DisplayName("Verify Fetch all VotedList function")
	void fetchAlltest() {
		when(votedListDao.findAll()).thenReturn(Stream.of(new VotedList(),new VotedList()).collect(Collectors.toList()));
		assertEquals(2, votedListService.findAll().size());
	}
}
