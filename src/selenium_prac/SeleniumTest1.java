package selenium_prac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest1 {

	public static void main(String[] args) {
		// 사용할 크롬 드라이버 불러오기
		WebDriver driver = new ChromeDriver();	// 원래 괄호 속에 PATH 넣어줘야 되지만, 지금은 같은 폴더 내에 있으므로 불필요
		// 여기서 WebDriver는 인터페이스
		
		// 드라이버를 이용하여 웹페이지 열기
		driver.get("https://www.naver.com/");
		
		// 연 브라우저에서 어떤 요소 클릭 하는 동작
		// 여기서는 네이버의 증권 부분 클릭
		// 아래 코드는 네이버 -> 개발자 모드의 증권 버튼 부분 <a>부분 copy selector
		// #shortcutArea > ul > li:nth-child(6) > a
		
		// selector로 가져오는 방법
		// WebElement financeButton = driver.findElement(By.cssSelector("#shortcutArea > ul > li:nth-child(6) > a"));
		
		// System.out.println(financeButton);
		
		// xpath: HTML 문서의 구조를 보여주는 패스 -> 태그의 경로를 알려줌
		// 아래 코드는 네이버 -> 개발자 모드의 증권 버튼 부분 <a>부분 copy full xpath
		// /html/body/div[2]/div[1]/div/div[6]/ul/li[6]/a
		WebElement financeButton = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[6]/ul/li[6]/a"));
		
		// element에 클릭 명령을 내림
		financeButton.click();
	}

}
