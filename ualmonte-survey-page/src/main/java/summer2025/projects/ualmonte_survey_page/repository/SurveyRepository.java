package summer2025.projects.ualmonte_survey_page.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import summer2025.projects.ualmonte_survey_page.entity.SurveyRecord;

public interface SurveyRepository extends JpaRepository<SurveyRecord, Long> {

}
