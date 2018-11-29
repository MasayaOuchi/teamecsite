package com.internousdev.casablanca.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.casablanca.dao.MCategoryDAO;
import com.internousdev.casablanca.dao.UserInfoDAO;
import com.internousdev.casablanca.dto.MCategoryDTO;
import com.internousdev.casablanca.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class CreateUserConfirmAction extends ActionSupport implements SessionAware{

	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String sex;
	private String email;
	private String loginId;
	private String password;
	private List<String> familyNameErrorMessageList;
	private List<String> firstNameErrorMessageList;
	private List<String> familyNameKanaErrorMessageList;
	private List<String> firstNameKanaErrorMessageList;
	private List<String> emailErrorMessageList;
	private List<String> loginIdErrorMessageList;
	private List<String> passwordErrorMessageList;
	private String loginIdDuplicateErrorMessage;
	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;
		if (familyName == null ||
				firstName == null ||
				familyNameKana == null ||
				firstNameKana == null ||
				email == null ||
				loginId == null ||
				password == null) {
			} else {
				/* 入力値のチェック */
				InputChecker inputChecker = new InputChecker();
				familyNameErrorMessageList = inputChecker.doCheck("姓", familyName, 1, 16, true, true, true, false, false, false, false, false, false);
				firstNameErrorMessageList = inputChecker.doCheck("名", firstName, 1, 16, true, true, true, false, false, false, false, false, false);
				familyNameKanaErrorMessageList = inputChecker.doCheck("姓ふりがな", familyNameKana, 1, 16, false, false, true, false, false, false, false, false, false);
				firstNameKanaErrorMessageList = inputChecker.doCheck("名ふりがな", firstNameKana, 1, 16, false, false, true, false, false, false, false, false, false);
				emailErrorMessageList = inputChecker.doCheck("メールアドレス", email, 14, 32, true, false, false, true, true, false, false, false, false);
				loginIdErrorMessageList = inputChecker.doCheck("ログインID", loginId, 1, 8, true, false, false, true, false, false ,false, false, false);
				passwordErrorMessageList = inputChecker.doCheck("パスワード", password, 1, 16, true, false, false, true, false, false ,false, false, false);

				if(familyNameErrorMessageList.size()==0
				&& firstNameErrorMessageList.size()==0
				&& familyNameKanaErrorMessageList.size()==0
				&& firstNameKanaErrorMessageList.size()==0
				&& firstNameErrorMessageList.size()==0
				&& emailErrorMessageList.size()==0
				&& loginIdErrorMessageList.size()==0
				&& passwordErrorMessageList.size()==0) {

					/* 入力されたログインIDが既に登録済みかをチェック */
					UserInfoDAO userInfoDAO = new UserInfoDAO();
					if (userInfoDAO.isExistsLoginId(loginId)) {
						loginIdDuplicateErrorMessage = "すでに登録されているログインIDです。";
						result = INPUT;
					} else {
						result = SUCCESS;
					}
				} else {
					result = INPUT;
				}
			}
		if(!session.containsKey("mCategoryDtoList")) {
			MCategoryDAO mCategoryDAO = new MCategoryDAO();
			List<MCategoryDTO> mCategoryDtoList = mCategoryDAO.getMCategoryList();
			session.put("mCategoryDtoList", mCategoryDtoList);
		}
		return result;
	}
	public List<String> getLoginIdErrorMessageList() {
		return loginIdErrorMessageList;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getFamilyNameKana() {
		return familyNameKana;
	}
	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}
	public String getFirstNameKana() {
		return firstNameKana;
	}
	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex){
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<String> getFamilyNameErrorMessageList() {
		return familyNameErrorMessageList;
	}
	public List<String> getFirstNameErrorMessageList() {
		return firstNameErrorMessageList;
	}
	public List<String> getFamilyNameKanaErrorMessageList() {
		return familyNameKanaErrorMessageList;
	}
	public List<String> getFirstNameKanaErrorMessageList() {
		return firstNameKanaErrorMessageList;
	}
	public List<String> getEmailErrorMessageList() {
		return emailErrorMessageList;
	}
	public List<String> getLoginErrorMessageList() {
		return loginIdErrorMessageList;
	}
	public List<String> getPasswordErrorMessageList() {
		return passwordErrorMessageList;
	}
	public String getLoginIdDuplicateErrorMessage() {
		return loginIdDuplicateErrorMessage;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}