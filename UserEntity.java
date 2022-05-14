
public class UserEntity
{
	private Integer uId;
	private long mobileNo;
	private String password;
	private String uName;
	private String uAddress;
	private String uCity;
	
	public UserEntity() {
	
	}

	public UserEntity(long mobileNo, String password, String uName, String uAddress, String uCity) {
		super();
		this.mobileNo = mobileNo;
		this.password = password;
		this.uName = uName;
		this.uAddress = uAddress;
		this.uCity = uCity;
	}

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuAddress() {
		return uAddress;
	}

	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}

	public String getuCity() {
		return uCity;
	}

	public void setuCity(String uCity) {
		this.uCity = uCity;
	}

	@Override
	public String toString() {
		return "UserEntity [uId=" + uId + ", mobileNo=" + mobileNo + ", password=" + password + ", uName=" + uName
				+ ", uAddress=" + uAddress + ", uCity=" + uCity + "]";
	}
		
}
