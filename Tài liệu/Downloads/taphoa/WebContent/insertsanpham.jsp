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
<body style="background-color: rgba(230, 191, 198, 0.06);">
	<div id="fo1">
		<div id="fo2">
			<h1 style="color: rgba(240, 12, 12, 1);">Insert san pham</h1>
			<s:form action="inSP" method="post" validate="true">
				<table id="tb">
					<tr class="trtr">
						<td><s:textfield cssClass="form-control" name="sp.tensp"
								label="Ten san pham" /></td>
					</tr>
					<tr class="trtr">
						<td><s:textfield cssClass="form-control" name="sp.hinhanh"
								label="Hinh anh" /></td>
					</tr>
					<tr class="trtr">
						<td><s:textfield cssClass="form-control" name="sp.gia"
								label="Gia san pham" /></td>
					</tr>
					<tr class="trtr">
						<td><s:textfield cssClass="form-control" name="sp.soluong"
								label="So luong" /></td>
					</tr>
					<tr class="trtr">
						<td><s:textfield cssClass="form-control" name="sp.iddm"
								label="Danh Muc" /></td>
					</tr>
				</table>
				<s:submit id="btn" cssClass="btn btn-success" value="Add san pham"></s:submit>
			</s:form>
			<s:form action="seSP">
				<s:submit cssClass="btn btn-primary" value="Xem san pham"></s:submit>
			</s:form>
		</div>
	</div>
</body>
</html>