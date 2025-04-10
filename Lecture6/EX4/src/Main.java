import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.time.LocalDate;


public class Exercise4 {
    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        mapper.registerModule(module);


        StudentWithBirthday student = new StudentWithBirthday("John Doe", 20, "johndoe@example.com", LocalDate.now());
        String json = mapper.writeValueAsString(student);
        System.out.println("Serialized JSON: " + json);

        StudentWithBirthday deserializedStudentWithBirthday = mapper.readValue(json, StudentWithBirthday.class);
        System.out.println("Deserialized Student birthday: " + deserializedStudentWithBirthday.getBirthday());
    }
}

class LocalDateSerializer extends JsonSerializer<LocalDate> {
    @Override
    public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(value.toString());
    }
}

class LocalDateDeserializer extends JsonDeserializer<LocalDate> {
    @Override
    public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return LocalDate.parse(p.getText());
    }
}

class StudentWithBirthday {
    private String name;
    private int age;
    private String email;

    private LocalDate birthday;

    public StudentWithBirthday() {
    }

    public StudentWithBirthday(String name, int age, String email, LocalDate birthday) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.birthday = birthday;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}