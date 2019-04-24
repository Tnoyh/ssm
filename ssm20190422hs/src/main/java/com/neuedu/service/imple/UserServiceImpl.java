package com.neuedu.service.imple;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neuedu.dao.IUserDAO;
import com.neuedu.entity.User;
import com.neuedu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional//⚠️ 1：可以把它放到类上面进行注解
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDAO userDAO;

    public PageInfo<User> getVipAll(int start,int num) {

        PageHelper.startPage(start,num);
        List<User> userList=userDAO.selectAllByUlevel(1);

        PageInfo<User> userPageInfo=new PageInfo<User>(userList);
       // userPageInfo.setList(userList);
        return userPageInfo;

    }

    public List<User> getAdminAll() {
        return userDAO.selectAllByUlevel(0);
    }

    //⚠️ 2：也可以放在方法上面实现注解f
    @Transactional(propagation= Propagation.REQUIRED)
    public void modify(User user) {

         userDAO.deleteUser(15);//正常
         userDAO.insertUser(user);//错误的
    }

    public void add(User user) {
        userDAO.insertUser(user);
    }

    public List<User> getAll(){
        return userDAO.selectAll();
    }

    public void delete(Integer uid) {
        userDAO.deleteUser(uid);
    }


    public boolean checklogin(String username, String upwd) {
        //因为这儿要返回一个User对象 把username,upwd给他传上去
        User user=userDAO.selectByNamePassword(username,upwd);
        //传上去之后这儿出来的结果我需要进行判断
        if(user==null){
            return false;
        }
        if(user.getUlevel()!=0){
            return false;
        }

        return true;

    }

}
