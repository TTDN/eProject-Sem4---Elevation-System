<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Insert Hoa Don</h1>
	<s:form action="inHD" method="post" validate="true">
		<s:textfield label="IDchitiet" name="hd.idct" />
		<s:textfield label="Ngay Ban" name="hd.ngay" />
		<s:textfield label="Tong Tien" name="hd.tongtien" />
		<s:submit value="Add hoa don"></s:submit>
	</s:form>
	<s:form action="showHD" method="post">
		<s:submit value="Xem Hoa Don"></s:submit>
	</s:form>

</body>
</html>