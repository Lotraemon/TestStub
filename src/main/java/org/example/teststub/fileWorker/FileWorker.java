package org.example.teststub.fileWorker;

import java.nio.file.*;
import org.example.teststub.dto.User;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Random;

@Component
public class FileWorker {
    private static final String FILE_PATH = "C:\\Test\\data.txt";

    public void writeToFile(User user) throws IOException {
        String json = String.format(
                "{\"login\":\"%s\", \"password\":\"%s\",  \"email\":\"%s\", \"date\":\"%s\"}"
                , user.getLogin(), user.getPassword(), user.getEmail(), user.getDate()
        );
        Files.writeString(
                Paths.get(FILE_PATH),
                json + "\n",
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
    }
    public String randomReadFile() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));
        return lines.get(new Random().nextInt(lines.size()));
    }
}
