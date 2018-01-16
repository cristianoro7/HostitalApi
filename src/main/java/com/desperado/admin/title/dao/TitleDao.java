package desperado.admin.title.dao;

import java.util.List;

import desperado.admin.title.domain.TitleResult;

/**
 * Created by desperado on 18-1-13.
 */

public interface TitleDao {

    int addTitle(TitleResult.Title title);

    int deleteTitle(TitleResult.Title title);

    TitleResult.Title getTitleById(int id);

    int updateTitle(TitleResult.Title title);

    List<TitleResult.Title> listTitle();
}
