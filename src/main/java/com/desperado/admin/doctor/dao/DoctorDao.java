package desperado.admin.doctor.dao;

import java.util.List;

import desperado.admin.doctor.domain.DoctorResult;

/**
 * Created by desperado on 18-1-13.
 */

public interface DoctorDao {

    int addDoctor(DoctorResult doctor);

    int deleteDoctor(int id);

    int updateDoctor(DoctorResult.Doctor doctor);

    List<DoctorResult> listDoctors();

    DoctorResult fetchDoctorById(int id);

    DoctorResult fetchDoctors();

}
