package main.html2n3;

public class Triple {
	final private String subject;
	final private String predicate;
	final private String object;

	public Triple(String s, String p, String o) {
		this.subject = s;
		this.predicate = p;
		this.object = o;
	}

	public String getSubject() {
		return subject;
	}

	public String getPredicate() {
		return predicate;
	}

	public String getObject() {
		return object;
	}

	@Override
	public String toString() {
		if (object.contains("http://")) {
			return subject + " " + predicate + " " + object + " .";
		} else {
			return subject + " " + predicate + " \"" + object + "\" .";
		}

	}

}
