package com.nzv.batch.tycho.importer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "STAR")
public class Star {

	@Id
	@Column(name = "ID")
	private String id;
	
	@Column(name = "TYC1")
	private String tyc1;
	
	@Column(name = "TYC2")
	private String tyc2;
	
	@Column(name = "TYC3")
	private String tyc3;
	
	@Column(name = "HIPPARCOS_NUMBER")
	private Integer hipparcosNumber;
	
	@Column(name = "RIGHT_ASCENSION")
	private Double rightAscension;
	
	@Column(name = "DECLINAISON")
	private Double declinaison;
	
	@Column(name = "BT_MAG")
	private Double btMag;
	
	@Column(name = "VT_MAG")
	private Double vtMag;
	
	@Column(name = "SKIP_MARKER")
	private String skipMarker;

}
