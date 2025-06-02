package ir.mmdaminah.technicianservice.core.mapper;

import ir.mmdaminah.technicianservice.core.entity.Technician;
import ir.mmdaminah.technicianservice.core.entity.WorkingDay;
import ir.mmdaminah.technicianservice.core.entity.WorkingTime;
import ir.mmdaminah.technicianservice.core.validation.WorkingDayProperty;
import ir.mmdaminah.technicianservice.events.TechnicianCreatedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TechnicianMapper {

    public Technician toEntity(TechnicianCreatedEvent event) {
        Technician technician = new Technician();
        technician.setTechnicianId(event.getTechnicianId());
        technician.setFirstName(event.getFirstName());
        technician.setLastName(event.getLastName());
        technician.setWorkingDays(toWorkingDaysEntity(event.getWorkingDays()));
        return technician;
    }

    private List<WorkingDay> toWorkingDaysEntity(List<WorkingDayProperty> workingDays) {

        List<WorkingDay> workingDayList = new ArrayList<>();
        for (WorkingDayProperty workingDayProperty : workingDays) {
            var workingDay = new WorkingDay();
            workingDay.setDay(workingDayProperty.getWorkingDay());
            var workingHours = toWorkingTimeEntity(workingDayProperty.getWorkingTimes());
            workingDay.setWorkingTimes(workingHours);

            workingDayList.add(workingDay);
        }

        return workingDayList;
    }

    private List<WorkingTime> toWorkingTimeEntity(List<String> workingTimes) {
        return workingTimes.stream().map(this::parseWorkingTime).collect(Collectors.toList());
    }

    private WorkingTime parseWorkingTime(String workingTime) {
        var startTime = workingTime.split("-")[0];
        var endTime = workingTime.split("-")[1];

        WorkingTime workingTimeEntity = new WorkingTime();
        workingTimeEntity.setStartHour(Integer.parseInt(startTime.split(":")[0]));
        workingTimeEntity.setStartMinute(Integer.parseInt(startTime.split(":")[1]));
        workingTimeEntity.setEndHour(Integer.parseInt(endTime.split(":")[0]));
        workingTimeEntity.setEndMinute(Integer.parseInt(endTime.split(":")[1]));

        return workingTimeEntity;
    }

}
