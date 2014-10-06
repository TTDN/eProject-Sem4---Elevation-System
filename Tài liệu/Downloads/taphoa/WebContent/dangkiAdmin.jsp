<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
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
<body style="background-color: rgba(230, 191, 198, 0.06);">
	<div id="fo1">
		<div id="fo2">
			<h1 style="color: rgba(240, 12, 12, 1);">Register Admin</h1>
			<s:form action="registeradmin" method="post" validate="true">
				<table id="tb">
					<tr class="trtr">
						<td><s:textfield cssClass="form-control" name="ad.username"
								label="Username" /></td>
					</tr>
					<tr>
						<td><s:textfield cssClass="form-control" name="ad.password"
								label="Password" /></td>
					</tr>
					<tr>
						<td><s:textfield cssClass="form-control" name="ad.phone"
								label="Phone" /></td>
					</tr>
					<tr>
						<td><s:textfield cssClass="form-control" name="ad.ngaysinh"
								label="Ngay Sinh" /></td>
					</tr>
					<tr>
						<td><s:textfield cssClass="form-control" name="ad.email"
								label="Email" /></td>
					</tr>
					<tr>
						<td><s:textfield cssClass="form-control" name="ad.diachi"
								label="Dia Chi" /></td>
					</tr>
				</table>
				<s:submit id="btn" cssClass="btn btn-success" value="Register"></s:submit>
			</s:form>
			<s:form action="showadmimm" method="post">
				<s:submit value="Xem Admin" cssClass="btn btn-primary"></s:submit>
			</s:form>
		</div>
	</div>
</body>
</html>