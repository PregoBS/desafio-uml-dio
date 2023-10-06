public class MusicPlayer implements Application {
    String currentSong;
    boolean isPlaying;

    public MusicPlayer() {
        this.onInit();

        this.currentSong = "";
        this.isPlaying = false;
    }

    public void play() {
        if (this.currentSong.isBlank()) return;
        this.onResume();
        this.isPlaying = true;
    }

    public void pause() {
        this.onPause();
        this.isPlaying = false;
    }

    public void selectSong(String song) {
        if (song.isBlank()) return;

        System.out.println("Música selecionada: " + song);
        this.currentSong = song;
        this.play();
    }

    public void onInit() {
        System.out.println("Inicializando Music Player..");
    }
    
    public void onPause() {
        System.out.println("Music Player pausado. A música atual é " + this.currentSong);
    }

    public void onResume() {
        System.out.println("Retomando Music Player do ponto em que parou, tocando a música " + this.currentSong);
    }

    public void onDestroy() {
        System.out.println("Music Player encerrado. Liberando memória..");
    }
    
}

class MusicPlayerMain {
    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();

        player.selectSong("Queen - We Will Rock You");
        player.pause();
        player.play();

        player.onDestroy();
    }
}