package selenium_prac;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest3 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		// 시작 페이지를 네이버 증권 페이지로 설정
		driver.get("https://finance.naver.com/");
		
		// 네이버 증권 페이지에서 뉴스 가져오기
		// /html/body/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div/ul/li
		// 배열 형태를 순서대로 저장한 것
		// 복수의 요소 가져오기 -> findElements
		List<WebElement> newsTitleList = driver.findElements(By.xpath("/html/body/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div/ul/li"));
		
		for(WebElement webElement : newsTitleList) {
			// 요소 내의 text를 뽑아오기 위해 .getText() 사용
			System.out.println(webElement.getText());
		}
	}
}
