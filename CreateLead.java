package week5.day2.assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead extends ProjectSpecificMethod {
@BeforeTest
public void setData() {
excelFilePath="./TestData/TC002.xlsx";
}
	@Test(dataProvider ="Dynamic_Data")
	public void tc01(String username, String password, String companyName,String firstName,String lastName,String firstNameLocal,String departmentName) {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
		WebElement elementDropDown = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select dd = new Select(elementDropDown);
		dd.selectByVisibleText("Cold Call");
		WebElement firstselectedOption = dd.getFirstSelectedOption();
		System.out.println(firstselectedOption.getText());
		List<WebElement> options = dd.getOptions();
		for (int i = 0; i < options.size(); i++) {
			System.out.println(options.get(i).getText());
		}
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys(firstNameLocal);
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys(departmentName);
		driver.findElement(By.id("createLeadForm_description")).sendKeys("dealswithplcandscadaforbms");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("murugappankannappan@gmail.com");
		WebElement elementDropDown1 = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select dd1 = new Select(elementDropDown1);
		dd1.selectByValue("NY");
		WebElement firstSelectedOption = dd1.getFirstSelectedOption();
		System.out.println(firstSelectedOption.getText());
		List<WebElement> options1 = dd1.getOptions();
		for (int j = 0; j < options1.size(); j++) {
			System.out.println(options1.get(j).getText());
		}
		driver.findElement(By.className("smallSubmit")).click();
		System.out.println("The Title is:" + driver.getTitle());
	}

}
