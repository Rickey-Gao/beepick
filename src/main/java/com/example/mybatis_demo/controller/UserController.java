package com.example.mybatis_demo.controller;
import com.example.mybatis_demo.bean.User;
import com.example.mybatis_demo.service.UserService;
import com.example.mybatis_demo.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userservice;


    @RequestMapping("/index")
    public  Object index(){
        return  "部署成功";
    }

    @RequestMapping("/adduser")
    public  Object addUser(
                           @RequestParam (value = "name")String name,
                           @RequestParam (value = "password")String password,
                           @RequestParam (value = "age")String age,
                           @RequestParam (value = "sex")String sex){
        Map<String,Object>map=new HashMap<>();
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        user.setAge(age);
        user.setSex(sex);
        int addcode=userservice.addUser(user);
        if(addcode==1){
            map.put("code",200);
            map.put("msg","添加数据成功");
        }else {
            map.put("code",100);
            map.put("msg","添加数据失败");
        }
        return map;
    }


    @RequestMapping("/getalluser")
    public  Object getAllUser(){
        List<User>data=userservice.getallUser();
        Map<String,Object>map=new HashMap<>();
        if(data!=null&&data.size()>0){
            map.put("code",200);
            map.put("msg","获取数据成功");
            map.put("data",data);
        }else{
            map.put("code",100);
            map.put("msg","暂时没有数据");
        }
        return  map;

    }

    @RequestMapping("/getusetbyid")
    public  Object getUserById(@RequestParam (value = "id") Integer id){
        User user=userservice.getuserbyId(id);
        Map<String,Object>map=new HashMap<>();
        if(user!=null){
            map.put("code",200);
            map.put("msg","获取数据成功");
            map.put("user",user);
        }else{
            map.put("code",100);
            map.put("msg","暂时没有数据");
        }
        return  map;
    }

    @RequestMapping("/updatepassword")
    public  Object updatePassword(@RequestParam(value = "name") String  name,
                                  @RequestParam (value = "password")String password,
                               @RequestParam (value = "newpsw")String newpsw) {
        Map<String, Object> map = new HashMap<>();
        if (TextUtils.Isempty(name) || TextUtils.Isempty(password) || TextUtils.Isempty(newpsw)) {
            map.put("msg", "账号或者密码不能为空");
            map.put("code", 100);
            return map;
        } else {
            if (password.equals(newpsw)) {
                map.put("msg", "新密码和旧密码不能一样");
                map.put("code", 101);
                return map;
            } else {
                String infindpsw = userservice.upDatePassword(name, password, newpsw);
                if (infindpsw.equals("success")) {
                    map.put("msg", "修改密码成功");
                    map.put("code", 200);
                    return map;
                } else if (infindpsw.equals("defeated")) {
                    map.put("msg", "旧密码不对");
                    map.put("code", 102);
                    return map;
                } else if (infindpsw.equals("fail")) {
                    map.put("msg", "不存在该用户");
                    map.put("code", 103);
                    return map;
                } else {
                    map.put("msg", "服务器错误");
                    map.put("code", 104);
                    return map;
                }
            }
        }
    }

     @RequestMapping("/deleteuser")
    public  Object deleteUser(@RequestParam (value = "id")Integer id){
        Map<String,Object>map=new HashMap<>();
        User user=userservice.getuserbyId(id);
        if(user!=null){
            int deletecode=userservice.deleteUser(id);
            if(deletecode==1){
                map.put("code",200);
                map.put("msg","删除数据成功");
            }else {
                map.put("code",100);
                map.put("msg","删除数据失败");
            }
        }else{
            map.put("code",101);
            map.put("msg","不存在该条数据");
        }
        return map;

    }

    /**

     * @return
     * 分页查询用户的数据
     *
     *
     */
    @RequestMapping("/getalluserlinit")
    public  Object getAllUserLinit(@RequestParam (value = "curPage")Integer curPage,
                                   @RequestParam(value = "pageSize")Integer pageSize){
        List<User>data=userservice.getallUserlimit((curPage-1)*pageSize,pageSize);
        Map<String,Object>map=new HashMap<>();
        if(data!=null&&data.size()>0){
            map.put("code",200);
            map.put("msg","获取数据成功");
            map.put("data",data);
        }else{
            map.put("code",100);
            map.put("msg","暂时没有数据");
        }
        return  map;
    }

    /**
     *
     * @param name
     * @return
     * 模糊查询
     *
     *
     */
    @RequestMapping("/getuserlike")
    public   Object getUserLike(@RequestParam(value = "name")String name){
        List<User>data=userservice.getallUserLike(name);
        Map<String,Object>map=new HashMap<>();
        if(data!=null&&data.size()>0){
            map.put("code",200);
            map.put("msg","获取数据成功");
            map.put("data",data);
        }else{
            map.put("code",100);
            map.put("msg","暂时没有数据");
        }
        return  map;

    }

    /***
     *
     * @param name
     * @param sex
     * @return
     *
     *
     *
     *
     */

    @RequestMapping(method = RequestMethod.GET,value = "/getuserByNameAndSex")
    public Object  getuserByNameAndSex(@RequestParam(value = "name")String name,
                                       @RequestParam(value = "sex")String sex){
        System.out.println("name"+name +"sex"+sex);
        Map<String,Object>map=new HashMap<>();
        if(TextUtils.Isempty(name)||TextUtils.Isempty(sex)){
            map.put("code",101);
            map.put("msg","请求参数不能为空");
            return map;
        }else{
            List<User>data=userservice.getUserbyNameAndsex(name,sex);
            if(data!=null&&data.size()>0){
                map.put("code",200);
                map.put("msg","获取数据成功");
                map.put("data",data);
            }else{
                map.put("code",100);
                map.put("msg","暂时没有数据");
            }
            return  map;

        }
    }
    

}
