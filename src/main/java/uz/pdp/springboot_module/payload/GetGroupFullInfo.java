package uz.pdp.springboot_module.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public interface GetGroupFullInfo {
    Long getId();
    @JsonProperty("group_name")
    String getGroupName();
    @JsonProperty("group_level")
    Integer getGroupLevel();

    @Value("#{@studentRepository.getAllStudents(target.id)}")
    List<GetStudentResponse> getAllStudents();

    @Value("#{@studentRepository.getStudentsByAgeLessThen(target.id,18)}")
    List<GetStudentResponse> getStudentAge18LessThen();

    @Value("#{@studentRepository.getStudentsByAgeGreaterThenAndEqueal(target.id,18)}")
    List<GetStudentResponse> getStudentAge18GreaterThenAndEqual();
}
