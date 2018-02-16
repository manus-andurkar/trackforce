package com.revature.entity;
// Generated Nov 7, 2017 9:24:46 PM by Hibernate Tools 5.2.5.Final

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * TfBatch generated by hbm2java
 */
@Entity
@Table(name = "TF_BATCH", schema = "ADMIN")
public class TfBatch implements java.io.Serializable, Comparable<TfBatch> {

	/**
	 *
	 */
	private static final long serialVersionUID = 1893469049852289417L;
	private Integer tfBatchId;
	private TfBatchLocation tfBatchLocation;
	private TfCurriculum tfCurriculum;
	private String tfBatchName;
	private Timestamp tfBatchStartDate;
	private Timestamp tfBatchEndDate;
	private Set<TfAssociate> tfAssociates = new HashSet<TfAssociate>();
	private Set<TfTech> techs = new HashSet<TfTech>();  //Batch owns these Technologies

	public TfBatch() {
	}

	public TfBatch(Integer tfBatchId) {
		this.tfBatchId = tfBatchId;
	}

	public TfBatch(Integer tfBatchId, TfBatchLocation tfBatchLocation, TfCurriculum tfCurriculum, String tfBatchName,
			Timestamp tfBatchStartDate, Timestamp tfBatchEndDate, Set<TfAssociate> tfAssociates, Set<TfTech> techs) {
		this.tfBatchId = tfBatchId;
		this.tfBatchLocation = tfBatchLocation;
		this.tfCurriculum = tfCurriculum;
		this.tfBatchName = tfBatchName;
		this.tfBatchStartDate = tfBatchStartDate;
		this.tfBatchEndDate = tfBatchEndDate;
		this.tfAssociates = tfAssociates;
		this.techs = techs;
	}

	@Id
	@Column(name = "TF_BATCH_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getTfBatchId() {
		return this.tfBatchId;
	}

	public void setTfBatchId(Integer tfBatchId) {
		this.tfBatchId = tfBatchId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TF_BATCH_LOCATION_ID")
	public TfBatchLocation getTfBatchLocation() {
		return this.tfBatchLocation;
	}

	public void setTfBatchLocation(TfBatchLocation tfBatchLocation) {
		this.tfBatchLocation = tfBatchLocation;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TF_CURRICULUM_ID")
	public TfCurriculum getTfCurriculum() {
		return this.tfCurriculum;
	}

	public void setTfCurriculum(TfCurriculum tfCurriculum) {
		this.tfCurriculum = tfCurriculum;
	}


	//ManyToMany
	@ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, targetEntity=TfTech.class)
  @JoinTable(name="TF_BATCH_JUNCTION",
						 schema="ADMIN",
						 joinColumns={@JoinColumn(name="TF_BATCH_ID") },
  			 	   inverseJoinColumns= { @JoinColumn(name="TF_TECH_ID")})
    public Set<TfTech> getTechs()
    {
        return techs;
    }
    public void setTechs(Set<TfTech> techs)
    {
        this.techs = techs;  //reference the techs that it owns
    }

	@Column(name = "TF_BATCH_NAME", length = 50)
	public String getTfBatchName() {
		return this.tfBatchName;
	}

	public void setTfBatchName(String tfBatchName) {
		this.tfBatchName = tfBatchName;
	}

	@Column(name = "TF_BATCH_START_DATE")
	public Timestamp getTfBatchStartDate() {
		return this.tfBatchStartDate;
	}

	public void setTfBatchStartDate(Timestamp tfBatchStartDate) {
		this.tfBatchStartDate = tfBatchStartDate;
	}

	@Column(name = "TF_BATCH_END_DATE")
	public Timestamp getTfBatchEndDate() {
		return this.tfBatchEndDate;
	}

	public void setTfBatchEndDate(Timestamp tfBatchEndDate) {
		this.tfBatchEndDate = tfBatchEndDate;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tfBatch")
	public Set<TfAssociate> getTfAssociates() {
		return this.tfAssociates;
	}
    	public void setTfAssociates(Set<TfAssociate> tfAssociates) {
		this.tfAssociates = tfAssociates;
	}

	@Override
	public String toString() {
		return "TfBatch [tfBatchId=" + tfBatchId + ", tfBatchLocation=" + tfBatchLocation + ", tfCurriculum="
				+ tfCurriculum + ", tfBatchName=" + tfBatchName + ", tfBatchStartDate=" + tfBatchStartDate
				+ ", tfBatchEndDate=" + tfBatchEndDate + ", tfAssociates=" + tfAssociates + "]";
	}

	@Override
	public int compareTo(TfBatch o) {
		return this.tfBatchId-o.getTfBatchId();
	}


}
