package pl.mjedynak.springReactor;

import org.apache.commons.io.FileUtils;
import reactor.event.Event;
import reactor.function.Consumer;

import java.io.File;
import java.io.IOException;

public class ErrorConsumer implements Consumer<Event<Exception>> {

    @Override
    public void accept(Event<Exception> exceptionEvent) {
        try {
            FileUtils.write(new File(Bootstrap.EXCEPTIONS_FILE), exceptionEvent.getData().getMessage() + "\n", true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
