package module13;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class JsoupTest {

    public static void main(String[] args) throws IOException {
        String url = "https://bt.rozetka.com.ua/ua/deerma_dem-f628/p223758583/?gclid=Cj0KCQiAmaibBhCAARIsAKUlaKS5IkxknB9vb9pHDlPE7-5ng9QDDv5T4ZBd45VBO6uTAqAhJLUuZZ0aAgy1EALw_wcB";

        //Document document = Jsoup.connect(url).method(Connection.Method.PUT).execute().parse();

        Document document = Jsoup.connect(url).get();
        Element element = document.selectFirst("p.product-prices__big");
        int price = Integer.parseInt(element.text().split("₴")[0]);
        System.out.println("price = " + price);

    }
}
