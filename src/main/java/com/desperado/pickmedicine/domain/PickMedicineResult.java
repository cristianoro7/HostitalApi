package desperado.pickmedicine.domain;

import java.util.ArrayList;
import java.util.List;

import desperado.casereport.domain.CaseReportResult;
import desperado.common.domain.Result;

/**
 * Created by desperado on 18-1-15.
 */

public class PickMedicineResult extends Result {

    private PickMedicine list = new PickMedicine(null);

    public PickMedicine getList() {

        return list;
    }

    public void setList(PickMedicine list) {
        this.list = list;
    }

    public static class PickMedicine {

        private String reportId;

        private String patientId;

        private String patientName;

        public String getPatientId() {
            return patientId;
        }

        public void setPatientId(String patientId) {
            this.patientId = patientId;
        }

        public String getPatientName() {
            return patientName;
        }

        public void setPatientName(String patientName) {
            this.patientName = patientName;
        }

        public PickMedicine(String reportId) {
            this.reportId = reportId;
        }

        public String getReportId() {
            return reportId;
        }

        public void setReportId(String reportId) {
            this.reportId = reportId;
        }

        private List<CaseReportResult.MedicineList> medicineLists = new ArrayList<>();

        public void addMedicineList(List<CaseReportResult.MedicineList> lists) {
            if (lists != null) {
                medicineLists.addAll(lists);
            }
        }

        public List<CaseReportResult.MedicineList> getMedicineLists() {
            return medicineLists;
        }
    }
}
