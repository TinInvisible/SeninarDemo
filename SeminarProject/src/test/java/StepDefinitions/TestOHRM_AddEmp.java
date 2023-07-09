//package StepDefinitions;
//
//import java.time.Duration;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class TestOHRM_AddEmp {
//	WebDriver driver = null;
//	List<Exception> e = new ArrayList<>();
//	@Given("browser window is open")
//	public void browser_window_is_open() {
//		System.out.println("Inside Step - browser is open");
//
//		String projectPath = System.getProperty("user.dir");
//		System.out.println("Project path is : " + projectPath);
//
//		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");
//
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
//
//		// driver.manage().window().maximize();
//	}
//
//	@Given("user is on OrangeHRM, PIM page")
//	public void user_is_on_orange_hrm_editting_profile_page() throws InterruptedException {
//		System.out.println("Inside Step - user is on goolge search page");
//		
//		// Vao trang dang nhap Orange HRM
//		driver.navigate().to("http://localhost/orangehrm-4.5/symfony/web/index.php/auth/login");
//		
//		// Dang nhap
//		//Nhap tai khoan
//		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
//		Thread.sleep(2000);
//		//Nhap mat khau
//		driver.findElement(By.id("txtPassword")).sendKeys("H@ck321die");
//		Thread.sleep(2000);
//		// Nhan nut Enter
//		driver.findElement(By.id("txtPassword")).sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		
//		// Vao trang PIM
//		driver.findElement(By.id("menu_pim_viewPimModule")).click();
//		Thread.sleep(2000);
//	}
//	@When("user clicks Add button")
//	public void user_clicks_Add_button() {
//		// Nhấn vào nút Add
//		driver.findElement(By.id("btnAdd")).click();
//	}
//	@When("user enters (.*), (.*), (.*)$")
//	public void user_enters_a_new_name(String FName, String MName, String LName) throws InterruptedException {
//		
//		// Tìm ô First Name
//		String checkFName = driver.findElement(By.name("firstName")).getAttribute("value");
//		// Xóa hết kí tự ở trong
//		while(checkFName.length() > 0) {
//			driver.findElement(By.name("firstName")).sendKeys(Keys.BACK_SPACE);
//			checkFName = driver.findElement(By.name("firstName")).getAttribute("value");
//		}
//		
//		// Điền vào tên mới
//		driver.findElement(By.name("firstName")).sendKeys(FName);
//		Thread.sleep(2000);
//		
//		// Tương tự với Middle Name và Last Name
//		String checkMName = driver.findElement(By.name("middleName")).getAttribute("value");
//		while(checkMName.length() > 0) {
//			driver.findElement(By.name("middleName")).sendKeys(Keys.BACK_SPACE);
//			checkMName = driver.findElement(By.name("middleName")).getAttribute("value");
//		}
//		driver.findElement(By.name("middleName")).sendKeys(MName);
//		Thread.sleep(2000);
//		
//		
//		String checkLName = driver.findElement(By.name("lastName")).getAttribute("value");
//		while(checkLName.length() > 0) {
//			driver.findElement(By.name("lastName")).sendKeys(Keys.BACK_SPACE);
//			checkLName = driver.findElement(By.name("lastName")).getAttribute("value");
//		}
//		driver.findElement(By.name("lastName")).sendKeys(LName);
//		Thread.sleep(2000);
//
//	}
//
//	@When("hits Save")
//	public void hits_edit() throws InterruptedException {
//		
//		//Nhấn vào nút Save
//		driver.findElement(By.id("btnSave")).click();
//		Thread.sleep(2000);
//
//	}
//
//	@Then("new employee is added with the id likes [emp_id]")
//	public void the_name_is_change_and_the_other_names_is_not_change() throws InterruptedException {
//		
//		// Tìm và lấy value trong ô id
//		String check = driver.findElement(By.id("personal_txtEmployeeId")).getAttribute("value");
//		System.out.println("Check: " + check);
//		
//		// Check id nếu đúng như mẫu emp_id thì thành công và đóng trình duyệt
//		if (check.equals("emp_(.*)$")) {
//			Thread.sleep(2000);
//			driver.close();
//			driver.quit();
//			return;
//		}
//		// Nếu không thành công sẽ throw exception
//		System.out.println("Having bugs after finishing add");
//		driver.close();
//		driver.quit();
//		throw new io.cucumber.java.PendingException(check);
//
//	}
//}
