package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestOHRM_EditProfile {
	WebDriver driver = null;

	@Given("browser window is open")
	public void browser_window_is_open() {
		System.out.println("Inside Step - browser is open");

		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is : " + projectPath);

		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));

		// driver.manage().window().maximize();
	}

	@Given("user is on OrangeHRM, editting profile page")
	public void user_is_on_orange_hrm_editting_profile_page() throws InterruptedException {
		System.out.println("Inside Step - user is on goolge search page");
		
		// Vao trang Orange HRM
		driver.navigate().to("http://localhost/orangehrm-4.5/symfony/web/index.php/auth/login");
		
		// Dang nhap
		//Nhap tai khoan
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		Thread.sleep(2000);
		//Nhap mat khau
		driver.findElement(By.id("txtPassword")).sendKeys("H@ck321die");
		Thread.sleep(2000);
		// Nhan nut Enter
		driver.findElement(By.id("txtPassword")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		// Vao trang My Info
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
		Thread.sleep(2000);
	}

	@When("user enters new (.*), (.*), (.*)$")
	public void user_enters_a_new_name(String FName, String MName, String LName) throws InterruptedException {
		
		// Nhấn vào nút Edit
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(2000);
		
		// Tìm ô First Name
		String checkFName = driver.findElement(By.name("personal[txtEmpFirstName]")).getAttribute("value");
		// Xóa hết kí tự ở trong
		while(checkFName.length() > 0) {
			driver.findElement(By.name("personal[txtEmpFirstName]")).sendKeys(Keys.BACK_SPACE);
			checkFName = driver.findElement(By.name("personal[txtEmpFirstName]")).getAttribute("value");
		}
		// Điền vào 1 chuối mới
		driver.findElement(By.name("personal[txtEmpFirstName]")).sendKeys(FName);
		Thread.sleep(2000);
		
		// Tương tự với Middle Name và Last Name
		String checkMName = driver.findElement(By.name("personal[txtEmpMiddleName]")).getAttribute("value");
		while(checkMName.length() > 0) {
			driver.findElement(By.name("personal[txtEmpMiddleName]")).sendKeys(Keys.BACK_SPACE);
			checkMName = driver.findElement(By.name("personal[txtEmpMiddleName]")).getAttribute("value");
		}
		driver.findElement(By.name("personal[txtEmpMiddleName]")).sendKeys(MName);
		Thread.sleep(2000);
		
		//Last Name
		String checkLName = driver.findElement(By.name("personal[txtEmpLastName]")).getAttribute("value");
		while(checkLName.length() > 0) {
			driver.findElement(By.name("personal[txtEmpLastName]")).sendKeys(Keys.BACK_SPACE);
			checkLName = driver.findElement(By.name("personal[txtEmpLastName]")).getAttribute("value");
		}
		driver.findElement(By.name("personal[txtEmpLastName]")).sendKeys(LName);
		Thread.sleep(2000);

	}

	@When("hits edit")
	public void hits_edit() throws InterruptedException {
		
		//Nhấn vào nút Save
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(2000);
	}

	@Then("the name is change")
	public void the_name_is_change_and_the_other_names_is_not_change() throws InterruptedException {
		
		// Lấy value của nút Edit
		String check = driver.findElement(By.id("btnSave")).getAttribute("value");
		System.out.println("Check: " + check);
		
		// Nếu thành công sẽ kết thúc test
		if (check.equals("Edit")) {
			Thread.sleep(2000);
			driver.close();
			driver.quit();
			return;
		}
		// Nếu không thành công sẽ throw exception
		throw new io.cucumber.java.PendingException();
	}

}
