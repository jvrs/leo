package hu.jvrs.lion.jpa.afakulcs;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the AFAKULCS_RESZLET database table.
 * 
 */
@Entity
@Table(name="AFAKULCS_RESZLET")
@NamedQuery(name="AfakulcsReszlet.findAll", query="SELECT a FROM AfakulcsReszlet a")
public class AfakulcsReszlet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AFAKULCS_RESZLET_ID")
	private long afakulcsReszletId;

	private BigDecimal adomertek;

	@Temporal(TemporalType.DATE)
	@Column(name="ERV_KEZD")
	private Date ervKezd;

	@Temporal(TemporalType.DATE)
	@Column(name="ERV_VEGE")
	private Date ervVege;

	@Column(name="KOD_ES")
	private String kodEs;

	private BigDecimal mertek;

	//bi-directional many-to-one association to AfakulcsAlap
	@ManyToOne
	@JoinColumn(name="AFAKULCS_ALAP_ID")
	private AfakulcsAlap afakulcsAlap;

	public AfakulcsReszlet() {
	}

	public long getAfakulcsReszletId() {
		return this.afakulcsReszletId;
	}

	public void setAfakulcsReszletId(long afakulcsReszletId) {
		this.afakulcsReszletId = afakulcsReszletId;
	}

	public BigDecimal getAdomertek() {
		return this.adomertek;
	}

	public void setAdomertek(BigDecimal adomertek) {
		this.adomertek = adomertek;
	}

	public Date getErvKezd() {
		return this.ervKezd;
	}

	public void setErvKezd(Date ervKezd) {
		this.ervKezd = ervKezd;
	}

	public Date getErvVege() {
		return this.ervVege;
	}

	public void setErvVege(Date ervVege) {
		this.ervVege = ervVege;
	}

	public String getKodEs() {
		return this.kodEs;
	}

	public void setKodEs(String kodEs) {
		this.kodEs = kodEs;
	}

	public BigDecimal getMertek() {
		return this.mertek;
	}

	public void setMertek(BigDecimal mertek) {
		this.mertek = mertek;
	}

	public AfakulcsAlap getAfakulcsAlap() {
		return this.afakulcsAlap;
	}

	public void setAfakulcsAlap(AfakulcsAlap afakulcsAlap) {
		this.afakulcsAlap = afakulcsAlap;
	}

}