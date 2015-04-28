/*
package com.playerplanet.core.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Launcher {

    private static Class clas = Launcher.class;

    public static void main(String[] args) {

           */
/* Document doc = Jsoup.connect("http://whoscored.com/Teams/13/")
                               // .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.2 (KHTML, like Gecko)Chrome/15.0.874.120 Safari/535.2").get();
                    .userAgent("Chrome/41").get();*//*

        System.setProperty("webdriver.chrome.driver","C:\\software\\chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://whoscored.com/Teams/13/");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String html_content = driver.getPageSource();
        driver.close();
        Document doc = Jsoup.parse(html_content);
        Element element = doc.body().getElementById("layout-wrapper")
                .getElementById("layout-content-wrapper")
                .getElementsByClass("layout-content-2col-left").get(0)
                .getElementsByClass("stat-table").get(0)
                .getElementById("team-squad-stats")
                .getElementById("team-squad-stats-summary")
                .getElementById("statistics-table-summary");

        element = element.getElementById("top-player-stats-summary-grid")
                .getElementById("player-table-statistics-body");
        System.out.println(element.toString());
        System.out.println(element.children().get(0).getElementsByClass("pn").get(0).select("a").first().text());
    }
}
*/
