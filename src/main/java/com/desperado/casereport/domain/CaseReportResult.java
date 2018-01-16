package desperado.casereport.domain;

import java.util.ArrayList;
import java.util.List;

import desperado.common.domain.Result;

/**
 * Created by desperado on 18-1-14.
 */

public class CaseReportResult extends Result {

    private List<CaseReport> list = new ArrayList<>();

    public void addReport(CaseReport report) {
        if (report != null) {
            list.add(report);
        }
    }

    public void addReports(List<CaseReport> list) {
        if (list != null) {
            this.list.addAll(list);
        }
    }

    public List<CaseReport> reports() {
        return list;
    }

    public static class CaseReport {

        private String appointmentId;

        public CaseReport(String appointmentId, String patientId, String description, boolean isPay) {
            this.patientId = patientId;
            this.description = description;
            this.isPay = isPay;
            this.appointmentId = appointmentId;
        }

        public String getAppointmentId() {
            return appointmentId;
        }

        public void setAppointmentId(String appointmentId) {
            this.appointmentId = appointmentId;
        }

        private String caseReportId;

        private String patientId;

        private String description;

        private boolean isPay;

        private List<MedicineList> medicineLists = new ArrayList<>();

        public CaseReport(String caseReportId, String patientId, String description, boolean isPay, List<MedicineList> medicineLists) {
            this.caseReportId = caseReportId;
            this.patientId = patientId;
            this.description = description;
            this.isPay = isPay;
            this.medicineLists = medicineLists;
        }

        public CaseReport(String patientId, String description, boolean isPay) {
            this.patientId = patientId;
            this.description = description;
            this.isPay = isPay;
        }

        public CaseReport(String patientId, String description, boolean isPay, List<MedicineList> medicineLists) {
            this.patientId = patientId;
            this.description = description;
            this.isPay = isPay;
            this.medicineLists = medicineLists;
        }

        public String getCaseReportId() {
            return caseReportId;
        }

        public void setCaseReportId(String caseReportId) {
            this.caseReportId = caseReportId;
        }

        public String getPatientId() {
            return patientId;
        }

        public void setPatientId(String patientId) {
            this.patientId = patientId;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public boolean isPay() {
            return isPay;
        }

        public void setPay(boolean pay) {
            isPay = pay;
        }

        public void addMedicine(MedicineList medicineList) {
            if (medicineList != null) {
                this.medicineLists.add(medicineList);
            }
        }

        public void addMedicines(List<MedicineList> medicineList) {
            if (medicineList != null) {
                this.medicineLists.addAll(medicineList);
            }
        }

        public List<MedicineList> medicineLists() {
            return medicineLists;
        }
    }

    public static class MedicineList {

        private String id;

        private String name;

        private String counts;

        private String price;

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public MedicineList(String id, String name, String counts) {
            this.id = id;
            this.name = name;
            this.counts = counts;
        }

        public MedicineList(String name, String counts) {
            this.name = name;
            this.counts = counts;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCounts() {
            return counts;
        }

        public void setCounts(String counts) {
            this.counts = counts;
        }

        public MedicineList() {
        }
    }
}
