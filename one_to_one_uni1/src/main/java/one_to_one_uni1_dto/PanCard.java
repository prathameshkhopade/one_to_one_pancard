package one_to_one_uni1_dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PanCard {
	@Id
	private int panId;
	private String panName;
	private String address;

	@Override
	public String toString() {
		return "PanCard [panId=" + panId + ", panName=" + panName + ", address=" + address + "]";
	}

	public int getPanId() {
		return panId;
	}

	public void setPanId(int panId) {
		this.panId = panId;
	}

	public String getPanName() {
		return panName;
	}

	public void setPanName(String panName) {
		this.panName = panName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
