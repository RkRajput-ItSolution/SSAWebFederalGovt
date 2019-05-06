
package com.ssa.federal.gov.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "USA_STATE")
public class SSAAppStateEntity {

	@Id
	@Column(name="STATEID")
	private int stateId;

	@Column(name = "STATECODE")
	private String stateCode;

	@Column(name = "STATENAME")
	private String stateName;

}
