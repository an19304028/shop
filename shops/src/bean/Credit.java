package bean;

import java.io.Serializable;

public class Credit implements Serializable {

	private String userId;
	private String creditNumber;
	private String securityCode;
	private String expirationDate;
	private int payCount;


	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCreditNumber() {
		return creditNumber;
	}
	public void setCreditNumber(String creditNumber) {
		this.creditNumber = creditNumber;
	}
	public String getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public int getPayCount() {
		return payCount;
	}
	public void setPayCount(int payCount) {
		this.payCount = payCount;
	}

}
