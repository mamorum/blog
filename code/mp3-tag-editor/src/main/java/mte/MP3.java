package mte;

import java.io.File;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.id3.ID3v23Tag;

public class MP3 {

	public AudioFile audio;

	private MP3(File f) throws Exception {
		this.audio = AudioFileIO.read(f);
	}

	public static MP3 get(File f) throws Exception {
		return new MP3(f);
	}

	public MP3 updateTag(String artist, String album, String title) throws Exception {
		// ジャンルは変更しない。
		String genre = audio.getTag().getFirst(FieldKey.GENRE);
		AudioFileIO.getDefaultAudioFileIO().deleteTag(audio);
		addTag(genre, artist, album, title);
		return this;
	}
	
	private void addTag(String genre, String artist, String album, String title) throws Exception {
		ID3v23Tag t = new ID3v23Tag();
		t.setField(FieldKey.GENRE, genre);
		t.setField(FieldKey.ARTIST, artist);
		t.setField(FieldKey.ALBUM, album);
		t.setField(FieldKey.TITLE, title);
		this.audio.setTag(t);
	}

	public void save() throws Exception {
		audio.commit();
	}
}
