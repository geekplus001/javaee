package upload;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet
 */
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UploadServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//创建文件项工厂对象
				DiskFileItemFactory factory = new DiskFileItemFactory();
				//创建用于解析请求数据的组件
				ServletFileUpload upload = new ServletFileUpload(factory);
				
				try {
					//开始解析数据
					List<FileItem> list = upload.parseRequest(request);
					
					for (int i = 0; i < list.size(); i++) {
						//从列表中遍历每个文件项
						FileItem item = list.get(i);
						//判断该文件项是否为表单字段
						if(item.isFormField())
						{
							//判断是否是指定表单字段
							if("description".equals(item.getFieldName())){
								System.out.println(new String(item.getString().getBytes("iso-8859-1"),"utf-8"));
							}
						}
						else
						{
							//处理文件
							String fileName = item.getName();
							System.out.println(fileName);
							//截取文件扩展名
							String extName = fileName.substring(fileName.lastIndexOf("."));
							System.out.println(extName);
							//生成UUID作为文件名
							String newName = UUID.randomUUID().toString();
							
							//获取服务器上自定义的存放文件的目录
							String rootPath = request.getServletContext().getRealPath("/upload");
							
							String newPath = rootPath+"/"+newName+extName;
							System.out.println(newPath);
							//写入文件
							item.write(new File(newPath));
						}
					}
				
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
