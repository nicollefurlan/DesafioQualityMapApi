package br.com.nfsb.suite.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import br.com.nfsb.rest.tests.CasesTestLogin;
import br.com.nfsb.rest.tests.CasesTestUsers;

@RunWith(org.junit.runners.Suite.class)
@SuiteClasses({
	CasesTestLogin.class,
	CasesTestUsers.class
})

public class SuiteTest {
	
}
