package selenium_prac;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumEduSSAFY {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		// 에듀싸피 접속 -> 로그인
		driver.get("https://edu.ssafy.com/comm/login/SecurityLoginForm.do");

		WebElement id = driver
				.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/div/div[2]/div[1]/div[1]/input"));
		id.sendKeys("");

		WebElement pw = driver
				.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/div/div[2]/div[1]/div[2]/input"));
		pw.sendKeys("");

		pw.sendKeys(Keys.ENTER);
		Thread.sleep(500);

		// 팝업 닫기
		WebElement popupExitBtn = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/button[2]"));
		popupExitBtn.click();
		Thread.sleep(500);

		// 익명게시판 접속
		WebElement communityBtn = driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div[2]/ul/li[3]/a"));
		communityBtn.click();
		Thread.sleep(500);

		WebElement annoymousBtn = driver
				.findElement(By.xpath("/html/body/div[1]/form/div/div[1]/div[2]/div/ul/li[3]/a"));
		annoymousBtn.click();
		Thread.sleep(500);

		// 익명게시판에서 글쓰기 버튼 클릭
		WebElement annWriteBtn = driver
				.findElement(By.xpath("/html/body/div[1]/form/div/div[2]/div/div[2]/div/span/button"));
		annWriteBtn.click();

		// 익명게시판 제목 작성
		WebElement annTitle = driver.findElement(By.xpath("/html/body/div[1]/form/div/div[2]/div/div[1]/div/div[1]/div[2]/input"));
		annTitle.sendKeys("대전 3반");

		// 익명게시판 내용 작성
		WebElement annContent = driver.findElement(By.xpath("/html/body/div[1]/form/div/div[2]/div/div[1]/div/div[2]/div[2]/div/textarea"));
		annContent.sendKeys("대전 3반 화이팅!!");

		// 내용 작성 후 글쓰기 버튼 클릭
		WebElement annSubmitBtn = driver.findElement(By.xpath("/html/body/div[1]/form/div/div[2]/div/div[2]/div[2]/div/a"));
		annSubmitBtn.click();
		Thread.sleep(300);

		// 내용 작성 후 글쓰기 확인 버튼 클릭
		WebElement annSubmitEndBtn = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/button"));
		annSubmitEndBtn.click();
		Thread.sleep(300);

		// 익명게시판 좋아요 메크로
		List<WebElement> annList = driver.findElements(By.xpath("/html/body/div[1]/form/div/div[2]/div/div[3]/ul/li"));

		for (int i = 1; i <= annList.size(); i++) {
			/// html/body/div[1]/form/div/div[2]/div/div[3]/ul/li[1]/div[1]
			WebElement element = driver.findElement(By.xpath("html/body/div[1]/form/div/div[2]/div/div[3]/ul/li[" + i + "]/div[1]/a"));

			element.click();
			Thread.sleep(300);

			// 페이지 접속 후 좋아요 버튼 누르고 목록으로 복귀
			WebElement annGood = driver
					.findElement(By.xpath("/html/body/div[1]/form/div/div[2]/div/div[2]/div[4]/div/button[1]"));
			// 만약 버튼에 수정이라고 적혀있으면 목록으로 돌아가기
			if(annGood.getText().equals("수정")) {
				// 내용 수정하기
				
				WebElement annBackList = driver
						.findElement(By.xpath("/html/body/div[1]/form/div/div[2]/div/div[3]/div[2]/div/div/button"));
				annBackList.click();
				Thread.sleep(300);
				continue;
			} else {
				// 아니면 좋아요 누르기
				annGood.click();
				Thread.sleep(300);
			}
			
			WebElement annBackList = driver
					.findElement(By.xpath("/html/body/div[1]/form/div/div[2]/div/div[3]/div[2]/div/div/button"));
			annBackList.click();
			Thread.sleep(300);

			// 클릭후 새로운 탭이 생겼으므로 마지막 핸들로 전환
			Set<String> handles = driver.getWindowHandles();
			for (String handle : handles) {
				driver.switchTo().window(handle);
			}
		}
		
		// 멘토링 게시판 이동
		WebElement mentoringBtn = driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div[2]/ul/li[5]/a"));
		mentoringBtn.click();
		Thread.sleep(500);
		// 주요 트렌트 클릭
		WebElement majorTrandBtn = driver
				.findElement(By.xpath("/html/body/div[1]/form/div/div[2]/div/div[2]/div/div/ul/li[4]/a"));
		majorTrandBtn.click();
		Thread.sleep(500);
		
		// 주요 트렌드 리스트 불러오기
		List<WebElement> trandTitleList = driver.findElements(By.xpath("/html/body/div[1]/form/div/div[2]/div/div[3]/ul/li"));
		
		// 반복문으로 주요 트렌드 타이틀 불러오기
		for (int i = 1; i <= trandTitleList.size(); i++) {
			/// html/body/div[1]/form/div/div[2]/div/div[3]/ul/li[1]/div[1]
			WebElement element = driver.findElement(By.xpath("/html/body/div[1]/form/div/div[2]/div/div[3]/ul/li[" + i  + "]/div[2]/a"));
			
			if(element.getText().indexOf("우수사례") != -1) {
				continue;
			}
			System.out.println(element.getText());
			
		}

	}

}
