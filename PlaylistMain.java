import java.util.Scanner;

class MusicPlaylist {

    // Node class
    class Node {
        String song;
        Node next;

        Node(String song) {
            this.song = song;
            this.next = null;
        }
    }

    Node head;

    // Add song
    void addSong(String song) {

        Node newNode = new Node(song);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }

        System.out.println("Song added: " + song);
    }

    // Delete song
    void deleteSong(String song) {

        if (head == null) {
            System.out.println("Playlist is Empty.");
            return;
        }

        if (head.song.equalsIgnoreCase(song)) {
            head = head.next;
            System.out.println("Song deleted: " + song);
            return;
        }

        Node temp = head;

        while (temp.next != null &&
               !temp.next.song.equalsIgnoreCase(song)) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Song not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Song deleted: " + song);
        }
    }

    // Play song
    void playSong() {

        if (head == null) {
            System.out.println("Playlist is Empty.");
        } else {
            System.out.println("Playing: " + head.song);
        }
    }

    // Display playlist
    void display() {

        if (head == null) {
            System.out.println("Playlist is Empty.");
            return;
        }

        System.out.println("Songs in Playlist:");

        Node temp = head;

        while (temp != null) {
            System.out.println(temp.song);
            temp = temp.next;
        }
    }
}

public class PlaylistMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MusicPlaylist playlist = new MusicPlaylist();

        int choice;

        do {
            System.out.println("\n--- MUSIC PLAYLIST ---");
            System.out.println("Choose: 1. Add Song 2.Delete Song 3.Play Song 4. Display Playlist 5.Exit:");
            
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter song name: ");
                    String song = sc.nextLine();
                    playlist.addSong(song);
                    break;

                case 2:
                    System.out.print("Enter song to delete: ");
                    String deleteSong = sc.nextLine();
                    playlist.deleteSong(deleteSong);
                    break;

                case 3:
                    playlist.playSong();
                    break;

                case 4:
                    playlist.display();
                    break;

                case 5:
                    System.out.println("Program ended.");
                    break;

                default:
                    System.out.println("Invalid choice.Please choose 1-5");
            }

        } while (choice != 5);

        sc.close();
    }
}