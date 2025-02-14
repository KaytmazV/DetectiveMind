package com.volkankaytmaz.detectivegame.config;

import com.volkankaytmaz.detectivegame.model.Person;
import com.volkankaytmaz.detectivegame.model.Question;
import com.volkankaytmaz.detectivegame.model.UserList;
import com.volkankaytmaz.detectivegame.service.PersonService;
import com.volkankaytmaz.detectivegame.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class DataLoader implements CommandLineRunner {

    private final PersonService personService;
    private final QuestionService questionService;

    @Autowired
    public DataLoader(PersonService personService, QuestionService questionService) {
        this.personService = personService;
        this.questionService = questionService;
    }

    @Override
    public void run(String... args) {
        loadPersons();
        loadQuestions();
    }

    private void loadPersons() {
        if (personService.getAllPersons().isEmpty()) {
            List<Person> persons = Arrays.asList(
                    new Person("Ahmet Yılmaz", UserList.SUSPECT, false, false, "Evde televizyon izliyordum.", "45 yaşında, iş adamı"),
                    new Person("Ayşe Kaya", UserList.SUSPECT, false, false, "Arkadaşımla telefonda konuşuyordum.", "38 yaşında, doktor"),
                    new Person("Mehmet Demir", UserList.SUSPECT, false, false, "Geç saate kadar ofiste çalışıyordum.", "52 yaşında, avukat"),
                    new Person("Fatma Şahin", UserList.SUSPECT, false, false, "Kitap okuyordum.", "41 yaşında, öğretmen"),
                    new Person("Ali Öztürk", UserList.SUSPECT, false, false, "Spor salonundaydım.", "29 yaşında, sporcu"),
                    new Person("Zeynep Çelik", UserList.SUSPECT, false, false, "Arkadaşlarımla dışarıdaydım.", "22 yaşında, öğrenci"),
                    new Person("Mustafa Aydın", UserList.SUSPECT, false, false, "İş seyahatindeydim.", "36 yaşında, mühendis"),
                    new Person("Elif Yıldız", UserList.SUSPECT, false, false, "Evde çocuklarımla ilgileniyordum.", "33 yaşında, ev hanımı"),
                    new Person("Hasan Kara", UserList.SUSPECT, false, false, "Gece vardiyasındaydım.", "47 yaşında, güvenlik görevlisi"),
                    new Person("Selin Arslan", UserList.SUSPECT, false, false, "Yoga yapıyordum.", "31 yaşında, yoga eğitmeni"),
                    new Person("Emre Güneş", UserList.SUSPECT, false, false, "Stüdyoda müzik kaydı yapıyordum.", "27 yaşında, müzisyen"),
                    new Person("Canan Tuna", UserList.SUSPECT, false, false, "Hastanede nöbetteydim.", "35 yaşında, hemşire")
            );

            // Rastgele bir şüpheliyi suçlu olarak işaretle
            Random random = new Random();
            int guiltyIndex = random.nextInt(persons.size());
            persons.get(guiltyIndex).setGuilty(true);

            persons.forEach(personService::savePerson);
        }
    }

    private void loadQuestions() {
        if (questionService.getAllQuestions().isEmpty()) {
            List<Question> questions = Arrays.asList(
                    new Question("Cinayet gecesi neredeydiniz?", 0),
                    new Question("Maktul ile nasıl bir ilişkiniz vardı?", 0),
                    new Question("Son zamanlarda herhangi bir şüpheli davranış gözlemlediniz mi?", 0),
                    new Question("Silahınız var mı?", 0),
                    new Question("Olay günü neler yaptınız?", 0),
                    new Question("Maktulün düşmanları var mıydı?", 0),
                    new Question("Cinayetin işlendiği saatte neredeydiniz?", 0),
                    new Question("Maktulü en son ne zaman gördünüz?", 0),
                    new Question("Olay yerinde bulunduğunuz iddia ediliyor, ne diyorsunuz?", 0),
                    new Question("Alibi'nizi kanıtlayabilecek biri var mı?", 0),
                    new Question("Maktulün son günlerdeki davranışlarında bir değişiklik gözlemlediniz mi?", 0),
                    new Question("Cinayetle ilgili bildiklerinizi anlatır mısınız?", 0),
                    new Question("Maktulün çevresinde şüphelendiğiniz biri var mıydı?", 0),
                    new Question("Olay günü unusual bir şey fark ettiniz mi?", 0),
                    new Question("Maktulün mali durumu nasıldı?", 0),
                    new Question("Sizce bu cinayetin sebebi ne olabilir?", 0),
                    new Question("Maktulün son zamanlarda yeni tanıştığı biri var mıydı?", 0),
                    new Question("Olay yerinde bulunan kanıtlar hakkında ne düşünüyorsunuz?", 0),
                    new Question("Maktulün ailesinden şüphelendiğiniz biri var mı?", 0),
                    new Question("Bu cinayetle ilgili teoriniz nedir?", 0)
            );

            questions.forEach(questionService::saveQuestion);
        }
    }
}