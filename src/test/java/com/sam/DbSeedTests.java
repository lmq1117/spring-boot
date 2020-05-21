package com.sam;

import com.google.common.base.CaseFormat;
import com.google.common.base.Joiner;
import com.google.common.io.BaseEncoding;
import com.sam.dao.UserMapper;
import com.sam.database.seeds.DbSeed;
import com.sam.entity.User;
import com.sam.service.HelloService;
import com.sam.utils.SerializeUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.*;
import java.util.*;
import java.util.jar.JarOutputStream;

import org.apache.commons.lang3.SerializationUtils;


@SpringBootTest
@RunWith(SpringRunner.class)
class DbSeedTests {
    @Autowired
    DbSeed dbSeed;


    @Autowired
    UserMapper userMapper;

    @Autowired
    HelloService helloService;


    //@Test
    void reflect() {
        List<User> users = userMapper.selectList(null);
        User user0 = users.get(0);

        Class user0Class = user0.getClass();
        Constructor[] cons = user0Class.getDeclaredConstructors();
        System.out.println("类User的构造方法包括: ");
        for (int i = 0; i < cons.length; i++) {
            Constructor con = cons[i]; //取出第i个构造方法。
            System.out.print(Modifier.toString(con.getModifiers()));
            //---- 打印该构造方法的前缀修饰符
            System.out.print(" " + con.getName() + "##("); //打印该构造方法的名字

            //---- 打印该构造方法的参数。
            Class[] parameterTypes = con.getParameterTypes(); //构造方法参数集但是 数组类型显示特殊
            for (int j = 0; j < parameterTypes.length; j++) {
                System.out.print(parameterTypes[j].getName() + ",");
            }
            System.out.println(")");
        }


    }

    @Test
    void iSeed() throws IllegalAccessException {


        //初始化模板引擎
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();
        //获取模板文件
        Template t = ve.getTemplate("seed.vm");
        //设置变量
        VelocityContext ctx = new VelocityContext();
        ctx.put("entityName", "User");
        List<User> users = userMapper.selectList(null);
        ctx.put("name", "sam");
        ctx.put("lists", users);

        //根据查询结果生成new Entity全参构造函数语句
        List<String> parameterList = new ArrayList<>();
        for (User user : users) {
            StringBuilder stringBuilder = new StringBuilder("new User(");
            Field[] declaredFields = user.getClass().getDeclaredFields();
            for (int i = 0; i < declaredFields.length; i++) {
                declaredFields[i].setAccessible(true);
                //给字符类型的字段加上""
                if (declaredFields[i].getType().toString().endsWith("String")) {
                    stringBuilder.append("\"");
                    stringBuilder.append(declaredFields[i].get(user));
                    stringBuilder.append("\"");
                    if (i < declaredFields.length - 1) {
                        stringBuilder.append(",");
                    }
                } else {
                    stringBuilder.append(declaredFields[i].get(user));
                    if (i < declaredFields.length - 1) {
                        stringBuilder.append(",");
                    }
                }


            }
            stringBuilder.append(")");
            parameterList.add(stringBuilder.toString());
        }




        ctx.put("parameterList", parameterList);
        StringWriter sw = new StringWriter();
        t.merge(ctx, sw);

        String rootPath = this.getClass().getClassLoader().getResource("").getFile() + "../../src/main";
        merge(t, ctx, rootPath + "/java/com/sam/database/seeds/UserTableSeeder.java");
        System.out.println("generate seed file success");


    }

    //private List<T> List<String> generateNewConstruct(){
    //
    //}

    private void merge(Template template, VelocityContext ctx, String path) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(path);
            template.merge(ctx, writer);
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }


    @Test
    void up() {
        dbSeed.up();
    }


    @Test
    void down() {
        dbSeed.down();
    }

    @Test
    void truncate() {
        userMapper.truncate();
    }

    @Test
    void hello() {
        helloService.hello();
    }
}
