package com.sam;

import com.google.common.base.CaseFormat;
import com.google.common.base.Joiner;
import com.google.common.io.BaseEncoding;
import com.sam.dao.UserMapper;
import com.sam.database.seeds.DbSeed;
import com.sam.entity.User;
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
    void iSeed() throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {


        //初始化模板引擎
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();
        //获取模板文件
        Template t = ve.getTemplate("seed.vm");
        //设置变量
        VelocityContext ctx = new VelocityContext();
        ctx.put("entityName","User");
        List<User> users = userMapper.selectList(null);
        ctx.put("name","sam");
        ctx.put("lists",users);



        //System.out.println(rootPath);


        //List<User> users = userMapper.selectList(null);
        User user0 = users.get(0);

        //序列化方式实现 可读性不好 pass
        //byte[] bytes = SerializationUtils.serialize(user0);
        //String encodeStr = BaseEncoding.base64().encode(bytes);
        //System.out.println("序列化后base64encode："+encodeStr);
        //byte[] decodeBytes = BaseEncoding.base64().decode(encodeStr);
        //Object deserialize = SerializationUtils.deserialize(decodeBytes);
        //System.out.println("base64decode后反序列化："+deserialize);


        Class user0Class = user0.getClass();
        Constructor[] cons = user0Class.getDeclaredConstructors();
        Constructor con = cons[1];//取其有参构造
        Class[] parameterTypes = con.getParameterTypes(); //构造方法参数集但是 数组类型显示特殊
        Parameter[] parameters = con.getParameters();

        List<String> parameterList = new ArrayList<>();
        for (Parameter parameter : parameters
        ) {

            //HashMap<String, String> stringStringHashMap = new HashMap<>();
            //stringStringHashMap.put(parameter.getName(),parameter.getType().toString());
            //parameterList.add( stringStringHashMap);

            parameterList.add( parameter.getName());
            System.out.println("get" + CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, parameter.getName()) + ",");
        }
        System.out.println(parameterList);
        Joiner joiner = Joiner.on(",").skipNulls();
        String parameterString = joiner.join(parameterList);


        System.out.println(parameters.length);
        //int length = parameterTypes.length;
        System.out.println("#################");
        //System.out.println(parameterTypes[0]);
        //System.out.println(parameterTypes[1]);
        //System.out.println(parameterTypes[2]);
        //System.out.println(parameterTypes[3]);
        //System.out.println(parameterTypes[4]);
        Object newUser = con.newInstance(user0.getId(), user0.getName(), user0.getAge(), user0.getCreatedAt(), user0.getUpdatedAt());
        System.out.println((User) newUser);

        Field[] fields = user0Class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field.getName());
            //Object obj = c.newInstance();
            //System.out.println(field.get(user0));
        }


        //c.getDeclaredConstructor();
        //c.getConstructor();

        //Constructor constructor = c.getConstructor();


        //constructor.newInstance()


        //String serialize = SerializeUtils.serialize(user0);
        //System.out.println(serialize);
        //Object o = SerializeUtils.serializeToObject(serialize);
        //System.out.println((User)o);
        //System.out.println(SerializeUtils.serialize(user0));

        //merge(t,ctx,rootPath+"/java/com/sam/database/seeds/UsersTableSeeder.java");

        //System.out.println(sw.toString());

        ctx.put("parameterString",parameterString);
        ctx.put("parameterList",parameterList);
        ctx.put("parameterListLength",parameterList.size());
        StringWriter sw = new StringWriter();
        t.merge(ctx,sw);

        //
        String rootPath = this.getClass().getClassLoader().getResource("").getFile() + "../../src/main";
        merge(t,ctx,rootPath+"/java/com/sam/database/seeds/User2TableSeeder.java");
        System.out.println("generate seed file success");



    }

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


    //@Test
    //void up() {
    //    dbSeed.up();
    //}
    //
    //
    //@Test
    //void down() {
    //    dbSeed.down();
    //}
    //
    //@Test
    //void truncate() {
    //    userMapper.truncate();
    //}
}
