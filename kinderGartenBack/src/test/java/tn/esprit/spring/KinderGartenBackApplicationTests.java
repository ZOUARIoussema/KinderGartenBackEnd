package tn.esprit.spring;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;

//import org.junit.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entity.*;
import tn.esprit.spring.service.interfaceS.ISubscriptionChildService;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class KinderGartenBackApplicationTests {

	@Autowired
	ISubscriptionChildService SubscriptionChildS;

	/*** Senario 1 subscription child sans extra ***/

	/*@Test
	public void addSubscriptionChild() {

		// create child

		Child child = new Child();

		child.setId(1);
		child.setAge(5);
		child.setName("oussema");

		// create category subscrption

		CategorySubscription categorySubscription = new CategorySubscription();

		categorySubscription.setId(1);
		categorySubscription.setDescription("full day");
		categorySubscription.setPrice(150);

		// create subscriptionChild

		SubscriptionChild subscriptionChild = new SubscriptionChild();
		subscriptionChild.setCategorySubscription(categorySubscription);
		subscriptionChild.setChild(child);
		subscriptionChild.setDateC(new Date());
		subscriptionChild.setChild(child);

		double total = SubscriptionChildS.addSubscriptionChild(subscriptionChild).getTotal();

		assertTrue(150 == total);

	}*/

	/*** Senario 2 susbscription child avec extrat ****/
/*
	@Test
	public void addSubscriptionChildWithExtra() {

		// create child

		Child child = new Child();

		child.setId(1);
		child.setAge(5);
		child.setName("oussema");

		// create category subscrption

		CategorySubscription categorySubscription = new CategorySubscription();

		categorySubscription.setId(1);
		categorySubscription.setDescription("full day");
		categorySubscription.setPrice(150);

		// create subscriptionChild

		SubscriptionChild subscriptionChild = new SubscriptionChild();
		subscriptionChild.setCategorySubscription(categorySubscription);
		subscriptionChild.setChild(child);
		subscriptionChild.setDateC(new Date());
		subscriptionChild.setChild(child);

		

		// create extra

		Extra extra1 = new Extra();
		extra1.setDescription("tennis");
		extra1.setId(2);
		extra1.setPrice(50);

		Extra extra2 = new Extra();
		extra2.setDescription("swimming pool");
		extra2.setId(1);
		extra2.setPrice(50);

		// add extra
		subscriptionChild.getLisExtras().add(extra1);
		subscriptionChild.getLisExtras().add(extra2);

		double totalWithExtra = SubscriptionChildS.addSubscriptionChild(subscriptionChild).getTotal();

		assertTrue(250 == totalWithExtra);

	}
*/
}
