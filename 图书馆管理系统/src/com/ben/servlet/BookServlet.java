package com.ben.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.ben.base.PageRoll;
import com.ben.dao.factory.DaoFactory;
import com.ben.vo.Book;
import com.ben.vo.Category;




/**
 * Servlet implementation class BookServlet
 */
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BookServlet() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String method = request.getParameter("method");
			if("listImg".equals(method))
			{
				listImg(request,response);
			}
			else if("listRoll".equals(method))
			{
				listRoll(request, response);
			}
			else if("findAll".equals(method))
			{
				findAll(request, response);
			}
			else if("find".equals(method))
			{
				find(request, response);
			}
			else if ("update".equals(method)) {
				update(request, response);
			}
			else if("add".equals(method))
			{
				try {
					add(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if("delete".equals(method))
			{
				delete(request, response);
			}
	}

	private void listImg(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Category> categories = DaoFactory.getCategoryDao().findAllCategory();
			List<Book> books = DaoFactory.getBookDao().findAllBook();
			request.getSession().setAttribute("categories", categories);
			request.getSession().setAttribute("books", books);
			request.getRequestDispatcher("/view/share/page/homepage.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}  catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void listRoll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				String currPage = request.getParameter("currPage");
				
				PageRoll pageRoll = new PageRoll();
				
				if(currPage!=null)
				{
					pageRoll.setCurrPage(Integer.parseInt(currPage));
					
				}
				
				try {
					List<Book> list = DaoFactory.getBookDao().listRoll(pageRoll);
					request.setAttribute("list", list);
					request.setAttribute("pageRoll",pageRoll);
					
					request.getRequestDispatcher("").forward(request, response);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				
	}	

	
	protected void add(HttpServletRequest request, HttpServletResponse response) throws  Exception{
//		String bookCategory = request.getParameter("bookcategory");
//		String bookName = request.getParameter("bookname");
//		Integer bookPrice = Integer.parseInt(request.getParameter("bookprice"));
//		String author = request.getParameter("authorname");
//		String publishingHouse = request.getParameter("publishinghouse");
//		String authorIntro = request.getParameter("authorintro");
//		String bookIntro = request.getParameter("bookintro");
//		Integer bookStock = Integer.parseInt(request.getParameter("bookstock"));
		String bookCategory = null;
		String bookName = null;
		float bookPrice = 0;
		String author = null;
		String publishingHouse = null;
		String authorIntro = null;
		String bookIntro = null;
		Integer bookStock = 0;
		String href = "";
		PrintWriter out = response.getWriter();
		String extName = null;
		String fileName = null;
		FileItem item = null;
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		List<FileItem> list = upload.parseRequest(request);

		for (int i = 0; i < list.size(); i++) {
			item = list.get(i);
			
			
//			if (!ServletFileUpload.isMultipartContent(request)) {
//				return;
//			}
			if(item.isFormField())
			{
				System.out.println(new String(item.getString().getBytes("ISO-8859-1"), "UTF-8"));
				
				if("bookcategory".equals(item.getFieldName())){
					bookCategory = new String(item.getString().getBytes("ISO-8859-1"), "UTF-8");
				}
				if("bookname".equals(item.getFieldName())){
					bookName =  new String(item.getString().getBytes("ISO-8859-1"), "UTF-8");
				}
				 if("bookprice".equals(item.getFieldName())){
					Float price =  Float.parseFloat(new String(item.getString().getBytes("ISO-8859-1"), "UTF-8"));
					bookPrice = price;
				}
				if("authorname".equals(item.getFieldName())){
					author =  new String(item.getString().getBytes("ISO-8859-1"), "UTF-8");
				}
				if("publishinghouse".equals(item.getFieldName())){
					publishingHouse =  new String(item.getString().getBytes("ISO-8859-1"), "UTF-8");
				}
				if("authorintro".equals(item.getFieldName())){
					authorIntro =  new String(item.getString().getBytes("ISO-8859-1"), "UTF-8");
				}
				if("bookintro".equals(item.getFieldName())){
					bookIntro =  new String(item.getString().getBytes("ISO-8859-1"), "UTF-8");
				}
				if("bookstock".equals(item.getFieldName())){
					bookStock =  Integer.parseInt( new String(item.getString().getBytes("ISO-8859-1"), "UTF-8"));
				}
			}
			else
			{
				fileName = item.getName();
//				fileName  = fileName.substring(fileName.lastIndexOf("\\") + 1);
				System.out.println(fileName);
				
				extName = fileName.substring(fileName.lastIndexOf("."));
				System.out.println(extName);
				
				if(extName.equals(".jpg")&&extName.equals(".png"))
				{
					href = request.getContextPath()+"/view/share/book/addbook.jsp";
					out.println("<script language='javascript'>alert('上传必须是.jpg或.png文件');"
					    	+ "window.location.href='"+ href + "';</script>");
				}
//				String path =  request.getServletContext().getRealPath("/img/"+new String(bookCategory.getBytes("iso-8859-1"),"utf-8"));
//				String path = new File("/测试/图书馆管理系统/WebContent/img").getAbsolutePath();
				String path = "F:/javaeeWeb/图书馆管理系统/WebContent/img/"+bookCategory+"/";
//				String path1 = path+"/"+bookCategory;
				
				String newPath = path + fileName;
//				 File   fNew=   new   File(path1,newPath); 
				System.out.println(newPath);
				item.write(new File(newPath));
//				item.write(fNew);
				
			}
			
			
		}
		
		
		int newId;
		int changeId;
		Book book = new Book();
		Category category = DaoFactory.getCategoryDao().findCategoryByName(bookCategory);
		Category category2 = null;
		int categoryId = 0;
		if(category.getCategories()==1)
		{
			newId = category.getCategoriesNumber()+1;
		}
		else
		{
			for(int k=1;k<category.getCategories();k++)
			{
				category2 = DaoFactory.getCategoryDao().findCategoryById(k);
				categoryId += category2.getCategoriesNumber();
			}
			newId = categoryId+category.getCategoriesNumber()+1;
		}
		
		book.setBookNumber(newId);
		book.setBookCategory(bookCategory);
		book.setBookName(bookName);
		book.setBookPrice(bookPrice);
		book.setBookAuthor(author);
		book.setBookPublishingHouse(publishingHouse);
		book.setAuthorIntroduction(authorIntro);
		book.setBookIntroduction(bookIntro);
		book.setBookStock(bookStock);
		book.setBookPath("/img/"+bookCategory+"/"+bookName+extName);
		
		List<Book> books = DaoFactory.getBookDao().findAllBook();
		System.out.println(newId);
		System.out.println(books.size());
		for(int j=books.size()-1;j>=newId-1;j--)
		{
			changeId = j+1+1;
			DaoFactory.getBookDao().addBookNumber(changeId, books.get(j).getBookName());
		}
		
		DaoFactory.getCategoryDao().updateCategoryNumber(category.getCategoriesNumber()+1, category.getCategoriesName());
		DaoFactory.getBookDao().saveBook(book);
		href = request.getContextPath()+"/view/share/book/addbook.jsp";
		out.println("<script language='javascript'>alert('上传成功');"
		    	+ "window.location.href='"+ href + "';</script>");
	
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	}
	protected void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	}
	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
	}
	

}
