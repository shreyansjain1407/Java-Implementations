import java.util.*;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<Album>();
    public static void main(String[] args) {
        Album album = new Album("Underground", "Linkin Park");
        album.addSong("In the end", 3.2);
        album.addSong("Castle of glass",4.2);
        album.addSong("Sharp Edges",2.5);
        album.addSong("Until it's gone",5.0);
        album.addSong("Iridescent",4.2);
        album.addSong("Lost in the echo",3.9);
        albums.add(album);

        album = new Album("One More Light", "Linkin Park");
        album.addSong("A",1.0);
        album.addSong("B",2.0);
        album.addSong("C",3.0);
        album.addSong("D",4.0);
        album.addSong("E",5.0);
        album.addSong("F",6.0);
        album.addSong("G",7.0);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlaylist("Castle of glass",playList);
        albums.get(0).addToPlaylist("Sharp Edges",playList);
        albums.get(0).addToPlaylist("Lost in the echo",playList);
        albums.get(1).addToPlaylist(3,playList);
        albums.get(1).addToPlaylist(1,playList);
        albums.get(1).addToPlaylist("F",playList);

        play(playList);

    }

    private static void play(LinkedList<Song> playList){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0){
            System.out.println("No Songs in playlist");
            return;
        } else {
            System.out.println("Now Playing " + listIterator.next().toString());
            printMenu();
        }

        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0 :
                    System.out.println("Playlist Complete");
                    quit = true;
                    break;
                case 1 :
                    if (!forward){
                        if (listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()){
                        System.out.println("Now Playing: " + listIterator.next().toString());
                    } else {
                        System.out.println("End of the playlist");
                        forward = false;
                    }
                    break;
                case 2 :
                    if (forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()){
                        System.out.println("Now Playing: "+listIterator.previous().toString());
                    } else {
                        System.out.println("Reached beginning of the playlist.");
                        forward = true;
                    }
                    break;
                case 3 :
                    if (forward){
                        if (listIterator.hasPrevious()){
                            System.out.println("Now Playing: " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the beginning of the playlist");
                        }
                    } else {
                        if (listIterator.hasNext()){
                            System.out.println("Now Playing: " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the playlist");
                        }
                    }
                    break;
                case 4 :
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6 :
                    if (playList.size()>0){
                        listIterator.remove();
                        if (listIterator.hasNext()){
                            System.out.println("Now playing: "+ listIterator.next().toString());
                        } else if (listIterator.hasPrevious()){
                            System.out.println("Now Playing: " + listIterator.previous().toString());
                        }
                    } else {
                        System.out.println("The current list is empty");
                    }
                    break;
            }
        }
    }

    private static void printMenu(){
        System.out.println("""
                These are the menu options:
                Press 0 to Quit.
                Press 1 to play next song
                Press 2 to play previous song
                Press 3 to replay the current song
                Press 4 to list the songs in the playlist
                Press 5 to print the available options
                Press 6 to remove current song from the playlist
                """);
    }

    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("============================");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("============================");
    }
}
