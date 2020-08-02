package onlineShop.log;

import java.math.BigDecimal;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Applications {

	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("payment.xml");
		PaymentAction paymentAction = (PaymentAction) container.getBean("paymentAction");
		paymentAction.pay(new BigDecimal(2));
	}

}
