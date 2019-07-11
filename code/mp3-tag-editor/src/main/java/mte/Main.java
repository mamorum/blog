package mte;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
					
		System.out.println("Input artist directory path.");
		System.out.print("> ");
		
		String artistDirPath = handleInput();
		if ("".equals(artistDirPath)) {
			return;
		}
		process(artistDirPath);
		
		System.out.println("Updated.");
		System.out.println();
	}

	private static String handleInput() throws Exception {
		return (new BufferedReader(new InputStreamReader(System.in))).readLine();
	}
	
	private static void process(String artistDirPath)  throws Exception {
		File dir = new File(artistDirPath);
		String artist = dir.getName();
		String album = artist;
		update(dir.listFiles(), artist, album);		
	}

	private static void update(File[] files, String artist, String album) throws Exception {
		for (File f : files) {
			String title = deleteExtension(f.getName());
			MP3.get(f).updateTag(artist, album, title).save();
		}
	}

	private static String deleteExtension(String fileName) {
		return fileName.substring(0, fileName.lastIndexOf("."));
	}
}
