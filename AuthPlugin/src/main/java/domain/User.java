package domain;

import java.io.Serializable;

/** 
* @author 作者 ：walker 
* @time 创建时间：2018年1月22日 上午10:39:35 
* @describe 
*/
public class User implements Serializable{

	/** 
	* @author 作者 ：walker 
	* @time 创建时间：2018年1月22日上午10:39:54
	* @field 字段：serialVersionUID
	*/ 
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String clientId;
	
	private String ip;
	
	//private String userName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	/*public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	*/
	
	
}
