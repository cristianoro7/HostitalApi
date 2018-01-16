package desperado.admin.doctor.service;

import desperado.admin.doctor.dao.DoctorDao;
import desperado.admin.doctor.domain.DoctorResult;
import desperado.base.Service;
import desperado.common.helper.ResultCodeHelper;

/**
 * Created by desperado on 18-1-13.
 */

public class DoctorService implements Service {

    private DoctorDao doctorDao;

    public DoctorService(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }

    public int addDoctor(DoctorResult doctorResult) {
        int c = doctorDao.addDoctor(doctorResult);
        if (c > 0) {
            doctorResult.setSuccess(true);
            doctorResult.setCode(ResultCodeHelper.CODE_SUCCESS);
            doctorResult.setReason("success");
        }
        return c;
    }

    public DoctorResult deleteDoctor(String id) {
        int dId = Integer.parseInt(id);
        DoctorResult doctorResult = doctorDao.fetchDoctorById(dId);
        DoctorResult.Doctor doctor = doctorResult.getDoctors().get(0);
        if (doctor.getName() != null) {
            int c = doctorDao.deleteDoctor(dId);
            if (c > 0) {
                doctorResult.setCode(ResultCodeHelper.CODE_SUCCESS);
                doctorResult.setReason("success");
                doctorResult.setSuccess(true);
            }
        }
        return doctorResult;
    }

    public DoctorResult fetchDoctorById(String id) {
        int dId = Integer.parseInt(id);
        DoctorResult doctorResult = doctorDao.fetchDoctorById(dId);
        if (doctorResult.getDoctors().get(0).getName() != null) {
            setSuccess(doctorResult);
        }
        return doctorResult;
    }

    public DoctorResult fetchDoctors() {
        DoctorResult doctorResult = doctorDao.fetchDoctors();
        if (doctorResult.getDoctors().size() != 0) {
            setSuccess(doctorResult);
        }
        return doctorResult;
    }

    public void updateDoctor(DoctorResult doctorResult) {
        int c = doctorDao.updateDoctor(doctorResult.getDoctors().get(0));
        if (c > 0) {
            setSuccess(doctorResult);
        }
    }
}
