import java.util.List;

public class ex3 {
    public static void main(String[] args) {
        Movie movie1 = new Movie.Builder("Puss in Boots: The Last Wish", 2022)
                                .director(new Person("Joel Crawford"))
                                .writer(new Person("Paul Fisher"))
                                .addCast(List.of(new Person("Antonio Banderas")))
                                .addLocation(List.of(new Place("Black Forest", "Fantasy World", "Wonderland")))
                                .addLanguage(List.of("English", "Spanish"))
                                .addGenre(List.of("Animation", "Adventure", "Comedy", "Fantasy"))
                                .addCast(List.of(new Person("Salma Hayek"), new Person("Harvey Guillén")))
                                .isNetflix(true)
                                .isIndependent(true)
                                .build();

        Movie movie2 = new Movie.Builder("Bad Boys II", 2003)
                                .director(new Person("Michael Bay"))
                                .writer(new Person("George Gallo"))
                                .addCast(List.of(new Person("Will Smith"), new Person("Martin Lawrence")))
                                .addLocation(List.of(new Place("Miami", "USA", "Florida")))
                                .addLanguage(List.of("English"))
                                .addGenre(List.of("Action", "Comedy", "Crime"))
                                .isNetflix(true)
                                .isTelevision(true)
                                .build();
                                
        Movie movie3 = new Movie.Builder("Evangelion 3.0: You Can (Not) Redo", 2012)
                                .director(new Person("Mahiro Maeda"))
                                .writer(new Person("Hideaki Anno"))
                                .addCast(List.of(new Person("Megumi Ogata"), new Person("Yuko Miyamura")))
                                .addLocation(List.of(new Place("Tokyo-3", "Japan", "Tokyo")))
                                .addLanguage(List.of("Japanese"))
                                .addGenre(List.of("Animation", "Action", "Drama", "Mecha", "Sci-Fi"))
                                .isNetflix(true)
                                .build();

        System.out.println(movie1);
        System.out.println(movie2);
        System.out.println(movie3);  
    }    
}
