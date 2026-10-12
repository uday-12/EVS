package com.rgukt.evs.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import com.rgukt.evs.dao.PartyRepo;
import com.rgukt.evs.entity.CandidateEntity;
import com.rgukt.evs.entity.EOEntity;
import com.rgukt.evs.entity.ElectionEntity;
import com.rgukt.evs.entity.PartyEntity;
import com.rgukt.evs.entity.VoterRegisterEntity;
import com.rgukt.evs.service.AdminService;
import com.rgukt.evs.service.EOService;
import com.rgukt.evs.service.VoterService;

@Controller
public class EvsController {

	@Autowired
	AdminService adminService;

	@Autowired
	VoterService voterService;

	@Autowired
	EOService eoService;

	int v = 1;
	int electionVoterId = 100;

//-------------------------- Home Page Menu -------------------------------------//
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		return mav;
	}

	@GetMapping("/adminLogin")
	public ModelAndView adminLogin() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/adminLogin");
		return mav;
	}

	@GetMapping("/voterLogin")
	public ModelAndView voterLogin() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/voterLogin");
		return mav;
	}

	@GetMapping("/voterRegister")
	public ModelAndView voterRegister() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("voterRegister");
		return mav;
	}

	@GetMapping("/eoLogin")
	public ModelAndView eoLogin() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/eoLogin");
		return mav;
	}

//----------------------------------------Admin Tasks----------------------------------------//
	@GetMapping("/adminHome")
	public ModelAndView adminHomeGet() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/adminHome");
		return mav;
	}

	@PostMapping("/adminHome")
	public ModelAndView adminHome(String email, String password) {
		ModelAndView mav = new ModelAndView();
		if (adminService.validate(email, password)) {
			mav.setViewName("adminHome");
		} else {
			mav.setViewName("/adminLogin");
		}
		return mav;
	}

//--------------------------------------------------------------adding Election-----------------------------------------------//
	@GetMapping("/addElection")
	public ModelAndView addElection() {
		ModelAndView mav = new ModelAndView();
		List<ElectionEntity> list = adminService.getAllElection();
		mav.addObject("elections", list);
		mav.setViewName("/addElection");
		return mav;
	}

	@PostMapping("/addElection")
	public ModelAndView postAddElections(ElectionEntity electionEntity) {
		adminService.addElection(electionEntity);
		ModelAndView mav = new ModelAndView();
		List<ElectionEntity> list = adminService.getAllElection();
		mav.addObject("elections", list);
		mav.setViewName("/addElection");
		return mav;
	}

//--------------------------------------------adding Party-------------------------------------------------------------//
	@GetMapping("/addParty/{electionId}")
	public ModelAndView addParty(@PathVariable("electionId") int electionId) {
		ModelAndView mav = new ModelAndView();
		List<PartyEntity> list = adminService.getAllParty();
		adminService.addPartyStatus(electionId);
		for(PartyEntity pe:list)
		{
			pe.setPartySymbol(Base64.getEncoder().encodeToString(pe.getData()));
		}
		mav.addObject("party", list);
		mav.addObject("electionId", electionId);
		mav.setViewName("/addParty");
		return mav;
	}

	@PostMapping("/addParty/{electionId}")
	public ModelAndView postAddParty(HttpServletRequest request, PartyEntity partyEntity,
			@PathVariable("electionId") int electionId) throws IOException, ServletException {
		
		Part part = request.getPart("file");
		InputStream inputStream = part.getInputStream();
		adminService.addParty(inputStream,partyEntity, electionId);
		ModelAndView mav = new ModelAndView();
		List<PartyEntity> list = adminService.getAllParty();
		for(PartyEntity pe:list)
		{
			pe.setPartySymbol(Base64.getEncoder().encodeToString(pe.getData()));
		}
		mav.addObject("party", list);
		mav.addObject("electionId", electionId);
		mav.setViewName("/addParty");
		return mav;
	}

//--------------------------------------------------------adding Candidates--------------------------------------------//
	@GetMapping("/addCandidates/{electionId}")
	public ModelAndView addCandidates(@PathVariable("electionId") int electionId) {
		ModelAndView mav = new ModelAndView();
		List<CandidateEntity> list = adminService.getAllCandidates();
		/*
		 * for(CandidateEntity ce:list) {
		 * 
		 * ce.setStringCandidateImage(Base64.getEncoder().encodeToString(ce.
		 * getCandidateImage()));
		 * ce.setStringPartyImage(Base64.getEncoder().encodeToString(ce.getPartyImage())
		 * ); }
		 */
		mav.addObject("candidate", list);
		mav.addObject("electionId", electionId);
		adminService.addElectionStatus(electionId);

		mav.setViewName("/addCandidates");
		return mav;
	}

	@PostMapping("/addCandidates/{electionId}")
	public ModelAndView addCandidatesPost(HttpServletRequest request,CandidateEntity candidateEntity, @PathVariable("electionId") int electionId) throws IOException, ServletException {
		Part part1 = request.getPart("file1");
		InputStream inputStream1 = part1.getInputStream();
		Part part2 = request.getPart("file2");
		InputStream inputStream2= part2.getInputStream();
		adminService.addCandidate(candidateEntity, electionId,inputStream1,inputStream2);
		ModelAndView mav = new ModelAndView();
		List<CandidateEntity> list = adminService.getAllCandidates();
		for(CandidateEntity ce:list)
		{

			ce.setStringCandidateImage(Base64.getEncoder().encodeToString(ce.getCandidateImage()));
			ce.setStringPartyImage(Base64.getEncoder().encodeToString(ce.getPartyImage()));
		}
		mav.addObject("candidate", list);
		mav.addObject("electionId", electionId);
		mav.setViewName("/addCandidates");
		return mav;
	}
//-------------------------------------------------------Add EO--------------------------------------------------------//

	@GetMapping("/addEO/{electionId}")
	public ModelAndView addEO(@PathVariable("electionId") int electionId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("electionId", electionId);
		mav.setViewName("/adminAddEO");
		return mav;
	}

	@PostMapping("/addingEO/{electionId}")
	public ModelAndView addingEO(EOEntity eoEntity, @PathVariable("electionId") int electionId) {

		ModelAndView mav = new ModelAndView();
		adminService.addEOEntity(eoEntity, electionId);
		mav.addObject("electionId", electionId);
		mav.addObject("success", "Created Successfully");
		mav.setViewName("/adminAddEO");
		return mav;
	}

	@PostMapping("/EOLogin")
	public ModelAndView EOLogin(String email, String password) {
		ModelAndView mav = new ModelAndView();
		if (adminService.EOLoginValidate(email, password)) {
			List<VoterRegisterEntity> list = voterService.getAllVoters();
			mav.addObject("voters", list);
			mav.setViewName("/eoHome");
		} else {
			mav.addObject("Invalidlogin", "Enter Correct Username and Password");
			mav.setViewName("/eoLogin");
		}
		return mav;
	}

	@GetMapping("/eoHome")
	public String eoHome() {
		return "/eoHome";
	}

//	-------------------------------------------------EO Task Page-------------------------------------------------------//
	@GetMapping("/eoTask")
	public ModelAndView eoTask() {
		ModelAndView mav = new ModelAndView();
		List<VoterRegisterEntity> list = voterService.getAllVoters();
		mav.addObject("voter", list);
		mav.setViewName("eoTask");
		return mav;
	}

	@GetMapping("/approve/{vId}")
	public ModelAndView approve(@PathVariable("vId") int vId) {
		ModelAndView mav = new ModelAndView();
		electionVoterId++;
		List<VoterRegisterEntity> list = voterService.getAllVoters();
		eoService.approve(vId, electionVoterId);
		mav.addObject("voter", list);
		mav.setViewName("eoTask");
		return mav;
	}

	@GetMapping("/disapprove/{vId}")
	public ModelAndView disApprove(@PathVariable("vId") int vId) {
		ModelAndView mav = new ModelAndView();
		List<VoterRegisterEntity> list = voterService.getAllVoters();
		eoService.disapprove(vId);
		mav.addObject("voter", list);
		mav.setViewName("eoTask");
		return mav;
	}

//---------------------------------------------------Start/Stop Election------------------------------------------------//
	@GetMapping("/viewStatus/{electionId}")
	public ModelAndView viewStatus(@PathVariable("electionId") int electionId) {
		ModelAndView mav = new ModelAndView();
		List<CandidateEntity> list = adminService.getAllCandidates();
		for(CandidateEntity ce:list)
		{
			ce.setStringCandidateImage(Base64.getEncoder().encodeToString(ce.getCandidateImage()));
			ce.setStringPartyImage(Base64.getEncoder().encodeToString(ce.getPartyImage()));
		}
		mav.addObject("candidate", list);
		mav.addObject("electionId", electionId);
		mav.setViewName("adminViewStatus");
		return mav;
	}

	@GetMapping("/startElection/{electionId}")
	public ModelAndView startElection(@PathVariable("electionId") int electionId) {
		ModelAndView mav = new ModelAndView();
		adminService.startElection(electionId);
		List<CandidateEntity> list = adminService.getAllCandidates();
		
		for(CandidateEntity ce:list)
		{

			ce.setStringCandidateImage(Base64.getEncoder().encodeToString(ce.getCandidateImage()));
			ce.setStringPartyImage(Base64.getEncoder().encodeToString(ce.getPartyImage()));
		}
		/*
		 * List<ElectionEntity> list1 = adminService.getAllElection();
		 * mav.addObject("election",list1);
		 */
		mav.addObject("candidate", list);
		mav.addObject("electionId", electionId);
		mav.addObject("success", "Election Started");
		mav.setViewName("adminViewStatus");
		return mav;
	}

	@GetMapping("/stopElection/{electionId}")
	public ModelAndView stopElection(@PathVariable("electionId") int electionId) {
		ModelAndView mav = new ModelAndView();
		adminService.stopElection(electionId);
		List<CandidateEntity> list = adminService.getAllCandidates();
		for(CandidateEntity ce:list)
		{

			ce.setStringCandidateImage(Base64.getEncoder().encodeToString(ce.getCandidateImage()));
			ce.setStringPartyImage(Base64.getEncoder().encodeToString(ce.getPartyImage()));
		}

		List<ElectionEntity> list1 = adminService.getAllElection();
		mav.addObject("election", list1);

		mav.addObject("candidate", list);
		mav.addObject("electionId", electionId);
		mav.addObject("success", "Election Stoped");
		mav.setViewName("adminViewStatus");
		return mav;
	}

	@GetMapping("/approveResults/{electionId}")
	public ModelAndView approveResults(@PathVariable("electionId") int electionId) {
		ModelAndView mav = new ModelAndView();
		adminService.approveResults(electionId);
		List<CandidateEntity> list = adminService.getAllCandidates();
		for(CandidateEntity ce:list)
		{

			ce.setStringCandidateImage(Base64.getEncoder().encodeToString(ce.getCandidateImage()));
			ce.setStringPartyImage(Base64.getEncoder().encodeToString(ce.getPartyImage()));
		}
		List<ElectionEntity> list1 = adminService.getAllElection();
		mav.addObject("election", list1);
		mav.addObject("candidate", list);
		mav.addObject("electionId", electionId);
		mav.addObject("success", "Results Are Out Now");
		mav.setViewName("adminViewStatus");
		return mav;
	}

//-------------------------------------------------------Results--------------------------------------------------------//
	@GetMapping("/viewResults")
	public ModelAndView viewResults() {
		ModelAndView mav = new ModelAndView();
		List<ElectionEntity> list = adminService.getAllElection();
		mav.addObject("election", list);
		mav.setViewName("adminViewResults");
		return mav;
	}

	@GetMapping("/results/{electionId}")
	public ModelAndView results(@PathVariable("electionId") int electionId) {
		int f = 0, max = -9999;
		String name = "";
		String party = "";
		String cons = "";
		ModelAndView mav = new ModelAndView();
		List<ElectionEntity> list = adminService.getAllElection();
		List<CandidateEntity> list1 = adminService.getAllCandidates();
		String result1="";
		String result2="";
		for (ElectionEntity x : list) {
			if ((x.getElectionId() == electionId) && x.isResultsApprove() == true) {
				f = 1;
				for (CandidateEntity x1 : list1) {
					if (x1.getVote() > max && x1.getElectionId() == electionId) {
						max = x1.getVote();
						name = x1.getCandidateName();
						party = x1.getCandidateParty();
						cons = x1.getCandidateConstituency();
					result1=Base64.getEncoder().encodeToString(x1.getCandidateImage());
					 result2=Base64.getEncoder().encodeToString(x1.getPartyImage());
					}
					x1.setStringCandidateImage(Base64.getEncoder().encodeToString(x1.getCandidateImage()));
					x1.setStringPartyImage(Base64.getEncoder().encodeToString(x1.getPartyImage()));
				}
				
				// ----winner-------------//
				mav.addObject("votes", max);
				mav.addObject("result1",result1);
				mav.addObject("result2",result2);
				mav.addObject("name", name);
				mav.addObject("party", party);
				mav.addObject("cons", cons);

				// ------All Candidates Results---//
				mav.addObject("candidate", list1);
				mav.addObject("electionId", electionId);
				mav.addObject("electionName", x.getElectionName());
				mav.setViewName("results");
				break;
			}

		}
		if (f == 0) {
			mav.addObject("resultsNotOut", "Results are not Out");
			mav.setViewName("adminViewResults");
		}
		return mav;
	}
//	-----------------------------------------------Voter Register-----------------------------------------------------//

	@PostMapping("/voterRegister")
	public ModelAndView voterRegisters(VoterRegisterEntity voterRegister, String voterPassword,
			String voterRepeatPassword) {
		ModelAndView mav = new ModelAndView();

//		System.out.println(voterPassword+""+voterRepeatPassword);
		if (voterPassword.equals(voterRepeatPassword)) {
			voterService.register(voterRegister);
			mav.setViewName("voterLogin");
		} else {
			mav.addObject("password", "Enter Correct Password");
			mav.setViewName("voterRegister");
		}
		return mav;
	}

	@PostMapping("/voterLogin")
	public ModelAndView voterLogin(String email, String password) {
		ModelAndView mav = new ModelAndView();
		List<VoterRegisterEntity> list = voterService.getAllVoters();
		List<ElectionEntity> list1 = adminService.getAllElection();
		mav.addObject("election", list1);

		if (voterService.validate(email, password)) {
			mav.setViewName("voterHome");
		} else {
			mav.addObject("password", "Enter Correct Password");
			mav.setViewName("voterLogin");
		}
		for (VoterRegisterEntity x11 : list) {
			if (x11.getVoterEmail().equals(email)) {
				mav.addObject("vId", x11.getvId());
			}
		}
		return mav;
	}

	@GetMapping("/voterHome/{vId}")
	public ModelAndView voterHome(@PathVariable("vId") int vId) {
		ModelAndView mav = new ModelAndView();

		List<ElectionEntity> list = adminService.getAllElection();
		mav.addObject("election", list);
		mav.addObject("vId", vId);
		System.out.println(vId);

		mav.setViewName("/voterHome");
		return mav;
	}

	@GetMapping("/voteRequestEo/{vId}")
	public ModelAndView voteRequestEo(@PathVariable("vId") int vId) {
		ModelAndView mav = new ModelAndView();
		voterService.voterEORequest(vId);
		List<ElectionEntity> list = adminService.getAllElection();
		mav.addObject("election", list);
		mav.addObject("vId", vId);
		List<VoterRegisterEntity> list1 = voterService.getAllVoters();
		mav.addObject("voter", list1);
		mav.setViewName("voterHome");
		return mav;
	}

	@GetMapping("/castVote/{electionId}/{vId}")
	public ModelAndView castVote(@PathVariable("electionId") int electionId, @PathVariable("vId") int vId) {
		ModelAndView mav = new ModelAndView();
		List<CandidateEntity> list = adminService.getAllCandidates();
		for(CandidateEntity ce:list)
		{

			ce.setStringCandidateImage(Base64.getEncoder().encodeToString(ce.getCandidateImage()));
			ce.setStringPartyImage(Base64.getEncoder().encodeToString(ce.getPartyImage()));
		}
		List<ElectionEntity> list1 = adminService.getAllElection();
		if (voterService.eoResponceVoterCheck(vId)) {
			if (voterService.electionStartCheck(electionId)) {
				mav.addObject("candidate", list);
				mav.addObject("electionId", electionId);
				mav.addObject("vId", vId);
				mav.setViewName("castVote");
			} else {
				mav.addObject("election", list1);
				mav.addObject("vId", vId);
				mav.addObject("message", "Election Not Started Yet...");
				mav.setViewName("voterHome");
			}

		} else {
			mav.addObject("election", list1);
			mav.addObject("vId", vId);
			mav.addObject("message",
					"Without Voter Id You Cant vote, If you requested, your Request is Under Process by EO...");
			mav.setViewName("voterHome");
		}
		return mav;
	}

	@GetMapping("/vote/{candidateId}/{vId}/{electionId}")
	public ModelAndView vote(@PathVariable("candidateId") int candidateId, @PathVariable("vId") int vId,
			@PathVariable("electionId") int electionId) {
		ModelAndView mav = new ModelAndView();
		if (voterService.isVoted(vId)) {
			List<CandidateEntity> list = adminService.getAllCandidates();
			for(CandidateEntity ce:list)
			{

				ce.setStringCandidateImage(Base64.getEncoder().encodeToString(ce.getCandidateImage()));
				ce.setStringPartyImage(Base64.getEncoder().encodeToString(ce.getPartyImage()));
			}
			mav.addObject("candidate", list);
			mav.addObject("electionId", electionId);
			mav.addObject("vId", vId);
			mav.addObject("message", "Your Can't Vote for multiple, Your Vote is already registered...");
			mav.setViewName("castVote");
		} else {

			voterService.voteRegister(candidateId);// adding votes to candidate
			voterService.voteStatus(vId);// making voted status as true
			mav.addObject("vId", vId);
			mav.addObject("message", "Your Vote Is Successfully Registered...");
			mav.setViewName("thankYou");
		}
		return mav;
	}

	@GetMapping("/votersViewResults/{vId}")
	public ModelAndView votersViewResults(@PathVariable("vId") int vId) {
		ModelAndView mav = new ModelAndView();
		List<ElectionEntity> list = adminService.getAllElection();
		mav.addObject("election", list);
		mav.addObject("vId", vId);
		mav.setViewName("votersViewResults");
		return mav;
	}

	@GetMapping("/voterResults/{vId}/{electionId}")
	public ModelAndView voterResults(@PathVariable("vId") int vId, @PathVariable("electionId") int electionId) {
		int f = 0, max = -9999;
		String name = "";
		String party = "";
		String cons = "";
		ModelAndView mav = new ModelAndView();
		List<ElectionEntity> list = adminService.getAllElection();
		List<CandidateEntity> list1 = adminService.getAllCandidates();
		mav.addObject("vId", vId);
		String result3 = "";
		String result4 ="";
		for (ElectionEntity x : list) {
			if ((x.getElectionId() == electionId) && x.isResultsApprove() == true) {
				f = 1;
				for (CandidateEntity x1 : list1) {
					if (x1.getVote() > max && x1.getElectionId() == electionId) {
						max = x1.getVote();
						name = x1.getCandidateName();
						party = x1.getCandidateParty();
						cons = x1.getCandidateConstituency();
						result3=Base64.getEncoder().encodeToString(x1.getCandidateImage());
						result4=Base64.getEncoder().encodeToString(x1.getPartyImage());
					}
					x1.setStringCandidateImage(Base64.getEncoder().encodeToString(x1.getCandidateImage()));
					x1.setStringPartyImage(Base64.getEncoder().encodeToString(x1.getPartyImage()));
					
				}
				// ----winner-------------//
				mav.addObject("votes", max);
				mav.addObject("result1",result3);
				mav.addObject("result2",result4);
				mav.addObject("name", name);
				mav.addObject("party", party);
				mav.addObject("cons", cons);

				// ------All Candidates Results---//
				mav.addObject("candidate", list1);
				mav.addObject("electionId", electionId);
				mav.addObject("electionName", x.getElectionName());
				mav.setViewName("VoterResults");
				break;
			}

		}
		if (f == 0) {
			mav.addObject("resultsNotOut", "Results are not Out");
			mav.setViewName("voterHome");
		}
		return mav;
	}

	@GetMapping("/uploadServlet")
	public String postPhoto() {
		return "upload";
	}

	@PostMapping("/uploadServlet")

	void postPhoto(HttpServletRequest request) throws IOException, ServletException {
		Part part = request.getPart("file");
		InputStream inputStream = part.getInputStream();
		adminService.addParty("1", "3", electionVoterId, inputStream);
	}

	@GetMapping("/getPhoto")
	ModelAndView getPhoto() throws IOException {
		PartyEntity pe = adminService.getParty();
		String base64Image = Base64.getEncoder().encodeToString(pe.getData());
		ModelAndView mav = new ModelAndView();
		mav.addObject("photo", base64Image);
		mav.setViewName("view");
		return mav;
	}
}
