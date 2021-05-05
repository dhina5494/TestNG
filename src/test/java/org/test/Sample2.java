package org.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Sample2 {
	@Test(groups = "smoke")
	public void tc0() {
		System.out.println("Method 1");
	}

	@Test(groups = "sanity")
	public void tc1() {
		System.out.println("Method 2");
	}

	@Test(groups = "reg",dependsOnGroups="sanity")
	public void tc2() {
		
		System.out.println("Method 3");
	}

	@Test(groups = "sanity")
	public void tc3() {
		Assert.assertTrue(false);
		System.out.println("Method 4");
	}

	@Test(groups = "reg",dependsOnGroups="sanity")
	public void tc4() {
		System.out.println("Method 5");
	}

	@Test(groups = "E2E")
	public void tc5() {
		System.out.println("Method ^");

	}

}
