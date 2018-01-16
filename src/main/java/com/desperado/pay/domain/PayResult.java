package desperado.pay.domain;

import desperado.common.domain.Result;
import desperado.pickmedicine.domain.PickMedicineResult;

/**
 * Created by desperado on 18-1-15.
 */

public class PayResult extends Result {

    private PickMedicineResult.PickMedicine list = new PickMedicineResult.PickMedicine(null);

    public PickMedicineResult.PickMedicine getList() {
        return list;
    }

    public void setList(PickMedicineResult.PickMedicine list) {
        this.list = list;
    }

    private String totalPrice;

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }
}
