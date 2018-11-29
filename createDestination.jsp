<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-text-Type" content="text/css; charset=UTF-8">
<title>宛先情報入力</title>
</head>
<body>
<div class = "contents">
<s:include value="header.jsp" />
<div class = "title">新規宛先情報入力</div>
<s:if test="!familyNameErrorMessageList.isEmpty()">
		<div class="error-message">
			<s:iterator value="familyNameErrorMessageList"><s:property /></s:iterator>
		</div>
</s:if>
<s:if test="!firstNameErrorMessageList.isEmpty()">
		<div class="error-message">
			<s:iterator value="firstNameErrorMessageList"><s:property /></s:iterator>
		</div>
</s:if>
<s:if test="!familyNameKanaErrorMessageList.isEmpty()">
		<div class="error-message">
			<s:iterator value="familyNameKanaErrorMessageList"><s:property /></s:iterator>
		</div>
</s:if>
<s:if test="!firstNameKanaErrorMessageList.isEmpty()">
		<div class="error-message">
			<s:iterator value="firstNameKanaErrorMessageList"><s:property /></s:iterator>
		</div>
</s:if>
<s:if test="!userAddressErrorMessageList.isEmpty()">
		<div class="error-message">
			<s:iterator value="userAddressErrorMessageList"><s:property /></s:iterator>
		</div>
</s:if>
<s:if test="!telNumberErrorMessageList.isEmpty()">
		<div class="error-message">
			<s:iterator value="telNumberErrorMessageList"><s:property /></s:iterator>
		</div>
</s:if>
<s:if test="!emailErrorMessageList.isEmpty()">
		<div class="error-message">
			<s:iterator value="emailErrorMessageList"><s:property /></s:iterator>
		</div>
</s:if>
<s:form action="CreateDestinationConfirmAction">
	<div class = "input_create">
			<div class = "form_label">
				<span>姓</span><span class = "required">必須</span>
			</div>
			<div class = "form_box">
				<s:textfield name="familyName" value="%{familyName}" label="姓" placeholder="姓" class="txt" />
			</div>
			<div class = "form_label">
				<span>名</span><span class = "required">必須</span>
			</div>
			<div class = "form_box">
				<s:textfield name="firstName" value="%{firstName}" label="名" placeholder="名" class="txt" />
			</div>
			<div class = "form_label">
				<span>姓ふりがな</span><span class = "required">必須</span>
			</div>
			<div class = "form_box">
				<s:textfield name="familyNameKana" value="%{familyNameKana}" label="姓ふりがな" placeholder="姓ふりがな" class="txt" />
			</div>
			<div class = "form_label">
				<span>名ふりがな</span><span class = "required">必須</span>
			</div>
			<div class = "form_box">
				<s:textfield name="firstNameKana" value="%{firstNameKana}" label="名ふりがな" placeholder="名ふりがな" class="txt" />
			</div>
			<div class = "form_label">
				<span>性別</span>
				<span class="required">必須</span>
			</div>
			<div class = "form_sex">
				<div class = "sex_list">
					<s:if test="%{sex==1}">
						<label>男性<input type="radio" value="0" name="sex"/></label>
						<label>女性<input type="radio" value="1" checked="checked" name="sex"/></label>
					</s:if>
					<s:else>
						<label>男性<input type="radio" value="0" checked="checked" name="sex"/></label>
						<label>女性<input type="radio" value="1" name="sex"/></label>
					</s:else>
				</div>
			</div>
			<div class = "form_label">
					<span>住所</span>
					<span class = "required">必須</span>
			</div>
			<div class = "form_box">
				<s:textfield name="userAddress" value="%{userAddress}" label="userAddress" placeholder="住所" class="txt" />
			</div>
			<div class = "form_label">
					<span>電話番号</span>
					<span class = "required">必須</span>
			</div>
			<div class = "form_box">
				<s:textfield name="telNumber" value="%{telNumber}" label="電話番号" placeholder="電話番号" class="txt" />
			</div>
			<div class = "form_label">
					<span>メールアドレス</span>
					<span class = "required">必須</span>
			</div>
			<div class = "form_box">
					<s:textfield name="email" value="%{email}" label="メールアドレス" class="txt" placeholder="メールアドレス" />
			</div>
	<div>
		<s:submit value="宛先情報確認" class="btn_blue" />
	</div>
	</div>
</s:form>
</div>
<s:include value="footer.jsp"/>
</body>
</html>