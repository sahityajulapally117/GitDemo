package pojo;

import java.util.List;

public class Courses {

	public List<WebAutomation> WebAutomation;
	public List<Api> api;
	public List<Mobile> mobile;
	public List<WebAutomation> getWebAutomation() {
		return WebAutomation;
	}
	public void setWebAutomation(List<pojo.WebAutomation> webAutomation) {
		WebAutomation = webAutomation;
	}
	public List<Api> getApi() {
		return api;
	}
	public void setApi(List<Api> api) {
		this.api = api;
	}
	public List<Mobile> getMobile() {
		return mobile;
	}
	public void setMobile(List<Mobile> mobile) {
		this.mobile = mobile;
	}
	
	
}
