package cn.controller;

import cn.domain.User;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/fileupload1")
    public String fileupload1(HttpServletRequest request) throws Exception {
        System.out.println("fileupload1方法执行了");

        //使用fileupload组件完成文件上传

        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        // 判断该路径是否存在
        File file = new File(path);

        if (!file.exists()) {
            file.mkdir();
        }

        //解析request对象，获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        //解析request
        List<FileItem> items = upload.parseRequest(request);

        for (FileItem item : items) {
            // 进行判断，当前item对象是否是上传文件项
            if (item.isFormField()) {
                //说明普通表单项
            } else {
                // 说明上传文件项
                // 获取上传文件的名称
                String filename = item.getName();
                // 把文件的名称设置唯一值，uuid
                String uuid = UUID.randomUUID().toString().replace("-", "");
                filename = uuid + filename;
                // 完成文件上传
                item.write(new File(path, filename));
                //删除临时文件
                item.delete();

            }

        }
        return "success";
    }

    /**
     * StringMVC上传
     * @return
     * @throws Exception
     */
    @RequestMapping("/fileupload2")
    public String fileupload2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("fileupload2方法执行了");

        //使用fileupload组件完成文件上传

        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        // 判断该路径是否存在
        File file = new File(path);

        if (!file.exists()) {
            file.mkdir();
        }



        String filename = upload.getOriginalFilename();
        // 说明上传文件项
        // 获取上传文件的名称
        // 把文件的名称设置唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + filename;
        // 完成文件上传
        upload.transferTo(new File(path, filename));


        return "success";
    }

    /**
     * 跨服务器文件上传
     * @return
     * @throws Exception
     */
    @RequestMapping("/fileupload3")
    public String fileupload3(MultipartFile upload) throws Exception {
        System.out.println("fileupload3方法执行了");

        // 定义上传文件服务器
        String path = "http://localhost:9090/fileuploadserver_war/uploads/";
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;

        //完成文件上传，跨服务器上传
        // 创建客户端的对象
        Client client = Client.create();
        // 和图片服务器进行连接
        WebResource webResource = client.resource(path + filename);
        //上传文件
        webResource.put(upload.getBytes());
        // 完成文件上传，跨服务器上传
        return "success";
    }
}
