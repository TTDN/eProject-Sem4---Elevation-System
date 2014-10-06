<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap-theme.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="css/bootstrap-theme.min.css"
	type="text/css" media="screen" />
<link rel="stylesheet" href="css/bootstrap.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="css/admin.css" type="text/css"
	media="screen" />
</head>
</head>
<body style="background-color: rgba(230, 191, 198, 0.06);">
	<div style="width: 900px; margin: 120px auto auto; text-align: center;">
		<h1 style="color: rgba(255, 0, 27, 1);">Chi Tiet Danh Muc</h1>
		<table style="background-color: white;" class="table table-bordered">
			<tr>
				<th>IDDM</th>
				<th>TENDM</th>
			</tr>
			<s:iterator value="listdm" status="groupStatus">
				<tr
					class="<s:if test="#groupStatus.odd == true ">odd</s:if><s:else>even</s:else>">
					<td><s:property value="iddm" /></td>
					<td><s:property value="tendm" /></td>
					<td><s:url var="testUrlId" action="upDM">
							<s:param name="id">
								<s:property value="iddm" />
							</s:param>
						</s:url> <s:a errorText="Sorry your request had an error."
							preInvokeJS="confirm('Are you sure you want to delete this item?')"
							href="%{testUrlId}">Update
					</s:a></td>
					<td><s:url var="UrlId" action="deDM">
							<s:param name="idDM">
								<s:property value="iddm" />
							</s:param>
						</s:url> <s:a errorText="Sorry your request had an error."
							preInvokeJS="confirm('Are you sure you want to delete this item?')"
							href="%{UrlId}">Delete
					</s:a></td>
				</tr>
			</s:iterator>
		</table>
	</div>
</body>
</html>