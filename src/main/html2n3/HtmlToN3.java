package main.html2n3;

import java.io.File;
import java.io.IOException;

import main.html2n3.vocabulary.DC;
import main.html2n3.vocabulary.RDFS;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlToN3 {

	public static void main(String[] args) {
		// http://collection.nmwa.go.jp/artizeweb/search_7_detail.do
		File input = new File("./example_data/P.1959-0091.html");
		try {
			String uri = "P.1959-0091";
			N3Writer n3writer = new N3Writer(uri + ".n3");

			Document doc = Jsoup.parse(input, "UTF-8");
			Element content = doc.getElementById("mainClm");
			Elements links = content.getElementsByTag("div");

			Element div = links.get(14);
			Elements divs = div.getElementsByTag("div");

			Element divLabel = divs.get(5);
			n3writer.add(uri, RDFS.label, divLabel.getElementsByTag("p").text());

			Element divCreated = divs.get(8);
			n3writer.add(uri, DC.created, divCreated.getElementsByTag("p")
					.text());

			n3writer.write();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
