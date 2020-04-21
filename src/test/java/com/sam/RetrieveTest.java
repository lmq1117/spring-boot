package com.sam;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.sam.dao.UserMapper;
import com.sam.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)//可以在spring环境下运行juint测试
@SpringBootTest
class RetrieveTest {
    /*
        selectById
        selectBatchIds
        selectByMap
     */

    @Autowired
    private UserMapper userMapper;

    @Test
    void selectById() {
        User user = userMapper.selectById(1088250446457389058L);
        System.out.println(user);
    }

    @Test
    void selectIds() {
        List<Long> ids = Arrays.asList(1088248166370832385L, 1094590409767661570L);
        List<User> users = userMapper.selectBatchIds(ids);
//        System.out.println(users);
        users.forEach(System.out::println);
    }

    @Test
    void selectByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "王天风");
        map.put("age", 25);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);

    }


    /*
        Mapper ---- 条件构造器 com.baomidou.mybatisplus.core.conditions.AbstractWrapper

            1 QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
            2


        1、名字中包含雨并且年龄小于40
    	name like '%雨%' and age<40


     */
    @Test
    public void selectByWrapper1() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        QueryWrapper<User> query = Wrappers.<User>query();
        queryWrapper.like("name", "雨").lt("age", 40);
        query.like("name", "刘").lt("age", 40);

        List<User> users1 = userMapper.selectList(queryWrapper);
        List<User> users2 = userMapper.selectList(query);
        users1.forEach(System.out::println);
        users2.forEach(System.out::println);

    }

    /*
        2、名字中包含雨年并且龄大于等于20且小于等于40并且email不为空
       name like '%雨%' and age between 20 and 40 and email is not null
     */
    @Test
    public void selectByWrapper2() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.like("name", "雨").between("age", 20, 40).isNotNull("email");
        List<User> users1 = userMapper.selectList(queryWrapper);
        users1.forEach(System.out::println);

    }


    /*
     3、名字为王姓或者年龄大于等于25，按照年龄降序排列，年龄相同按照id升序排列
     name like '王%' or age>=25 order by age desc,id asc
     */
    @Test
    public void selectByWrapper3() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.likeRight("name", "王")
                .or()
                .ge("age", 32)
                .orderByDesc("age")
                .orderByAsc("id")
        ;
        List<User> users1 = userMapper.selectList(queryWrapper);
        users1.forEach(System.out::println);
    }


    /*
    4、创建日期为2019年2月14日并且直属上级为名字为王姓
      date_format(create_time,'%Y-%m-%d')='2019-02-14' and manager_id in (select id from user where name like '王%')

     */
    @Test
    public void selectByWrapper4() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        //queryWrapper.apply("date_format(create_time,'%Y-%m-%d') = {0}","2019-02-14")// 无sql 注入风险
        queryWrapper.apply("date_format(create_time,'%Y-%m-%d') = '2019-02-14' or true or true")//此方式有sql注入风险
                .inSql("manager_id", "select id from user where name like '王%'")
        ;
        List<User> users1 = userMapper.selectList(queryWrapper);
        users1.forEach(System.out::println);
    }

    /*
    5、名字为王姓并且（年龄小于40或邮箱不为空）
    name like '王%' and (age<40 or email is not null)

     */
    @Test
    public void selectByWrapper5() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.likeRight("name", "王")
                .and(wq -> wq.lt("age", 40).or().isNotNull("email"))
        ;
        List<User> users1 = userMapper.selectList(queryWrapper);
        users1.forEach(System.out::println);
    }


    /*
    6、名字为王姓或者（年龄小于40并且年龄大于20并且邮箱不为空）
    name like '王%' or (age<40 and age>20 and email is not null)

     */
    @Test
    public void selectByWrapper6() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.likeRight("name", "王")
                .or(wq -> wq.lt("age", 40).gt("age", 20).isNotNull("email"))
        ;
        List<User> users1 = userMapper.selectList(queryWrapper);
        users1.forEach(System.out::println);
    }


    /*
    7、（年龄小于40或邮箱不为空）并且名字为王姓
    (age<40 or email is not null) and name like '王%'
     */
    @Test
    public void selectByWrapper7() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.nested(wq -> wq.lt("age", 40).or().isNotNull("email"))
                .likeRight("name", "王")
        ;
        List<User> users1 = userMapper.selectList(queryWrapper);
        users1.forEach(System.out::println);
    }


    /*
    8、年龄为30、31、34、35
    age in (30、31、34、35)
     */
    @Test
    public void selectByWrapper8() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.in("age", Arrays.asList(30, 31, 34, 35))
        ;
        List<User> users1 = userMapper.selectList(queryWrapper);
        users1.forEach(System.out::println);
    }

    /*
    9、只返回满足条件的其中一条语句即可
limit 1
     */
    @Test
    public void selectByWrapper9() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.in("age", Arrays.asList(30, 31, 34, 35)).last("limit 1")
        ;
        List<User> users1 = userMapper.selectList(queryWrapper);
        users1.forEach(System.out::println);
    }

    /*
    10、名字中包含雨并且年龄小于40(需求1加强版)
第一种情况：select id,name
	           from user
	           where name like '%雨%' and age<40
第二种情况：select id,name,age,email
	           from user
	           where name like '%雨%' and age<40
     */
    //选择列 select
    @Test
    public void selectByWrapper10() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.select("id", "name")
                .like("name", "雨")
                .lt("age", 40)
        ;
        List<User> users1 = userMapper.selectList(queryWrapper);
        users1.forEach(System.out::println);
    }

    //排除列
    @Test
    public void selectByWrapper102() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.select(User.class, info -> !info.getColumn().equals("create_time") && !info.getColumn().equals("manager_id"))
                .like("name", "雨")
                .lt("age", 40)
        ;
        List<User> users1 = userMapper.selectList(queryWrapper);
        users1.forEach(System.out::println);
    }

    //condition的作用 执行条件
    //设计意图

    @Test
    public void testCondition() {
        String name = "";
        String email = "baomidou";
        condition(name, email);

    }


    private void condition(String name, String email) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //if(StringUtils.isNotEmpty(name)){
        //    queryWrapper.like("name",name);
        //}
        //if(StringUtils.isNotEmpty(email)){
        //    queryWrapper.like("email",email);
        //}
        queryWrapper
                .like(StringUtils.isNotEmpty(name), "name", name)
                .like(StringUtils.isNotEmpty(email), "email", email);
        List<User> users1 = userMapper.selectList(queryWrapper);
        users1.forEach(System.out::println);
    }

    /*
    实体作为条件构造器构造方法的参数
    可继续使用其他构造器 与实体是and关系
     */
    @Test
    public void selectByWrapperEntity(){
        User u = new User();
        u.setName("李艺伟");
        u.setEmail("lyw@baomidou.com");
        u.setAge(28);
        //实体作为条件构造器构造方法的参数
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>(u);
        //可继续使用其他构造器 与实体是and关系
        queryWrapper.eq("manager_id",1088248166370832385L).eq("name","李艺伟");

        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    /*
    allEq

     */
    @Test
    public void selectByWrapperAllEq(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        Map<String,Object> params = new HashMap<>();
        params.put("name","王天风");
        //params.put("age",25);
        params.put("email",null);

        //queryWrapper.allEq(params,false);
        queryWrapper.allEq((k,v)->!k.equals("name"),params);
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    /*
    selectMaps 查询结果丢map里
     */
    @Test
    public void selectByWrapperMaps(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.like("name", "雨").between("age", 20, 40).isNotNull("email").select("id","name");
        List<Map<String,Object>> mapLists = userMapper.selectMaps(queryWrapper);
        mapLists.forEach(System.out::println);
    }
    /*
    selectObjs 查询第一列
     */
    @Test
    public void selectByWrapperObjs(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.like("name", "雨").between("age", 20, 40).isNotNull("email").select("id","name");
        List<Object> mapLists = userMapper.selectObjs(queryWrapper);
        mapLists.forEach(System.out::println);
    }

    /*
    count(1) 总记录数 不要写select字段
     */
    @Test
    public void selectByWrapperCount(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.like("name", "雨").between("age", 20, 40).isNotNull("email");
        Integer count = userMapper.selectCount(queryWrapper);
        System.out.println("总记录数："+count);
    }

    /*
    selectOne
     */
    @Test
    public void selectByWrapperOne(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.like("name","雨").lt("age",40);
        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);
    }

    /*
    lambda条件构造器 好处:防误写
    创建方式 三种
        LambdaQueryWrapper<User> lambda = new QueryWrapper<User>().lambda();
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<User>();
        LambdaQueryWrapper<User> lambdaQuery = Wrappers.<User>lambdaQuery();
     */
    @Test
    public void selectLambda(){
        //LambdaQueryWrapper<User> lambda = new QueryWrapper<User>().lambda();
        //LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<User>();
        LambdaQueryWrapper<User> lambdaQuery = Wrappers.<User>lambdaQuery();
        lambdaQuery.like(User::getName,"雨").le(User::getAge,40);
        List<User> users = userMapper.selectList(lambdaQuery);
        users.forEach(System.out::println);
    }

    /*
    名字王姓 且 （年龄小于40 或者邮箱不为空）
     */
    @Test
    public void selectLambda2(){
        LambdaQueryWrapper<User> lambdaQuery = Wrappers.<User>lambdaQuery();
        lambdaQuery.likeRight(User::getName,"王")
        .and(lqw->lqw.lt(User::getAge,40).or().isNotNull(User::getEmail))
        ;
        List<User> users = userMapper.selectList(lambdaQuery);
        users.forEach(System.out::println);
    }

    /*
    .list public interface ChainQuery<T> extends ChainWrapper<T> {
    default List<T> list() {
        return this.getBaseMapper().selectList(this.getWrapper());
    }
    是调用了selectList  只是换了种写法
     */
    @Test
    public void selectLambda3(){
        List<User> users = new LambdaQueryChainWrapper<User>(userMapper)
                .like(User::getName,"雨")
                .ge(User::getAge,25)
                .list();
        users.forEach(System.out::println);
    }


    /*
    使用自定义查询
     */
    @Test
    public void selectMy(){
        LambdaQueryWrapper<User> lambdaQuery = Wrappers.<User>lambdaQuery();
        lambdaQuery.likeRight(User::getName,"王")
                .and(lqw->lqw.lt(User::getAge,40).or().isNotNull(User::getEmail))
        ;
        List<User> users = userMapper.selectAll(lambdaQuery);
        users.forEach(System.out::println);
    }





}
