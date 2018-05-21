package com.josh.torn.sainsburys;


        import java.io.IOException;

        import org.jsoup.Jsoup;
        import org.jsoup.nodes.Document;
        import org.jsoup.nodes.Element;
        import org.jsoup.select.Elements;

/**
 * GroceriesScraper
 *
 */
public class GroceriesScraper {

    public static void main(String[] args) throws IOException {

        // retrieves html from the url
        Document doc;
        doc = Jsoup.connect("https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html").get();

        // finds all product elements
        Elements products = doc.select("div.product");

        for(Element product: products) {
        }

        // prints the html
        System.out.println(products.html());

    }
}