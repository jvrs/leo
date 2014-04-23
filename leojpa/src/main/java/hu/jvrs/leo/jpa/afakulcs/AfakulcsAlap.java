package hu.jvrs.leo.jpa.afakulcs;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the AFAKULCS_ALAP database table.
 * 
 */
@Entity
@Table(name="AFAKULCS_ALAP")
@NamedQuery(name="AfakulcsAlap.findAll", query="SELECT a FROM AfakulcsAlap a")
public class AfakulcsAlap implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AFAKULCS_ALAP_ID")
	private long afakulcsAlapId;

	@Column(name="GYUJTO_KOD")
	private String gyujtoKod;

	//bi-directional many-to-one association to AfakulcsReszlet
	@OneToMany(mappedBy="afakulcsAlap")
	private List<AfakulcsReszlet> afakulcsReszlets;

	public AfakulcsAlap() {
	}

	public long getAfakulcsAlapId() {
		return this.afakulcsAlapId;
	}

	public void setAfakulcsAlapId(long afakulcsAlapId) {
		this.afakulcsAlapId = afakulcsAlapId;
	}

	public String getGyujtoKod() {
		return this.gyujtoKod;
	}

	public void setGyujtoKod(String gyujtoKod) {
		this.gyujtoKod = gyujtoKod;
	}

	public List<AfakulcsReszlet> getAfakulcsReszlets() {
		return this.afakulcsReszlets;
	}

	public void setAfakulcsReszlets(List<AfakulcsReszlet> afakulcsReszlets) {
		this.afakulcsReszlets = afakulcsReszlets;
	}

	public AfakulcsReszlet addAfakulcsReszlet(AfakulcsReszlet afakulcsReszlet) {
		getAfakulcsReszlets().add(afakulcsReszlet);
		afakulcsReszlet.setAfakulcsAlap(this);

		return afakulcsReszlet;
	}

	public AfakulcsReszlet removeAfakulcsReszlet(AfakulcsReszlet afakulcsReszlet) {
		getAfakulcsReszlets().remove(afakulcsReszlet);
		afakulcsReszlet.setAfakulcsAlap(null);

		return afakulcsReszlet;
	}

}