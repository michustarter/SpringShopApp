package com.capgemini.shop;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.capgemini.shop.intern.services.InternServicesTestSuite;
import com.capgemini.shop.service.ServiceTestSuite;
import com.capgemini.shop.service.facade.FacadeTestSuite;
import com.capgemini.shop.service.rest.RestTestSuite;

@RunWith(Suite.class)
@SuiteClasses({ InternServicesTestSuite.class, ServiceTestSuite.class, FacadeTestSuite.class, RestTestSuite.class })
public class AllTests {

}
