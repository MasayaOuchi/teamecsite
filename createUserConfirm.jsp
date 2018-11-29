<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css"/>
<link rel="stylesheet" href="./css/create.css">
<link rel="stylesheet" href="./css/settlementconfirm.css" >
<title>登録内容確認画面</title>
</head>
<body>
<s:include value="header.jsp"/>
<div class="contents">
<div class="title">登録内容確認画面</div>
	<p>以下の内容で登録します</p>
<div class="create">
<s:form action="CreateUserCompleteAction">
<table class="list-table">
<tr>
	<th scope="row">
		<s:label value="姓"/>
	</th>
	<td>
		<s:property value="familyName"/>
		<s:hidden name="familyName" value="%{familyName}"/>
	</td>
</tr>
<tr>
	<th scope="row">
		<s:label value="名"/>
	</th>
	<td>
		<s:property value="firstName"/>
		<s:hidden name="firstName" value="%{firstName}"/>
	</td>
</tr>
<tr>
	<th scope="row">
		<s:label value="姓ふりがな"/>
	</th>
	<td>
		<s:property value="familyNameKana"/>
		<s:hidden name="familyNameKana" value="%{familyNameKana}"/>
	</td>
</tr>
<tr>
	<th scope="row">
		<s:label value="名ふりがな"/>
	</th>
	<td>
		<s:property value="firstNameKana"/>
		<s:hidden name="firstNameKana" value="%{firstNameKana}"/>
	</td>
</tr>
<tr>
	<th scope="row">
		<s:label value="性別"/>
	</th>
		<s:if test="%{sex==0}">
			<td>男</td>
		</s:if>
		<s:else>
			<td>女</td>
		</s:else>
		<s:hidden name="sex" value="%{sex}"/>
</tr>
<tr>
	<th scope="row">
		<s:label value="メールアドレス"/>
	</th>
	<td>
		<s:property value="email"/>
		<s:hidden name="email" value="%{email}"/>
	</td>
</tr>
<tr>
	<th scope="row">
		<s:label value="ログインID"/>
	</th>
	<td>
		<s:property value="loginId"/>
		<s:hidden name="loginId" value="%{loginId}"/>
	</td>
</tr>
<tr>
	<th scope="row">
		<s:label value="パスワード"/>
	</th>
	<td>
		<s:property value="password"/>
		<s:hidden name="password" value="%{password}"/>
	</td>
</tr>
</table>
<div class="submit_btn_box">
<s:token/>
<s:submit value="登録" class="btn_blue"/>
</div>
</s:form>
</div>
</div>
<s:include value="footer.jsp"/>
</body>
</html>