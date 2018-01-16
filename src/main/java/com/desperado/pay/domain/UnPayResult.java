package desperado.pay.domain;

import java.util.ArrayList;
import java.util.List;

import desperado.common.domain.Result;
import desperado.pickmedicine.domain.PickMedicineResult;

/**
 * Created by desperado on 18-1-15.
 */

public class UnPayResult extends Result {

    private List<UnPay> list = new ArrayList<>();

    public void addUnpays(List<UnPay> list) {
        if (list != null) {
            this.list.addAll(list);
        }
    }

    public List<UnPay> unPays() {
        return list;
    }

    public static class UnPay {

        private String totalPrice;

        private PickMedicineResult.PickMedicine medicine = new PickMedicineResult.PickMedicine(null);

        public String getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(String totalPrice) {
            this.totalPrice = totalPrice;
        }

        public PickMedicineResult.PickMedicine getMedicine() {
            return medicine;
        }

        public void setMedicine(PickMedicineResult.PickMedicine medicine) {
            this.medicine = medicine;
        }
    }

}
