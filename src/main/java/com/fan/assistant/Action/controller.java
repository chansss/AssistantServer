package com.fan.assistant.Action;

import com.fan.assistant.Dao.mapper;
import com.fan.assistant.Service.service;
import com.fan.assistant.entity.User;
import com.fan.assistant.entity.goal;
import com.fan.assistant.entity.task;
import com.fan.assistant.entity.task_time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
@Controller
public class controller {
    private mapper mapper;
    private service service;
    @Autowired
    public controller(service service,mapper mapper) {
        this.service = service;this.mapper = mapper;
    }

    @ResponseBody
    @RequestMapping("regin")
    public Map regin(User user)
    {
        HashMap model = new HashMap();
        if(!service.isExist(user.getUser_name()))
        {

            model.put("msg","账号已经存在，请重新注册");
            return model;
        }

//        String trueFileName = null;
//        String trueFileName = null;
//        if (file!=null) {// 判断上传的文件是否为空
//            String path=null;// 文件路径
//            String type=null;// 文件类型
//            String fileName=file.getOriginalFilename();// 文件原名称
//            // 判断文件类型
//            type=fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
//            if (type!=null) {// 判断文件类型是否为空
//                if ("PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
//                    // 项目在容器中实际发布运行的根路径
//                    String realPath=request.getSession().getServletContext().getRealPath("/")+"avators\\";
//                    // 自定义的文件名称
//                    trueFileName=String.valueOf(System.currentTimeMillis())+fileName;
//                    // 设置存放图片文件的路径
//                    path=realPath+/*System.getProperty("file.separator")+*/trueFileName;
//                    System.out.println("上传的文件原名称:"+trueFileName);
//                    System.out.println("存放图片文件的路径:"+path);
//                    // 转存文件到指定的路径
//                    try {
//                        file.transferTo(new File(path));
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("文件成功上传到指定目录下");
//                }else {
//                    model.put("msg","文件不正确，重新上传");
//                    return model;
//                }
//            }else {
//                model.put("msg","文件不是PNG格式，请重新上传");
//                return model;
//            }
//        }else {
//            model.put("msg","头像失败，请重试");
//            return model;
//        }
            user.setRegin_date(getTime());
            user.setAvatar("default");
            mapper.regin(user);
            model.put("success","1");
            return model;
    }


    @ResponseBody
    @RequestMapping("/login")
    public Map login(@RequestParam(name = "user_name") String user_name , @RequestParam(name = "user_pass") String user_pass)
    {
        HashMap model = new HashMap();
        User u = service.login(user_name,user_pass);
        System.out.println(user_name+"   "+user_pass);
        if(u==null)
        {
            model.put("msg","登录失败，请检查用户名和密码");
        }
        else{
            model.put("data",u);
            model.put("msg","ok");
        }
        return model;
    }


    @ResponseBody
    @RequestMapping("/updatePassword")
    public Map UpdatePassword(String user_name,String user_pass,String new_pass)
    {
        HashMap model = new HashMap();
        User u = service.login(user_name,user_pass);
        if(u==null)
        {
            model.put("msg","原密码错误");
        }
        else{
            service.UpdatePassword(user_name,new_pass);
            model.put("msg","ok");
        }
        return model;
    }


    @ResponseBody
    @RequestMapping("/updatePasswordF")
    public Map UpdatePasswordF(String user_name,String new_pass)
    {
        HashMap model = new HashMap();
        service.UpdatePassword(user_name,new_pass);
        model.put("msg","ok");
        return model;
    }


    @ResponseBody
    @RequestMapping("/getQuestion")
    public Map getQuestion(String user_name)
    {
        HashMap model = new HashMap();
        if(service.isExist(user_name))
        {
            model.put("msg","wrong");
        }
        else{
            model.put("msg","ok");
            model.put("data", service.getQuestion(user_name));
        }
        return model;
    }


    @ResponseBody
    @RequestMapping("/addGoal")
    public Map addGoal(goal goal)
    {
        HashMap model = new HashMap();
        mapper.addGoal(goal);
        model.put("msg","ok");
        return model;
    }

    @ResponseBody
    @RequestMapping("/getGoalsByUser_id")
    public Map getGoals(String user_id)
    {
        HashMap model = new HashMap();
        model.put("data",mapper.getGoals(user_id));
        return model;
    }

    @ResponseBody
    @RequestMapping("/deleteGoal")
    public Map deleteGoal(String goal_id)
    {
        HashMap model = new HashMap();
        mapper.deleteGoal(goal_id);
        model.put("msg","ok");
        return model;
    }

    @ResponseBody
    @RequestMapping("/404")
    public Map notFind()
    {
        HashMap model = new HashMap();
        model.put("msg","404找不到");
        return model;
    }

    @ResponseBody
    @RequestMapping("/isExist")
    public Map isExist(String user_name)
    {
        HashMap model = new HashMap();
        if(mapper.isExist(user_name)==null)
        {
            model.put("msg","ok");
        }
        else{
            model.put("msg","no");
        }
        return model;
    }

    @ResponseBody
    @RequestMapping("/500")
    public Map Error()
    {
        HashMap model = new HashMap();
        model.put("msg","500服务器错误");
        return model;
    }

  





    @ResponseBody
    @RequestMapping("/addTask")
    public Map addTask(task task)
    {
        HashMap model = new HashMap();
        mapper.addTask(task);
        model.put("msg","ok");
        return model;
    }

    @ResponseBody
    @RequestMapping("/getTasksByGoal_id")
    public Map getTasks(String goal_id)
    {
        HashMap model = new HashMap();
        model.put("data",mapper.getTasks(goal_id));
        return model;
    }

    @ResponseBody
    @RequestMapping("/deleteTask")
    public Map deleteTask(String task_id)
    {
        HashMap model = new HashMap();
        mapper.deleteTask(task_id);
        model.put("msg","ok");
        return model;
    }


    @ResponseBody
    @RequestMapping("/addTaskTime")
    public Map addTask_Time(task_time taskTime)
    {
        HashMap model = new HashMap();
        mapper.addTask_Time(taskTime);
        model.put("msg","ok");
        return model;
    }

    @ResponseBody
    @RequestMapping("/getTasksTimeByTaskId")
    public Map getTask_Time(String task_id)
    {
        HashMap model = new HashMap();
        model.put("data",mapper.getTask_Time(task_id));
        return model;
    }

    @ResponseBody
    @RequestMapping("/deleteTaskTime")
    public Map deleteTask_Time(String time_id)
    {
        HashMap model = new HashMap();
        mapper.deleteTask_Time(time_id);
        model.put("msg","ok");
        return model;
    }



    private Calendar time()
    {
        return Calendar.getInstance();
    }
    private String getTime(){
        Calendar c = time();
        return c.get(Calendar.YEAR)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.DATE);
    }


}
