package com.crm.vtiger;

import org.testng.annotations.Test;

public class CreateOrganizationTest {
	@Test(groups={"smoke","regression"})
	public void create() {
		System.out.println("organization is created");
	}
	@Test
	public void createquotation() {
		System.out.println("quotatin is created");
		System.out.println("org modified");
	}

}
