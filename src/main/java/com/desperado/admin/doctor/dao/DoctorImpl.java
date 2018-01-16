package desperado.admin.doctor.dao;

import java.sql.Timestamp;
import java.util.List;

import desperado.admin.doctor.domain.DoctorResult;
import desperado.base.AbstractDao;

/**
 * Created by desperado on 18-1-13.
 */

public class DoctorImpl extends AbstractDao implements DoctorDao {

    private static final String SQL_ADD_DOCTOR = "INSERT INTO doctor(doctor_name, sex, age, tel_phone, " +
            "department_id, consulting_room_id, create_time) " +
            "VALUES(?,?, ?, ?, ?, ?, ?);";

    private static final String SQL_DELETE_DOCTOR = "DELETE from doctor " +
            "WHERE doctor_id = ?;";

    private static final String SQL_QUERY_DOCTOR = "SELECT * " +
            "FROM doctor " +
            "WHERE doctor_id = ?;";

    private static final String SQL_QUERY_DOCTORS = "SELECT * FROM doctor";

    private static final String SQL_UPDATE_DOCTOR = "UPDATE doctor SET " +
            "doctor_name = ?, sex = ?, age = ?, tel_phone = ?, department_id = ?, " +
            "consulting_room_id = ?, modified_time = ? " +
            "WHERE doctor_id = ?;";

    @Override
    public int addDoctor(DoctorResult doctorResult) {
        DoctorResult.Doctor doctor = doctorResult.getDoctors().get(0);
        return insert(SQL_ADD_DOCTOR, new Object[]{doctor.getName(), doctor.getSex(), doctor.getAge(), doctor.getTel(),
                doctor.getDepartmentId(), doctor.getConsultingRoomId(),
                new Timestamp(System.currentTimeMillis())});
    }

    @Override
    public int deleteDoctor(int id) {
        return update(SQL_DELETE_DOCTOR, new Object[]{id});
    }

    @Override
    public int updateDoctor(DoctorResult.Doctor doctor) {
        return update(SQL_UPDATE_DOCTOR, new Object[]{doctor.getName(), doctor.getSex(),
                doctor.getAge(), doctor.getTel(), doctor.getDepartmentId(), doctor.getConsultingRoomId(),
                new Timestamp(System.currentTimeMillis()), doctor.getId()});
    }

    @Override
    public List<DoctorResult> listDoctors() {
        return null;
    }

    @Override
    public DoctorResult fetchDoctorById(int id) {
        DoctorResult doctorResult = new DoctorResult();
        DoctorResult.Doctor doctor = new DoctorResult.Doctor();

        query(SQL_QUERY_DOCTOR, new Object[]{id}, resultSet -> { //如果存在该医生的话会回调
            doctor.setId(String.valueOf(resultSet.getInt(1)));
            doctor.setName(resultSet.getString(2));
            doctor.setSex(resultSet.getString(3));
            doctor.setAge(resultSet.getInt(4));
            doctor.setTel(resultSet.getString(5));
            doctor.setDepartmentId(resultSet.getInt(6));
            doctor.setConsultingRoomId(resultSet.getInt(7));
            doctorResult.addDoctor(doctor);
        });
        return doctorResult;
    }

    @Override
    public DoctorResult fetchDoctors() {
        DoctorResult result = new DoctorResult();
        query(SQL_QUERY_DOCTORS, null, resultSet -> {
            DoctorResult.Doctor doctor = new DoctorResult.Doctor();
            doctor.setId(String.valueOf(resultSet.getInt(1)));
            doctor.setName(resultSet.getString(2));
            doctor.setSex(resultSet.getString(3));
            doctor.setAge(resultSet.getInt(4));
            doctor.setTel(resultSet.getString(5));
            doctor.setDepartmentId(resultSet.getInt(6));
            doctor.setConsultingRoomId(resultSet.getInt(7));
            result.addDoctor(doctor);
        });
        return result;
    }
}
