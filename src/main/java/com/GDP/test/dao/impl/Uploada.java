//package com.GDP.test.dao.impl;
//
//import java.io.DataInputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Servlet implementation class Uploada
// */
//public class Uploada extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public Uploada() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		
//		
//		
//		 try (PrintWriter out = response.getWriter()) {
//	            /* TODO output your page here. You may use following sample code. */
//	            
//	            String file = new String();
//	            String content = request.getContentType();
//	            
//	            if((content != null) && (content.indexOf("multipart/form-data") >= 0)){
//	                DataInputStream is = new DataInputStream(request.getInputStream());
//	                
//	                int length = request.getContentLength();
//	                byte data[] = new byte[length];
//	                int byteRead = 0;
//	                int totalbytes = 0;
//	                
//	                while(totalbytes < length){
//	                    byteRead = is.read(data, totalbytes, length);
//	                    totalbytes += byteRead;
//	                }
//	                String ufile = new String(data);	                	                
//	                file = ufile.substring(ufile.indexOf("filename=\"") + 10);
//	                file = file.substring(0 , file.indexOf("\n"));
//	                file = file.substring(file.lastIndexOf("\\") + 1, file.indexOf("\""));
//	                
//	                int lastIndex = content.lastIndexOf("=");
//	                String boundary = content.substring(lastIndex + 1, content.length());
//	                
//	                int position;
//	                	                
//	                
//	                position = ufile.indexOf("filename\"");
//	                position = ufile.indexOf("\n", position) + 1;
//	                position = ufile.indexOf("\n", position) + 1;
//	                position = ufile.indexOf("\n", position) + 1;
//	                
//	                int bloc = ufile.indexOf(boundary, position) - 4;
//	                int sPosition = ((ufile.substring(0, position)).getBytes()).length;
//	                int ePosition = ((ufile.substring(0, bloc)).getBytes()).length;
//	                //file = "c:/test/" + file;
//	                file = "c:/test/" + "sss.docx";	//change your file name here
//	                  
//	                
//	                File uf = new File(file);
//	                try{
//	                   // System.out.println(uf);
//	                    try (FileOutputStream fo = new FileOutputStream(uf)) {
//	                        fo.write(data, sPosition, (ePosition - sPosition));
//	                        fo.flush();
//	                    }
//	                } catch (Exception e){
//	                    out.println(e);
//	                }
//	            }
//	            response.sendRedirect("author.html");
//	        }
//		
//
//
//		
//		
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
