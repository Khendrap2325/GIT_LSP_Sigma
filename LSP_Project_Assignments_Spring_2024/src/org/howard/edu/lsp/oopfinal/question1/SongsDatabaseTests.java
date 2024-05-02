package org.howard.edu.lsp.oopfinal.question1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class SongsDatabaseTests {
    private SongsDatabase songsDatabase;

    @BeforeEach
    void setUp() {
        songsDatabase = new SongsDatabase();
    }

    @Test
    void testAddSong() {
        songsDatabase.addSong("Rap", "Anaconda");
        Assertions.assertFalse(songsDatabase.getSongs("Rap").contains("Like That"));
        Assertions.assertTrue(songsDatabase.getSongs("Rap").contains("Anaconda"));
    }

    @Test
    void testGetGenreOfSong() {
        songsDatabase.addSong("Jazz", "The Devil and the Deep Blue Sea");
        Assertions.assertEquals("Jazz", songsDatabase.getGenreOfSong("The Devil and the Deep Blue Sea"));
        Assertions.assertNotEquals("Jazz", songsDatabase.getGenreOfSong("The Girl from Ipanema"));

    }

    @Test
    void testGetSongs() {
        songsDatabase.addSong("Rap", "Redrum");
        songsDatabase.addSong("Rap", "Euphoria");
        Set<String> rapSongs = songsDatabase.getSongs("Rap");
        Assertions.assertFalse(rapSongs.contains("Good Days"));
        Assertions.assertTrue(rapSongs.contains("Redrum"));
        Assertions.assertTrue(rapSongs.contains("Euphoria"));
    }
}
