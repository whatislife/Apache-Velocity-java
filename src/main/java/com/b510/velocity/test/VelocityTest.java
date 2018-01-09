/**
 * 
 */
package com.b510.velocity.test;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import com.b510.velocity.bean.Mail;
import com.b510.velocity.bean.User;

/**
 * 测试类
 * 
 * @author hongten<br>
 * @date 2013-3-9
 */
public class VelocityTest {

	public static final String HELLO_WORLD_VM_PATH = "vms/helloWorld.ftl";//两种方式都可以使用
	public static final String USER_INFO_VM_PATH = "vms/userInfo.vm";
	public static final String EMAIL_TEMPLATE_VM_PATH = "vms/emailTemplate.vm";

	public static void main(String[] args) throws Exception {
		sayHelloFromVM(HELLO_WORLD_VM_PATH);
		testUser(USER_INFO_VM_PATH);
		testEmail(EMAIL_TEMPLATE_VM_PATH);
	}

	/**
	 * 简单的hello world
	 * 
	 * @param fileVM
	 * @throws Exception
	 */
	public static void sayHelloFromVM(String fileVM) throws Exception {
		VelocityEngine ve = new VelocityEngine();
		ve.init();
		Template t = ve.getTemplate(fileVM);
		VelocityContext context = new VelocityContext();
		context.put("hello", "Hello world!!");
		StringWriter writer = new StringWriter();
		t.merge(context, writer);
		System.out.println(writer.toString());
	}

	/**
	 * test User
	 * 
	 * @param fileVM
	 * @throws Exception
	 */
	public static void testUser(String fileVM) throws Exception {
		VelocityEngine ve = new VelocityEngine();
		ve.init();

		Template template = ve.getTemplate(fileVM);
		VelocityContext velocityContext = new VelocityContext();
		User user = new User();
		user.setEmail("hongtenzone@foxmail.com");
		user.setName("hongten");
		user.setBirthday("1990-11-18");
		velocityContext.put("user", user);
		StringWriter stringWriter = new StringWriter();
		template.merge(velocityContext, stringWriter);

		System.out.println(stringWriter.toString());
	}

	/**
	 * test email
	 * 
	 * @param fileVM
	 * @throws Exception
	 */
	public static void testEmail(String fileVM) throws Exception {
		VelocityEngine velocityEngine = new VelocityEngine();
		velocityEngine.init();

		Template template = velocityEngine.getTemplate(fileVM);
		VelocityContext velocityContext = new VelocityContext();
		Mail mail = new Mail();
		mail.setContent("2013年腾讯开发者新扶持政策解读及创业机会所在");
		mail.setReceiverMail("hongtenzone@foxmail.com");
		mail.setReceiverName("Hongten");
		mail.setSenderMail("opensns_noreply@tencent.com");
		mail.setSenderName("腾讯开放平台");
		mail.setSenderWebSite("open.qq.com");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		mail.setDate(simpleDateFormat.format(new Date()));
		velocityContext.put("mail", mail);
		StringWriter stringWriter = new StringWriter();
		template.merge(velocityContext, stringWriter);

		System.out.println(stringWriter.toString());
	}
}
