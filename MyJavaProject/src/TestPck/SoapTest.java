package TestPck;

import java.io.IOException;
import org.testng.annotations.Test;

import org.apache.xmlbeans.XmlException;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.support.SoapUIException;
public class SoapTest {
	@Test
	public void Test() throws XmlException, IOException, SoapUIException
	{
		WsdlProject project=new WsdlProject("D:\\SOAPUI\\EmployeeDemo-soapui-project.xml");
		//WsdlTestSuite testsuite=project.getTestSuiteByName("Employee");
		int totalsuites=project.getTestSuiteCount();
		System.out.println("________________________________Total Suites__________"+totalsuites);
				
		for(int j=0;j<project.getTestSuiteCount();j++)
		{
		System.out.println("Test Suite started *****************      "+project.getTestSuiteAt(j).getName());		
		WsdlTestSuite testsuite=project.getTestSuiteAt(j);
		for(int i=0;i<testsuite.getTestCaseCount();i++)
		{
		System.out.println("---------------------------------------------------------------------");
		WsdlTestCase testcase=testsuite.getTestCaseAt(i);
		TestRunner runner=testcase.run(new PropertiesMap(), false);
		//Assert.assertEquals(com.eviware.soapui.model.testsuite.TestRunner.Status.FINISHED, runner.getStatus());
		
		}
		}
		
	}
}
