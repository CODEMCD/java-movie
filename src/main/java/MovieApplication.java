import domain.Movie;
import domain.MovieRepository;
import domain.Point;
import domain.ReservingMovie;
import jdk.internal.util.xml.impl.Input;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        List<ReservingMovie> reservedMovies = new ArrayList<>();
        OutputView.printMovies(movies);

        boolean reservingProcess = true;
        while(reservingProcess) {
            int movieId = InputView.inputMovieId();

            // TODO 구현 진행
            Movie selectedMovie = MovieRepository.getMovieUsingMovieID(movieId);
            OutputView.printSelectedMovie(selectedMovie);

            int moveStartTimeNumber = InputView.inputMovieStartTime();
            int numberOfPeople = InputView.inputNumberOfPeople();
            reservingProcess = (InputView.inputPaymentOrAddingReserve() == 2)
                    ? true : false;
            reservedMovies.add(new ReservingMovie(selectedMovie, moveStartTimeNumber, numberOfPeople));
        }

        OutputView.printDetailsOfReservingMovie(reservedMovies);
        int inputPoint = InputView.inputPoint();
        Point point = new Point(inputPoint);
    }
}
