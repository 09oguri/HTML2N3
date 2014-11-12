package main.html2n3.vocabulary;

public class RDFS {
	private static final String URI = "http://www.w3.org/2000/01/rdf-schema#";

	public static final String label = URI + "label";

	private RDFS() {
	}

	public String getURI() {
		return URI;
	}
}
