package com.neuedu.test;

import com.neuedu.pojo.Book02;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:applicationContext02.xml")
public class BookTest02 {

    @Autowired
    private Book02 book02;
    @Test
    public void  book(){
        book02.print();
    }
}
