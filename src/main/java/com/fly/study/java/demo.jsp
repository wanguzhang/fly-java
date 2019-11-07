<%@ page language="java" contentType="texthtml; charset=utf-8"
         pageEncoding="utf-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"></meta>
        <title>Insert title here</title>
    </head>
    <body>
        <%
            String username = "zhangsan";
            int password = 123;

            try {
                // String sql="select * from login where Snumber='"+username+"' and Spassword='"+ password + "';";
                Class.forName("com.mysql.cj.jdbc.Driver"); ////驱动程序名
                String url = "jdbc:mysql://localhost:3306/haha?autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&serverTimezone=GMT%2B8&waitTimeout=10"; //数据库名
                String name = "root";
                String pass = "wang0110";  //数据库用户密码
                Connection conn = DriverManager.getConnection(url, name, pass);  //连接状态

                if(conn != null){
                    Statement stmt = null;
                    ResultSet rs = null;
                    String sql = "select * from user where username='"+username+"' and password='"+ password + "'";  //查询语句
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery(sql);

                    if(rs.next()) {
                        request.getRequestDispatcher("home.jsp").forward(request,response);
                    }
                    else{
                        request.getRequestDispatcher("denglu2.jsp").forward(request,response);
                    }
                }

            }catch (Exception e) {
                e.printStackTrace();
            }
        %>

    </body>
</html>