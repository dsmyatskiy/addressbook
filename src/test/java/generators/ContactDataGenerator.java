package generators;

import com.beust.jcommander.*;
import dto.*;

import java.io.*;
import java.util.*;

public class ContactDataGenerator {


    @Parameter(names = "-c", description = "ContactCount")
    public int count;

    @Parameter(names = "-f", description = "Target file = ")
    public String file;

    public static void main(String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
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
        List<ContactData> contacts = generateContacts(count);
        save(contacts, new File(file));
    }

    private void save(List<ContactData> contacts, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (ContactData contact : contacts) {
            writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s\n", contact.getFirstName(), contact.getLastName(),
                    contact.getMobilePhone(), contact.getHomePhone(), contact.getWorkPhone(),
                    contact.getAddress(), contact.getEmail(), contact.getEmail2(), contact.getEmail3()));
        }
        writer.close();
    }

    private List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            contacts.add(new ContactData().
                    withFirstName(String.format("test %s", i))
                    .withLastName(String.format("ivanov %s", i))
                    .withMobilePhone(String.format("792712562%s", i))
                    .withHomePhone("92712562" + i)
                    .withWorkPhone("92712552" + i)
                    .withAddress("Lenina " + i)
                    .withEmail("1email" + i)
                    .withEmail2("2email" + i)
                    .withEmail3("1email" + i));
        }
        return contacts;
    }
}
