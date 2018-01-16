package desperado.base;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.SessionCookieConfig;
import javax.servlet.annotation.WebListener;

import desperado.admin.consultingroom.dao.ConsultingRoomDaoImpl;
import desperado.admin.consultingroom.service.ConsultingRoomService;
import desperado.admin.department.dao.DepartmentImpl;
import desperado.admin.department.service.DepartmentService;
import desperado.admin.doctor.dao.DoctorImpl;
import desperado.admin.doctor.service.DoctorService;
import desperado.admin.medicine.dao.MedicineDaoImpl;
import desperado.admin.medicine.service.MedicineService;
import desperado.admin.title.dao.TitleDaoImpl;
import desperado.admin.title.service.TitleService;
import desperado.admin.user.dao.UserDaoImpl;
import desperado.admin.user.service.UserService;
import desperado.appointment.dao.AppointmentDaoImpl;
import desperado.appointment.service.AppointmentService;
import desperado.casereport.dao.CaseReportDaoImpl;
import desperado.casereport.service.CaseReportService;
import desperado.login.dao.LoginDaoImpl;
import desperado.login.service.LoginService;
import desperado.pay.dao.PayDaoImpl;
import desperado.pay.service.PayService;
import desperado.pickmedicine.dao.PickMedicineDaoImpl;
import desperado.pickmedicine.service.PickMedicineService;

/**
 * Created by desperado on 18-1-13.
 */
@WebListener
public class HospitalServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        registerService();
        configSession(sce.getServletContext());
    }


    private void registerService() {
        ServiceContainer container = ServiceContainer.getInstance();
        container.addService(ServiceNameContract.LOGIN_SERVICE, new LoginService(new LoginDaoImpl()));
        container.addService(ServiceNameContract.ADMIN_DOCTOR_SERVICE, new DoctorService(new DoctorImpl()));
        container.addService(ServiceNameContract.ADMIN_TITLE_SERVICE, new TitleService(new TitleDaoImpl()));
        container.addService(ServiceNameContract.ADMIN_MEDICINE_SERVICE, new MedicineService(new MedicineDaoImpl()));
        container.addService(ServiceNameContract.ADMIN_DEPARTMENT_SERVICE, new DepartmentService(new DepartmentImpl()));
        container.addService(ServiceNameContract.ADMIN_ROOM_SERVICE, new ConsultingRoomService(new ConsultingRoomDaoImpl()));
        container.addService(ServiceNameContract.ADMIN_USER_SERVICE, new UserService(new UserDaoImpl()));
        container.addService(ServiceNameContract.APPOINTMENT_SERVICE, new AppointmentService(new AppointmentDaoImpl()));
        container.addService(ServiceNameContract.CASE_REPORT_SERVICE, new CaseReportService(new CaseReportDaoImpl()));
        container.addService(ServiceNameContract.PICK_MEDICINE_SERVICE, new PickMedicineService(new PickMedicineDaoImpl()));
        container.addService(ServiceNameContract.PAY_SERVICE, new PayService(new PayDaoImpl()));
    }

    private void configSession(ServletContext servletContext) {
        SessionCookieConfig config = servletContext.getSessionCookieConfig();
        config.setHttpOnly(true);
        config.setMaxAge(60 * 60 * 24); //有效期一天
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
