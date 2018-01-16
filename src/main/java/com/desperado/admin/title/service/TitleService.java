package desperado.admin.title.service;

import java.util.List;

import desperado.admin.title.dao.TitleDao;
import desperado.admin.title.domain.TitleResult;
import desperado.base.Service;

/**
 * Created by desperado on 18-1-13.
 */

public class TitleService implements Service {

    private TitleDao titleDao;

    public TitleService(TitleDao titleDao) {
        this.titleDao = titleDao;
    }

    public void addTitle(TitleResult result) {
        int c = titleDao.addTitle(result.getTitles().get(0));
        if (c > 0) {
            setSuccess(result);
        }
    }

    public void deleteTitle(TitleResult result) {
        TitleResult.Title title = titleDao.getTitleById(Integer.parseInt(result.getTitles().get(0).getId()));
        if (title.getName() != null) {
            int c = titleDao.deleteTitle(result.getTitles().get(0));
            if (c > 0) {
                result.getTitles().clear();
                result.getTitles().add(title);
            }
        }
        setSuccess(result);
    }

    public void updateTitle(TitleResult result) {
        int c = titleDao.updateTitle(result.getTitles().get(0));
        if (c > 0) {
            setSuccess(result);
        }
    }

    public TitleResult getTitleById(String id) {
        int iId = Integer.parseInt(id);
        TitleResult.Title title = titleDao.getTitleById(iId);
        TitleResult titleResult = new TitleResult(title);

        if (title.getName() != null) {
            setSuccess(titleResult);
        }
        return titleResult;
    }

    public TitleResult listTitle() {
        TitleResult titleResult = new TitleResult();
        List<TitleResult.Title> titles = titleDao.listTitle();
        if (titles.size() > 0) {
            titleResult.getTitles().addAll(titles);
        }
        setSuccess(titleResult);
        return titleResult;
    }
}
