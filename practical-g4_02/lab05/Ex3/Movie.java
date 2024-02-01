import java.util.ArrayList;
import java.util.List;

public class Movie {
    private final String title;
    private final int year;
    private final Person director;
    private final Person writer;
    private final String series;
    private final List<Person> cast;
    private final List<Place> locations;
    private final List<String> languages;
    private final List<String> genres;
    private final boolean isTelevision;
    private final boolean isNetflix;
    private final boolean isIndependent;

    public static class Builder {
        private final String title;
        private final int year;
        private Person director;
        private Person writer;
        private String series;
        private List<Person> cast = new ArrayList<>();
        private List<Place> locations = new ArrayList<>();
        private List<String> languages = new ArrayList<>();
        private List<String> genres = new ArrayList<>();
        private boolean isTelevision;
        private boolean isNetflix;
        private boolean isIndependent;
        public Builder(String title, int year) {
            this.title = title;
            this.year = year;
        }
        public Builder director(Person director) {
            this.director = director;
            return this;
        }
        public Builder writer(Person writer) {
            this.writer = writer;
            return this;
        }
        public Builder series(String series) {
            this.series = series;
            return this;
        }
        public Builder addCast(List<Person> cast) {
            this.cast.addAll(cast);
            return this;
        }
        public Builder addLocation(List<Place> locations) {
            this.locations.addAll(locations);
            return this;
        }
        public Builder addLanguage(List<String> languages) {
            this.languages.addAll(languages);
            return this;
        }
        public Builder addGenre(List<String> genres) {
            this.genres.addAll(genres);
            return this;
        }
        public Builder isTelevision(boolean isTelevision) {
            this.isTelevision = isTelevision;
            return this;
        }
        public Builder isNetflix(boolean isNetflix) {
            this.isNetflix = isNetflix;
            return this;
        }
        public Builder isIndependent(boolean isIndependent) {
            this.isIndependent = isIndependent;
            return this;
        }
        public Movie build() {
            return new Movie(this);
        }
    }
    
    private Movie(Builder builder) {
        this.title = builder.title;
        this.year = builder.year;
        this.director = builder.director;
        this.writer = builder.writer;
        this.series = builder.series;
        this.cast = builder.cast;
        this.locations = builder.locations;
        this.languages = builder.languages;
        this.genres = builder.genres;
        this.isTelevision = builder.isTelevision;
        this.isNetflix = builder.isNetflix;
        this.isIndependent = builder.isIndependent;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", director=" + director +
                ", writer=" + writer +
                ", series='" + series + '\'' +
                ", cast=" + cast +
                ", locations=" + locations +
                ", languages=" + languages +
                ", genres=" + genres +
                ", isTelevision=" + isTelevision +
                ", isNetflix=" + isNetflix +
                ", isIndependent=" + isIndependent +
                '}';
    }
}
