package in.abc.main;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.abc.controller.CustomerController;
import in.abc.vo.CustomerVo;

public class ClientApp {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the CustomerName :: ");
		String customerName = scanner.next();

		System.out.print("Enter the CustomerAddr :: ");
		String customerAddress = scanner.next();

		System.out.print("Enter the Principal Amount :: ");
		String pAmount = scanner.next();

		System.out.print("Enter the Time period :: ");
		String time = scanner.next();

		System.out.print("Enter the Rate of Interest :: ");
		String rate = scanner.next();

		CustomerVo vo = new CustomerVo();
		vo.setCustomerAddress(customerAddress);
		vo.setCustomerName(customerName);
		vo.setPamt(pAmount);
		vo.setRate(rate);
		vo.setTime(time);

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("in/abc/cfg/applicationContext.xml");
		
		CustomerController controller = applicationContext.getBean("controller", CustomerController.class);
		System.out.println(controller.processResult(vo));
		
		applicationContext.close();
		scanner.close();
	}
}
