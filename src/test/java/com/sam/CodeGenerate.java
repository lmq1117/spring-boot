package com.sam;

import com.sam.dao.UserMapper;
import com.sam.database.seeds.DbSeed;
import com.sam.entity.User;
import com.sam.service.HelloService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;


//代码自动生成器
//@SpringBootTest
//@RunWith(SpringRunner.class)
@Service
public class CodeGenerate {
    private static List<String> ops = Arrays.asList("seed","truncate","generateCode");

    @Autowired
    static UserMapper userMapper;



    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
        //userMapper.insert(new User("小花mm",25));


        run.close();



        //String op = scanner("操作名,"+ ops.toString());

        /*

        //switch (op){
        //    case "seed":
        //        String tableName = scanner("表名");
        //        new UserTableSeeder().seed();
        //        System.out.println("你是要填充数据");
        //        break;
        //    case "truncate":
        //        System.out.println("你是想清空数据");
        //        break;
        //    default:
        //        System.out.println("少年,请检查操作类型,Bye");
        //}
        //if(op == "generateCode"){
            //构建代码生成器对象
            AutoGenerator mpg = new AutoGenerator();

            //配置策略
            // 1 全局配置
            GlobalConfig gc = new GlobalConfig();
            String projectPath = System.getProperty("user.dir");
            System.out.println("======="+projectPath);
            gc.setOutputDir(projectPath+"/src/main/java");
            gc.setAuthor("sam");
            gc.setOpen(false);
            gc.setFileOverride(false);//是否覆盖
            gc.setServiceName("%sService");//通过正则表达式去掉service 的interface的i前缀
            gc.setIdType(IdType.AUTO);
            gc.setDateType(DateType.ONLY_DATE);
            //gc.setSwagger2(true);

            mpg.setGlobalConfig(gc);


            //设置数据源
            DataSourceConfig dsc = new DataSourceConfig();
            dsc.setUrl("jdbc:mysql://122.51.104.146:3307/mh?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8&useSSL=false");
            dsc.setDriverName("com.mysql.cj.jdbc.Driver");
            dsc.setUsername("root");
            dsc.setPassword("root");
            dsc.setDbType(DbType.MYSQL);

            mpg.setDataSource(dsc);

            //包的配置
            PackageConfig pc = new PackageConfig();
            //pc.setModuleName("blog");
            pc.setModuleName(scanner("模块名"));

            pc.setParent("com.sam");
            pc.setEntity("entity");
            pc.setMapper("mapper");
            pc.setService("service");
            pc.setController("controller");
            mpg.setPackageInfo(pc);

            //策略配置
            StrategyConfig strategy = new StrategyConfig();
            //strategy.setInclude("user");//设置要映射的表
            strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
            strategy.setNaming(NamingStrategy.underline_to_camel);//下划线转驼峰
            strategy.setColumnNaming(NamingStrategy.underline_to_camel);//下划线转驼峰
            //strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
            strategy.setEntityLombokModel(true);
            //strategy.setRestControllerStyle(true);
            //strategy.setLogicDeleteFieldName("deleted");


            //自动填充
            TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);
            TableFill gmtModified = new TableFill("gmt_modified", FieldFill.INSERT_UPDATE);
            ArrayList<TableFill> tableFills = new ArrayList<>();
            tableFills.add(gmtCreate);
            tableFills.add(gmtModified);

            //设置自动填充
            //strategy.setTableFillList(tableFills);

            //乐观锁
            //strategy.setVersionFieldName("version");

            //
            //strategy.setRestControllerStyle(true);

            //strategy.setControllerMappingHyphenStyle(true);//http://localhost:8008/hello_id_2

            mpg.setStrategy(strategy);


            //执行
            mpg.execute();
        //}

         */







    }


    //@Test
    //void sout(){
    //    System.out.println("#######sdafd####");
    //}




    //public static String scanner(String tip) {
    //    Scanner scanner = new Scanner(System.in);
    //    StringBuilder help = new StringBuilder();
    //    help.append("请输入" + tip + "：");
    //    System.out.println(help.toString());
    //    if (scanner.hasNext()) {
    //        String ipt = scanner.next();
    //        if (StringUtils.isNotEmpty(ipt)) {
    //            return ipt;
    //        }
    //    }
    //    throw new MybatisPlusException("请输入正确的" + tip + "！");
    //}
}
