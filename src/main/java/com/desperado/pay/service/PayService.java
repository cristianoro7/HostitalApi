package desperado.pay.service;

import java.util.List;

import desperado.base.Service;
import desperado.casereport.domain.CaseReportResult;
import desperado.pay.dao.PayDao;
import desperado.pay.domain.PayResult;
import desperado.pay.domain.UnPayResult;
import desperado.pickmedicine.service.PickMedicineService;

/**
 * Created by desperado on 18-1-15.
 */

public class PayService implements Service {


    private PayDao payDao;

    public PayService(PayDao payDao) {
        this.payDao = payDao;
    }

    public PayResult getPay(List<CaseReportResult.MedicineList> list, int reportId) {
        PayResult payResult = new PayResult();
        payResult.getList().addMedicineList(list);
        payResult.getList().setReportId(String.valueOf(reportId));
        payResult.setTotalPrice(payDao.getPay(list));
        int c = payDao.finishPay(reportId);
        if (c > 0) {
            setSuccess(payResult);
        }
        return payResult;
    }

    public UnPayResult listUnPay(PickMedicineService service) {
        UnPayResult result = new UnPayResult();
        List<UnPayResult.UnPay> list = payDao.getUnPay();
        if (list.size() > 0) {
            System.out.println("size:" + list.size());
            for (UnPayResult.UnPay unPay : list) {
                List<CaseReportResult.MedicineList> medicineLists =
                        service.getMedicineListById(Integer.parseInt(unPay.getMedicine().getReportId()))
                                .getList()
                                .getMedicineLists();
                System.out.println("medicineList:" + medicineLists.size());
                unPay.getMedicine().addMedicineList(medicineLists);
                unPay.setTotalPrice(payDao.getPay(medicineLists));
            }
            result.addUnpays(list);
        }
        setSuccess(result);
        return result;
    }
}
