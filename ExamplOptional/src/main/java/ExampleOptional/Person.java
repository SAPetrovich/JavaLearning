package ExampleOptional;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Optional;

@Data
@Accessors(chain = true)
public class Person {

    private String fName = "";
    private Optional<String> mName = Optional.empty();
    private Optional<String> phone = Optional.empty();
    private Optional<String> email = Optional.empty();

    public String getFullName() {
        return mName.map(s -> fName + " " + s).orElseGet(() -> fName);
    }

    public boolean hasContacts() {
        return phone.isPresent() || email.isPresent();
    }

    public void sendNotification (String msg) {
        System.out.println(msg);

        // обработаем phoneNum и email разными способами (в познавательных целях)

        phone.ifPresent(phoneNum ->
            System.out.println("Отправлено СМС на номер " + phoneNum)
        );

        if(email.isPresent()) {
            System.out.println("Отправлен EMAil на адрес " + email.get());
        }
    }
}
