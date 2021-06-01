package ExampleOptional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Application {

    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();

        persons.add( new Person()
                .setFName("Василий")
                .setMName(Optional.of("Петрович"))
                .setPhone(Optional.of("1234567890"))
                .setEmail(Optional.of("1@xxx.yy"))
        );

        persons.add( new Person()
                .setFName("Михаил")
                .setPhone(Optional.of("0987654321"))
        );

        persons.add( new Person()
                .setFName("Григорий")
                .setMName(Optional.of("Дмитриевич"))
                .setEmail(Optional.of("grisha@xxx.yy"))
        );

        persons.add( new Person()
                .setFName("Игорь")
        );

        for (int i = 0; i < 5; i++) {
            persons.add( generateRandomPerson() );
        }

        persons.forEach((p) -> {
            System.out.println();
            if(p.hasContacts()) {
                p.sendNotification("Уважаемый " + p.getFullName() + ". Поздравляю вас с Новым Годом!");
            }else{
                System.out.println(p.getFName()+" не указал контактов. Останется без поздравления.");
            }
        });
    }

    private static Person generateRandomPerson() {
        String[] fnames = {"Василий","Петр","Иван","Матвей"};
        String[] mnames = {"Васильевич","Петрович","Иванович","Матвеевич"};
        String[] phones = {"1111111111","2222222222","3333333333","4444444444"};
        String[] emails = {"1@domain.zone","2@domain.zone","3@domain.zone","4@domain.zone"};

        return new Person()
                .setFName(randomString(fnames))
                .setMName(randomOptionalString(mnames))
                .setPhone(randomOptionalString(phones))
                .setEmail(randomOptionalString(emails));
    }

    private static String randomString(String[] strings) {
        return strings[(int)(Math.random()*strings.length)];
    }

    private static Optional<String> randomOptionalString(String[] strings) {
        if (Math.random() < 0.1)
            return Optional.empty();
        return Optional.of(randomString(strings));
    }

}
