package testvagrantAssignment;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class RecentlyPlayedStore {
    private final int initialCapacity;
    private final Map<String, LinkedList<String>> store;

    public RecentlyPlayedStore(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        this.store = new HashMap<>();
    }

    public void addSong(String user, String song) {
        LinkedList<String> playlist = store.get(user);
        if (playlist == null) {
            playlist = new LinkedList<>();
            store.put(user, playlist);
        }

        if (playlist.size() == initialCapacity) {
            playlist.removeFirst(); // Remove least recently played song
        }

        playlist.addLast(song); // Add the new song at the end
    }

    public LinkedList<String> getRecentlyPlayedSongs(String user) {
        return store.get(user);
    }

    public static void main(String[] args) {
        RecentlyPlayedStore store = new RecentlyPlayedStore(3);

        store.addSong("User1", "S1");
        store.addSong("User1", "S2");
        store.addSong("User1", "S3");
        System.out.println("User1 playlist: " + store.getRecentlyPlayedSongs("User1"));

        store.addSong("User1", "S4");
        System.out.println("User1 playlist: " + store.getRecentlyPlayedSongs("User1"));

        store.addSong("User1", "S2");
        System.out.println("User1 playlist: " + store.getRecentlyPlayedSongs("User1"));

        store.addSong("User1", "S1");
        System.out.println("User1 playlist: " + store.getRecentlyPlayedSongs("User1"));
    }
}