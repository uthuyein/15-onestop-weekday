package com.jdc.mkt.test;

import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Account;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class SynchronizedTest {

	EntityManagerFactory emf;

	@Test
	void test() {
		emf = Persistence.createEntityManagerFactory("synchronized");
		Thread operationOne = threadOne(5000.00);
		Thread operationTwo = threadTwo(5000.00);

		operationOne.start();
		operationTwo.start();

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private Thread threadOne(double amount) {
		return new Thread(() -> {
			var em = emf.createEntityManager();
			var account = em.find(Account.class, 1);
			
			try {
				em.getTransaction().begin();

				System.out.println("=============     Before  Update Operation One     =========");
				System.out.println("=============     Balance(::: Ope One :::)" + account.getBalance() + "     =========");

				Thread.sleep(800);

				em.refresh(account);
				account.setBalance(account.getBalance() - amount);
				em.flush();

				System.out.println("=============     After  Update Operation One     =========");
				System.out.println("=============     Balance(::: Ope One :::)" + account.getBalance() + "     =========");

				em.getTransaction().commit();
				em.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	private Thread threadTwo(double amount) {
		return new Thread(() -> {
			var em = emf.createEntityManager();
			var account = em.find(Account.class, 1);
			
			try {
				em.getTransaction().begin();

				System.out.println("=============     Before  Update Operation Two     =========");
				System.out.println("=============     Balance(::: Ope Two :::)" + account.getBalance() + "     =========");

				Thread.sleep(500);

				em.refresh(account);
				account.setBalance(account.getBalance() + amount);
				em.flush();

				System.out.println("=============     After  Update Operation Two     =========");
				System.out.println("=============     Balance(::: Ope Two :::)" + account.getBalance() + "     =========");

				em.getTransaction().commit();
				em.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

}
