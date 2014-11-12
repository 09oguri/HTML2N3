package main.html2n3;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class N3Writer {
	private final String filePath;
	private ArrayList<Triple> triples;

	public N3Writer(String filePath) {
		this.filePath = filePath;
		this.triples = new ArrayList<Triple>();
	}

	public void add(Triple triple) {
		triples.add(triple);
	}

	public void add(String s, String p, String o) {
		triples.add(new Triple(s, p, o));
	}

	public void write() throws IOException {
		FileOutputStream fos = new FileOutputStream(filePath);
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);

		for (Triple triple : triples) {
			bw.write(triple.toString());
			bw.newLine();
		}

		bw.close();
	}

}
