package bean;

import java.io.Serializable;

public class Color implements Serializable {
	private String colorId;
	private String colorName;
	private String colorImagePath;
	public Color() {}
	public String getColorId() {
		return colorId;
	}
	public void setColorId(String colorId) {
		this.colorId = colorId;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	public String getColorImagePath() {
		return colorImagePath;
	}
	public void setColorImagePath(String colorImagePath) {
		this.colorImagePath = colorImagePath;
	}

}
