package selenium_prac;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest2 {

//	public static void main(String[] args) {
//		WebDriver driver = new ChromeDriver();
//		
//		// 시작 페이지를 네이버 증권 페이지로 설정
//		driver.get("https://finance.naver.com/");
//		
//		// 검색창에 내용 검색
//		// /html/body/div[2]/div[1]/div/div[2]/div[1]/form/input[1]
//		WebElement searchBar = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[1]/form/input[1]"));
//		searchBar.sendKeys("삼성전자");
//		
//		// 현재 검색 버튼 활성화x -> enter키 입력 방식으로 검색
//		searchBar.sendKeys(Keys.ENTER);
//	}
    public static void main(String[] args) {
        // 1. 크롬 드라이버를 사용할 준비를 한다.
        // 자바와 크롬을 연동하기 위한 준비
        WebDriver driver = new ChromeDriver();

        // 2. 접속하고자 하는 웹페이지의 주소를 작성한다.
        driver.get("https://www.naver.com/");

        /// html/body/div[2]/div[1]/div/div[5]/ul/li[6]/a/span[1]
        // xpath란 : 태그의 경로를 써놓은것
        // 엘리먼트를 받아오기
        WebElement financeButton = driver
                .findElement(By.xpath("/html/body/div[2]/div[1]/div/div[6]/ul/li[6]/a"));
        
        // 증권 메뉴를 클릭해보자
        financeButton.click();

        // 클릭후 새로운 탭이 생겼으므로 마지막 핸들로 전환
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            driver.switchTo().window(handle);
        }

        // input box를 받아옴
        WebElement searchBox = driver
                .findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[1]/form/input[1]"));
        searchBox.sendKeys("삼성전자"); // inputBox에 삼성전자 라는 문자를 보냄


        // Enter버튼 입력
        searchBox.sendKeys(Keys.ENTER);
    }
}
