package com.jdc.mkt.test;

import java.util.Objects;

import org.junit.jupiter.api.Test;

public class Main {

	class Human{
		String name;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + Objects.hash(name);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Human other = (Human) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			return Objects.equals(name, other.name);
		}

		private Main getEnclosingInstance() {
			return Main.this;
		}
		
		
	}
	
	@Test
	void test() {
		var h1 = new Human();
		h1.name = "Andrew";
		
		var h2 = new Human();
		h2.name = "Andrew";
		System.out.println(h1);
		System.out.println(h2);
		System.out.println(h1.equals(h2));
	}
}
