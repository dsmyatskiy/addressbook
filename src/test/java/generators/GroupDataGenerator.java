package generators;

import com.beust.jcommander.*;
import com.google.gson.*;
import dto.*;

import java.io.*;
import java.util.*;

public class GroupDataGenerator {

    @Parameter(names = "-c", description = "GroupCount")
    public int count;

    @Parameter(names = "-f", description = "Target file = ")
    public String file;

    @Parameter(names = "-d", description = "Format")
    public String format;

    public static void main(String[] args) throws IOException {
        GroupDataGenerator generator = new GroupDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }

        generator.run();
    }

    private void run() throws IOException {
        List<GroupData> groups = generateGroups(count);
        if (format.equals("csv")) {
            saveAsCsv(groups, new File(file));
        } else {
            saveAsJson(groups, new File(file));
        }
    }

    private void saveAsJson(List<GroupData> groups, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        Writer writer = new FileWriter(file);
        String json = gson.toJson(groups);
        writer.write(json);
        writer.close();
    }

    private void saveAsCsv(List<GroupData> groups, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (GroupData group : groups) {
            writer.write(String.format("%s;%s;%s\n", group.getName(), group.getHeader(), group.getFooter()));
        }
        writer.close();
    }

    private List<GroupData> generateGroups(int count) {
        List<GroupData> groups = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            groups.add(new GroupData().withName(String.format("test %s", i))
                    .withHeader(String.format("header %s", i)).withFooter(String.format("footer %s", i)));
        }
        return groups;
    }
}
