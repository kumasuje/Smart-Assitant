package edu.iu.smart.assistance;

import edu.iu.smart.assistance.model.WeekModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmartAssistanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartAssistanceApplication.class, args);

        WeekModel.DayModel[] weekDays = WeekModel.getDays();
        weekDays[1].hours[20] = true;
        weekDays[0].hours[8] = true;
        weekDays[1].hours[8] = true;
	}
}
