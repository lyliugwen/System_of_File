<%@ page contentType="text/html;charset=gb2312" %>
 <jsp:useBean id="fileBean" type="mybean.data.ReadFile_Bean" scope="request"/>
<!DOCTYPE html>
	<head>
		<meta charset="UTF-8">
		<title>文件读写系统</title>
		<link rel="stylesheet" href="css/stu_style.css">
	</head>
	<body>
		<header>
			<div id="header_logo">
				<img src="image/header_logo.png" alt="header_logo">
				<h1>文件读写系统</h1>
			</div>
			<div id="user_pic">
				<a href=mmManage.jsp><img src="image/tubiao.png" alt="user_pic"></a>
			</div>
		</header>
		<div id="container">
		<nav>
			<ul>
				<li><a  href=mmManage.jsp>密码管理</a></li>
				<li><a  href=ChooseDir.jsp>查看目录</a></li>
				<li id="on_this_page"><a  href=ChooseFile.jsp>读取文件</a></li>
				<li><a  href=writeContent.jsp>新建文件</a></li>
				<li><a  href=DGFile.jsp>修改文件</a></li>
				<li><a  href=Upload.jsp>上传文件</a></li>
				<li><a  href=Download.jsp>下载文件</a></li>
			</ul>
		</nav>
		<section>
<div id="content" >
     <Font size=4>
<% String upload=(String)session.getAttribute("read");
if(upload.equals("yes")){
%>
    文件的位置: 
      <jsp:getProperty name="fileBean" property="filePath"/>,
    文件的名字：
      <jsp:getProperty name="fileBean" property="fileName"/>,
    文件的长度：
      <jsp:getProperty name="fileBean" property="fileLength"/> 字节。
    <br>文件的内容：  <br>
      <TextArea  rows="20" cols="100">
        <jsp:getProperty name="fileBean" property="fileContent"/>
      </TextArea>
<%
}
else{out.println("您无此权限");}
%>
   </div> 
		</section>
		</div>
	</body>
</html>