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
		//�����ļ��������
				DiskFileItemFactory factory = new DiskFileItemFactory();
				//�������ڽ����������ݵ����
				ServletFileUpload upload = new ServletFileUpload(factory);
				
				try {
					//��ʼ��������
					List<FileItem> list = upload.parseRequest(request);
					
					for (int i = 0; i < list.size(); i++) {
						//���б��б���ÿ���ļ���
						FileItem item = list.get(i);
						//�жϸ��ļ����Ƿ�Ϊ���ֶ�
						if(item.isFormField())
						{
							//�ж��Ƿ���ָ�����ֶ�
							if("description".equals(item.getFieldName())){
								System.out.println(new String(item.getString().getBytes("iso-8859-1"),"utf-8"));
							}
						}
						else
						{
							//�����ļ�
							String fileName = item.getName();
							System.out.println(fileName);
							//��ȡ�ļ���չ��
							String extName = fileName.substring(fileName.lastIndexOf("."));
							System.out.println(extName);
							//����UUID��Ϊ�ļ���
							String newName = UUID.randomUUID().toString();
							
							//��ȡ���������Զ���Ĵ���ļ���Ŀ¼
							String rootPath = request.getServletContext().getRealPath("/upload");
							
							String newPath = rootPath+"/"+newName+extName;
							System.out.println(newPath);
							//д���ļ�
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
