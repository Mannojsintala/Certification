package com.reverse;
// Generated Jan 10, 2018 10:42:17 AM by Hibernate Tools 5.2.3.Final

/**
 * UserScorecard generated by hbm2java
 */
public class UserScorecard implements java.io.Serializable {

	private int id;
	private CertificationTechnology certificationTechnology;
	private User user;
	private String certificationResult;
	private Long certificationScore;

	public UserScorecard() {
	}

	public UserScorecard(int id) {
		this.id = id;
	}

	public UserScorecard(int id, CertificationTechnology certificationTechnology, User user, String certificationResult,
			Long certificationScore) {
		this.id = id;
		this.certificationTechnology = certificationTechnology;
		this.user = user;
		this.certificationResult = certificationResult;
		this.certificationScore = certificationScore;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CertificationTechnology getCertificationTechnology() {
		return this.certificationTechnology;
	}

	public void setCertificationTechnology(CertificationTechnology certificationTechnology) {
		this.certificationTechnology = certificationTechnology;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCertificationResult() {
		return this.certificationResult;
	}

	public void setCertificationResult(String certificationResult) {
		this.certificationResult = certificationResult;
	}

	public Long getCertificationScore() {
		return this.certificationScore;
	}

	public void setCertificationScore(Long certificationScore) {
		this.certificationScore = certificationScore;
	}

	@Override
	public String toString() {
		return "UserScorecard [id=" + id + ", certificationTechnology=" + certificationTechnology + ", user=" + user
				+ ", certificationResult=" + certificationResult + ", certificationScore=" + certificationScore + "]";
	}

	
}
