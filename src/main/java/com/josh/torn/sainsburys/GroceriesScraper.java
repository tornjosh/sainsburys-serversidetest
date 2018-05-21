package com.josh.torn.sainsburys;


        import java.io.IOException;
        import java.text.DecimalFormat;

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

            String unitPrice = scrapeUnitPrice(product);


            Document productPage;
            productPage = Jsoup.connect(product.select("a").attr("abs:href")).get();

            int kcalPer100g = 0;

            String description = scrapeDescription(productPage);

            ProductItem item = new ProductItem(title, unitPrice, kcalPer100g, description);

            items[index] = item;

            System.out.println(items[index].getTitle());

            System.out.println("£" + items[index].getUnitPrice());

            System.out.println(items[index].getDescription());

            System.out.println();

            index++;
        }

        // prints the html
        //System.out.println(products.html());

    }

    // scrapes the title of a product from the groceries page.
    private static String scrapeTitle(Element element) {
        // the title is in the hyperlink text.
        return element.select("a").first().text();
    }

    // scrapes the Unit price of a product from the groceries page.
    private static String scrapeUnitPrice(Element element) {
        // formats the string to two decimal places
        DecimalFormat decim = new DecimalFormat("0.00");
        return decim.format(
                Double.parseDouble(
                        // the unit price is in the first 4 characters in the pricePerUnit element.
                        element.select("p.pricePerUnit").first().text().substring(1, 5)));
    }

    /*  scrapes the first line of the Description of a product from the product page html.

        * for the organic blueberries takes two lines.

        finding the description is quite difficult because on each of the product pages the html is
        structured slightly differently.
     */
    private static String scrapeDescription(Element element) {
        /* some of the descriptions are just text in the productText element, others are in the memo element.
           this if statement checks whether the productText is the actual description or starts with "Des",
           if it starts with "Des" then the actual description is in the memo element.*/
        if (element.select("div.productText").first().text().substring(0,3).equals("Des")) {
            /* there is one case where the description is in not in the memo, for that case the description
               is in the itemTypeGroup element */
            if (element.select("div.memo").first().text().substring(0,5).equals("Sains")) {
                return element.select("div.itemTypeGroup").first().text();
            }
            else {
                return element.select("div.memo").first().text();
            }
        }
        else {
            return element.select("div.productText").first().text();

        }
    }
}