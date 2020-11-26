package bean;

import java.io.Serializable;

public class Size implements Serializable {
	private String sizeId;
	private String sizeName;
	public Size() {}
	public String getSizeId() {
		return sizeId;
	}
	public void setSizeId(String sizeId) {
		this.sizeId = sizeId;
	}
	public String getSizeName() {
		return sizeName;
	}
	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}
	
}
