package com.reverse;
// Generated Jan 10, 2018 10:42:17 AM by Hibernate Tools 5.2.3.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ExaminationSlot generated by hbm2java
 */
public class ExaminationSlot implements java.io.Serializable {

	private int id;
	private CertificationTechnology certificationTechnology;
	private User user;
	private Date slotTime;
	private Set paymentDetailses = new HashSet(0);

	public ExaminationSlot() {
	}

	public ExaminationSlot(int id) {
		this.id = id;
	}

	public ExaminationSlot(int id, CertificationTechnology certificationTechnology, User user, Date slotTime,
			Set paymentDetailses) {
		this.id = id;
		this.certificationTechnology = certificationTechnology;
		this.user = user;
		this.slotTime = slotTime;
		this.paymentDetailses = paymentDetailses;
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

	public Date getSlotTime() {
		return this.slotTime;
	}

	public void setSlotTime(Date slotTime) {
		this.slotTime = slotTime;
	}

	public Set getPaymentDetailses() {
		return this.paymentDetailses;
	}

	public void setPaymentDetailses(Set paymentDetailses) {
		this.paymentDetailses = paymentDetailses;
	}

	@Override
	public String toString() {
		return "ExaminationSlot [id=" + id + ", certificationTechnology=" + certificationTechnology + ", user=" + user
				+ ", slotTime=" + slotTime + ", paymentDetailses=" + paymentDetailses + "]";
	}
	

}
