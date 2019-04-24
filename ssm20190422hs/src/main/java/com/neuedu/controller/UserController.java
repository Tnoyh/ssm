package com.neuedu.controller;

import com.github.pagehelper.PageInfo;
import com.neuedu.entity.User;
import com.neuedu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("user")//加的一个前缀
@SessionAttributes("uname")
public class UserController {

    @Autowired
    private IUserService userService;


    /*@Autowired
    private HttpServletRequest request;*/


/*
*  分页的时候
*    pageNum num可能没有传入值，使用默认值：@RequestParam(required = false,defaultValue = "1")
*
 * */
    @GetMapping("list")
    public String list(@RequestParam(required = false,defaultValue = "1") int pageNum,
                       @RequestParam(required = false,defaultValue = "3")int num,
                       ModelMap modelMap){
        /*提取数据 以前getVipAll里面的数据是写死的，现在设置了两个参数
        * 这两个参数由用户来传，如果不传则按照默认设置
        * */
        PageInfo<User> lists=userService.getVipAll(pageNum,num);
        List<User> listuser=lists.getList();

        //分页的时候我不传数据了  把pages这整个页面都传过来
        modelMap.put("pages",lists);

          return "userlist";
    }

    @GetMapping("addlist")
    public String addlist(){
        return "useradd";
    }

    @PostMapping("add")
    public String add(User user){
        user.setUlevel(1);
        System.out.println(user);
        userService.add(user);
        return "redirect:list.do";
    }


    /*用户名的验证
     *   返回类型：String  {"flag":true}  （返回的json对象属于String类型 判断flag返回的是true还是false）
     * */

    @PostMapping("checkName")
    @ResponseBody
    //传的uname参数为useradd.jsp里ajax里面data里的uname
    public String checkName(String uname){
        List<User> userList=userService.getAll();
        boolean flag=true;//为true表示此用户名可用，false不可以
        for (User user:userList
             ) {
            if (uname.equals(user.getUname())){
                flag=false;
                break;//因为已经比较出结果了，所有我就中断
            }
        }

        String jsonString="{\"flag\":"+flag+"}";
        System.out.println(jsonString);//无论他是真值还是假值都给他进行一下输出

        return jsonString;//因为返回的是json对象，所以注解加一个ResponseBody

    }


    /*删除*/
    @GetMapping("/{id}/delete")
    public String deleteById(@PathVariable("id") Integer uid){
        userService.delete(uid);
        return "redirect:/user/list.do";
    }


    /*
     * Session设置：
     *   1：使用HttpServletRequest对象完成
     * */
    /*@PostMapping("login")
    public String login(String username,String password,String ifsave){
        //现在要进行username和password的一个判断，判断我是不是这个用户，然后才看是否进行登陆
        //看IUserDAO里面有没有这个功能，没有的话进行添加
        boolean flag=userService.checklogin(username,password);
        if(flag){

            //把session加入
            HttpSession session=request.getSession();
            session.setAttribute("username",username);//把后边的值直接赋给前面

            return "redirect:/user/list.do";
        }else{
            return "redirect:/user/loginjsp.do";
        }
    }*/

    @GetMapping("loginjsp")
    public String loginjsp(){
        return "login";
    }


    //使用HttpServletRequest第二种写法，直接在参数里写HttpSession
    @PostMapping("login")
    public String login(String username,String password,String ifsave,HttpSession session){
        boolean flag=userService.checklogin(username,password);
        if(flag){
            session.setAttribute("username",username);
            return "redirect:/user/list.do";
        }else{
            return "redirect:/user/loginjsp.do";
            //通过@GetMapping("loginjsp")返回到login页面
        }
    }


    /*
     *   2：使用SpringMVC提供
     *      使用mvc模式 为了跟HttpServletRequest对象进行区分使用uname 不用username了
     * */
   /* @PostMapping("login")
    public String login(String username,
                        String password,
                        String ifsave,
                        Model model){
        boolean flag=userService.checklogin(username,password);
        if(flag){

          //使用model进行赋值 把username的值赋给unme
          //通过Attribute给他把这个值传到最上边@SessionAttributes("uname")处
           model.addAttribute("uname",username);
            return "redirect:/user/list.do";
        }else{
            return "redirect:/user/loinjsp.do";
        }
    }*/


   //把session里的值提取出来
    @GetMapping("getSession")
    //可以通过ModelAttribute这个注解给他把session里的值提取出来
    //把前一个uname 放到后边String定义的name里面
    public String getSessionValue(@ModelAttribute("uname")String name){
        System.out.println(name);//现在要进行输出的话，这个name值就是从session里面得到的值
        return "redirect:/user/list.do";//给他进行一个测试，给他返回到list页面
    }
}
