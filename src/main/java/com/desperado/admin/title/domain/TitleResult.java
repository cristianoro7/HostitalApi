package desperado.admin.title.domain;

import java.util.ArrayList;
import java.util.List;

import desperado.common.domain.Result;

/**
 * Created by desperado on 18-1-13.
 */

public class TitleResult extends Result {

    private List<Title> titles = new ArrayList<>();

    public TitleResult() {}

    public TitleResult(Title title) {
        titles.add(title);
    }

    public static class Title {
        private String id;

        private String name;

        public Title(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public Title(String name) {
            this.name = name;
        }

        public Title() {
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
    }

    public void addTitle(Title title) {
        if (title != null) {
            titles.add(title);
        }
    }

    public List<Title> getTitles() {
        return titles;
    }
}
