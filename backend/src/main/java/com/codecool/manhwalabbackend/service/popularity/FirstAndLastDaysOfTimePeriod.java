package com.codecool.manhwalabbackend.service.popularity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.Locale;

@Data
@Component
public class FirstAndLastDaysOfTimePeriod {

    private final Locale locale;
    private final DayOfWeek firstDayOfWeek;
    private final DayOfWeek lastDayOfWeek;
    private LocalDate firstDayOfMonth;
    private LocalDate lastDayOfMonth;

    public FirstAndLastDaysOfTimePeriod() {
        this.locale = Locale.ENGLISH;
        this.firstDayOfWeek =  WeekFields.of(locale).getFirstDayOfWeek();
        this.lastDayOfWeek = DayOfWeek.of(((firstDayOfWeek.getValue() + 5) % DayOfWeek.values().length) + 1);
        this.firstDayOfMonth = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        this.lastDayOfMonth = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
    }

    protected LocalDate getStartOfWeek(){
        return LocalDate.now().with(TemporalAdjusters.previousOrSame(firstDayOfWeek));
    }

    protected LocalDate getEndOfWeek(){return LocalDate.now().with(TemporalAdjusters.nextOrSame(lastDayOfWeek));
    }
}
