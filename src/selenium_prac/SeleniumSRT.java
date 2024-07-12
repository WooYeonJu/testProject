package selenium_prac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumSRT {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		// srt 홈페이지 열기
		driver.get("https://etk.srail.kr/main.do");
		
		// 출발역 선택
		// /html/body/div/div[4]/div[1]/div[2]/div[1]/div[1]/form/fieldset/div[1]/select
		Select departure = new Select(driver.findElement(By.name("dptRsStnCd")));
		
		// System.out.println(departure);
		// selectByVisibleText -> 화면에 출력되는 문자 중 선택
		departure.selectByVisibleText("동탄");
		
		// 도착역
		Select arrival = new Select(driver.findElement(By.name("arvRsStnCd")));
		// selector에 있는 각각의 값은 value라는 옵션이 있음 -> 그걸로 가져오기
		arrival.selectByValue("0010");
	}

}
