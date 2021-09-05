import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Music implements Comparable<Music> {

    private final int played;
    private final int id;
    private final String genre;

    public Music(String genre, int played, int id) {
        this.genre = genre;
        this.played = played;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getPlayed() {
        return played;
    }

    public static Music of(String genre, int played, int id) {
        return new Music(genre, played, id);
    }

    @Override
    public int compareTo(Music other) {
        if (this.played == other.played) {
            return this.id - other.id;
        }
        return other.played - this.played;
    }

    public String getGenre() {
        return genre;
    }
}

class Solution {
    private int sum(List<Music> value) {
        return value.stream().mapToInt(Music::getPlayed).sum();
    }

    public int[] solution(String[] genres, int[] plays) {
        return IntStream.range(0, genres.length)
                .mapToObj(i -> Music.of(genres[i], plays[i], i))
                .collect(Collectors.groupingBy(Music::getGenre))
                .entrySet().stream()
                .sorted((a, b) -> sum(b.getValue()) - sum(a.getValue()))
                .flatMap(x -> x.getValue().stream().sorted().limit(2))
                .mapToInt(Music::getId).toArray();
    }
}
