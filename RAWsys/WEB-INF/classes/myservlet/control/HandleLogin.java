package myservlet.control;
import mybean.data.Login;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
public class HandleLogin extends HttpServlet{
   public void init(ServletConfig config) throws ServletException{
      super.init(config);
  try{  Class.forName("com.mysql.jdbc.Driver");
     }
     catch(Exception e){} 
   }

public void doPost(HttpServletRequest request,HttpServletResponse response)
               throws ServletException,IOException{
       
             Connection con;
             Statement sql; 
             String idr=request.getParameter("id");
             int id=Integer.parseInt(idr == null || "".equals(idr)?"0":idr);
             String password=request.getParameter("password").trim();
             String people=request.getParameter("people");
             String uri="jdbc:mysql://127.0.0.1/sys?"+"user=root&password=&characterEncoding=gb2312";   
             boolean boo=(id>0)&&(password.length()>0);
if(people.equals("ad")){
if(id==000000&&password.equals("123456")){
RequestDispatcher dispatcher=request.getRequestDispatcher("studentManage");
   dispatcher.forward(request,response);}	
else{
Login loginBean=null;
HttpSession session=request.getSession(true);
loginBean=(Login)session.getAttribute("loginBean");
      if(loginBean==null){
      loginBean=new Login();
      session.setAttribute("loginBean",loginBean);
      loginBean=(Login)session.getAttribute("loginBean");}
String backNews="������ѧ�Ŵ�������벻ƥ��";
loginBean.setBackNews(backNews);}
}

else{
try{
con=DriverManager.getConnection(uri);
String condition="select * from student where s_id="+id+" and s_password='"+password+"'" ;
sql=con.createStatement();
if(boo){
ResultSet rs=sql.executeQuery(condition);
boolean m=rs.next();
if (m==true){
String name=rs.getString(2);

String dir=rs.getString(4);
String read=rs.getString(5);
String creat=rs.getString(6);
String write=rs.getString(7);
String upload=rs.getString(8);
String download=rs.getString(9);
if(name==null||name.length()==0)
{
String backNews="ȡ����";
fail(request,response,id,backNews);}
else{success(request,response,id,name,password,dir,read,creat,write,upload,download);
   RequestDispatcher dispatcher=request.getRequestDispatcher("Welcome.jsp");
   dispatcher.forward(request,response);}
}

else{
Login loginBean=null;
HttpSession session=request.getSession(true);
loginBean=(Login)session.getAttribute("loginBean");
      if(loginBean==null){
      loginBean=new Login();
      session.setAttribute("loginBean",loginBean);
      loginBean=(Login)session.getAttribute("loginBean");}
String backNews="������ѧ�Ŵ�������벻ƥ��";
loginBean.setBackNews(backNews);
}
}
else{
Login loginBean=null;
HttpSession session=request.getSession(true);
loginBean=(Login)session.getAttribute("loginBean");
      if(loginBean==null){
      loginBean=new Login();
      session.setAttribute("loginBean",loginBean);
      loginBean=(Login)session.getAttribute("loginBean");}
String backNews="������ѧ�ź�����";
loginBean.setBackNews(backNews);
}
con.close();
}

catch(SQLException exp){
String backNews=""+exp;
fail(request,response,id,backNews);
}
}
RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
   dispatcher.forward(request,response);
}

   public  void  doGet(HttpServletRequest request,HttpServletResponse response)
           throws ServletException,IOException{
       doPost(request,response);
   }
public void success(HttpServletRequest request,HttpServletResponse response,int id,String name,String password,String dir,String read,String creat,String write,String upload,String download){
Login loginBean=null;
HttpSession session=request.getSession(true);
session.setAttribute("id",id);
session.setAttribute("name",name);
session.setAttribute("password",password);
session.setAttribute("dir",dir);
session.setAttribute("read",read);
session.setAttribute("creat",creat);
session.setAttribute("write",write);
session.setAttribute("upload",upload);
session.setAttribute("download",download);
try{ loginBean=(Login)session.getAttribute("loginBean");
      if(loginBean==null){
      loginBean=new Login();
      session.setAttribute("loginBean",loginBean);
      loginBean=(Login)session.getAttribute("loginBean");


}
}
catch(Exception ee){
loginBean=new Login();
session.setAttribute("loginBean",loginBean);
session.setAttribute("id",id);
session.setAttribute("name","name");
session.setAttribute("password",password);
session.setAttribute("dir",dir);
session.setAttribute("read",read);
session.setAttribute("creat",creat);
session.setAttribute("write",write);
session.setAttribute("upload",upload);
session.setAttribute("download",download);
}
}
public void fail(HttpServletRequest request,HttpServletResponse response,int id,String backNews){
response.setContentType("text/html;charset=gb2312");
try{
PrintWriter out=response.getWriter();
out.println("<html><body>");
out.println("<h2>"+backNews+"</h2>");
out.println("����");
out.println("<a href=index.jsp>�����¼</a>");
out.println("</body></html>");
}
catch(IOException exp){}
}}