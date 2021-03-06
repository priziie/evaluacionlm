package com.bank.entity;
// Generated 11-may-2019 0:40:11 by Hibernate Tools 5.2.12.Final

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * BnkTraTransaction generated by hbm2java
 */
@Entity
@Table(name = "bnk_tra_transaction", schema = "transactions")
public class BnkTraTransaction implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int traCode;
	private String traAccid;
	private String traUsrcod;
	private String traDescription;
	private BigDecimal traAmount;
	private String traStatus;
	private String traCreatedBy;
	private Date traCreatedDate;
	private String traModifiedBy;
	private Date traModifiedDate;

	public BnkTraTransaction() {
	}

	public BnkTraTransaction(int traCode, String traAccid, String traUsrcod, String traCreatedBy,
			Date traCreatedDate) {
		this.traCode = traCode;
		this.traAccid = traAccid;
		this.traUsrcod = traUsrcod;
		this.traCreatedBy = traCreatedBy;
		this.traCreatedDate = traCreatedDate;
	}

	public BnkTraTransaction(int traCode, String traAccid, String traUsrcod, String traDescription,
			BigDecimal traAmount, String traStatus, String traCreatedBy, Date traCreatedDate, String traModifiedBy,
			Date traModifiedDate) {
		this.traCode = traCode;
		this.traAccid = traAccid;
		this.traUsrcod = traUsrcod;
		this.traDescription = traDescription;
		this.traAmount = traAmount;
		this.traStatus = traStatus;
		this.traCreatedBy = traCreatedBy;
		this.traCreatedDate = traCreatedDate;
		this.traModifiedBy = traModifiedBy;
		this.traModifiedDate = traModifiedDate;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tra_code", unique = true, nullable = false, length = 10)
	public int getTraCode() {
		return this.traCode;
	}

	public void setTraCode(int traCode) {
		this.traCode = traCode;
	}

	@Column(name = "tra_accid", nullable = false, length = 10)
	public String getTraAccid() {
		return this.traAccid;
	}

	public void setTraAccid(String traAccid) {
		this.traAccid = traAccid;
	}

	@Column(name = "tra_usrcod", nullable = false, length = 10)
	public String getTraUsrcod() {
		return this.traUsrcod;
	}

	public void setTraUsrcod(String traUsrcod) {
		this.traUsrcod = traUsrcod;
	}

	@Column(name = "tra_description", length = 100)
	public String getTraDescription() {
		return this.traDescription;
	}

	public void setTraDescription(String traDescription) {
		this.traDescription = traDescription;
	}

	@Column(name = "tra_amount", precision = 131089, scale = 0)
	public BigDecimal getTraAmount() {
		return this.traAmount;
	}

	public void setTraAmount(BigDecimal traAmount) {
		this.traAmount = traAmount;
	}

	@Column(name = "tra_status", length = 1)
	public String getTraStatus() {
		return this.traStatus;
	}

	public void setTraStatus(String traStatus) {
		this.traStatus = traStatus;
	}

	@Column(name = "tra_created_by", nullable = false, length = 25)
	public String getTraCreatedBy() {
		return this.traCreatedBy;
	}

	public void setTraCreatedBy(String traCreatedBy) {
		this.traCreatedBy = traCreatedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "tra_created_date", nullable = false, length = 29)
	public Date getTraCreatedDate() {
		return this.traCreatedDate;
	}

	public void setTraCreatedDate(Date traCreatedDate) {
		this.traCreatedDate = traCreatedDate;
	}

	@Column(name = "tra_modified_by", length = 25)
	public String getTraModifiedBy() {
		return this.traModifiedBy;
	}

	public void setTraModifiedBy(String traModifiedBy) {
		this.traModifiedBy = traModifiedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "tra_modified_date", length = 29)
	public Date getTraModifiedDate() {
		return this.traModifiedDate;
	}

	public void setTraModifiedDate(Date traModifiedDate) {
		this.traModifiedDate = traModifiedDate;
	}

}
