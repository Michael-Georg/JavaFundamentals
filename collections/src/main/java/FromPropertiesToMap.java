import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;

class FromPropertiesToMap {
    private Path path;
    private Map<String, String> map;

    FromPropertiesToMap(String path) {
        this.path = Paths.get(path);
    }

    void create() throws IOException {
        map = Files.lines(path).map(s -> s.split("="))
                .collect(Collectors.toMap(str -> str[0], str -> str[1]));
    }

    String getValue(String key){
        return map.get(key);
    }
}