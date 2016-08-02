<%-- 
    Document   : upload
    Created on : Nov 14, 2015, 3:54:39 AM
    Author     : Subramanyam
--%>
<%-- <%@page import="com.oracle.webservices.api.message.ContentType"%> --%>
<%@page import="java.io.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload</title>
    </head>
    <body>
        <h1>Upload</h1>
        <form name="Uploader" action="#" method="POST" enctype="multipart/form-data">
            <%
            String file = new String();
            String content = request.getContentType();
            
            if((content != null) && (content.indexOf("multipart/form-data") >= 0)){
                DataInputStream is = new DataInputStream(request.getInputStream());
                
                int length = request.getContentLength();
                byte data[] = new byte[length];
                int byteRead = 0;
                int totalbytes = 0;
                
                while(totalbytes < length){
                    byteRead = is.read(data, totalbytes, length);
                    totalbytes += byteRead;
                }
                String ufile = new String(data);
                file = ufile.substring(ufile.indexOf("filename=\"") + 10);
                file = file.substring(0 , file.indexOf("\n"));
                file = file.substring(file.lastIndexOf("\\") + 1, file.indexOf("\""));
                
                int lastIndex = content.lastIndexOf("=");
                String boundary = content.substring(lastIndex + 1, content.length());
                
                int position;
                
                position = ufile.indexOf("filename\"");
                position = ufile.indexOf("\n", position) + 1;
                position = ufile.indexOf("\n", position) + 1;
                position = ufile.indexOf("\n", position) + 1;
                
                int bloc = ufile.indexOf(boundary, position) - 4;
                int sPosition = ((ufile.substring(0, position)).getBytes()).length;
                int ePosition = ((ufile.substring(0, bloc)).getBytes()).length;
                  file = "c:/test/" + file;
                
                File uf = new File(file);
                try{
                    System.out.println(uf);
                    FileOutputStream fo = new FileOutputStream(uf);
                    fo.write(data, sPosition, (ePosition - sPosition));
                    fo.flush();
                    fo.close();
                } catch (Exception e){
                    out.println(e);
                }
            }
            %>
            <input type="file" name="choose" value="" width="100" />
            <input type="submit" value="submit" name="submit" />
        </form>
    </body>
</html>
