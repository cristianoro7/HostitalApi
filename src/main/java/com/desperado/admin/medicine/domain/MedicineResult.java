package desperado.admin.medicine.domain;

import java.util.ArrayList;
import java.util.List;

import desperado.common.domain.Result;

/**
 * Created by desperado on 18-1-13.
 */

public class MedicineResult extends Result {

    private List<Medicine> list = new ArrayList<>();

    public List<Medicine> medicines() {
        return list;
    }

    public MedicineResult(Medicine medicine) {
        list.add(medicine);
    }

    public MedicineResult() {}

    public void addMedicine(Medicine medicine) {
        if (medicine != null) {
            list.add(medicine);
        }
    }

    public void addMedicines(List<Medicine> medicines) {
        if (medicines != null) {
            list.addAll(medicines);
        }
    }

    public static class Medicine {
        private String id;

        private String name;

        private String price;

        public Medicine(String name, String price) {
            this.name = name;
            this.price = price;
        }

        public Medicine() {
        }

        public Medicine(String id, String name, String price) {
            this.id = id;
            this.name = name;
            this.price = price;
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

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }
}
