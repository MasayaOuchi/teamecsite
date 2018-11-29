<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-text-Type" content="text/css; charset=UTF-8">
<meta http-equiv="Content-Script-Type" content="text.javascript; charset=UTF-8">
<meta name="description" content="" />
<meta name="keywords" content="" />
<title>ユーザー情報登録</title>
</head>
<body>

<jsp:include page="header.jsp" />
<div class= "contents">
<div class= "title">アカウント新規登録</div>
	<s:if test="!loginIdDuplicateErrorMessage.isEmpty()">
		<div class="error-message">
			<s:property value="loginIdDuplicateErrorMessage"/>
		</div>
	</s:if>
	<s:if test="!familyNameErrorMessageList.isEmpty()">
		<div class="error-message">
			<s:iterator value="familyNameErrorMessageList">
				<s:property />
			</s:iterator>
		</div>
	</s:if>
	<s:if test="!firstNameErrorMessageList.isEmpty()">
		<div class="error-message">
		<s:iterator value="firstNameErrorMessageList">
			<s:property />
		</s:iterator>
		</div>
	</s:if>
	<s:if test="!familyNameKanaErrorMessageList.isEmpty()">
		<div class="error-message">
		<s:iterator value="familyNameKanaErrorMessageList">
			<s:property />
		</s:iterator>
		</div>
	</s:if>
	<s:if test="!firstNameKanaErrorMessageList.isEmpty()">
		<div class="error-message">
		<s:iterator value="firstNameKanaErrorMessageList">
			<s:property />
		</s:iterator>
		</div>
	</s:if>
	<s:if test="!emailErrorMessageList.isEmpty()">
		<div class="error-message">
		<s:iterator value="emailErrorMessageList">
			<s:property />
		</s:iterator>
		</div>
	</s:if>
	<s:if test="!loginErrorMessageList.isEmpty()">
		<div class="error-message">
		<s:iterator value="loginErrorMessageList">
			<s:property />
		</s:iterator>
		</div>
	</s:if>
	<s:if test="!passwordErrorMessageList.isEmpty()">
		<div class="error-message">
		<s:iterator value="passwordErrorMessageList">
			<s:property />
		</s:iterator>
		</div>
	</s:if>
	<s:form action="CreateUserConfirmAction">
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
					<span>メールアドレス</span>
					<span class = "required">必須</span>
			</div>
			<div class = "form_box">
				<s:textfield name="email" value="%{email}" label="メールアドレス" placeholder="メールアドレス" class="txt" />
			</div>
			<div class = "form_label">
					<span>ログインID</span>
					<span class = "required">必須</span>
			</div>
			<div class = "form_box">
				<s:textfield name="loginId" value="%{loginId}" label="ログインID" placeholder="ログインID" class="txt" />
			</div>
			<div class = "form_label">
					<span>パスワード</span>
					<span class = "required">必須</span>
			</div>
			<div class = "form_box">
			<s:password name="password" value="" label="パスワード" class="txt" placeholder="パスワード" autocomplete="new-password"/>
			</div>
			<div>
				<s:submit value="登録" class="btn_blue" />
			</div>




	</div>
	</s:form>
<div id="footer">
	<s:include value="footer.jsp"/>
</div>
</div>
</body>
</html>