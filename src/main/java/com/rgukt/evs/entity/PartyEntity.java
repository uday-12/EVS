package com.rgukt.evs.entity;

import java.io.InputStream;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class PartyEntity {

	private int electionId; // foreginKey

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pId;
	private String partyName;
	private String partyLeader;
 	private String partySymbol;
	// private InputStream symbol;
	@Lob
    private byte[] data;

	public String getPartySymbol() {
		return partySymbol;
	}

	public void setPartySymbol(String partySymbol) {
		this.partySymbol = partySymbol;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public int getElectionId() {
		return electionId;
	}

	public void setElectionId(int electionId) {
		this.electionId = electionId;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getPartyLeader() {
		return partyLeader;
	}

	public void setPartyLeader(String partyLeader) {
		this.partyLeader = partyLeader;
	}

//	public InputStream getSymbol() {
//		return symbol;
//	}
//
//	public void setSymbol(InputStream symbol) {
//		this.symbol = symbol;
//	}

//	public String getPartySymbol() {
//		return partySymbol;
//	}
//
//	public void setPartySymbol(String partySymbol) {
//		this.partySymbol = partySymbol;
//	}

}
