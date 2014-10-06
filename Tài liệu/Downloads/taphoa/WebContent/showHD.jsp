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
	<table border="1">
		<tr>
			<th>IDhoadon</th>
			<th>IDchitiet</th>
			<th>Ngay Ban</th>
			<th>Tong Tien</th>
		</tr>
		<s:iterator value="listhd" status="groupStatus">
			<tr
				class="<s:if test="#groupStatus.odd == true ">odd</s:if><s:else>even</s:else>">
				<td><s:property value="idhd" /></td>
				<td><s:property value="idct" /></td>
				<td><s:property value="ngay" /></td>
				<td><s:property value="tongtien" /></td>
				<td><s:url var="testUrlId" action="upHD">
						<s:param name="id">
							<s:property value="idhd" />
						</s:param>
					</s:url> <s:a errorText="Sorry your request had an error."
						preInvokeJS="confirm('Are you sure you want to delete this item?')"
						href="%{testUrlId}">Update
					</s:a></td>
				<td><s:url var="UrlId" action="deHD">
						<s:param name="idHD">
							<s:property value="idhd" />
						</s:param>
					</s:url> <s:a errorText="Sorry your request had an error."
						preInvokeJS="confirm('Are you sure you want to delete this item?')"
						href="%{UrlId}">Update
					</s:a></td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>