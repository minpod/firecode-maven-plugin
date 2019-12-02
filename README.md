# firecode-maven-plugin
#自动生成代码
如果项目结构不够通用欢迎 提建议或自行fork

#三步配置

##1.引入依赖
```
<plugin>
<groupId>com.youzan.beauty.util</groupId>
<artifactId>firecode-maven-plugin</artifactId>
<version>1.0.0-SNAPSHOT</version>
</plugin>
```
##2.在项目resources目录中创建firecode.xml
```
<config>
    <author>菊花</author>
    <basePackage>com.youzan.beauty.spa</basePackage>
    <module>security</module>

    <!--数据库连接参数 目前只支持mysql-->
    <database>jdbc:mysql://10.9.51.13:3008/beauty?useSSL=false</database>
    <user>user_beauty</user>
    <password>i6SXNjDAByLabCdw8GEu</password>

    <!--表-->
    <table>security_code_log</table>
    <!--默认使用表名对应的转换类名,如果需要自定义名字可配置以下两字段-->
    <clazzName>SecurityCode</clazzName>
    <javaName>securityCode</javaName>

    <!--配置所要生成的类,默认为true-->
    <!-- 数据库代码 包括DO,MAPPER,XML-->
    <dal>true</dal>
    <manager>true</manager>
    <service>true</service>
    <!--写操作的参数包装类-->
    <param>true</param>
    <!--读操作的参数包装类-->
    <query>true</query>
    <!--网络传递对象-->
    <dto>true</dto>
    <!--数据库对象与网络传递对象转换工具-->
    <trans>true</trans>
    <!--单元测试代码-->
    <test>true</test>
</config>
```

##3.运行maven插件firecode-maven-plugin:fire

mvn com.youzan.beauty.util:firecode-maven-plugin:1.0.0-SNAPSHOT:fire

###建议直接在maven视频中双击插件直接运行,整体配置如下

![](http://img.yzcdn.cn/upload_files/2017/12/01/FpUo8FLhegciHLuS8prBkMNSlJr6.jpeg)

#视频demo

##密码：youzan

http://v.youku.com/v_show/id_XMzE0NDMyNzUxMg==.html