import java.util.Iterator;

public class MyMarvelCollection implements Iterable<Film> {
    private Film[] films;

    public MyMarvelCollection(Film[] films) {
        this.films = films;
    }

    public void add(Film film) {
        for (int i = 0; i < films.length; i++) {
            if (films[i] == null) {
                films[i] = film;
                break;
            }
        }
    }

    public Film get(int index) {
        return films[index];
    }

    public void show(MyMarvelCollection a) {
        for (var film : a) {
            System.out.println(film);
        }
    }

    @Override
    public Iterator<Film> iterator() {
        return new FilmIterator(films);
    }

    private class FilmIterator implements Iterator<Film> {
        private Film[] films;
        private int index;

        public FilmIterator(Film[] films) {
            this.films = films;
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < films.length && films[index] != null;
        }

        @Override
        public Film next() {
            return films[index++];
        }
    }
}