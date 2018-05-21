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

        // array of the products of the page
        ProductItem[] items = new ProductItem[products.size()];

        int index = 0;

        // loops through element selecting one element at a time and scraps information
        for(Element product: products) {

            String title = scrapeTitle(product);

            double unitPrice = 0;

            int kcalPer100g = 0;

            String description = "";

            ProductItem item = new ProductItem(title, unitPrice, kcalPer100g, description);

            items[index] = item;

            System.out.println(items[index].getTitle());

            index++;
        }

        // prints the html
        //System.out.println(products.html());

    }

    // scrapes the title of a product from the product element.
    private static String scrapeTitle(Element element) {
        return element.select("a").first().text();
    }
}