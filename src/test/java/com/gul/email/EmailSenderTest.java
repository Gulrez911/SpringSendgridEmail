package com.gul.email;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.gul.common.EmailGeneric;
import com.gul.config.JavaConfig;
import com.gul.entity.PropertyConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JavaConfig.class)
@WebAppConfiguration
public class EmailSenderTest {

	@Autowired
	PropertyConfig config;

	@Test
	public void Test() throws InterruptedException, IOException {
		System.out.println("Tests");
		String html = config.getHtmlLocation();
		System.out.println(config.getHtmlLocation());
		@SuppressWarnings("deprecation")
		String htmlPage = FileUtils.readFileToString(new File(html));
		EmailGeneric generic = new EmailGeneric("gulfarooqui1@gmail.com", "This is Test Message", htmlPage,
				config);
		Thread thread = new Thread(generic);
		thread.start();
		Thread.sleep(5000);
	}
}
