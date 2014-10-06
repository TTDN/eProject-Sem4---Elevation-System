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
	<div style="width: 450px" id="fo1">
		<div style="width: 345px" id="fo2">
			<h1 style="color: rgba(240, 12, 12, 1);">Insert chi tiet hoa don</h1>
			<s:form action="inCTHD" method="post" validate="true">
				<table id="tb">
					<tr class="trtr">
						<td><s:textfield cssClass="form-control" name="cthd.idsp"
								label="IDSP" /></td>
					</tr>
					<tr class="trtr">
						<td><s:textfield cssClass="form-control" name="cthd.soluong"
								label="So Luong" /></td>
					</tr>
					<tr class="trtr">
						<td><s:textfield cssClass="form-control"
								name="cthd.thanhtien" label="Thanh Tien" /></td>
					</tr>
					<tr class="trtr">
						<td><s:textfield cssClass="form-control" name="cthd.gia"
								label="Gia" /></td>
					</tr>
				</table>
				<s:submit id="btn" cssClass="btn btn-success" value="Add san pham"></s:submit>
			</s:form>
			<s:form action="seCTHD" method="post">
				<s:submit value="Xem chi tiet hoa don" cssClass="btn btn-primary"></s:submit>
			</s:form>
		</div>
	</div>
</body>
</html>