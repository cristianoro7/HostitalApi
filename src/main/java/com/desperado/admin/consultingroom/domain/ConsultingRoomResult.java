package desperado.admin.consultingroom.domain;

import java.util.ArrayList;
import java.util.List;

import desperado.common.domain.Result;

/**
 * Created by desperado on 18-1-14.
 */

public class ConsultingRoomResult extends Result {

    private List<ConsultingRoom> list = new ArrayList<>();

    public void addConsultingRoom(ConsultingRoom room) {
        if (room != null) {
            list.add(room);
        }
    }

    public void addConsultingRooms(List<ConsultingRoom> list) {
        if (list != null) {
            this.list.addAll(list);
        }
    }

    public List<ConsultingRoom> getConsultingRooms() {
        return list;
    }

    public static class ConsultingRoom {
        private String id;

        private String location;

        private String departmentId;

        public String getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(String departmentId) {
            this.departmentId = departmentId;
        }


        public ConsultingRoom() {}

        public ConsultingRoom(String id, String location) {
            this.id = id;
            this.location = location;
        }

        public ConsultingRoom(String id, String departmentId, String location) {
            this.id = id;
            this.departmentId  = departmentId;
            this.location = location;
        }

        public ConsultingRoom(String location) {
            this.location = location;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }
    }
}
