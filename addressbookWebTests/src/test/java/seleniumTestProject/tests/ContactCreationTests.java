package seleniumTestProject.tests;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import seleniumTestProject.model.ContactData;
import seleniumTestProject.model.Contacts;
import seleniumTestProject.model.GroupData;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContactsFromJson() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")));
        String json = "";
        String line = reader.readLine();
        while (line != null){
            json += line;
            line = reader.readLine();
        }
        Gson gson = new Gson();
        List<ContactData> contacts= gson.fromJson(json, new TypeToken<List<ContactData>>(){}.getType());
        return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
    }

    @Test(dataProvider = "validContactsFromJson")
    public void testContactCreation() throws Exception {
        Contacts before = app.contact().allHamcrestAllPhones();
        ContactData contact = new ContactData().withName("Создаем новый").withLastName("Контакт");
        app.goTo().addNewContact();
        File photo = new File("src/test/resources/kitty.jpg");
        app.contact().fillContacts((contact.withName("test_name").withLastName("test_surname").withPhoto(photo)),
                true);
        app.contact().submitContactCreation();
        app.goTo().homePage();
        Contacts after = app.contact().allHamcrestAllPhones();
        assertThat(after.size(), equalTo(before.size() + 1));

        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c)-> c.getId()).max().getAsInt()))));
    }

    @Test
    public void testCurrentDirectory(){
        File currentDir = new File(".");
        File photo = new File("src/test/resources/kitty.jpg");
        System.out.println(currentDir.getAbsolutePath());
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());

    }
}
