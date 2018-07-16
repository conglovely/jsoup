package com.lumacong.jsoup;

import java.io.IOException;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		//结果集
		HashMap hm = new HashMap();
		hm.put("wzG1", "大绿");
		hm.put("wzR1", "大红");
		hm.put("wzG2", "小绿");
		hm.put("wzR2", "小红");
		hm.put("wzG3", "单绿");
		hm.put("wzR3", "单红");
		hm.put("wzG4", "双绿");
		hm.put("wzR4", "双红");
		hm.put("duile", "对了");
		hm.put("cuole", "错了");

		try {
			// 获取网页
			Document doc = Jsoup.connect("https://free.cece28.com/yuce/1/1.html").data("query", "java")
					.userAgent("Chrome").cookie("auth", "token").timeout(30000).post();
			// 获取元素集
			Elements elements = doc.getElementsByTag("tr");
			for (int i = 4; i < elements.size() - 1; i++) {
				// 获取元素
				Element element = elements.get(i);
				// 抓取有用信息
				System.out.println(i + "\t" + element.getElementsByClass("s1f").text() + "\t"
						+ element.getElementsByClass("s1r").text() + "\t"
						+ hm.get(element.getElementsByTag("img").get(0).attr("src").split("\\/")[3].split("\\.")[0])
								.toString()
						+ "\t"
						+ hm.get(element.getElementsByTag("img").get(1).attr("src").split("\\/")[3].split("\\.")[0])
								.toString()
						+ "\t"
						+ hm.get(element.getElementsByTag("img").get(2).attr("src").split("\\/")[3].split("\\.")[0])
								.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
