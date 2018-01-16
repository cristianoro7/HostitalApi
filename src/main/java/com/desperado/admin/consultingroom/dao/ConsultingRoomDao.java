package desperado.admin.consultingroom.dao;

import java.util.List;

import desperado.admin.consultingroom.domain.ConsultingRoomResult;

/**
 * Created by desperado on 18-1-14.
 */

public interface ConsultingRoomDao {

    int deleteConsultingRoom(int id);

    int updateConsultingRoom(ConsultingRoomResult.ConsultingRoom room);

    int addConsultingRoom(ConsultingRoomResult.ConsultingRoom room);

    ConsultingRoomResult.ConsultingRoom getRoomById(int id);

    List<ConsultingRoomResult.ConsultingRoom> listRooms();

    List<ConsultingRoomResult.ConsultingRoom> listRoomByDepartmentId(int departmentId);

}
